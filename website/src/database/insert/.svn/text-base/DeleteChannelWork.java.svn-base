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
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class DeleteChannelWork implements ICoreWork {
    int _channelid;

    public DeleteChannelWork(int channelid){
        this._channelid = channelid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException  {
        try {
            Connection c = Access.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM usergroup where groupid = ?");
            ps.setInt(1, _channelid);
            pair.setKey(c);
            pair.setValue(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InsertFolloweeWork.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 1452
                    && ex.getSQLState().equals("23000")) {
                return Constant.CHANNEL_NOT_EXIST;
            } else {
                throw ex;
            }
        }
        return Constant.DATABASE_MODIFY_SUCCESS;
    }

}
