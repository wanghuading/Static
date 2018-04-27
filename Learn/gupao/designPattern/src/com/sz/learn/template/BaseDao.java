package com.sz.learn.template;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author whd
 * @Date 2018/4/27 15:56
 * @Description
 **/
public class BaseDao<T> {
    private JdbcTemplate<T> template = new JdbcTemplate<T>(null);

    public List<T> query () {
        try {
            String sql = "select * from t_person";
            return template.executeQuery(sql, new RowMapper<T>() {
                @Override
                public T mapRow(ResultSet rs, int rowNum) throws Exception {
                    Person person = new Person();
                    person.setId(rs.getString("id"));
                    person.setRealName(rs.getString("real_name"));
                    person.setIdCard(rs.getString("idcard"));
                    person.setAddress(rs.getString("address"));
                    return (T) person;
                }
            }, null);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
