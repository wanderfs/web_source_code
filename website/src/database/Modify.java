/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import database.insert.InsertPostToGroup;
import database.insert.InsertJoinGroupWork;
import database.insert.InsertFolloweeWork;
import database.insert.InsertVideoCommentWork;
import database.insert.InsertWatchWork;
import database.insert.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.*;
import logic.datatype.CommentEvent;
import logic.datatype.PostEvent;
import logic.datatype.ShareEvent;
import test.Test;
import utility.Constant;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class Modify {

    public int insertAD(AD ad) {
         Connection c = null;
         Statement s = null;
         int result = Constant.DATABASE_UNKNOWN_ERROR;
         try {
            c = Access.getConnection();
            StringBuffer statement = new StringBuffer("INSERT INTO ad (");
            List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(ad);
            Iterator<Pair<String, Object>> it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append(pair.getKey());
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            // append first submit user
            statement.append(") VALUES (");
            it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append("'" + encodeString(pair.getValue().toString()) + "'");
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            statement.append(")");
            Test.println(statement.toString());
            s = c.createStatement();
            s.execute(statement.toString(), Statement.RETURN_GENERATED_KEYS);
            //s.executeUpdate(statement.toString());
            ResultSet rs = s.getGeneratedKeys();
            rs.next();
            result = rs.getInt(1);
            //c.commit();
        } catch (SQLException ex) {
            //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 1062
                        && ex.getSQLState().equals("23000")) {
                result = Constant.DATABASE_INSERT_DUPLICATE;
            }
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int updateAD(String condition, Object conditionValue, AD ad) {
        int result = Constant.DATABASE_UNKNOWN_ERROR;
        Connection c = null;
        PreparedStatement ps = null;
        if (condition.equals("videoid")) {
            try {
                c = Access.getConnection();
                StringBuilder statement = new StringBuilder("UPDATE ad SET ");
                List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(ad);
                Iterator<Pair<String, Object>> it = affectedColumns.iterator();
                while(it.hasNext()) {
                    Pair<String, Object> pair = it.next();
                    statement.append(" ").append(pair.getKey()).append(" = " + "'").append(encodeString(pair.getValue().toString())).append("'");
                    if (it.hasNext()) {
                        statement.append(",");
                    }
                }
                ps = c.prepareStatement(
                        statement.toString() +" WHERE " + condition + " = ?");
                ps.setObject(1, conditionValue);
                result = ps.executeUpdate();
                //c.commit();
            } catch (SQLException ex) {
                //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                if (ex.getErrorCode() == 1062
                        && ex.getSQLState().equals("23000")) {
                    result = Constant.DATABASE_INSERT_DUPLICATE;
                }
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }

    public int updateVideo(String condition, Object conditionValue, IVideo v) {
        int result = Constant.DATABASE_UNKNOWN_ERROR;
        Connection c = null;
        PreparedStatement ps = null;
        if (condition.equals("videoid")) {
            try {
                c = Access.getConnection();
                StringBuffer statement = new StringBuffer("UPDATE video SET ");
                List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(v);
                Iterator<Pair<String, Object>> it = affectedColumns.iterator();
                while(it.hasNext()) {
                    Pair<String, Object> pair = it.next();
                    statement.append(" " + pair.getKey() + " = " + "'" + encodeString(pair.getValue().toString()) + "'");
                    if (it.hasNext()) {
                        statement.append(",");
                    }
                }
                ps = c.prepareStatement(
                        statement.toString() +" WHERE " + condition + " = ?");
                ps.setObject(1, conditionValue);
                result = ps.executeUpdate();
                //c.commit();
            } catch (SQLException ex) {
                //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                if (ex.getErrorCode() == 1062
                        && ex.getSQLState().equals("23000")) {
                    result = Constant.DATABASE_INSERT_DUPLICATE;
                } 
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }

    public int insertVideo(IUser u, IVideo v) {
         Connection c = null;
         Statement s = null;
         int result = Constant.DATABASE_UNKNOWN_ERROR;
         try {
            c = Access.getConnection();
            StringBuffer statement = new StringBuffer("INSERT INTO video (");
            List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(v);
            Iterator<Pair<String, Object>> it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append(pair.getKey());
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            // append first submit user
            statement.append(", firstSubmitUserid");
            statement.append(") VALUES (");
            it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append("'" + encodeString(pair.getValue().toString()) + "'");
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            // append first submit user
            statement.append(", " + u.getUserid());
            statement.append(")");
            s = c.createStatement();
            result  = s.executeUpdate(statement.toString());
              //c.commit();
        } catch (SQLException ex) {
            //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 1062
                        && ex.getSQLState().equals("23000")) {
                result = Constant.DATABASE_INSERT_DUPLICATE;
            }
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    /**
     * Currently, only allow update on unique keys.
     * 
     * @param condition
     * @param conditionValue
     * @param u
     * @return
     * error code
     * -2: Duplicated Entry for email
     * -1: condition not acceptable
     * >0: affected row count
     */
    public int updateUser(String condition, Object conditionValue, IUser u) {
        Connection c = null;
        PreparedStatement s = null;
        int result = Constant.USER_ENTRY_UNKNOW_ERROR;
        if (condition.equals("userid")) {
            try {
                c = Access.getConnection();
                StringBuffer statement = new StringBuffer("UPDATE user SET ");
                List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(u);
                Iterator<Pair<String, Object>> it = affectedColumns.iterator();
                while(it.hasNext()) {
                    Pair<String, Object> pair = it.next();
                    statement.append(" " + pair.getKey() + " = " + "'" + encodeString(pair.getValue().toString()) + "'");
                    if (it.hasNext()) {
                        statement.append(",");
                    }
                }
                PreparedStatement ps = c.prepareStatement(
                        statement.toString() +" WHERE " + condition + " = ?");
                ps.setObject(1, conditionValue);
                Test.println(statement.toString());
                result = ps.executeUpdate();
                //c.commit();
            } catch (SQLException ex) {
                //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                //Test.println(ex.getMessage());
                if (ex.getErrorCode() == 1062  
                        && ex.getSQLState().equals("23000")
                        && ex.getMessage().contains(u.getEmail())) {
                    result = Constant.USER_ENTRY_EMAIL_DUPLICATED;
                }
            } finally {
                try {
                    if (s != null) {
                        s.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }
    /**
     * 
     * @param u
     * @return
     * -2: Duplicated Entry for email
     * -1: Unknown error
     * >0: affected row count
     */
    public int insertUser(IUser u) {
        Connection c = null;
        Statement s = null;
        int result = Constant.USER_ENTRY_UNKNOW_ERROR;
        try {
            c = Access.getConnection();
            StringBuffer statement = new StringBuffer("INSERT INTO user (");
            List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(u);
            Iterator<Pair<String, Object>> it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append(pair.getKey());
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            statement.append(") VALUES (");
            it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append("'" + encodeString(pair.getValue().toString()) + "'");
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            statement.append(")");
            s = c.createStatement();
            //Test.println(statement.toString());
            result = s.executeUpdate(statement.toString());
            //c.commit();
        } catch (SQLException ex) {
            //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            //Test.println(ex.getMessage());
            if (ex.getErrorCode() == Constant.MYSQL_INSERT_DUPLICATE_CODE
                    && ex.getSQLState().equals(Constant.MYSQL_INSERT_DUPLICATE_STATE)
                    && ex.getMessage().contains(u.getEmail())) {
                result = Constant.USER_ENTRY_EMAIL_DUPLICATED;
            }
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int updateGroup(String condition, Object conditionValue, IChannel g) {
        Connection c = null;
        PreparedStatement s = null;
        int result = Constant.DATABASE_UNKNOWN_ERROR;
        if (condition.equals("groupid")) {
            try {
                c = Access.getConnection();
                StringBuffer statement = new StringBuffer("UPDATE usergroup SET ");
                List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(g);
                Iterator<Pair<String, Object>> it = affectedColumns.iterator();
                while(it.hasNext()) {
                    Pair<String, Object> pair = it.next();
                    statement.append(" " + pair.getKey() + " = " + "'" + encodeString(pair.getValue().toString()) + "'");
                    if (it.hasNext()) {
                        statement.append(",");
                    }
                }
                PreparedStatement ps = c.prepareStatement(
                        statement.toString() +" WHERE " + condition + " = ?");
                ps.setObject(1, conditionValue);
                result = ps.executeUpdate();
                //c.commit();
            } catch (SQLException ex) {
                //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                //Test.println(ex.getMessage());
                if (ex.getErrorCode() == 1062
                        && ex.getSQLState().equals("23000")) {
                    result = Constant.DATABASE_INSERT_DUPLICATE;
                }
            } finally {
                try {
                    if (s != null) {
                        s.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }
    public int insertGroup(IUser u, IChannel g) {
        Connection c = null;
        Statement s = null;
        int result = Constant.USER_ENTRY_UNKNOW_ERROR;
        g.setAdministratorid(u.getUserid());
        try {
            c = Access.getConnection();
            StringBuffer statement = new StringBuffer("INSERT INTO usergroup (");
            List<Pair<String, Object>> affectedColumns = this.getUpdatebleColumn(g);
            Iterator<Pair<String, Object>> it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append(pair.getKey());
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            statement.append(") VALUES (");
            it = affectedColumns.iterator();
            while(it.hasNext()) {
                Pair<String, Object> pair = it.next();
                statement.append("'" + encodeString(pair.getValue().toString()) + "'");
                if (it.hasNext()) {
                    statement.append(",");
                }
            }
            statement.append(")");
            s = c.createStatement();
            //Test.println(statement.toString());
            result = s.executeUpdate(statement.toString());
            //c.commit();
        } catch (SQLException ex) {
            //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            //Test.println(ex.getMessage());
            if (ex.getErrorCode() == Constant.MYSQL_INSERT_DUPLICATE_CODE
                    && ex.getSQLState().equals(Constant.MYSQL_INSERT_DUPLICATE_STATE)
                    && ex.getMessage().contains(u.getEmail())) {
                result = Constant.DATABASE_INSERT_DUPLICATE;
            }
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    public int insertSubmit(IUser u, int videoid, String comment) {
        return doWorkGeneral(new InsertSubmitWork(u, videoid, comment));
    }

    public int insertRate(IUser u, int videoid, double score, String comment) {
        return doWorkGeneral(new InsertRateWork(u, videoid, score, comment));
    }

    /**
     * 
     * @param work
     * @return
     * DATABASE_INSERT_DUPLICATE
     * DATABASE_INSERT_SUCCESS
     * DATABASE_UNKNOWN_ERROR
     *
     * And other work specific status.
     */
    public int doWorkGeneral(ICoreWork work) {
        Pair<Connection, Statement> pair = new Pair<Connection, Statement>();
        int status = Constant.DATABASE_MODIFY_SUCCESS;
        try {
            status = work.dowork(pair);
        } catch (SQLException ex) {
            //Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == Constant.MYSQL_INSERT_DUPLICATE_CODE
                    && ex.getSQLState().equals(Constant.MYSQL_INSERT_DUPLICATE_STATE)) {
                status = Constant.DATABASE_INSERT_DUPLICATE;
            }
        } finally {
            try {
                if (pair.getValue() != null) {  // statement close
                    pair.getValue().close();
                }
                if (pair.getKey() != null) { // connection close;
                    pair.getKey().close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
   
    public int insertWatch(IUser u, int videoID) {
        return doWorkGeneral(new InsertWatchWork(u, videoID));
    }

    public int insertCollect(IUser u, int videoID, String comment) {
        return doWorkGeneral(new InsertCollectWork(u, videoID, comment));
    }

    public int removeCollect(IUser u, int videoID) {
        return doWorkGeneral(new RemoveCollectWork(u, videoID));
    }


    public int insertVideoComment(IUser u, int videoid, String comment, int parentid) {
        return doWorkGeneral(new InsertVideoCommentWork(u, videoid, comment, parentid));
    }

    public int insertFollowee(IUser u, int followeeid) {
        return doWorkGeneral(new InsertFolloweeWork(u, followeeid));
    }

     public int removeFollowee(IUser u, int followeeid) {
        return doWorkGeneral(new RemoveFolloweeWork(u, followeeid));
    }

    public int insertJoinGroup(IUser u, int groupid) {
        return doWorkGeneral(new InsertJoinGroupWork(u, groupid));
    }

    public int insertPostToGroup(IUser u, PostEvent post) {
        return doWorkGeneral(new InsertPostToGroup(u, post));
    }

    public int insertChannelFollower(IUser u, int channelid) {
        return doWorkGeneral(new InsertChannelFollowerWork(u, channelid));
    }

    public int removeChannelFollower(IUser u, int channelid) {
        return doWorkGeneral(new RemoveChannelFollowerWork(u, channelid));
    }

    public int deleteChannel(int channelid) {
        return doWorkGeneral(new DeleteChannelWork(channelid));
    }

    public int removeCollectChannel(int channelid, int videoid, int userid) {
        return doWorkGeneral(new RemoveCollectChannelWork(channelid, videoid, userid));
    }


    public int removeCollectChannelForce(int channelid, int videoid) {
        return doWorkGeneral(new RemoveCollectChannelWork(channelid, videoid, -1));
    }

    public int insertChannelADRelation(int channelid, int adid) {
        return doWorkGeneral(new InsertChannelADRelationWork(channelid, adid));
    }

    public int removeChannelADRelation(int channelid, int adid) {
        return doWorkGeneral(new RemoveChannelADRelationWork(channelid, adid));
    }

    protected ArrayList<Pair<String, Object>> getUpdatebleColumn(IUser u) {
        ArrayList<Pair<String, Object>> affectedColumns = new ArrayList<Pair<String, Object>>();
        if (u.getEmail() != null) {
           affectedColumns.add(new Pair<String, Object>("email", u.getEmail()));
        }
        if (u.getName() != null) {
           affectedColumns.add(new Pair<String, Object>("name", u.getName()));
        }
        if (u.getPassword() != null) {
           affectedColumns.add(new Pair<String, Object>("password", u.getPassword()));
        }
        if (u.getDescription() != null) {
           affectedColumns.add(new Pair<String, Object>("description", u.getDescription()));
        }
        if (u.getAuthenticator() != null) {
           affectedColumns.add(new Pair<String, Object>("authenticator", u.getAuthenticator()));
        }
        if (u.getRenrenid() != null) {
            affectedColumns.add(new Pair<String, Object>("renrenid", u.getRenrenid()));
        }
        if (u.getPhoto() != null) {
            affectedColumns.add(new Pair<String, Object>("photo", u.getPhoto()));
        }
        if (u.getPhotoMedium() != null) {
            affectedColumns.add(new Pair<String, Object>("photoMedium", u.getPhotoMedium()));
        }
        if (u.getPhotoSmall() != null) {
            affectedColumns.add(new Pair<String, Object>("photoSmall", u.getPhotoSmall()));
        }
        if (u.getPhotoMini() != null) {
            affectedColumns.add(new Pair<String, Object>("photoMini", u.getPhotoMini()));
        }
        if (u.getBirthday() != null) {
            affectedColumns.add(new Pair<String, Object>("birthday", new java.sql.Date(u.getBirthday().getTime())));
        }
        if (u.getLocation() != null) {
            affectedColumns.add(new Pair<String, Object>("location", u.getLocation()));
        }
        if (u.getGender() != null) {
            affectedColumns.add(new Pair<String, Object>("gender", u.getGender()));
        }
        return affectedColumns;
    }
    protected ArrayList<Pair<String, Object>> getUpdatebleColumn(IVideo v) {
        ArrayList<Pair<String, Object>> affectedColumns = new ArrayList<Pair<String, Object>>();
        if (v.getSiteSpecificID() != null)
           affectedColumns.add(new Pair<String, Object>("siteSpecificID", v.getSiteSpecificID()));
        if (v.getResidentSite() != null)
           affectedColumns.add(new Pair<String, Object>("residentSite", v.getResidentSite()));
        if (v.getSnapshotURL() != null)
           affectedColumns.add(new Pair<String, Object>("snapShotURL", v.getSnapshotURL()));
        if (v.getTitle() != null)
           affectedColumns.add(new Pair<String, Object>("title", v.getTitle()));
        if (v.getSummary() != null)
           affectedColumns.add(new Pair<String, Object>("summary", v.getSummary()));
        if (v instanceof Video) {
            Video video = (Video)v;
            if (video.getRefHtml() != null)
                affectedColumns.add(new Pair<String, Object>("refHtml", video.getRefHtml()));
        }
        return affectedColumns;
    }
    
    protected List<Pair<String, Object>> getUpdatebleColumn(IChannel g) {
        ArrayList<Pair<String, Object>> affectedColumns = new ArrayList<Pair<String, Object>>();
        if (g.getName() != null)
           affectedColumns.add(new Pair<String, Object>("name", g.getName()));
        if (g.getAdministratorid() > 0)
           affectedColumns.add(new Pair<String, Object>("administratorid", g.getAdministratorid()));
        if (g.getDescription() != null)
           affectedColumns.add(new Pair<String, Object>("description", g.getDescription()));
        return affectedColumns;
    }
    
    protected List<Pair<String, Object>> getUpdatebleColumn(AD ad) {
        ArrayList<Pair<String, Object>> affectedColumns = new ArrayList<Pair<String, Object>>();
        if (ad.getAdid() > 0) {
            affectedColumns.add(new Pair<String, Object>("adid", ad.getAdid()));
        }
        if (ad.getText() != null) {
            affectedColumns.add(new Pair<String, Object>("text", ad.getText()));
        }
        if (ad.getUrl() != null) {
            affectedColumns.add(new Pair<String, Object>("url", ad.getUrl()));
        }
        return affectedColumns;
    }
    
    protected String encodeString(String s) {
        return s.replace("'", "''");
    }
    
    protected String decodeString(String s) {
        return s.replace("''", "'");
    }

    public void insertComment(CommentEvent comment) {
        doWorkGeneral(new InsertCommentWork(comment));
    }

    public void insertVisit(IUser visitor, int hostuid) {
        doWorkGeneral(new InsertUserVisitWork(visitor.getUserid(), hostuid));
    }

    public void insertShare(ShareEvent e) {
        doWorkGeneral(new InsertShareWork(e));
    }
}
