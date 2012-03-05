package utility.email;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.EntityFactory;
import logic.IUser;
import utility.Misc;

/**
 * gets sent after user forgets password
 * @author Sen
 */
public class PasswordReminderEmail implements EmailMessage {
    private IUser user;

    public PasswordReminderEmail(String email) {
        user = EntityFactory.getUser(email);
    }

    @Override
    public String getSubject() {
        return Misc.hardCodedChinese("iweishi账号密码提醒", "iweishi.cn account reminder");
    }

    @Override
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(Misc.hardCodedChinese("亲爱的 ", "Dear "))
          .append(user.getName())
          .append(Misc.hardCodedChinese(", \n你的iweishi账户密码是", " \nYour iweishi account password is "))
          .append(user.getPassword());

        return sb.toString();
    }

    @Override
    public String getRecipient() {
        return user.getEmail();
    }
}
