package com.sz.base.TypeParamter;

public class TurpleTest {
    static Turple<String, Integer> f() {
        return new Turple<String, Integer>("hi", 57);
    }
    public static void main(String[] args) {
        Turple turple = f();
        System.out.println(turple.first);
        System.out.println(turple.second);
    }
}
