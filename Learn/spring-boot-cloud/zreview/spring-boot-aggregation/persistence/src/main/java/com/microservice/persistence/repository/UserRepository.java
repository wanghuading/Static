package com.microservice.persistence.repository;

import com.microservice.persistence.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager platformTransactionManager;

    private DataSource primaryDataSource;
//    private DataSource slaveDataSource;

    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate,
                          PlatformTransactionManager platformTransactionManager,
                          @Qualifier("primaryDataSource") DataSource primaryDataSource
                          /*@Qualifier("slaveDataSource") DataSource slaveDataSource*/) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.platformTransactionManager = platformTransactionManager;
        this.primaryDataSource = primaryDataSource;
//        this.slaveDataSource = slaveDataSource;
    }

    public Collection<User> findAll() {
        Connection conn = null;
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM test";
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                users.add(user);
            }
            rs.close();
            return users;
        } catch (Exception e) {

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return Collections.emptyList();
    }

    /**
     * jdbc 事务管理
     * @param user
     * @return
     */
    public boolean save(User user) {
        Connection conn = null;
        try {
            String sql = "INSERT INTO test(name) VALUE(?)";
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            boolean flag = ps.executeUpdate() > 0;
            ps.close();
//            ps = null;
//            ps.getMetaData();
            return flag;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.commit();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 声明式事务
     * @param user
     * @return
     */
    @Transactional
    public boolean transactionSave(User user) {
        boolean success = false;
        String sql = "INSERT INTO test(name) VALUES ('111')";
        success = jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
//                preparedStatement.setString(1, user.getName());
                boolean flag =preparedStatement.executeUpdate(sql) > 0;
                return flag;
            }
        });
        return success;
    }

    public boolean platformSave(User user) {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

        boolean success = false;
        String sql = "INSERT INTO test(name) VALUES ('111')";
        success = jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
//                preparedStatement.setString(1, user.getName());
                boolean flag =preparedStatement.executeUpdate(sql) > 0;
                return flag;
            }
        });


        platformTransactionManager.commit(transactionStatus);
        return success;
    }

}
