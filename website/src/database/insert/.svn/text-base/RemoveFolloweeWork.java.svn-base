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
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.IUser;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class RemoveFolloweeWork implements ICoreWork {
    IUser u;
    int followeeid;

    public RemoveFolloweeWork(IUser u, int followeeid) {
        this.u = u;
        this.followeeid = followeeid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException  {
        try {
            Connection c = Access.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM follow where followeeid = ? and  followerid = ?");
            ps.setInt(1, followeeid);
            ps.setInt(2, u.getUserid());
            pair.setKey(c);
            pair.setValue(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InsertFolloweeWork.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 1452
                    && ex.getSQLState().equals("23000")) {
                return Constant.FOLLOWEE_NOT_EXIST;
            } else {
                throw ex;
            }
        }
        return Constant.DATABASE_MODIFY_SUCCESS;
    }

}
