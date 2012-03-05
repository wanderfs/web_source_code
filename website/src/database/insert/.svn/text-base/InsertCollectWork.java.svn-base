/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database.insert;

import database.Access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import logic.IUser;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertCollectWork implements ICoreWork {

    IUser u;
    int videoID;
    String comment;

    public InsertCollectWork(IUser u, int videoID, String comment) {
        this.u = u;
        this.videoID = videoID;
        this.comment = comment;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        if ( (Constant.ARTIFICIAL_USER_ID_MIN <= u.getUserid() && u.getUserid() <= Constant.ARTIFICIAL_USER_ID_MAX)
                || u.getUserid() == 1598 || u.getUserid() == 1599 || u.getUserid() == 1600) {
            Connection c = Access.getConnection();
            PreparedStatement ps = c.prepareStatement("REPLACE INTO collect (userid, videoid, comment, time) VALUES (?, ?, ?, ?)");
            ps.setInt(1, u.getUserid());
            ps.setInt(2, videoID);
            ps.setString(3, comment);
            Calendar rightnow = Calendar.getInstance();
            ps.setTimestamp(4, new Timestamp(rightnow.getTimeInMillis() - (long)(Math.floor(5 * 60 * 1000 * Math.random()))));
            pair.setKey(c);
            pair.setValue(ps);
            ps.executeUpdate();
            pair.setKey(c);
            pair.setValue(ps);
            ps.executeUpdate();
        } else {
            Connection c = Access.getConnection();
            PreparedStatement ps = c.prepareStatement("REPLACE INTO collect (userid, videoid, comment) VALUES (?, ?, ?)");
            ps.setInt(1, u.getUserid());
            ps.setInt(2, videoID);
            ps.setString(3, comment);
            pair.setKey(c);
            pair.setValue(ps);
            ps.executeUpdate();
        }
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }
}
