package com.iscas.smurfs.test.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/28
 */
@Component
public class A {
    @Autowired
    B b;

    public void insidePrint(){
        System.out.println("from a");
    }

    public void print(){
        b.insidePrint();
    }
}
