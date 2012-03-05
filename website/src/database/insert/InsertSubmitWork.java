/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database.insert;

import database.Access;
import java.sql.*;
import java.util.Calendar;
import logic.*;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertSubmitWork implements ICoreWork {
    IUser u;
    int videoid;
    String comment;

    public InsertSubmitWork(IUser u, int v, String comment) {
        this.u = u;
        this.videoid = v;
        this.comment = comment;
    }
    
    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        // fake timestamp
        if ( Constant.ARTIFICIAL_USER_ID_MIN <= u.getUserid() && u.getUserid() <= Constant.ARTIFICIAL_USER_ID_MAX) {
            Connection c = Access.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO submit (userid, videoid, time, comment) VALUES (?, ?, ?, ?)");
            ps.setInt(1, u.getUserid());
            ps.setInt(2, this.videoid);
            Calendar rightnow = Calendar.getInstance();
            ps.setTimestamp(3, new Timestamp(rightnow.getTimeInMillis() - (long)(Math.floor(2 * 3600 * 1000 * Math.random()))));
            ps.setString(4, comment);
            pair.setKey(c);
            pair.setValue(ps);
            ps.executeUpdate();
        } else {
            Connection c = Access.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO submit (userid, videoid, comment) VALUES (?, ?, ?)");
            ps.setInt(1, u.getUserid());
            ps.setInt(2, this.videoid);
            ps.setString(3, comment);
            pair.setKey(c);
            pair.setValue(ps);
            ps.executeUpdate();
        }
        return Constant.DATABASE_MODIFY_SUCCESS;
     //   c.commit();
    }

}
