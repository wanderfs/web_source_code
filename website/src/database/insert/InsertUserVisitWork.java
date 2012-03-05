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
public class InsertUserVisitWork implements ICoreWork{
    int visitorid;
    int hostid;

    public InsertUserVisitWork(int visitorid, int hostid) {
        this.visitorid = visitorid;
        this.hostid = hostid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO visit (hostid, visitorid) VALUES (?, ?)");
        ps.setInt(1, hostid);
        ps.setInt(2, visitorid);
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }

}
