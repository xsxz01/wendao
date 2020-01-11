package org.linlinjava.litemall.gameserver.service;

import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.domain.Renwu;
import org.linlinjava.litemall.db.service.base.BaseRenwuMonsterService;
import org.linlinjava.litemall.db.service.base.BaseRenwuService;
import org.linlinjava.litemall.db.task.BaxianRepository;
import org.linlinjava.litemall.db.task.TaskVO;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.SubSystem.Baxian;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.process.GameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.util.function.Tuple2;

import java.util.Iterator;
import java.util.List;

@Service
public class BaxianService {
    private static final Logger logger = LoggerFactory.getLogger(BaxianService.class);

    @Autowired
    private BaxianRepository baxianRepository;

    @Autowired
    private M_MSG_BAXIAN_MENGJING_INFO m_msg_baxian_mengjing_info;

    @Autowired
    private M_MSG_TASK_PROMPT m_msg_task_prompt;

    @Autowired
    private BaseRenwuService renwuService;

    @Autowired
    private BaseRenwuMonsterService renwuMonsterService;

    public void afterTalkToNpc(GameObjectChar gameObjectChar, int npcId) {
        TaskVO taskVO = baxianRepository.getChainAndTaskIdByNpcId(npcId);
        if (taskVO == null) {
            logger.error(String.format("Fail to find a task with npcId: %d", npcId));
            return;
        }
        if (!CollectionUtils.isEmpty(taskVO.getMonsterList())) {
            pullIntoFight(gameObjectChar, taskVO.getChainId(), taskVO);
        } else {
            gotoNextTask(gameObjectChar, taskVO.getChainId(), taskVO.getTaskId());
        }
    }

    public void gotoNextTask(GameObjectChar gameObjectChar, Integer chainId, Integer taskId) {
        Chara chara = gameObjectChar.chara;
        TaskVO taskVO = baxianRepository.getNextTask(chainId, taskId);
        if (taskVO == null) {
            mainTaskFinish(gameObjectChar, chainId);
            return;
        }
        chara.baxian.setCurrentTaskId(taskVO.getTaskId());
        if (chara.mapid != taskVO.getMapId()) {
            chara.mapid = taskVO.getMapId();
            chara.mapName = taskVO.getMapName();
            chara.x = taskVO.getNpcX();
            chara.y = taskVO.getNpcY();

            List<Npc> npcList = GameData.that.baseNpcService.findByMapId(taskVO.getMapId());
            Vo_45157_0 vo_45157_0 = new Vo_45157_0();
            vo_45157_0.id = chara.id;
            vo_45157_0.mapId = chara.mapid;
            gameObjectChar.sendOne(new M45157_0(), vo_45157_0);
            Vo_65505_0 vo_65505_1 = GameUtil.a65505(chara);
            gameObjectChar.sendOne(new M65505_0(), vo_65505_1);
            Iterator var6 = npcList.iterator();

            while(var6.hasNext()) {
                Npc npc = (Npc)var6.next();
                gameObjectChar.sendOne(new M65529_npc(), npc);
            }

            Vo_65529_0 vo_65529_0 = GameUtil.a65529(chara);
            GameUtil.genchongfei(chara);
            gameObjectChar.sendOne(new M65529_0(), vo_65529_0);
            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.mapid;
            vo_61671_0.count = 0;
            gameObjectChar.sendOne(new M61671_0(), vo_61671_0);
        }
        Renwu renwu = renwuService.findById(taskVO.getTaskId());
        if (renwu != null) {
            Vo_61553_0 vo_61553_0 = new Vo_61553_0();
            vo_61553_0.count = 1;
            vo_61553_0.task_prompt = renwu.getTaskPrompt();
            vo_61553_0.task_type = "八仙梦境";
            vo_61553_0.task_desc = renwu.getUncontent();
            vo_61553_0.refresh = 1;
            vo_61553_0.task_end_time = (int)(System.currentTimeMillis() / 1000) + 2 * 60 * 60;
            vo_61553_0.attrib = 1;
            vo_61553_0.reward = renwu.getReward();
            vo_61553_0.show_name = renwu.getShowName();
            vo_61553_0.tasktask_extra_para = "";
            vo_61553_0.tasktask_state = "";
            gameObjectChar.sendOne(m_msg_task_prompt, vo_61553_0);
        }
    }

    private void pullIntoFight(GameObjectChar gameObjectChar, Integer chainId, TaskVO taskVO) {
        FightManager.goFightWithCallback(gameObjectChar.chara, taskVO.getMonsterList(), (isWin) -> fightCallback(gameObjectChar, chainId, taskVO.getTaskId(), isWin));
    }

    private void fightCallback(GameObjectChar gameObjectChar, Integer chainId, Integer taskId, boolean isWin) {
        if (isWin) {
            TaskVO taskVO = baxianRepository.getNextTask(chainId, taskId);
            if (taskVO == null) {
                mainTaskFinish(gameObjectChar, chainId);
            } else {
                gotoNextTask(gameObjectChar, chainId, taskVO.getTaskId());
            }
        } else {
            // 失败惩罚逻辑暂时没有实现
        }
    }

    private void mainTaskFinish(GameObjectChar gameObjectChar, int chainId) {
        // 主任务执行完毕
        Baxian baxian = gameObjectChar.chara.baxian;
        baxian.setCurrentMaxLevel(chainId + 1);
        baxian.setCurrentTaskId(null);
        baxian.setStatus(0);
        GameObjectCharMng.save(gameObjectChar);
    }

    public void showBaxianSelectDlg(GameObjectChar gameObjectChar) {
        Baxian baxian = gameObjectChar.chara.baxian;
        BAXIAN_MENGJING_INFO_VO baxian_mengjing_info_vo = BAXIAN_MENGJING_INFO_VO.builder()
                .times_left(baxian.getTimesLeft())
                .curCheckpoint(baxian.getCurrentLevel() - 1)
                .openMax(baxian.getCurrentMaxLevel())
                .mainState(baxian.getStatus())
                .isOpenDlg(1)
                .build();
        gameObjectChar.sendOne(m_msg_baxian_mengjing_info, baxian_mengjing_info_vo);
    }
}
