/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.EntityFactory;
import logic.IUser;
import utility.Constant;

/**
 *
 * @author xuan
 */
public class ParseDoubanNames {

    public static void main(String[] s) throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println(new String(new String("中文").getBytes("UTF-8")));
        File file = new File("/home/xuan/Downloads/douban.name");
        PrintStream ps = new PrintStream("/home/xuan/Downloads/douban.name.line");
        BufferedReader reader = null;
        int nextUpdateUserID = Constant.ARTIFICIAL_USER_ID_MIN;
        try {
            String filename = file.getName();
            if (!file.isDirectory()) {
                System.out.println("file.getName: " + file.getName());
                System.out.println("file: " + filename);
                reader = new BufferedReader(new FileReader(file));
                String line = new String();
                String identifier = "</dt><dd><a href=\"http://www.douban.com/people/";
                while (true) {
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    line = line.trim();
                    if (line.startsWith(identifier)) {
                        int index1 = line.indexOf(">", identifier.length());
                        int index2 = line.indexOf("<", identifier.length());
                        if (0 < index1 && index1 < index2) {
                            String name = line.substring(index1 + 1, index2);
                            if (!name.contains("已注销")) {
                                System.out.println(name);
                                ps.println(name);
                                if (nextUpdateUserID > Constant.ARTIFICIAL_USER_ID_MAX) {
                                    break;
                                } else {
                                    IUser u = EntityFactory.getUser(nextUpdateUserID);
                                    u.setName(name);
                                    u.commit();
                                    ++nextUpdateUserID;
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParseDoubanNames.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ParseDoubanNames.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParseDoubanNames.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ParseDoubanNames.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
