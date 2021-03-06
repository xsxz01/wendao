//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonNodeTypeHandler extends BaseTypeHandler<JsonNode> {
	private static final ObjectMapper mapper = new ObjectMapper();
	private final Logger logger = LoggerFactory.getLogger(JsonNodeTypeHandler.class);

	public JsonNodeTypeHandler() {
	}

	public void setNonNullParameter(PreparedStatement ps, int i, JsonNode parameter, JdbcType jdbcType) throws SQLException {
		String str = null;

		try {
			str = mapper.writeValueAsString(parameter);
		} catch (JsonProcessingException var7) {
			this.logger.error("", var7);
			str = "{}";
		}

		ps.setString(i, str);
	}

	public JsonNode getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String jsonSource = rs.getString(columnName);
		if (jsonSource == null) {
			return null;
		} else {
			try {
				JsonNode jsonNode = mapper.readTree(jsonSource);
				return jsonNode;
			} catch (IOException var5) {
				this.logger.error("", var5);
				return null;
			}
		}
	}

	public JsonNode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String jsonSource = rs.getString(columnIndex);
		if (jsonSource == null) {
			return null;
		} else {
			try {
				JsonNode jsonNode = mapper.readTree(jsonSource);
				return jsonNode;
			} catch (IOException var5) {
				this.logger.error("", var5);
				return null;
			}
		}
	}

	public JsonNode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String jsonSource = cs.getString(columnIndex);
		if (jsonSource == null) {
			return null;
		} else {
			try {
				JsonNode jsonNode = mapper.readTree(jsonSource);
				return jsonNode;
			} catch (IOException var5) {
				this.logger.error("", var5);
				return null;
			}
		}
	}
}
