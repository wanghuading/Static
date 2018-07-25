package com.sz.mybatis.domain;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
    @Select("select * from test where id = #{id}")
    public Test selectBlog(int id);
}
