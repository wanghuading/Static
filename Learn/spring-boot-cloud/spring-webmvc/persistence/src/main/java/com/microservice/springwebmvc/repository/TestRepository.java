package com.microservice.springwebmvc.repository;

import com.microservice.springwebmvc.pojo.TestUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author whd
 * @Date 2018/6/2 16:44
 * @Description
 **/
@Repository
public class TestRepository {
    private final JdbcTemplate jdbcTemplate;
    private final DataSource hikariDataSource;
    private final DataSource masterDataSource;
    private final DataSource slaveDataSourceOne;
    private final DataSource slaveDataSourceTwo;
    private final PlatformTransactionManager platformTransactionManager;

    public TestRepository(JdbcTemplate jdbcTemplate, DataSource hikariDataSource,
                          @Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("slaveDataSourceOne") DataSource slaveDataSourceOne,
                          @Qualifier("slaveDataSourceTwo") DataSource slaveDataSourceTwo,
                          PlatformTransactionManager platformTransactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.hikariDataSource = hikariDataSource;
        this.masterDataSource = masterDataSource;
        this.slaveDataSourceOne = slaveDataSourceOne;
        this.slaveDataSourceTwo = slaveDataSourceTwo;
        this.platformTransactionManager = platformTransactionManager;
    }


//    @Transactional
    public boolean save(TestUser user) {
        System.out.printf("Current Thread Name %s", Thread.currentThread().getName());
//        Connection conn  = null;
        try {
            TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
            TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
            jdbcTemplate.execute("INSERT INTO test(name) value (?)", new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement preparedStatement)
                        throws SQLException, DataAccessException {
                    preparedStatement.setString(1, "wooow");
                    return preparedStatement.executeUpdate() > 0;
                }
            });
            platformTransactionManager.commit(transactionStatus);
//            platformTransactionManager.rollback(transactionStatus);
            /*conn = hikariDataSource.getConnection();
//            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO test(name) value (?)");
            stmt.setString(1, "ces");
            stmt.execute();*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*try {
                if (conn != null) {
                    conn.commit();
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        return true;
    }
}
