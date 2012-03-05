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
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertVideoCommentWork implements ICoreWork {

    IUser u;
    int videoid;
    String comment;
    int parentid;
    
    public InsertVideoCommentWork(IUser u, int videoid, String comment, int parentid) {
        this.u = u;
        this.videoid = videoid;
        this.comment = comment;
        this.parentid = parentid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO videocomment (videoid, comment, userid, parentid) VALUES (?, ?, ?, ?)");
        ps.setInt(1, videoid);
        ps.setString(2, comment);
        ps.setInt(3, u.getUserid());
        ps.setInt(4, parentid);
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }

}
