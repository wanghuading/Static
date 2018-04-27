package com.sz.learn.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author whd
 * @Date 2018/4/27 14:55
 * @Description
 **/
public class JdbcTemplate<T> {
    private DataSource dataSource;
    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
      * @Author whd
      * @Date 2018/4/27 15:14
      * @Param []
      * @Return java.sql.Connection
      * @Description  获取连接
      **/
    private Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    /**
      * @Author whd
      * @Date 2018/4/27 15:33
      * @Param [conn, sql]
      * @Return java.sql.PreparedStatement
      * @Description 创建语句集
      **/
    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    /**
      * @Author whd
      * @Date 2018/4/27 15:44
      * @Param [stmt, values]
      * @Return java.sql.ResultSet
      * @Description 设置参数，并执行结果集
      **/
    private ResultSet executeQuery(PreparedStatement stmt, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i, values[i]);
        }
        return stmt.executeQuery();
    }

    /**
      * @Author whd
      * @Date 2018/4/27 15:50
      * @Param [rs, rowMapper]
      * @Return java.util.List<T>
      * @Description 解析结果集
      **/
    private List<T> parseResultSet(ResultSet rs, RowMapper rowMapper) throws Exception {
        List<T> list = new ArrayList<>();
        int rowNumber = 0;
        while (rs.next()) {
            list.add((T) rowMapper.mapRow(rs, rowNumber++));
        }
        return list;
    }

    /**
     * @Author whd
     * @Date 2018/4/27 15:50
     * @Param [rs]
     * @Return void
     * @Description 关闭结果集
     **/
    private void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }
    /**
      * @Author whd
      * @Date 2018/4/27 15:51
      * @Param [stmt]
      * @Return void
      * @Description 关闭语句集
      **/
    private void closePreparedStatement(PreparedStatement stmt) throws Exception {
        stmt.close();
    }

    /**
      * @Author whd
      * @Date 2018/4/27 15:52
      * @Param [conn]
      * @Return void
      * @Description 关闭结果集
      **/
    private void closeConnection(Connection conn) throws Exception {
        conn.close();
    }

    /**
      * @Author whd
      * @Date 2018/4/27 15:01
      * @Param [sql]
      * @Return java.util.List<E>
      * @Description 查询
      **/
    public List<T> executeQuery(String sql, RowMapper rowMapper, Object[] values) throws Exception {
        // 1. 获取连接
        Connection conn = getConnection();
        // 2. 创建语句集
        PreparedStatement stmt = createPreparedStatement(conn, sql);
        // 3. 执行语句集，获取结果集
        ResultSet rs = executeQuery(stmt, values);
        // 4. 解析结果集(可变)
        List<T> list = parseResultSet(rs, rowMapper);
        // 5.关闭结果集
        closeResultSet(rs);
        // 6.关闭语句集
        closePreparedStatement(stmt);
        // 7.关闭连接（或者放回连接池）
        closeConnection(conn);
        return list;
    }




}
