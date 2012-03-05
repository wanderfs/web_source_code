/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import logic.AD;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.EntityFactory;
import logic.Channel;
import logic.IChannel;
import logic.IUser;
import logic.IVideo;
import logic.User;
import logic.Video;
import logic.datatype.*;
import test.Test;
import utility.Constant;
import utility.Pair;
/**
 *
 * @author xuan
 */
public class Query {

    public List<IChannel> getGroup(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<IChannel> result = null;
        try {
            ArrayList<IChannel> groups = new ArrayList<IChannel>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT groupid, description, name, time, administratorid FROM usergroup WHERE " + condition + " = ? LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Channel g = new Channel();
                g.setName(decodeString(rs.getString("name")));
                g.setChannelid(rs.getInt("groupid"));
                g.setDescription(decodeString(rs.getString("description")));
                g.setAdministratorid(rs.getInt("administratorid"));
                g.setTime(rs.getTimestamp("time"));
                groups.add(g);
            }
            result = groups;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public List<IUser> getUser(String condition, Object conditionValue, int limit)  {
        Connection c = null;
        PreparedStatement ps = null;
        List<IUser> result = null;
        try {
            ArrayList<IUser> users = new ArrayList<IUser>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, email, name, jointime, password, description, photo, photoMedium, photoSmall, renrenid, photoMini, birthday, location, gender FROM user WHERE " + condition + " = ? LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IUser u = logic.EntityFactory.getEmptyUser();
                u.setUserid(rs.getInt("userid"));
                u.setEmail(decodeString(rs.getString("email")));
                u.setJoinTime(rs.getTimestamp("jointime"));
                u.setPassword(decodeString(rs.getString("password")));
                u.setName(decodeString(rs.getString("name")));
                u.setDescription(decodeString(rs.getString("description")));
                u.setRenrenid(decodeString(rs.getString("renrenid")));
                u.setPhoto(rs.getString("photo"));
                u.setPhotoMedium(rs.getString("photoMedium"));
                u.setPhotoSmall(rs.getString("photoSmall"));
                u.setPhotoMini(rs.getString("photoMini"));
                u.setBirthday(rs.getDate("birthday"));
                u.setLocation(rs.getString("location"));
                u.setGender(rs.getString("gender"));
                users.add(u);
            }
            result = users;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<IUser> searchUser(String name) {
        Connection c = null;
        PreparedStatement ps = null;
        List<IUser> result = null;
        try {
            ArrayList<IUser> users = new ArrayList<IUser>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, email, name, jointime, password, description, photo, renrenid FROM user WHERE name like '%" + name  + "%'");
 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IUser u = logic.EntityFactory.getEmptyUser();
                u.setUserid(rs.getInt("userid"));
                u.setEmail(decodeString(rs.getString("email")));
                u.setJoinTime(rs.getTimestamp("jointime"));
                u.setPassword(decodeString(rs.getString("password")));
                u.setName(decodeString(rs.getString("name")));
                u.setDescription(decodeString(rs.getString("description")));
                u.setRenrenid(decodeString(rs.getString("renrenid")));
                users.add(u);
            }
            result = users;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<IVideo> getVideo(String condition, Object conditionValue, int limit) {
        ArrayList<String> conArray = new ArrayList<String>();
        conArray.add(condition);
        ArrayList<Object> conValueArray = new ArrayList<Object>();
        conValueArray.add(conditionValue);
        return getVideo(conArray, conValueArray, limit);
    }

     public List<IVideo> getVideo(ArrayList<String> condition, ArrayList<Object> conditionValue, int limit)  {
        Connection c = null;
        PreparedStatement ps = null;
        List<IVideo> result = null;
        try {
            ArrayList<IVideo> videos = new ArrayList<IVideo>();
            c = Access.getConnection();
            StringBuffer statement = new StringBuffer(
                    "SELECT videoid, siteSpecificID, residentSite, title, snapshotURL, summary, firstSubmitUserid, refHtml, time FROM video WHERE ");
            Iterator<String> it = condition.iterator();
            while (it.hasNext()) {
                statement.append(it.next() + " = ? ");
                if (it.hasNext()) {
                    statement.append(" AND ");
                }
            }
            if (condition.size() == 0) {
                statement.append(" 1=1 ");
            }
            statement.append("ORDER BY videoid DESC LIMIT ?");
            ps = c.prepareStatement(statement.toString());
            it = condition.iterator();
            for (int i = 0; i != condition.size(); ++i) {
                ps.setObject(i + 1, conditionValue.get(i));
            }
            ps.setInt(condition.size() + 1, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Video v = new Video();
                v.setVideoid(rs.getInt("videoid"));
                v.setSiteSpecificID(decodeString(rs.getString("siteSpecificID")));
                v.setResidentSite(decodeString(rs.getString("residentSite")));
                v.setTitle(decodeString(rs.getString("title")));
                v.setSnapshotURL(decodeString(rs.getString("snapshotURL")));
                v.setSummary(decodeString(rs.getString("summary")));
                v.setFirstSubmitUserid(rs.getInt("firstSubmitUserid"));
                v.setTime(rs.getTimestamp("time"));
                v.setRefHtml(decodeString(rs.getString("refHtml")));
                videos.add(v);
            }
            result = videos;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<AD> getAD(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<AD> result = null;
        try {
            ArrayList<AD> ads = new ArrayList<AD>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT adid, text, url FROM ad WHERE " + condition + " = ? LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AD ad = new AD();
                ad.setAdid(rs.getInt("adid"));
                ad.setText(rs.getString("text"));
                ad.setUrl(rs.getString("url"));
                ads.add(ad);
            }
            result = ads;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<ChannelADRelation> getChannelADRelation(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<ChannelADRelation> result = null;
        try {
            ArrayList<ChannelADRelation> relation = new ArrayList<ChannelADRelation>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT groupid, adid, time FROM adinchannel WHERE " + condition + " = ? ORDER BY time desc LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChannelADRelation re = new ChannelADRelation();
                re.setAdid(rs.getInt("adid"));
                re.setChannelid(rs.getInt("groupid"));
                re.setTime(rs.getTimestamp("time"));
                relation.add(re);
            }
            result = relation;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public List<JoinChannelEvent> getUserChannelMemberRelation(
            String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<JoinChannelEvent> result = null;
        try {
            ArrayList<JoinChannelEvent> relation = new ArrayList<JoinChannelEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, groupid, score, time, id FROM ingroup WHERE " + condition + " = ? ORDER BY time desc LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                JoinChannelEvent re = new JoinChannelEvent();
                re.setUserid(rs.getInt("userid"));
                re.setGroupid(rs.getInt("groupid"));
                re.setScore(rs.getDouble("score"));
                re.setTime(rs.getTimestamp("time"));
                re.setJoinchannelid(rs.getLong("id"));
                relation.add(re);
            }
            result = relation;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<SubscribeChannelEvent> getUserChannelSubscriberRelation(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<SubscribeChannelEvent> result = null;
        try {
            ArrayList<SubscribeChannelEvent> relation = new ArrayList<SubscribeChannelEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, groupid, time, id FROM followchannel WHERE " + condition + " = ? ORDER BY time desc LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SubscribeChannelEvent re = new SubscribeChannelEvent();
                re.setUserid(rs.getInt("userid"));
                re.setChannelid(rs.getInt("groupid"));
                re.setTime(rs.getTimestamp("time"));
                re.setSubscribeid(rs.getLong("id"));
                relation.add(re);
            }
            result = relation;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
   
    public List<WatchEvent> getWatch(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<WatchEvent> result = null;
        try {
            ArrayList<WatchEvent> events = new ArrayList<WatchEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, videoid, min(time), id FROM watch WHERE " + condition + " = ?  group by userid, videoid ORDER BY time DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WatchEvent event = new WatchEvent();
                event.setUserid(rs.getInt("userid"));
                event.setVideoid(rs.getInt("videoid"));
                event.setTime(rs.getTimestamp("min(time)"));
                event.setWatchid(rs.getLong("id"));
                events.add(event);
            }
            result = events;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<CollectEvent> getCollect(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<CollectEvent> result = null;
        try {
            ArrayList<CollectEvent> events = new ArrayList<CollectEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, videoid, time, id, comment FROM collect WHERE " + condition + " = ? ORDER BY time DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CollectEvent event = new CollectEvent();
                event.setUserid(rs.getInt("userid"));
                event.setVideoid(rs.getInt("videoid"));
                event.setTime(rs.getTimestamp("time"));
                event.setComment(rs.getString("comment"));
                event.setCollectid(rs.getLong("id"));
                events.add(event);
            }
            result = events;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<RateEvent> getRate(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<RateEvent> result = null;
        try {
            ArrayList<RateEvent> events = new ArrayList<RateEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, videoid, time, score, id, comment FROM rate WHERE " + condition + " = ? ORDER BY time DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RateEvent event = new RateEvent();
                event.setUserid(rs.getInt("userid"));
                event.setVideoid(rs.getInt("videoid"));
                event.setTime(rs.getTimestamp("time"));
                event.setScore(rs.getDouble("score"));
                event.setComment(rs.getString("comment"));
                event.setRateid(rs.getLong("id"));
                events.add(event);
            }
            result = events;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<SubmitEvent> getSubmit(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<SubmitEvent> result = null;
        try {
            ArrayList<SubmitEvent> events = new ArrayList<SubmitEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, videoid, time, id, comment FROM submit WHERE " + condition + " = ? ORDER BY time DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SubmitEvent event = new SubmitEvent();
                event.setUserid(rs.getInt("userid"));
                event.setVideoid(rs.getInt("videoid"));
                event.setTime(rs.getTimestamp("time"));
                event.setSubmitid(rs.getLong("id"));
                event.setComment(rs.getString("comment"));
                events.add(event);
            }
            result = events;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<PostEvent> getPost(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<PostEvent> result = null;
        try {
            ArrayList<PostEvent> events = new ArrayList<PostEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT userid, videoid, groupid, time,id, comment FROM post WHERE " + condition + " = ? ORDER BY time DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostEvent event = new PostEvent();
                event.setGroupid(rs.getInt("groupid"));
                event.setUserid(rs.getInt("userid"));
                event.setVideoid(rs.getInt("videoid"));
                event.setTime(rs.getTimestamp("time"));
                event.setComment(rs.getString("comment"));
                event.setPostid(rs.getLong("id"));
                events.add(event);
            }
            result = events;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<VideoCommentEvent> getVideoComment(ArrayList<String> condition, ArrayList<Object> conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<VideoCommentEvent> result = null;
        try {
            ArrayList<VideoCommentEvent> comments = new ArrayList<VideoCommentEvent>();
            c = Access.getConnection();
            StringBuffer statement = new StringBuffer(
                    "SELECT videocommentid, videoid, userid, parentid, comment, time FROM videocomment WHERE ");
           Iterator<String> it = condition.iterator();
            while (it.hasNext()) {
                statement.append(it.next() + " = ? ");
                if (it.hasNext()) {
                    statement.append(" AND ");
                }
            }
            if (condition.size() == 0) {
                statement.append(" 1=1 ");
            }
            statement.append("ORDER BY time DESC LIMIT ?");
            ps = c.prepareStatement(statement.toString());
            it = condition.iterator();
            for (int i = 0; i != condition.size(); ++i) {
                ps.setObject(i + 1, conditionValue.get(i));
            }
            ps.setInt(condition.size() + 1, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VideoCommentEvent comment = new VideoCommentEvent();
                comment.setCommentid(rs.getInt("videocommentid"));
                comment.setVideoid(rs.getInt("videoid"));
                comment.setUserid(rs.getInt("userid"));
                comment.setParentCommentid(rs.getInt("parentid"));
                comment.setComments(decodeString(rs.getString("comment")));
                comment.setTime(rs.getTimestamp("time"));
                comments.add(comment);
            }
            result = comments;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<VideoCommentEvent> getVideoComment(String condition, Object conditionValue, int limit) {
        ArrayList<String> conditions = new ArrayList<String>();
        conditions.add(condition);
        ArrayList<Object> conditionValues = new ArrayList<Object>();
        conditionValues.add(conditionValue);
        return getVideoComment(conditions, conditionValues, limit);
    }

    public List<CommentEvent> getCommentEvent(ArrayList<String> condition, ArrayList<Object> conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<CommentEvent> result = null;
        try {
            ArrayList<CommentEvent> comments = new ArrayList<CommentEvent>();
            c = Access.getConnection();
            StringBuffer statement = new StringBuffer(
                    "SELECT id, hostid, userid, parentid, comment, time FROM comment WHERE ");
           Iterator<String> it = condition.iterator();
            while (it.hasNext()) {
                statement.append(it.next() + " = ? ");
                if (it.hasNext()) {
                    statement.append(" AND ");
                }
            }
            if (condition.size() == 0) {
                statement.append(" 1=1 ");
            }
            statement.append("ORDER BY time ASC LIMIT ?");
            ps = c.prepareStatement(statement.toString());
            it = condition.iterator();
            for (int i = 0; i != condition.size(); ++i) {
                ps.setObject(i + 1, conditionValue.get(i));
            }
            ps.setInt(condition.size() + 1, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CommentEvent comment = new CommentEvent();
                comment.setCommentid(rs.getLong("id"));
                comment.setHostid(rs.getLong("hostid"));
                comment.setUserid(rs.getInt("userid"));
                comment.setParentCommentid(rs.getInt("parentid"));
                comment.setComment(decodeString(rs.getString("comment")));
                comment.setTime(rs.getTimestamp("time"));
                comments.add(comment);
            }
            result = comments;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<CommentEvent> getEventComment(String condition, Object conditionValue, int limit) {
        ArrayList<String> conditions = new ArrayList<String>();
        conditions.add(condition);
        conditions.add("type");
        ArrayList<Object> conditionValues = new ArrayList<Object>();
        conditionValues.add(conditionValue);
        conditionValues.add(CommentEvent.HOST_TYPE.EVENT.name());
        return getCommentEvent(conditions, conditionValues, limit);
    }

    public List<CommentEvent> getUserComment(String condition, Object conditionValue, int limit) {
        ArrayList<String> conditions = new ArrayList<String>();
        conditions.add(condition);
        conditions.add("type");
        ArrayList<Object> conditionValues = new ArrayList<Object>();
        conditionValues.add(conditionValue);
        conditionValues.add(CommentEvent.HOST_TYPE.USER.name());
        return getCommentEvent(conditions, conditionValues, limit);
    }
    
    public List<VideoRelation> getVideoRelation(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<VideoRelation> result = null;
        try {
            ArrayList<VideoRelation> relation = new ArrayList<VideoRelation>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT videoid, relatedvideoid, weight FROM videorelated WHERE " + condition + " = ? ORDER BY weight DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VideoRelation re = new VideoRelation();
                re.setHostVideoid(rs.getInt("videoid"));
                re.setRelatedVideoid(rs.getInt("relatedvideoid"));
                re.setWeight(rs.getDouble("weight"));
                relation.add(re);
            }
            result = relation;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<UserRelationEvent> getUserRelation(String condition, Object conditionValue, int limit) {
        Connection c = null;
        PreparedStatement ps = null;
        List<UserRelationEvent> result = null;
        try {
            ArrayList<UserRelationEvent> relation = new ArrayList<UserRelationEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT followeeid, followerid, time, id FROM follow WHERE " + condition + " = ? ORDER BY time DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserRelationEvent re = new UserRelationEvent();
                re.setFolloweeid(rs.getInt("followeeid"));
                re.setFollowerid(rs.getInt("followerid"));
                re.setTime(rs.getTimestamp("time"));
                re.setUserrelationid(rs.getLong("id"));
                relation.add(re);
            }
            result = relation;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }


    public List<VisitEvent> getUserVisit(String condition, Object conditionValue, int limit) {
         Connection c = null;
        PreparedStatement ps = null;
        List<VisitEvent> result = null;
        try {
            ArrayList<VisitEvent> relation = new ArrayList<VisitEvent>();
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT hostid, visitorid, time, id FROM visit WHERE " + condition + " = ? ORDER BY time DESC LIMIT ?");
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VisitEvent re = new VisitEvent();
                re.setHostid(rs.getInt("hostid"));
                re.setTime(rs.getTimestamp("time"));
                re.setVisitorid(rs.getInt("visitorid"));
                re.setVisiteventid(rs.getLong("id"));
                relation.add(re);
            }
            result = relation;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }


    public List<ShareEvent> getShare(String condition, Object conditionValue, int limit, logic.datatype.ShareEvent.CONTENT_TYPE contenttype) {
        Connection c = null;
        PreparedStatement ps = null;
        List<ShareEvent> result = null;
        try {
            ArrayList<ShareEvent> relation = new ArrayList<ShareEvent>();
            c = Access.getConnection();
            String queryString = "SELECT userid, contentid, contenttype, snsid, comment, time, id FROM share WHERE " + condition + " = ? ORDER BY time DESC LIMIT ?";
            if (contenttype != null) {
                queryString = "SELECT userid, contentid, contenttype, snsid, comment, time, id FROM share WHERE " + condition + " = ? and contenttype = '" + contenttype.name() + "' ORDER BY time DESC LIMIT ?";
            }
            ps = c.prepareStatement(queryString);
            ps.setObject(1, conditionValue);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ShareEvent re = new ShareEvent();
                re.setUserid(rs.getInt("userid"));
                re.setContentid(rs.getLong("contentid"));
                re.setContent_type(ShareEvent.CONTENT_TYPE.valueOf(rs.getString("contenttype")));
                re.setSns_id(rs.getString("snsid"));
                re.setComment(rs.getString("comment"));
                re.setTime(rs.getTimestamp("time"));
                re.setShareeventid(rs.getLong("id"));
                relation.add(re);
            }
            result = relation;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    /** type can be "watch", "submit", "rate", "collect", "follower"
     *
     * @param type
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     * Pair usrid: count
     */
    public List<Pair<Integer, Integer>> getTopUser(String type, long startTime, long endTime, int limit) {
        if (type.equals("watch") || type.equals("submit") || type.equals("rate") || type.equals("collect") || type.equals("followee")) {
            Connection c = null;
            PreparedStatement ps = null;
            List<Pair<Integer, Integer>> result = null;
            try {
                result = new ArrayList<Pair<Integer, Integer>>();
                c = Access.getConnection();
                String idString = "userid";
                String tableString = type;
                if (type.equals("followee")) {
                    idString = "followeeid";
                    tableString = "follow";
                }
                ps = c.prepareStatement("SELECT " + idString + ", count(*) as count_u FROM " + tableString + " WHERE  time between  ?  and  ? GROUP BY " + idString + "  ORDER BY count_u DESC LIMIT ?");
                ps.setTimestamp(1, new Timestamp(startTime));
                ps.setTimestamp(2, new Timestamp(endTime));
                ps.setInt(3, limit);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Pair<Integer, Integer> p = new Pair<Integer, Integer>();
                    p.setKey(rs.getInt(idString));
                    p.setValue(rs.getInt("count_u"));
                    result.add(p);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return result;
        }
        return null;
    }

    /**
     * 
     * @param type
     *  type can be join, subscribe, post
     * @param startTime
     * @param currentTime
     * @param limit
     * @return
     */

    public List<Pair<Integer, Integer>> getTopChannel(String type, long startTime, long endTime, int limit) {
        if (type.equals("join") || type.equals("subscribe") || type.equals("post")) {
            Connection c = null;
            PreparedStatement ps = null;
            List<Pair<Integer, Integer>> result = null;
            try {
                result = new ArrayList<Pair<Integer, Integer>>();
                c = Access.getConnection();
                String idString = "groupid";
                String tableString = type;
                if (type.equals("join")) {
                    idString = "groupid";
                    tableString = "ingroup";
                } else if (type.equals("subscribe")) {
                    idString = "groupid";
                    tableString = "followchannel";
                } else if (type.equals("post")) {
                    idString = "groupid";
                    tableString = "post";
                }
                ps = c.prepareStatement("SELECT " + idString + ", count(*) as count_c FROM " + tableString + " WHERE  time between  ?  and  ? GROUP BY " + idString + "  ORDER BY count_c DESC LIMIT ?");
                ps.setTimestamp(1, new Timestamp(startTime));
                ps.setTimestamp(2, new Timestamp(endTime));
                ps.setInt(3, limit);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Pair<Integer, Integer> p = new Pair<Integer, Integer>();
                    p.setKey(rs.getInt(idString));
                    p.setValue(rs.getInt("count_c"));
                    result.add(p);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return result;
        }
        return null;
    }

    public int getWatchCount(String condition, Object conditionValue) {
        return (int)getAggregate(condition, conditionValue, "watch", "count(ALL " + condition + ")");
    }
    public int getRateCount(String condition, Object conditionValue) {
        return (int)getAggregate(condition, conditionValue, "rate", "count(ALL  " + condition + ")");
    }
    public int getSubmitCount(String condition, Object conditionValue)  {
        return (int)getAggregate(condition, conditionValue, "submit",  "count( ALL " + condition + ")");
    }
    public double getRateScoreAverage(String condition, Object conditionValue) {
        return getAggregate(condition, conditionValue, "rate", "avg(score)");
    }
    public int getCollectCount(String condition, Object conditionValue) {
        return (int) getAggregate(condition, conditionValue, "collect",  "count( ALL " + condition + ")");
    }
    public int getVideoCommentCount(String condition, Object conditionValue) {
        return (int) getAggregate(condition, conditionValue, "videocomment", "count( ALL " + condition  +")");
    }
    public int getPostCount(String condition, Object conditionValue) {
        return (int) getAggregate(condition, conditionValue, "post", "count( ALL "  + condition + ")");
    }
    public int getEventCommentCount(String condition, Object conditionValue) {
        return (int) getAggregate(condition, conditionValue, "comment", "count( ALL " + condition  +")", "type", logic.datatype.CommentEvent.HOST_TYPE.EVENT.name());
    }
    public int getUserCommentCount(String condition, Object conditionValue) {
        return (int) getAggregate(condition, conditionValue, "comment", "count( ALL " + condition  +")", "type", logic.datatype.CommentEvent.HOST_TYPE.USER.name());
    }
    public int getUserVisitCount(String condition, Object conditionValue) {
        return (int) getAggregate(condition, conditionValue, "visit", "count( ALL " + condition  +")");
    }
    public int getShareCount(String condition, Object conditionValue) {
        return (int) getAggregate(condition, conditionValue, "share", "count( ALL " + condition  +")");
    }
    public int getShareCountWithType(String condition, Object conditionValue, logic.datatype.ShareEvent.CONTENT_TYPE contenttype) {
        return (int) getAggregate(condition, conditionValue, "share", "count( ALL " + condition  +")", "contenttype", contenttype.name());
    }

    public double getAggregate(String condition, Object conditionValue,
            String table, String column) {
        return getAggregate(condition, conditionValue, table, column, "1", 1);
    }
    /**
     * 
     * @param condition
     * @param conditionValue
     * @param table
     * @param column
     * aggregate function, like count(*), avg(score)
     * @return
     * 
     */
    public double getAggregate(String condition, Object conditionValue,
            String table, String column, String constrain, Object constrainValue) {
        Connection c = null;
        PreparedStatement ps = null;
        double result = -1;
        try {
            c = Access.getConnection();
            ps = c.prepareStatement("SELECT " + column + " from " + table + " where " + condition + " = ? and " + constrain + " = ?");
            ps.setObject(1, conditionValue);
            ps.setObject(2, constrainValue);
            ResultSet rs = ps.executeQuery();
            double value = -1;
            if (rs.next()) {
                value = rs.getInt(column);
            }
            rs.close();
            ps.close();
            c.close();
            result = value;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    protected String decodeString(String s) {
        String result;
        if (s == null) {
            result = "null";
        } else {
            result = s.replace("''", "'");
        }
        return result;
    }

}
