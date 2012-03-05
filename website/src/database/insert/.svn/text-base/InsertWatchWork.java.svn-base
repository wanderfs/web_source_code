/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database.insert;

import database.Access;
import java.sql.*;
import logic.IUser;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertWatchWork implements ICoreWork {

    IUser u;
    int videoID;
    
    public InsertWatchWork(IUser u, int videoID) {
        this.u = u;
        this.videoID = videoID;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO watch (userid, videoid) VALUES (?, ?)");
        ps.setInt(1, u.getUserid());
        ps.setInt(2, videoID);
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }
}
