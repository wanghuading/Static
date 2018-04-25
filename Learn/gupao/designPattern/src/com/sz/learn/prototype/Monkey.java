package com.sz.learn.prototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author whd
 * @Date 2018/4/24 23:57
 * @Description
 **/
public class Monkey implements Serializable {
    private int a = 1;
    private List<String> list;

    public Monkey() {
        list = new ArrayList<>();
        list.add("a");
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
