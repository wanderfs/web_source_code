/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database.insert;

import database.Access;
import database.insert.ICoreWork;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import logic.IUser;
import logic.datatype.PostEvent;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertPostToGroup implements ICoreWork {

    IUser u;
    PostEvent post;

    public InsertPostToGroup(IUser u, PostEvent post) {
        this.u = u;
        this.post = post;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO post (videoid, userid, groupid, comment) VALUES (?, ?, ?, ?)");
        ps.setInt(1, post.getVideoid());
        ps.setInt(2, post.getUserid());
        ps.setInt(3, post.getGroupid());
        ps.setString(4, post.getComment());
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    }

}
