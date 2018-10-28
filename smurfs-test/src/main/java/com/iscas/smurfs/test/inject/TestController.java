package com.iscas.smurfs.test.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/28
 */
@RestController
public class TestController {
    @Autowired
    A a;
    @Lazy
    @Autowired
    B b;
    @GetMapping("/test")
    public void test(){
        a.insidePrint();
        b.insidePrint();
    }
}
