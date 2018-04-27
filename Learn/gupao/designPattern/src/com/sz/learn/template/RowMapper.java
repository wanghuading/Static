package com.sz.learn.template;

import java.sql.ResultSet;

/**
 * @Author whd
 * @Date 2018/4/27 15:32
 * @Description
 **/
public interface RowMapper<T> {
    public T mapRow(ResultSet rs, int rowNum) throws Exception;
}
