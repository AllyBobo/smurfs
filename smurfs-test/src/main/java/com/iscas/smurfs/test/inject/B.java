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
public class B {
    @Autowired
    A a;
    public void insidePrint(){
        System.out.println("from b");
    }

    public void print(){
        a.insidePrint();
    }
}
