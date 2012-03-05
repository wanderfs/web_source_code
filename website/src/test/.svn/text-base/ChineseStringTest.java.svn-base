/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author sen
 */
public class ChineseStringTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        char c = '你';
        int i = c;
        System.out.println(c);
        System.out.println(i);

        String chinese = "你好好地方";
        System.out.println("orig: "  + chinese);
        String utf = new String(chinese.getBytes("UTF-8"));
        System.out.println("utf8: " + utf);
        String iso = new String(chinese.getBytes("iso-8859-1"));
        System.out.println("iso-8859-1: " + iso);
        String gbk = new String(chinese.getBytes("gbk"));
        System.out.println("gbk: " + gbk);
        System.out.println("你好好地方");
        System.out.println("啦啦啦");
    }
}
