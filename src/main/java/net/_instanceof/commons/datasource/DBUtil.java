/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.datasource;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import com.google.common.collect.Maps;

public class DBUtil {

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

}
