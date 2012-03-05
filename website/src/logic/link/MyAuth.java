/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.link;
/**
 *
 * @author Franklin
 */
import javax.mail.PasswordAuthentication;

public class MyAuth extends javax.mail.Authenticator {
    private String strUser;
    private String strPwd;
    public MyAuth(String user, String password) {
      this.strUser = user;
      this.strPwd = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(strUser, strPwd);
    }
}
