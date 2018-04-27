package com.sz.learn.template;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author whd
 * @Date 2018/4/27 15:56
 * @Description
 **/
public class PersonDao {
    private JdbcTemplate<Person> template = new JdbcTemplate<Person>(null);

    public List<Person> query () {
        try {
            String sql = "select * from t_person";
            return template.executeQuery(sql, new RowMapper<Person>() {
                @Override
                public Person mapRow(ResultSet rs, int rowNum) throws Exception {
                    Person person = new Person();
                    person.setId(rs.getString("id"));
                    person.setRealName(rs.getString("real_name"));
                    person.setIdCard(rs.getString("idcard"));
                    person.setAddress(rs.getString("address"));
                    return person;
                }
            }, null);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
