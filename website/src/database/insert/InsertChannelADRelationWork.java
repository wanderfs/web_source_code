/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database.insert;

import database.Access;
import java.sql.*;
import logic.IUser;
import test.Test;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertChannelADRelationWork implements ICoreWork {

    int channelid;
    int adid;

    public InsertChannelADRelationWork(int channelid, int adid) {
        this.channelid = channelid;
        this.adid = adid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO adinchannel (groupid, adid) VALUES (?, ?)");
        ps.setInt(1, this.channelid);
        ps.setInt(2, this.adid);
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }
}
