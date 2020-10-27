package com.example.ws.mysql;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {

    @Override
    public Connection getConnection() throws SQLException {

        //取出连接池中一个连接
        final Connection conn = dataSources.removeFirst(); //删除第一个连接返回
        return conn;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

     LinkedList<Connection> dataSources = new LinkedList<Connection>();
    //无参构造器,初始化连接数量
    public MyDataSource() {
        //一次性创建10个连接
        for(int i = 0; i < 10; i++) {
            try {
                //1、获取数据库连接对象
                Connection conn = JdbcUtil.getConnection();
                //2、将连接加入连接池中
                dataSources.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    //将连接放回连接池
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
    }
}
