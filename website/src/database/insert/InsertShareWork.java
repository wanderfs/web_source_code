/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database.insert;

import database.Access;
import java.sql.*;
import logic.IUser;
import logic.datatype.ShareEvent;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class InsertShareWork implements ICoreWork{
    ShareEvent es;

    public InsertShareWork(ShareEvent es) {
        this.es = es;
    }

    @Override
    public int dowork(Pair<Connection, Statement> pair) throws SQLException {
        Connection c = Access.getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO share (userid, contentid, snsid, comment, contenttype) VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, es.getUserid());
        ps.setLong(2, es.getContentid());
        ps.setString(3, es.getSns_id());
        ps.setString(4, es.getComment());
        ps.setString(5, es.getContent_type().name());
        pair.setKey(c);
        pair.setValue(ps);
        ps.executeUpdate();
        return Constant.DATABASE_MODIFY_SUCCESS;
    //    c.commit();
    }

}
