package com.iscas.smurfs.test.test;

/**
 * @author: lee
 * @date: 2018-10-24
 */
public class TEST {
    public static void main(String[] args) {
        String str = "我ABC汉DEF";
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
          if (ch[i] > 255) {
           System.out.print(ch[i]);
          }
        }
    }
}
