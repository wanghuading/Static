package com.sz.mybatis.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class ExampleTypeHandler extends BaseTypeHandler<String> {
    public void setNonNullParameter(PreparedStatement preparedStatement, int i,
                                    String parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, parameter+"test");
    }

    public String getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return resultSet.getString(columnName) + "exampleHandlerWithName";
    }

    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i) + "exampleHandlerWithIndex";
    }

    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i)+"exampleHandlerWithcallable";
    }
}
