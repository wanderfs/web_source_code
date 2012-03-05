/*
 * Common utilities for servlets.
 */
package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.EntityFactory;
import logic.IUser;

/**
 *
 * @author sen
 */
public class ServletCommon {

    public static IUser nobody = null;
    public static int nobodyId = 0;
    private static Set<Integer> adminSet = null;

    static {
        nobody = EntityFactory.getUser(39);
        nobodyId = nobody.getUserid();

        // init administrators here
        // add your user id if you think you qualify an admin.
        adminSet = new HashSet();
        adminSet.add(35);  // xuan
        adminSet.add(19); // wanderfs
        adminSet.add(31); // sen
        adminSet.add(18); // wei
    }

    public static boolean isAdmin(int uid) {
        return adminSet.contains(uid);
    }

    public static IUser getCurrentUser(HttpSession session) {
        IUser user = (IUser) session.getAttribute(ServletConfig.SN_USER);
        return user == null ? ServletCommon.nobody : user;
    }

    public static void generateAutoLoginCookies(HttpServletResponse response, HttpSession session, IUser user) {
        Cookie ckUserid, ckSessionid;
        // 如果用户选择了“自动登录”，则向用户发送两个cookie。
        // 一个cookie记录用户id，另一个记录唯一的验证码，
        // 并将此验证码写入数据库，以备用户返回时查询。(防止伪造cookie)
        ckUserid = new Cookie(ServletConfig.CKNANE_USERID, Integer.toString(user.getUserid()));
        ckUserid.setMaxAge(60 * 60 * 24 * ServletConfig.AUTO_LOGIN_DAYS);   //设置Cookie有效期
        response.addCookie(ckUserid);

        String sessionid = session.getId(); // 取得当前的session id作为authenticator
        user.setAuthenticator(sessionid);
        user.commit();
        ckSessionid = new Cookie(ServletConfig.CKNAME_AUTENTICATOR, sessionid);
        ckSessionid.setMaxAge(60 * 60 * 24 * ServletConfig.AUTO_LOGIN_DAYS);   //设置Cookie有效期
        response.addCookie(ckSessionid);
    }

    public static void clearAutoLogin(HttpSession session) {
        session.removeAttribute(ServletConfig.SN_USER);
    }

    public static void onArgsError(PrintWriter out, Exception e) {
        out.println("argument error on this service");
        out.println(e.toString());
    }

    /**
     * This method properly decodes Chinese characters based on browser type and others
     * @deprecated we enforced UTF-8 encoding on ajax side. This method is essentially empty.
     *             we leave this empty stub here for backward compatibility purpose. Do NOT
     *             use this in new code.
     * @param request
     * @param paramName
     * @return
     */
    public static String ajaxChineseTranscoder(HttpServletRequest request, String paramName) {
        String str = request.getParameter(paramName);
        /*
        System.out.println(str);
        String browser = request.getHeader("User-Agent");
        if (str != null && !str.isEmpty()) {
            try {
                str = new String(str.getBytes("iso-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ServletCommon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(str); */
        return str;
    }

    public static String nullStringFilter(String strMayContainsNull) {
        if (strMayContainsNull == null || strMayContainsNull.toLowerCase().trim().equals("null")) {
            return "";
        } else {
            return strMayContainsNull;
        }
    }

    public static String formSubmitChineseTranscoder(String rawParam) {
        try {
            return new String(rawParam.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServletCommon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * returns number of pages needed to show all the items. consider reminder please!
     * @param totalNum
     * @param numPerPage
     * @return
     */
    public static int pagination(int totalNum, int numPerPage) {
        return totalNum / numPerPage + (totalNum % numPerPage > 0 ? 1 : 0);
    }

    // simple minimum log support.
    public static boolean appendLog(String record, String filename) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename, true);
            fw.write("\n" + record + "\n");
        } catch (IOException ex) {
            Logger.getLogger(ServletCommon.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ServletCommon.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    public static String readLog(String filename) {
        try {
            int len = (int) (new File(filename).length());
            FileInputStream fis =
                    new FileInputStream(filename);
            byte buf[] = new byte[len];
            fis.read(buf);
            fis.close();
            return new String(buf);
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
}
