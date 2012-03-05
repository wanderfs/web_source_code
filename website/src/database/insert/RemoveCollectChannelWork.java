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
import logic.IUser;
import test.Test;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class RemoveCollectChannelWork implements ICoreWork {
    int groupid;
    int videoid;
    int userid;

    public RemoveCollectChannelWork(int groupid, int videoID, int userid) {
        this.groupid = groupid;
        this.videoid = videoID;
        this.userid = userid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        String query = "DELETE FROM post where groupid = ? and  videoid = ?";
        if (userid > 0) { // not force mode
            query += " and userid = " + userid;
        }
        //Test.println(query + " | " + groupid + ", " + videoid);
        PreparedStatement ps = c.prepareStatement(query);
        ps.setInt(1, groupid);
        ps.setInt(2, videoid);
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }

}
