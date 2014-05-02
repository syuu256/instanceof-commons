/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class DBUtil {

    private static Logger log = LoggerFactory.getLogger(DBUtil.class);

    /**
     * ResultSet2Map
     * @param resultSet
     * @return
     * @throws Exception
     */
    public static Map<String, String> toMap(final ResultSet resultSet) throws SQLException {

        final Map<String, String> m = Maps.newHashMap();
        final ResultSetMetaData metadata = resultSet.getMetaData();

        for (int i = 0; i < metadata.getColumnCount(); i++) {
            final String key = metadata.getColumnName(i + 1);
            m.put(key, resultSet.getString(key));
        }
        return m;
    }

	public static void executeStatement(final Connection connection, final String sql, final String ... parameter) {

		try (final PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			for (int i = 0; i < parameter.length; i++)
				preparedStatement.setString(i + 1, parameter[i]);
			preparedStatement.execute();
		} catch (SQLException e) {
			if (log.isErrorEnabled()) {
				log.error("sql:" + sql, e);
			}
			throw new RuntimeException(e);
		}
	}
	
	public static void commit(final Connection connection) {
		
		try {
			connection.commit();
		} catch (SQLException e) {
			if (log.isErrorEnabled()) {
				log.error("commit error:", e);
			}
			throw new RuntimeException(e);
		}
	}
}
