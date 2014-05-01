/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.datasource.wrapper;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallableStatementWrapper implements CallableStatement {

    private static Logger log = LoggerFactory.getLogger(CallableStatementWrapper.class);

    private final CallableStatement callableStatement;

    public CallableStatementWrapper(final CallableStatement callableStatement) {
        this.callableStatement = callableStatement;
    }

    private void d(final String sql) {
        log.debug("sql:" + sql);
    }

    /**
     * @param iface
     * @return
     * @throws SQLException
     * @see java.sql.Wrapper#unwrap(java.lang.Class)
     */
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return callableStatement.unwrap(iface);
    }

    /**
     * @param sql
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeQuery(java.lang.String)
     */
    public ResultSet executeQuery(String sql) throws SQLException {
        return callableStatement.executeQuery(sql);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.PreparedStatement#executeQuery()
     */
    public ResultSet executeQuery() throws SQLException {
        return callableStatement.executeQuery();
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(int, int)
     */
    public void registerOutParameter(int parameterIndex, int sqlType)
            throws SQLException {
        d("registerOutParameter(parameterIndex/sqlType):" + parameterIndex + ":" + sqlType);
        callableStatement.registerOutParameter(parameterIndex, sqlType);
    }

    /**
     * @param iface
     * @return
     * @throws SQLException
     * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
     */
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return callableStatement.isWrapperFor(iface);
    }

    /**
     * @param sql
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeUpdate(java.lang.String)
     */
    public int executeUpdate(String sql) throws SQLException {
        return callableStatement.executeUpdate(sql);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.PreparedStatement#executeUpdate()
     */
    public int executeUpdate() throws SQLException {
        return callableStatement.executeUpdate();
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNull(int, int)
     */
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        d("setNull(parameterIndex/sqlType):" + parameterIndex + ":" + sqlType);
        callableStatement.setNull(parameterIndex, sqlType);
    }

    /**
     * @throws SQLException
     * @see java.sql.Statement#close()
     */
    public void close() throws SQLException {
        callableStatement.close();
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @param scale
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(int, int, int)
     */
    public void registerOutParameter(int parameterIndex, int sqlType, int scale)
            throws SQLException {
        d("registerOutParameter(parameterIndex/sqlType/scale):" + parameterIndex + ":" + sqlType + ":" + scale);
        callableStatement.registerOutParameter(parameterIndex, sqlType, scale);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getMaxFieldSize()
     */
    public int getMaxFieldSize() throws SQLException {
        return callableStatement.getMaxFieldSize();
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBoolean(int, boolean)
     */
    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        callableStatement.setBoolean(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setByte(int, byte)
     */
    public void setByte(int parameterIndex, byte x) throws SQLException {
        callableStatement.setByte(parameterIndex, x);
    }

    /**
     * @param max
     * @throws SQLException
     * @see java.sql.Statement#setMaxFieldSize(int)
     */
    public void setMaxFieldSize(int max) throws SQLException {
        callableStatement.setMaxFieldSize(max);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#wasNull()
     */
    public boolean wasNull() throws SQLException {
        return callableStatement.wasNull();
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setShort(int, short)
     */
    public void setShort(int parameterIndex, short x) throws SQLException {
        callableStatement.setShort(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getString(int)
     */
    public String getString(int parameterIndex) throws SQLException {
        return callableStatement.getString(parameterIndex);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getMaxRows()
     */
    public int getMaxRows() throws SQLException {
        return callableStatement.getMaxRows();
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setInt(int, int)
     */
    public void setInt(int parameterIndex, int x) throws SQLException {
        callableStatement.setInt(parameterIndex, x);
    }

    /**
     * @param max
     * @throws SQLException
     * @see java.sql.Statement#setMaxRows(int)
     */
    public void setMaxRows(int max) throws SQLException {
        callableStatement.setMaxRows(max);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setLong(int, long)
     */
    public void setLong(int parameterIndex, long x) throws SQLException {
        callableStatement.setLong(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBoolean(int)
     */
    public boolean getBoolean(int parameterIndex) throws SQLException {
        return callableStatement.getBoolean(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setFloat(int, float)
     */
    public void setFloat(int parameterIndex, float x) throws SQLException {
        callableStatement.setFloat(parameterIndex, x);
    }

    /**
     * @param enable
     * @throws SQLException
     * @see java.sql.Statement#setEscapeProcessing(boolean)
     */
    public void setEscapeProcessing(boolean enable) throws SQLException {
        callableStatement.setEscapeProcessing(enable);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getByte(int)
     */
    public byte getByte(int parameterIndex) throws SQLException {
        return callableStatement.getByte(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setDouble(int, double)
     */
    public void setDouble(int parameterIndex, double x) throws SQLException {
        callableStatement.setDouble(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getShort(int)
     */
    public short getShort(int parameterIndex) throws SQLException {
        return callableStatement.getShort(parameterIndex);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getQueryTimeout()
     */
    public int getQueryTimeout() throws SQLException {
        return callableStatement.getQueryTimeout();
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBigDecimal(int, java.math.BigDecimal)
     */
    public void setBigDecimal(int parameterIndex, BigDecimal x)
            throws SQLException {
        callableStatement.setBigDecimal(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getInt(int)
     */
    public int getInt(int parameterIndex) throws SQLException {
        return callableStatement.getInt(parameterIndex);
    }

    /**
     * @param seconds
     * @throws SQLException
     * @see java.sql.Statement#setQueryTimeout(int)
     */
    public void setQueryTimeout(int seconds) throws SQLException {
        callableStatement.setQueryTimeout(seconds);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setString(int, java.lang.String)
     */
    public void setString(int parameterIndex, String x) throws SQLException {
        d("setString:" + parameterIndex + ":" + x);
        callableStatement.setString(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getLong(int)
     */
    public long getLong(int parameterIndex) throws SQLException {
        return callableStatement.getLong(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBytes(int, byte[])
     */
    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        callableStatement.setBytes(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getFloat(int)
     */
    public float getFloat(int parameterIndex) throws SQLException {
        return callableStatement.getFloat(parameterIndex);
    }

    /**
     * @throws SQLException
     * @see java.sql.Statement#cancel()
     */
    public void cancel() throws SQLException {
        callableStatement.cancel();
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getDouble(int)
     */
    public double getDouble(int parameterIndex) throws SQLException {
        return callableStatement.getDouble(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setDate(int, java.sql.Date)
     */
    public void setDate(int parameterIndex, Date x) throws SQLException {
        callableStatement.setDate(parameterIndex, x);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getWarnings()
     */
    public SQLWarning getWarnings() throws SQLException {
        return callableStatement.getWarnings();
    }

    /**
     * @param parameterIndex
     * @param scale
     * @return
     * @throws SQLException
     * @deprecated
     * @see java.sql.CallableStatement#getBigDecimal(int, int)
     */
    public BigDecimal getBigDecimal(int parameterIndex, int scale)
            throws SQLException {
        return callableStatement.getBigDecimal(parameterIndex, scale);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setTime(int, java.sql.Time)
     */
    public void setTime(int parameterIndex, Time x) throws SQLException {
        callableStatement.setTime(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setTimestamp(int, java.sql.Timestamp)
     */
    public void setTimestamp(int parameterIndex, Timestamp x)
            throws SQLException {
        callableStatement.setTimestamp(parameterIndex, x);
    }

    /**
     * @throws SQLException
     * @see java.sql.Statement#clearWarnings()
     */
    public void clearWarnings() throws SQLException {
        callableStatement.clearWarnings();
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBytes(int)
     */
    public byte[] getBytes(int parameterIndex) throws SQLException {
        return callableStatement.getBytes(parameterIndex);
    }

    /**
     * @param name
     * @throws SQLException
     * @see java.sql.Statement#setCursorName(java.lang.String)
     */
    public void setCursorName(String name) throws SQLException {
        callableStatement.setCursorName(name);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setAsciiStream(int, java.io.InputStream, int)
     */
    public void setAsciiStream(int parameterIndex, InputStream x, int length)
            throws SQLException {
        callableStatement.setAsciiStream(parameterIndex, x, length);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getDate(int)
     */
    public Date getDate(int parameterIndex) throws SQLException {
        return callableStatement.getDate(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTime(int)
     */
    public Time getTime(int parameterIndex) throws SQLException {
        return callableStatement.getTime(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param length
     * @throws SQLException
     * @deprecated
     * @see java.sql.PreparedStatement#setUnicodeStream(int, java.io.InputStream, int)
     */
    public void setUnicodeStream(int parameterIndex, InputStream x, int length)
            throws SQLException {
        callableStatement.setUnicodeStream(parameterIndex, x, length);
    }

    /**
     * @param sql
     * @return
     * @throws SQLException
     * @see java.sql.Statement#execute(java.lang.String)
     */
    public boolean execute(String sql) throws SQLException {
        return callableStatement.execute(sql);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTimestamp(int)
     */
    public Timestamp getTimestamp(int parameterIndex) throws SQLException {
        return callableStatement.getTimestamp(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getObject(int)
     */
    public Object getObject(int parameterIndex) throws SQLException {
        return callableStatement.getObject(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBinaryStream(int, java.io.InputStream, int)
     */
    public void setBinaryStream(int parameterIndex, InputStream x, int length)
            throws SQLException {
        callableStatement.setBinaryStream(parameterIndex, x, length);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getResultSet()
     */
    public ResultSet getResultSet() throws SQLException {
        return callableStatement.getResultSet();
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBigDecimal(int)
     */
    public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
        return callableStatement.getBigDecimal(parameterIndex);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getUpdateCount()
     */
    public int getUpdateCount() throws SQLException {
        return callableStatement.getUpdateCount();
    }

    /**
     * @throws SQLException
     * @see java.sql.PreparedStatement#clearParameters()
     */
    public void clearParameters() throws SQLException {
        callableStatement.clearParameters();
    }

    /**
     * @param parameterIndex
     * @param map
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getObject(int, java.util.Map)
     */
    public Object getObject(int parameterIndex, Map<String, Class<?>> map)
            throws SQLException {
        return callableStatement.getObject(parameterIndex, map);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getMoreResults()
     */
    public boolean getMoreResults() throws SQLException {
        return callableStatement.getMoreResults();
    }

    /**
     * @param parameterIndex
     * @param x
     * @param targetSqlType
     * @throws SQLException
     * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, int)
     */
    public void setObject(int parameterIndex, Object x, int targetSqlType)
            throws SQLException {
        callableStatement.setObject(parameterIndex, x, targetSqlType);
    }

    /**
     * @param direction
     * @throws SQLException
     * @see java.sql.Statement#setFetchDirection(int)
     */
    public void setFetchDirection(int direction) throws SQLException {
        callableStatement.setFetchDirection(direction);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getRef(int)
     */
    public Ref getRef(int parameterIndex) throws SQLException {
        return callableStatement.getRef(parameterIndex);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setObject(int, java.lang.Object)
     */
    public void setObject(int parameterIndex, Object x) throws SQLException {
        callableStatement.setObject(parameterIndex, x);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getFetchDirection()
     */
    public int getFetchDirection() throws SQLException {
        return callableStatement.getFetchDirection();
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBlob(int)
     */
    public Blob getBlob(int parameterIndex) throws SQLException {
        return callableStatement.getBlob(parameterIndex);
    }

    /**
     * @param rows
     * @throws SQLException
     * @see java.sql.Statement#setFetchSize(int)
     */
    public void setFetchSize(int rows) throws SQLException {
        callableStatement.setFetchSize(rows);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getClob(int)
     */
    public Clob getClob(int parameterIndex) throws SQLException {
        return callableStatement.getClob(parameterIndex);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getFetchSize()
     */
    public int getFetchSize() throws SQLException {
        return callableStatement.getFetchSize();
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.PreparedStatement#execute()
     */
    public boolean execute() throws SQLException {
        return callableStatement.execute();
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getArray(int)
     */
    public Array getArray(int parameterIndex) throws SQLException {
        return callableStatement.getArray(parameterIndex);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getResultSetConcurrency()
     */
    public int getResultSetConcurrency() throws SQLException {
        return callableStatement.getResultSetConcurrency();
    }

    /**
     * @param parameterIndex
     * @param cal
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getDate(int, java.util.Calendar)
     */
    public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
        return callableStatement.getDate(parameterIndex, cal);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getResultSetType()
     */
    public int getResultSetType() throws SQLException {
        return callableStatement.getResultSetType();
    }

    /**
     * @param sql
     * @throws SQLException
     * @see java.sql.Statement#addBatch(java.lang.String)
     */
    public void addBatch(String sql) throws SQLException {
        callableStatement.addBatch(sql);
    }

    /**
     * @throws SQLException
     * @see java.sql.PreparedStatement#addBatch()
     */
    public void addBatch() throws SQLException {
        callableStatement.addBatch();
    }

    /**
     * @param parameterIndex
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setCharacterStream(int, java.io.Reader, int)
     */
    public void setCharacterStream(int parameterIndex, Reader reader, int length)
            throws SQLException {
        callableStatement.setCharacterStream(parameterIndex, reader, length);
    }

    /**
     * @param parameterIndex
     * @param cal
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTime(int, java.util.Calendar)
     */
    public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
        return callableStatement.getTime(parameterIndex, cal);
    }

    /**
     * @throws SQLException
     * @see java.sql.Statement#clearBatch()
     */
    public void clearBatch() throws SQLException {
        callableStatement.clearBatch();
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeBatch()
     */
    public int[] executeBatch() throws SQLException {
        return callableStatement.executeBatch();
    }

    /**
     * @param parameterIndex
     * @param cal
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTimestamp(int, java.util.Calendar)
     */
    public Timestamp getTimestamp(int parameterIndex, Calendar cal)
            throws SQLException {
        return callableStatement.getTimestamp(parameterIndex, cal);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setRef(int, java.sql.Ref)
     */
    public void setRef(int parameterIndex, Ref x) throws SQLException {
        callableStatement.setRef(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBlob(int, java.sql.Blob)
     */
    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        callableStatement.setBlob(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @param typeName
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(int, int, java.lang.String)
     */
    public void registerOutParameter(int parameterIndex, int sqlType,
            String typeName) throws SQLException {
        d("registerOutParameter(parameterIndex/sqlType/typeName):" + parameterIndex + ":" + sqlType + ":" + typeName);
        callableStatement.registerOutParameter(parameterIndex, sqlType,
                typeName);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setClob(int, java.sql.Clob)
     */
    public void setClob(int parameterIndex, Clob x) throws SQLException {
        callableStatement.setClob(parameterIndex, x);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setArray(int, java.sql.Array)
     */
    public void setArray(int parameterIndex, Array x) throws SQLException {
        callableStatement.setArray(parameterIndex, x);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getConnection()
     */
    public Connection getConnection() throws SQLException {
        return callableStatement.getConnection();
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.PreparedStatement#getMetaData()
     */
    public ResultSetMetaData getMetaData() throws SQLException {
        return callableStatement.getMetaData();
    }

    /**
     * @param parameterName
     * @param sqlType
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(java.lang.String, int)
     */
    public void registerOutParameter(String parameterName, int sqlType)
            throws SQLException {
        d("registerOutParameter(parameterName/sqlType):" + parameterName + ":" + sqlType);
        callableStatement.registerOutParameter(parameterName, sqlType);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param cal
     * @throws SQLException
     * @see java.sql.PreparedStatement#setDate(int, java.sql.Date, java.util.Calendar)
     */
    public void setDate(int parameterIndex, Date x, Calendar cal)
            throws SQLException {
        callableStatement.setDate(parameterIndex, x, cal);
    }

    /**
     * @param current
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getMoreResults(int)
     */
    public boolean getMoreResults(int current) throws SQLException {
        return callableStatement.getMoreResults(current);
    }

    /**
     * @param parameterName
     * @param sqlType
     * @param scale
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(java.lang.String, int, int)
     */
    public void registerOutParameter(String parameterName, int sqlType,
            int scale) throws SQLException {
        d("registerOutParameter(parameterName/sqlType/scale):" + parameterName + ":" + sqlType + ":" + scale);
        callableStatement.registerOutParameter(parameterName, sqlType, scale);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param cal
     * @throws SQLException
     * @see java.sql.PreparedStatement#setTime(int, java.sql.Time, java.util.Calendar)
     */
    public void setTime(int parameterIndex, Time x, Calendar cal)
            throws SQLException {
        callableStatement.setTime(parameterIndex, x, cal);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getGeneratedKeys()
     */
    public ResultSet getGeneratedKeys() throws SQLException {
        return callableStatement.getGeneratedKeys();
    }

    /**
     * @param parameterIndex
     * @param x
     * @param cal
     * @throws SQLException
     * @see java.sql.PreparedStatement#setTimestamp(int, java.sql.Timestamp, java.util.Calendar)
     */
    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
            throws SQLException {
        callableStatement.setTimestamp(parameterIndex, x, cal);
    }

    /**
     * @param parameterName
     * @param sqlType
     * @param typeName
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(java.lang.String, int, java.lang.String)
     */
    public void registerOutParameter(String parameterName, int sqlType,
            String typeName) throws SQLException {
        d("registerOutParameter(parameterName/sqlType/typeName):" + parameterName + ":" + sqlType + ":" + typeName);
        callableStatement
                .registerOutParameter(parameterName, sqlType, typeName);
    }

    /**
     * @param sql
     * @param autoGeneratedKeys
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeUpdate(java.lang.String, int)
     */
    public int executeUpdate(String sql, int autoGeneratedKeys)
            throws SQLException {
        return callableStatement.executeUpdate(sql, autoGeneratedKeys);
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @param typeName
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNull(int, int, java.lang.String)
     */
    public void setNull(int parameterIndex, int sqlType, String typeName)
            throws SQLException {
        d("setNull(parameterIndex/sqlType/typeName):" + parameterIndex + ":" + sqlType + ":" + typeName);
        callableStatement.setNull(parameterIndex, sqlType, typeName);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getURL(int)
     */
    public URL getURL(int parameterIndex) throws SQLException {
        return callableStatement.getURL(parameterIndex);
    }

    /**
     * @param sql
     * @param columnIndexes
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeUpdate(java.lang.String, int[])
     */
    public int executeUpdate(String sql, int[] columnIndexes)
            throws SQLException {
        return callableStatement.executeUpdate(sql, columnIndexes);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setURL(int, java.net.URL)
     */
    public void setURL(int parameterIndex, URL x) throws SQLException {
        callableStatement.setURL(parameterIndex, x);
    }

    /**
     * @param parameterName
     * @param val
     * @throws SQLException
     * @see java.sql.CallableStatement#setURL(java.lang.String, java.net.URL)
     */
    public void setURL(String parameterName, URL val) throws SQLException {
        callableStatement.setURL(parameterName, val);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.PreparedStatement#getParameterMetaData()
     */
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return callableStatement.getParameterMetaData();
    }

    /**
     * @param parameterName
     * @param sqlType
     * @throws SQLException
     * @see java.sql.CallableStatement#setNull(java.lang.String, int)
     */
    public void setNull(String parameterName, int sqlType) throws SQLException {
        d("setNull(parameterName/sqlType):" + parameterName + ":" + sqlType);
        callableStatement.setNull(parameterName, sqlType);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setRowId(int, java.sql.RowId)
     */
    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        callableStatement.setRowId(parameterIndex, x);
    }

    /**
     * @param sql
     * @param columnNames
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeUpdate(java.lang.String, java.lang.String[])
     */
    public int executeUpdate(String sql, String[] columnNames)
            throws SQLException {
        return callableStatement.executeUpdate(sql, columnNames);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setBoolean(java.lang.String, boolean)
     */
    public void setBoolean(String parameterName, boolean x) throws SQLException {
        callableStatement.setBoolean(parameterName, x);
    }

    /**
     * @param parameterIndex
     * @param value
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNString(int, java.lang.String)
     */
    public void setNString(int parameterIndex, String value)
            throws SQLException {
        callableStatement.setNString(parameterIndex, value);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setByte(java.lang.String, byte)
     */
    public void setByte(String parameterName, byte x) throws SQLException {
        callableStatement.setByte(parameterName, x);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setShort(java.lang.String, short)
     */
    public void setShort(String parameterName, short x) throws SQLException {
        callableStatement.setShort(parameterName, x);
    }

    /**
     * @param parameterIndex
     * @param value
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNCharacterStream(int, java.io.Reader, long)
     */
    public void setNCharacterStream(int parameterIndex, Reader value,
            long length) throws SQLException {
        callableStatement.setNCharacterStream(parameterIndex, value, length);
    }

    /**
     * @param sql
     * @param autoGeneratedKeys
     * @return
     * @throws SQLException
     * @see java.sql.Statement#execute(java.lang.String, int)
     */
    public boolean execute(String sql, int autoGeneratedKeys)
            throws SQLException {
        return callableStatement.execute(sql, autoGeneratedKeys);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setInt(java.lang.String, int)
     */
    public void setInt(String parameterName, int x) throws SQLException {
        callableStatement.setInt(parameterName, x);
    }

    /**
     * @param parameterIndex
     * @param value
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNClob(int, java.sql.NClob)
     */
    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        callableStatement.setNClob(parameterIndex, value);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setLong(java.lang.String, long)
     */
    public void setLong(String parameterName, long x) throws SQLException {
        callableStatement.setLong(parameterName, x);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setFloat(java.lang.String, float)
     */
    public void setFloat(String parameterName, float x) throws SQLException {
        callableStatement.setFloat(parameterName, x);
    }

    /**
     * @param parameterIndex
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setClob(int, java.io.Reader, long)
     */
    public void setClob(int parameterIndex, Reader reader, long length)
            throws SQLException {
        callableStatement.setClob(parameterIndex, reader, length);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setDouble(java.lang.String, double)
     */
    public void setDouble(String parameterName, double x) throws SQLException {
        callableStatement.setDouble(parameterName, x);
    }

    /**
     * @param sql
     * @param columnIndexes
     * @return
     * @throws SQLException
     * @see java.sql.Statement#execute(java.lang.String, int[])
     */
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        return callableStatement.execute(sql, columnIndexes);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setBigDecimal(java.lang.String, java.math.BigDecimal)
     */
    public void setBigDecimal(String parameterName, BigDecimal x)
            throws SQLException {
        callableStatement.setBigDecimal(parameterName, x);
    }

    /**
     * @param parameterIndex
     * @param inputStream
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBlob(int, java.io.InputStream, long)
     */
    public void setBlob(int parameterIndex, InputStream inputStream, long length)
            throws SQLException {
        callableStatement.setBlob(parameterIndex, inputStream, length);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setString(java.lang.String, java.lang.String)
     */
    public void setString(String parameterName, String x) throws SQLException {
        d("setString:" + parameterName + ":" + x);
        callableStatement.setString(parameterName, x);
    }

    /**
     * @param parameterIndex
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNClob(int, java.io.Reader, long)
     */
    public void setNClob(int parameterIndex, Reader reader, long length)
            throws SQLException {
        callableStatement.setNClob(parameterIndex, reader, length);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setBytes(java.lang.String, byte[])
     */
    public void setBytes(String parameterName, byte[] x) throws SQLException {
        callableStatement.setBytes(parameterName, x);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setDate(java.lang.String, java.sql.Date)
     */
    public void setDate(String parameterName, Date x) throws SQLException {
        callableStatement.setDate(parameterName, x);
    }

    /**
     * @param sql
     * @param columnNames
     * @return
     * @throws SQLException
     * @see java.sql.Statement#execute(java.lang.String, java.lang.String[])
     */
    public boolean execute(String sql, String[] columnNames)
            throws SQLException {
        return callableStatement.execute(sql, columnNames);
    }

    /**
     * @param parameterIndex
     * @param xmlObject
     * @throws SQLException
     * @see java.sql.PreparedStatement#setSQLXML(int, java.sql.SQLXML)
     */
    public void setSQLXML(int parameterIndex, SQLXML xmlObject)
            throws SQLException {
        callableStatement.setSQLXML(parameterIndex, xmlObject);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setTime(java.lang.String, java.sql.Time)
     */
    public void setTime(String parameterName, Time x) throws SQLException {
        callableStatement.setTime(parameterName, x);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setTimestamp(java.lang.String, java.sql.Timestamp)
     */
    public void setTimestamp(String parameterName, Timestamp x)
            throws SQLException {
        callableStatement.setTimestamp(parameterName, x);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param targetSqlType
     * @param scaleOrLength
     * @throws SQLException
     * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, int, int)
     */
    public void setObject(int parameterIndex, Object x, int targetSqlType,
            int scaleOrLength) throws SQLException {
        callableStatement.setObject(parameterIndex, x, targetSqlType,
                scaleOrLength);
    }

    /**
     * @param parameterName
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setAsciiStream(java.lang.String, java.io.InputStream, int)
     */
    public void setAsciiStream(String parameterName, InputStream x, int length)
            throws SQLException {
        callableStatement.setAsciiStream(parameterName, x, length);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getResultSetHoldability()
     */
    public int getResultSetHoldability() throws SQLException {
        return callableStatement.getResultSetHoldability();
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#isClosed()
     */
    public boolean isClosed() throws SQLException {
        return callableStatement.isClosed();
    }

    /**
     * @param parameterName
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setBinaryStream(java.lang.String, java.io.InputStream, int)
     */
    public void setBinaryStream(String parameterName, InputStream x, int length)
            throws SQLException {
        callableStatement.setBinaryStream(parameterName, x, length);
    }

    /**
     * @param poolable
     * @throws SQLException
     * @see java.sql.Statement#setPoolable(boolean)
     */
    public void setPoolable(boolean poolable) throws SQLException {
        callableStatement.setPoolable(poolable);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setAsciiStream(int, java.io.InputStream, long)
     */
    public void setAsciiStream(int parameterIndex, InputStream x, long length)
            throws SQLException {
        callableStatement.setAsciiStream(parameterIndex, x, length);
    }

    /**
     * @param parameterName
     * @param x
     * @param targetSqlType
     * @param scale
     * @throws SQLException
     * @see java.sql.CallableStatement#setObject(java.lang.String, java.lang.Object, int, int)
     */
    public void setObject(String parameterName, Object x, int targetSqlType,
            int scale) throws SQLException {
        callableStatement.setObject(parameterName, x, targetSqlType, scale);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#isPoolable()
     */
    public boolean isPoolable() throws SQLException {
        return callableStatement.isPoolable();
    }

    /**
     * @throws SQLException
     * @see java.sql.Statement#closeOnCompletion()
     */
    public void closeOnCompletion() throws SQLException {
        callableStatement.closeOnCompletion();
    }

    /**
     * @param parameterIndex
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBinaryStream(int, java.io.InputStream, long)
     */
    public void setBinaryStream(int parameterIndex, InputStream x, long length)
            throws SQLException {
        callableStatement.setBinaryStream(parameterIndex, x, length);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#isCloseOnCompletion()
     */
    public boolean isCloseOnCompletion() throws SQLException {
        return callableStatement.isCloseOnCompletion();
    }

    /**
     * @param parameterName
     * @param x
     * @param targetSqlType
     * @throws SQLException
     * @see java.sql.CallableStatement#setObject(java.lang.String, java.lang.Object, int)
     */
    public void setObject(String parameterName, Object x, int targetSqlType)
            throws SQLException {
        callableStatement.setObject(parameterName, x, targetSqlType);
    }

    /**
     * @param parameterIndex
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.PreparedStatement#setCharacterStream(int, java.io.Reader, long)
     */
    public void setCharacterStream(int parameterIndex, Reader reader,
            long length) throws SQLException {
        callableStatement.setCharacterStream(parameterIndex, reader, length);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getLargeUpdateCount()
     */
    public long getLargeUpdateCount() throws SQLException {
        return callableStatement.getLargeUpdateCount();
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setObject(java.lang.String, java.lang.Object)
     */
    public void setObject(String parameterName, Object x) throws SQLException {
        callableStatement.setObject(parameterName, x);
    }

    /**
     * @param max
     * @throws SQLException
     * @see java.sql.Statement#setLargeMaxRows(long)
     */
    public void setLargeMaxRows(long max) throws SQLException {
        callableStatement.setLargeMaxRows(max);
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setAsciiStream(int, java.io.InputStream)
     */
    public void setAsciiStream(int parameterIndex, InputStream x)
            throws SQLException {
        callableStatement.setAsciiStream(parameterIndex, x);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#getLargeMaxRows()
     */
    public long getLargeMaxRows() throws SQLException {
        return callableStatement.getLargeMaxRows();
    }

    /**
     * @param parameterIndex
     * @param x
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBinaryStream(int, java.io.InputStream)
     */
    public void setBinaryStream(int parameterIndex, InputStream x)
            throws SQLException {
        callableStatement.setBinaryStream(parameterIndex, x);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeLargeBatch()
     */
    public long[] executeLargeBatch() throws SQLException {
        return callableStatement.executeLargeBatch();
    }

    /**
     * @param parameterName
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setCharacterStream(java.lang.String, java.io.Reader, int)
     */
    public void setCharacterStream(String parameterName, Reader reader,
            int length) throws SQLException {
        callableStatement.setCharacterStream(parameterName, reader, length);
    }

    /**
     * @param parameterIndex
     * @param reader
     * @throws SQLException
     * @see java.sql.PreparedStatement#setCharacterStream(int, java.io.Reader)
     */
    public void setCharacterStream(int parameterIndex, Reader reader)
            throws SQLException {
        callableStatement.setCharacterStream(parameterIndex, reader);
    }

    /**
     * @param parameterName
     * @param x
     * @param cal
     * @throws SQLException
     * @see java.sql.CallableStatement#setDate(java.lang.String, java.sql.Date, java.util.Calendar)
     */
    public void setDate(String parameterName, Date x, Calendar cal)
            throws SQLException {
        callableStatement.setDate(parameterName, x, cal);
    }

    /**
     * @param parameterIndex
     * @param value
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNCharacterStream(int, java.io.Reader)
     */
    public void setNCharacterStream(int parameterIndex, Reader value)
            throws SQLException {
        callableStatement.setNCharacterStream(parameterIndex, value);
    }

    /**
     * @param parameterName
     * @param x
     * @param cal
     * @throws SQLException
     * @see java.sql.CallableStatement#setTime(java.lang.String, java.sql.Time, java.util.Calendar)
     */
    public void setTime(String parameterName, Time x, Calendar cal)
            throws SQLException {
        callableStatement.setTime(parameterName, x, cal);
    }

    /**
     * @param sql
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeLargeUpdate(java.lang.String)
     */
    public long executeLargeUpdate(String sql) throws SQLException {
        return callableStatement.executeLargeUpdate(sql);
    }

    /**
     * @param parameterIndex
     * @param reader
     * @throws SQLException
     * @see java.sql.PreparedStatement#setClob(int, java.io.Reader)
     */
    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        callableStatement.setClob(parameterIndex, reader);
    }

    /**
     * @param parameterName
     * @param x
     * @param cal
     * @throws SQLException
     * @see java.sql.CallableStatement#setTimestamp(java.lang.String, java.sql.Timestamp, java.util.Calendar)
     */
    public void setTimestamp(String parameterName, Timestamp x, Calendar cal)
            throws SQLException {
        callableStatement.setTimestamp(parameterName, x, cal);
    }

    /**
     * @param sql
     * @param autoGeneratedKeys
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeLargeUpdate(java.lang.String, int)
     */
    public long executeLargeUpdate(String sql, int autoGeneratedKeys)
            throws SQLException {
        return callableStatement.executeLargeUpdate(sql, autoGeneratedKeys);
    }

    /**
     * @param parameterName
     * @param sqlType
     * @param typeName
     * @throws SQLException
     * @see java.sql.CallableStatement#setNull(java.lang.String, int, java.lang.String)
     */
    public void setNull(String parameterName, int sqlType, String typeName)
            throws SQLException {
        d("setNull(parameterName/sqlType/typeName):" + parameterName + ":" + sqlType + ":" + typeName);
        callableStatement.setNull(parameterName, sqlType, typeName);
    }

    /**
     * @param parameterIndex
     * @param inputStream
     * @throws SQLException
     * @see java.sql.PreparedStatement#setBlob(int, java.io.InputStream)
     */
    public void setBlob(int parameterIndex, InputStream inputStream)
            throws SQLException {
        callableStatement.setBlob(parameterIndex, inputStream);
    }

    /**
     * @param parameterIndex
     * @param reader
     * @throws SQLException
     * @see java.sql.PreparedStatement#setNClob(int, java.io.Reader)
     */
    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        callableStatement.setNClob(parameterIndex, reader);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getString(java.lang.String)
     */
    public String getString(String parameterName) throws SQLException {
        return callableStatement.getString(parameterName);
    }

    /**
     * @param sql
     * @param columnIndexes
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeLargeUpdate(java.lang.String, int[])
     */
    public long executeLargeUpdate(String sql, int[] columnIndexes)
            throws SQLException {
        return callableStatement.executeLargeUpdate(sql, columnIndexes);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBoolean(java.lang.String)
     */
    public boolean getBoolean(String parameterName) throws SQLException {
        return callableStatement.getBoolean(parameterName);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param targetSqlType
     * @param scaleOrLength
     * @throws SQLException
     * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, java.sql.SQLType, int)
     */
    public void setObject(int parameterIndex, Object x,
            SQLType targetSqlType, int scaleOrLength) throws SQLException {
        callableStatement.setObject(parameterIndex, x, targetSqlType,
                scaleOrLength);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getByte(java.lang.String)
     */
    public byte getByte(String parameterName) throws SQLException {
        return callableStatement.getByte(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getShort(java.lang.String)
     */
    public short getShort(String parameterName) throws SQLException {
        return callableStatement.getShort(parameterName);
    }

    /**
     * @param sql
     * @param columnNames
     * @return
     * @throws SQLException
     * @see java.sql.Statement#executeLargeUpdate(java.lang.String, java.lang.String[])
     */
    public long executeLargeUpdate(String sql, String[] columnNames)
            throws SQLException {
        return callableStatement.executeLargeUpdate(sql, columnNames);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getInt(java.lang.String)
     */
    public int getInt(String parameterName) throws SQLException {
        return callableStatement.getInt(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getLong(java.lang.String)
     */
    public long getLong(String parameterName) throws SQLException {
        return callableStatement.getLong(parameterName);
    }

    /**
     * @param parameterIndex
     * @param x
     * @param targetSqlType
     * @throws SQLException
     * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, java.sql.SQLType)
     */
    public void setObject(int parameterIndex, Object x,
            SQLType targetSqlType) throws SQLException {
        callableStatement.setObject(parameterIndex, x, targetSqlType);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getFloat(java.lang.String)
     */
    public float getFloat(String parameterName) throws SQLException {
        return callableStatement.getFloat(parameterName);
    }

    /**
     * @return
     * @throws SQLException
     * @see java.sql.PreparedStatement#executeLargeUpdate()
     */
    public long executeLargeUpdate() throws SQLException {
        return callableStatement.executeLargeUpdate();
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getDouble(java.lang.String)
     */
    public double getDouble(String parameterName) throws SQLException {
        return callableStatement.getDouble(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBytes(java.lang.String)
     */
    public byte[] getBytes(String parameterName) throws SQLException {
        return callableStatement.getBytes(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getDate(java.lang.String)
     */
    public Date getDate(String parameterName) throws SQLException {
        return callableStatement.getDate(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTime(java.lang.String)
     */
    public Time getTime(String parameterName) throws SQLException {
        return callableStatement.getTime(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTimestamp(java.lang.String)
     */
    public Timestamp getTimestamp(String parameterName) throws SQLException {
        return callableStatement.getTimestamp(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getObject(java.lang.String)
     */
    public Object getObject(String parameterName) throws SQLException {
        return callableStatement.getObject(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBigDecimal(java.lang.String)
     */
    public BigDecimal getBigDecimal(String parameterName) throws SQLException {
        return callableStatement.getBigDecimal(parameterName);
    }

    /**
     * @param parameterName
     * @param map
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getObject(java.lang.String, java.util.Map)
     */
    public Object getObject(String parameterName, Map<String, Class<?>> map)
            throws SQLException {
        return callableStatement.getObject(parameterName, map);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getRef(java.lang.String)
     */
    public Ref getRef(String parameterName) throws SQLException {
        return callableStatement.getRef(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getBlob(java.lang.String)
     */
    public Blob getBlob(String parameterName) throws SQLException {
        return callableStatement.getBlob(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getClob(java.lang.String)
     */
    public Clob getClob(String parameterName) throws SQLException {
        return callableStatement.getClob(parameterName);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getArray(java.lang.String)
     */
    public Array getArray(String parameterName) throws SQLException {
        return callableStatement.getArray(parameterName);
    }

    /**
     * @param parameterName
     * @param cal
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getDate(java.lang.String, java.util.Calendar)
     */
    public Date getDate(String parameterName, Calendar cal) throws SQLException {
        return callableStatement.getDate(parameterName, cal);
    }

    /**
     * @param parameterName
     * @param cal
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTime(java.lang.String, java.util.Calendar)
     */
    public Time getTime(String parameterName, Calendar cal) throws SQLException {
        return callableStatement.getTime(parameterName, cal);
    }

    /**
     * @param parameterName
     * @param cal
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getTimestamp(java.lang.String, java.util.Calendar)
     */
    public Timestamp getTimestamp(String parameterName, Calendar cal)
            throws SQLException {
        return callableStatement.getTimestamp(parameterName, cal);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getURL(java.lang.String)
     */
    public URL getURL(String parameterName) throws SQLException {
        return callableStatement.getURL(parameterName);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getRowId(int)
     */
    public RowId getRowId(int parameterIndex) throws SQLException {
        return callableStatement.getRowId(parameterIndex);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getRowId(java.lang.String)
     */
    public RowId getRowId(String parameterName) throws SQLException {
        return callableStatement.getRowId(parameterName);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setRowId(java.lang.String, java.sql.RowId)
     */
    public void setRowId(String parameterName, RowId x) throws SQLException {
        callableStatement.setRowId(parameterName, x);
    }

    /**
     * @param parameterName
     * @param value
     * @throws SQLException
     * @see java.sql.CallableStatement#setNString(java.lang.String, java.lang.String)
     */
    public void setNString(String parameterName, String value)
            throws SQLException {
        callableStatement.setNString(parameterName, value);
    }

    /**
     * @param parameterName
     * @param value
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setNCharacterStream(java.lang.String, java.io.Reader, long)
     */
    public void setNCharacterStream(String parameterName, Reader value,
            long length) throws SQLException {
        callableStatement.setNCharacterStream(parameterName, value, length);
    }

    /**
     * @param parameterName
     * @param value
     * @throws SQLException
     * @see java.sql.CallableStatement#setNClob(java.lang.String, java.sql.NClob)
     */
    public void setNClob(String parameterName, NClob value) throws SQLException {
        callableStatement.setNClob(parameterName, value);
    }

    /**
     * @param parameterName
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setClob(java.lang.String, java.io.Reader, long)
     */
    public void setClob(String parameterName, Reader reader, long length)
            throws SQLException {
        callableStatement.setClob(parameterName, reader, length);
    }

    /**
     * @param parameterName
     * @param inputStream
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setBlob(java.lang.String, java.io.InputStream, long)
     */
    public void setBlob(String parameterName, InputStream inputStream,
            long length) throws SQLException {
        callableStatement.setBlob(parameterName, inputStream, length);
    }

    /**
     * @param parameterName
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setNClob(java.lang.String, java.io.Reader, long)
     */
    public void setNClob(String parameterName, Reader reader, long length)
            throws SQLException {
        callableStatement.setNClob(parameterName, reader, length);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getNClob(int)
     */
    public NClob getNClob(int parameterIndex) throws SQLException {
        return callableStatement.getNClob(parameterIndex);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getNClob(java.lang.String)
     */
    public NClob getNClob(String parameterName) throws SQLException {
        return callableStatement.getNClob(parameterName);
    }

    /**
     * @param parameterName
     * @param xmlObject
     * @throws SQLException
     * @see java.sql.CallableStatement#setSQLXML(java.lang.String, java.sql.SQLXML)
     */
    public void setSQLXML(String parameterName, SQLXML xmlObject)
            throws SQLException {
        callableStatement.setSQLXML(parameterName, xmlObject);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getSQLXML(int)
     */
    public SQLXML getSQLXML(int parameterIndex) throws SQLException {
        return callableStatement.getSQLXML(parameterIndex);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getSQLXML(java.lang.String)
     */
    public SQLXML getSQLXML(String parameterName) throws SQLException {
        return callableStatement.getSQLXML(parameterName);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getNString(int)
     */
    public String getNString(int parameterIndex) throws SQLException {
        return callableStatement.getNString(parameterIndex);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getNString(java.lang.String)
     */
    public String getNString(String parameterName) throws SQLException {
        return callableStatement.getNString(parameterName);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getNCharacterStream(int)
     */
    public Reader getNCharacterStream(int parameterIndex) throws SQLException {
        return callableStatement.getNCharacterStream(parameterIndex);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getNCharacterStream(java.lang.String)
     */
    public Reader getNCharacterStream(String parameterName) throws SQLException {
        return callableStatement.getNCharacterStream(parameterName);
    }

    /**
     * @param parameterIndex
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getCharacterStream(int)
     */
    public Reader getCharacterStream(int parameterIndex) throws SQLException {
        return callableStatement.getCharacterStream(parameterIndex);
    }

    /**
     * @param parameterName
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getCharacterStream(java.lang.String)
     */
    public Reader getCharacterStream(String parameterName) throws SQLException {
        return callableStatement.getCharacterStream(parameterName);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setBlob(java.lang.String, java.sql.Blob)
     */
    public void setBlob(String parameterName, Blob x) throws SQLException {
        callableStatement.setBlob(parameterName, x);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setClob(java.lang.String, java.sql.Clob)
     */
    public void setClob(String parameterName, Clob x) throws SQLException {
        callableStatement.setClob(parameterName, x);
    }

    /**
     * @param parameterName
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setAsciiStream(java.lang.String, java.io.InputStream, long)
     */
    public void setAsciiStream(String parameterName, InputStream x, long length)
            throws SQLException {
        callableStatement.setAsciiStream(parameterName, x, length);
    }

    /**
     * @param parameterName
     * @param x
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setBinaryStream(java.lang.String, java.io.InputStream, long)
     */
    public void setBinaryStream(String parameterName, InputStream x, long length)
            throws SQLException {
        callableStatement.setBinaryStream(parameterName, x, length);
    }

    /**
     * @param parameterName
     * @param reader
     * @param length
     * @throws SQLException
     * @see java.sql.CallableStatement#setCharacterStream(java.lang.String, java.io.Reader, long)
     */
    public void setCharacterStream(String parameterName, Reader reader,
            long length) throws SQLException {
        callableStatement.setCharacterStream(parameterName, reader, length);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setAsciiStream(java.lang.String, java.io.InputStream)
     */
    public void setAsciiStream(String parameterName, InputStream x)
            throws SQLException {
        callableStatement.setAsciiStream(parameterName, x);
    }

    /**
     * @param parameterName
     * @param x
     * @throws SQLException
     * @see java.sql.CallableStatement#setBinaryStream(java.lang.String, java.io.InputStream)
     */
    public void setBinaryStream(String parameterName, InputStream x)
            throws SQLException {
        callableStatement.setBinaryStream(parameterName, x);
    }

    /**
     * @param parameterName
     * @param reader
     * @throws SQLException
     * @see java.sql.CallableStatement#setCharacterStream(java.lang.String, java.io.Reader)
     */
    public void setCharacterStream(String parameterName, Reader reader)
            throws SQLException {
        callableStatement.setCharacterStream(parameterName, reader);
    }

    /**
     * @param parameterName
     * @param value
     * @throws SQLException
     * @see java.sql.CallableStatement#setNCharacterStream(java.lang.String, java.io.Reader)
     */
    public void setNCharacterStream(String parameterName, Reader value)
            throws SQLException {
        callableStatement.setNCharacterStream(parameterName, value);
    }

    /**
     * @param parameterName
     * @param reader
     * @throws SQLException
     * @see java.sql.CallableStatement#setClob(java.lang.String, java.io.Reader)
     */
    public void setClob(String parameterName, Reader reader)
            throws SQLException {
        callableStatement.setClob(parameterName, reader);
    }

    /**
     * @param parameterName
     * @param inputStream
     * @throws SQLException
     * @see java.sql.CallableStatement#setBlob(java.lang.String, java.io.InputStream)
     */
    public void setBlob(String parameterName, InputStream inputStream)
            throws SQLException {
        callableStatement.setBlob(parameterName, inputStream);
    }

    /**
     * @param parameterName
     * @param reader
     * @throws SQLException
     * @see java.sql.CallableStatement#setNClob(java.lang.String, java.io.Reader)
     */
    public void setNClob(String parameterName, Reader reader)
            throws SQLException {
        callableStatement.setNClob(parameterName, reader);
    }

    /**
     * @param parameterIndex
     * @param type
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getObject(int, java.lang.Class)
     */
    public <T> T getObject(int parameterIndex, Class<T> type)
            throws SQLException {
        return callableStatement.getObject(parameterIndex, type);
    }

    /**
     * @param parameterName
     * @param type
     * @return
     * @throws SQLException
     * @see java.sql.CallableStatement#getObject(java.lang.String, java.lang.Class)
     */
    public <T> T getObject(String parameterName, Class<T> type)
            throws SQLException {
        return callableStatement.getObject(parameterName, type);
    }

    /**
     * @param parameterName
     * @param x
     * @param targetSqlType
     * @param scaleOrLength
     * @throws SQLException
     * @see java.sql.CallableStatement#setObject(java.lang.String, java.lang.Object, java.sql.SQLType, int)
     */
    public void setObject(String parameterName, Object x,
            SQLType targetSqlType, int scaleOrLength) throws SQLException {
        callableStatement.setObject(parameterName, x, targetSqlType,
                scaleOrLength);
    }

    /**
     * @param parameterName
     * @param x
     * @param targetSqlType
     * @throws SQLException
     * @see java.sql.CallableStatement#setObject(java.lang.String, java.lang.Object, java.sql.SQLType)
     */
    public void setObject(String parameterName, Object x,
            SQLType targetSqlType) throws SQLException {
        callableStatement.setObject(parameterName, x, targetSqlType);
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(int, java.sql.SQLType)
     */
    public void registerOutParameter(int parameterIndex, SQLType sqlType)
            throws SQLException {
        d("registerOutParameter(parameterIndex/sqlType):" + parameterIndex + ":" + sqlType + "");
        callableStatement.registerOutParameter(parameterIndex, sqlType);
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @param scale
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(int, java.sql.SQLType, int)
     */
    public void registerOutParameter(int parameterIndex,
            SQLType sqlType, int scale) throws SQLException {
        d("registerOutParameter(parameterIndex/sqlType/scale):" + parameterIndex + ":" + sqlType + ":" + scale);
        callableStatement.registerOutParameter(parameterIndex, sqlType, scale);
    }

    /**
     * @param parameterIndex
     * @param sqlType
     * @param typeName
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(int, java.sql.SQLType, java.lang.String)
     */
    public void registerOutParameter(int parameterIndex,
            SQLType sqlType, String typeName) throws SQLException {
        d("registerOutParameter(parameterIndex/sqlType/typeName):" + parameterIndex + ":" + sqlType + ":" + typeName);
        callableStatement.registerOutParameter(parameterIndex, sqlType, typeName);
    }

    /**
     * @param parameterName
     * @param sqlType
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(java.lang.String, java.sql.SQLType)
     */
    public void registerOutParameter(String parameterName,
            SQLType sqlType) throws SQLException {
        d("registerOutParameter(parameterName/sqlType):" + parameterName + ":" + sqlType);
        callableStatement.registerOutParameter(parameterName, sqlType);
    }

    /**
     * @param parameterName
     * @param sqlType
     * @param scale
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(java.lang.String, java.sql.SQLType, int)
     */
    public void registerOutParameter(String parameterName,
            SQLType sqlType, int scale) throws SQLException {
        d("registerOutParameter(parameterName/sqlType/scale):" + parameterName + ":" + sqlType + ":" + scale);
        callableStatement.registerOutParameter(parameterName, sqlType, scale);
    }

    /**
     * @param parameterName
     * @param sqlType
     * @param typeName
     * @throws SQLException
     * @see java.sql.CallableStatement#registerOutParameter(java.lang.String, java.sql.SQLType, java.lang.String)
     */
    public void registerOutParameter(String parameterName,
            SQLType sqlType, String typeName) throws SQLException {
        d("registerOutParameter(parameterName/sqlType/typeName):" + parameterName + ":" + sqlType + ":" + typeName);
        callableStatement
                .registerOutParameter(parameterName, sqlType, typeName);
    }
}
