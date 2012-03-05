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
public class InsertRateWork implements ICoreWork{
    IUser u;
    int videoid;
    double score;
    String comment;
    
    public InsertRateWork(IUser u, int videoid, double score, String comment) {
        this.u = u;
        this.videoid = videoid;
        this.score = score;
        this.comment = comment;
    }
    
    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO rate (userid, videoid, score, comment) VALUES (?, ?, ?, ?)");
        ps.setInt(1, u.getUserid());
        ps.setInt(2, this.videoid);
        ps.setDouble(3, score);
        ps.setString(4, this.comment);
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }

}
