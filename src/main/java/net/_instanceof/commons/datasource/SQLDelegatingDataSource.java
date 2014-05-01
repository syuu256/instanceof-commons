/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import net._instanceof.commons.datasource.wrapper.ConnectionWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DelegatingDataSource;

/**
 *
 */
public class SQLDelegatingDataSource extends DelegatingDataSource {

    private static Logger log = LoggerFactory.getLogger(SQLDelegatingDataSource.class);

    public SQLDelegatingDataSource() {
        if (log.isInfoEnabled()) {
            log.info("SQLDelegatingDataSource-start");
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return new ConnectionWrapper(super.getConnection());
    }
    @Override
    public Connection getConnection(final String username, final String password) throws SQLException {
        return new ConnectionWrapper(super.getConnection(username, password));
    }
}
