/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database.insert;

import database.Access;
import database.insert.ICoreWork;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.IChannel;
import logic.IUser;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertChannelFollowerWork implements ICoreWork {

    IUser u;
    int channelid;

    public InsertChannelFollowerWork(IUser u, int channelid) {
        this.u = u;
        this.channelid = channelid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException  {
        try {
            Connection c = Access.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO followchannel (userid, groupid) VALUES (?, ?)");
            ps.setInt(1, u.getUserid());
            ps.setInt(2, this.channelid);
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
