/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import logic.EntityFactory;
import logic.IUser;

/**
 *
 * @author xuan
 */
public class AddArtificialUser {
    public static void main(String[] args) throws IOException {
        startAdd();
    }
    public static void startAdd() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("/home/xuan/Documents/1000_fake_ids.txt"), "utf8"));
        ArrayList<String> userNameList = new ArrayList<String>();
        while (true) {
            String s = input.readLine();
            if (s == null) {
                break;
            } else {
                System.out.println(s);
                s = s.trim();
                addArtificialUser(s);
            }
        }
        //addArtificialUser("小屁狗");
    }

    protected static void addArtificialUser(String username) {
        IUser user = EntityFactory.getEmptyUser();

        user.setName(username);
        user.setEmail(username + "@gmail.com");
        Calendar rightnow = Calendar.getInstance();
        Date artificialJoinTime = new Date(rightnow.getTimeInMillis() - (long)(Math.floor(5 * 24 * 3600 * 1000 * Math.random())));
        user.setJoinTime(artificialJoinTime);
        user.setPassword(username + Math.random());
        user.commit();
        System.out.println(user.toString());
    }
}
