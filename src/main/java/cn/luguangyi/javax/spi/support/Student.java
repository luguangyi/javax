package cn.luguangyi.javax.spi.support;

import cn.luguangyi.javax.spi.Operator;

public class Student implements Operator {
    @Override
    public void doing(String message) {
        System.out.println("i am student. ===> " + message);
    }
}
