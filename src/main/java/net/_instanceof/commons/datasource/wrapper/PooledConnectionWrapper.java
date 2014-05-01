/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.datasource.wrapper;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;

/**
 *
 */
class PooledConnectionWrapper implements PooledConnection {

    private PooledConnection pooledConnection;

    public PooledConnectionWrapper(PooledConnection pooledConnection) {
        this.pooledConnection = pooledConnection;
    }
    @Override
    public Connection getConnection() throws SQLException {
        return new ConnectionWrapper(pooledConnection.getConnection());
    }
    @Override
    public void close() throws SQLException {
        pooledConnection.close();
    }
    @Override
    public void addConnectionEventListener(ConnectionEventListener listener) {
        pooledConnection.addConnectionEventListener(listener);
    }
    @Override
    public void removeConnectionEventListener(ConnectionEventListener listener) {
        pooledConnection.removeConnectionEventListener(listener);
    }
    @Override
    public void addStatementEventListener(StatementEventListener listener) {
        pooledConnection.addStatementEventListener(listener);
    }
    @Override
    public void removeStatementEventListener(StatementEventListener listener) {
        pooledConnection.removeStatementEventListener(listener);
    }
}
