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
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertJoinGroupWork implements ICoreWork {
    IUser u;
    int groupid;
    
    public InsertJoinGroupWork(IUser u, int groupid) {
        this.u = u;
        this.groupid = groupid;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO ingroup (groupid, userid) VALUES (?, ?)");
        ps.setInt(1, groupid);
        ps.setInt(2, u.getUserid());
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    }

    
}
