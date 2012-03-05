package logic;

import database.StatementFactory;
import java.util.*;
import logic.datatype.*;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONObject;
import test.Test;
import utility.Constant;
import utility.ConstellationUtil;
import utility.ConstellationUtil.Constellation;
import utility.Pair;

public class User implements IUser {

    public final static String USER_ID = "userid";
    public final static String USER_EMAIL = "email";
    public final static String USER_RENREN_ID = "renrenid";
    int userid = -1;
    String name;
    String email;
    String password;
    String description;
    Date joinTime;
    String photo;
    String photoMedium;
    String photoSmall;
    String photoMini;
    String authenticator;
    String renrenid;
    String location = "";
    String gender;
    Date birthday;

    public User() {
        description = "";
        char random = (char) ('A' + (2345 * Math.random()) % ('T' - 'A' + 1));
        photo = "pic/face/face" + random + "160.png";
        photoMedium = "pic/face/face" + random + "75.png";
        photoSmall = "pic/face/face" + random + "45.png";
        photoMini = "pic/face/face" + random + "25.png";
        if (Math.random() < 0.5) {
            gender = "F";
        } else {
            gender = "M";
        }
        this.birthday = new Date();
    }

    @Override
    public String getGender() {
        return gender;
    }
    
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int getUserid() {
        return userid;
    }

    @Override
    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Date getJoinTime() {
        return joinTime;
    }

    @Override
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    // used for auto login authentication
    @Override
    public String getAuthenticator() {
        return authenticator;
    }

    @Override
    public void setAuthenticator(String authCode) {
        this.authenticator = authCode;
    }

    @Override
    public String getPhoto() {
        if (this.photo != null) {
            return this.photo;
        } else {
            return "pic/face/face"+ (char)('A' + this.userid % ('T' - 'A' + 1)) +"160.png";
        }
    }

    @Override
    public String getPhotoMedium() {
        if (this.photoMedium != null) {
            return this.photoMedium;
        } else {
            return "pic/face/face" + (char)('A' + this.userid % ('T' - 'A' + 1)) + "75.png";
        }
    }

    @Override
    public String getPhotoSmall() {
        if (this.photoSmall != null) {
            return this.photoSmall;
        } else {
            return "pic/face/face"+ (char)('A' + this.userid % ('T' - 'A' + 1)) + "45.png";
        }
    }

    public String getPhotoMini() {
        if (this.photoMini != null) {
            return this.photoMini;
        } else {
            return "pic/face/face"+ (char)('A' + this.userid % ('T' - 'A' + 1)) +"25.png";
        }
    }

    @Override
    public void setPhoto(String photoPath) {
        this.photo = photoPath;
    }

    public void setPhotoMedium(String photoPath) {
        this.photoMedium = photoPath;
    }

    public void setPhotoSmall(String photoPath) {
        this.photoSmall = photoPath;
    }

    public void setPhotoMini(String photoPath) {
        this.photoMini = photoPath;
    }

    @Override
    public String getRenrenid() {
        return renrenid;
    }

    @Override
    public void setRenrenid(String renrenid) {
        this.renrenid = renrenid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Constellation getConstellation() {
        return ConstellationUtil.constellationArr[ConstellationUtil.calculateConstellation(birthday) -1];
    }
    
    @Override
    public int commit() {
        int ret = 0;
        if (this.userid < 0) {  // should insert user
            ret = StatementFactory.getModify().insertUser(this);
        } else {
            ret = StatementFactory.getModify().updateUser(USER_ID, this.userid, this);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "User: " + "userid = " + userid
                + "; name = " + name + "; email = " + email
                + "; password = " + password
                + "; description = " + description
                + "; joinTime = " + joinTime
                + "; photo = " + photo
                + "; photoMedium = " + photoMedium
                + "; photoSmall = " + photoSmall
                + "; photoMini = " + photoMini
                + "; authenticator =" + this.authenticator
                + "; renrenid = " + this.renrenid
                + "; location = " + location
                + "; birthday = " + birthday
                + "; gender = " + gender;
    }

    // User-Video relation: submit, collect, watch, rate, comment
    // every action has three functions:
    // do the action; get a list of actions; get total number of actions
    @Override
    public int submitVideo(IVideo v) {
        int status = Constant.SUBMIT_UNKNOWN_ERROR;
        if (v != null) {
            ArrayList<String> conArray = new ArrayList<String>();
            ArrayList<Object> conValueArray = new ArrayList<Object>();
            conArray.add("siteSpecificID");
            conArray.add("residentSite");
            conValueArray.add(v.getSiteSpecificID());
            conValueArray.add(v.getResidentSite());
            int insertstatus = StatementFactory.getModify().insertVideo(this, v);
            if (insertstatus > 0) {
                status = Constant.SUBMIT_SUCCESS;
            } else if (insertstatus == Constant.DATABASE_INSERT_DUPLICATE) {
                status = Constant.SUBMIT_BEFORE;
            }
            List<IVideo> videos = StatementFactory.getQuery().getVideo(conArray, conValueArray, 1);
            if (videos != null && !videos.isEmpty()) {
                IVideo tmp = videos.get(0);
                StatementFactory.getModify().insertSubmit(this, tmp.getVideoid(), v.getSummary());
                v.setVideoid(tmp.getVideoid());
            } else {
                status = Constant.DATABASE_UNKNOWN_ERROR;
            }
        } else {
            status = Constant.SUBMIT_URL_ERROR;
        }
        ArtificialBehavior.smartFollowUser(this);
        return status;
    }

    @Override
    public List<SubmitEvent> getSubmitedVideo(int from, int num) {
        List<SubmitEvent> results = StatementFactory.getQuery().getSubmit(User.USER_ID, this.userid, from + num);
        if (results.size() > num) {
            results = results.subList(results.size() - num, results.size());
        }
        return results;
    }

    @Override
    public int getSubmitedVideoNumber() {
        return StatementFactory.getQuery().getSubmitCount(User.USER_ID, this.userid);
    }

    @Override
    public void collectVideo(int videoID) {
        this.collectVideo(videoID, "");
    }

    @Override
    public void collectVideo(int videoID, String comment) {
        StatementFactory.getModify().insertCollect(this, videoID, comment);
        ArtificialBehavior.smartFollowUser(this);
    }

    @Override
    public void cancelCollectVideo(int videoID) {
        StatementFactory.getModify().removeCollect(this, videoID);
    }

    @Override
    public List<CollectEvent> getCollectedVideo(int from, int num) {
        List<CollectEvent> results = StatementFactory.getQuery().getCollect(User.USER_ID, this.userid, from + num);
        if (results.size() > num) {
            results = results.subList(results.size() - num, results.size());
        }
        return results;
    }

    @Override
    public int getCollectedVideoNumber() {
        return StatementFactory.getQuery().getCollectCount(User.USER_ID, userid);
    }

    @Override
    public void watchVideo(int videoID) {
        StatementFactory.getModify().insertWatch(this, videoID);
    }

    @Override
    public List<WatchEvent> getWatchedVideo(int from, int num) {
        List<WatchEvent> results = StatementFactory.getQuery().getWatch(User.USER_ID, this.userid, from + num);
        if (results.size() > num) {
            results = results.subList(results.size() - num, results.size());
        }
        return results;
    }

    @Override
    public int getWatchedVideoNumber() {
        return StatementFactory.getQuery().getWatchCount(User.USER_ID, userid);
    }

    @Override
    public void rateVideo(int videoID, double score) {
        this.rateVideo(videoID, score, "");
    }

    @Override
    public void rateVideo(int videoID, double score, String comment) {
        StatementFactory.getModify().insertRate(this, videoID, score, comment);
        ArtificialBehavior.smartFollowUser(this);
    }

    @Override
    public List<RateEvent> getRatedVideo(int from, int num) {
        List<RateEvent> results = StatementFactory.getQuery().getRate(User.USER_ID, this.userid, from + num);
        if (results.size() > num) {
            results = results.subList(results.size() - num, results.size());
        }
        return results;
    }

    @Override
    public int getRatedVideoNumber() {
        return StatementFactory.getQuery().getRateCount(User.USER_ID, userid);
    }

    @Override
    public VideoCommentEvent addVideoComment(int videoid, String comment, int parentid) {
        ArtificialBehavior.smartFollowUser(this);
        StatementFactory.getModify().insertVideoComment(this, videoid, comment, parentid);
        ArrayList<String> conditions = new ArrayList<String>();
        conditions.add("videoid");
        conditions.add("comment");
        conditions.add("parentid");
        ArrayList<Object> value = new ArrayList<Object>();
        value.add(videoid);
        value.add(comment);
        value.add(parentid);
        List<VideoCommentEvent> result = StatementFactory.getQuery().getVideoComment(conditions, value, 1);
        if (result != null && !result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<VideoCommentEvent> getVideoCommented(int topnum) {
        return StatementFactory.getQuery().getVideoComment(User.USER_ID, this.userid, topnum);
    }

    @Override
    public int getCommentNumber() {
        return StatementFactory.getQuery().getVideoCommentCount(User.USER_ID, this.userid);
    }

    // User-User relation: follow, cancel follow
    @Override
    public int followByID(int userid) {
        ArtificialBehavior.smartFollowUser(this);
        return StatementFactory.getModify().insertFollowee(this, userid);
    }

    @Override
    public int followByEmail(String email) {
        IUser u = EntityFactory.getUser(email);
        if (u != null) {
            return this.followByID(u.getUserid());
        } else {
            return Constant.FOLLOWEE_NOT_EXIST;
        }
    }

    @Override
    public int cancelFollowByID(int userid) {
        return StatementFactory.getModify().removeFollowee(this, userid);
    }

    @Override
    public int cancelFollowByEmail(String email) {
        IUser u = EntityFactory.getUser(email);
        if (u != null) {
            return this.cancelFollowByID(u.getUserid());
        } else {
            return Constant.FOLLOWEE_NOT_EXIST;
        }
    }

    @Override
    public List<Integer> getFollower() {
        List<UserRelationEvent> l = StatementFactory.getQuery().getUserRelation(
                "followeeid", this.userid, Integer.MAX_VALUE);
        Iterator<UserRelationEvent> it = l.iterator();
        List<Integer> followers = new ArrayList<Integer>();
        while (it.hasNext()) {
            followers.add(it.next().getFollowerid());
        }
        return followers;
    }

    @Override
    public List<Integer> getFollowee() {
        List<UserRelationEvent> l = StatementFactory.getQuery().getUserRelation(
                "followerid", this.userid, Integer.MAX_VALUE);
        Iterator<UserRelationEvent> it = l.iterator();
        List<Integer> followees = new ArrayList<Integer>();
        while (it.hasNext()) {
            followees.add(it.next().getFolloweeid());
        }
        return followees;
    }

    // need permission control by upper layer
    @Override
    public void joinChannel(int channelid) {
        StatementFactory.getModify().insertJoinGroup(this, channelid);
        followChannel(channelid);
    }

    @Override
    public Pair<Integer, IChannel> setupChannel(String name) {
        int statusCode;
        IChannel g = new Channel();
        g.setName(name);
        statusCode = StatementFactory.getModify().insertGroup(this, g);
        if (statusCode != Constant.DATABASE_INSERT_DUPLICATE) {
            List<IChannel> channels = StatementFactory.getQuery().getGroup("name", g.getName(), 1);
            if (!channels.isEmpty()) {
                for (IChannel c : channels) {
                    if (c.getAdministratorid() == this.getUserid()) {
                        g = c;
                        break;
                    }
                }
                this.joinChannel(g.getChannelid());
            } else {
                Test.println("groups is empty");
                g = null;
            }
        } else {
            Test.println("duplicated ");
            g = null;
        }
        ArtificialBehavior.smartFollowUser(this);
        return new Pair<Integer, IChannel>(statusCode, g);
    }

    @Override
    public List<JoinChannelEvent> getJoinedChannel(int topnum) {
        return StatementFactory.getQuery().getUserChannelMemberRelation(USER_ID, this.userid, topnum);
    }

    @Override
    public void followChannel(int channelid) {
        StatementFactory.getModify().insertChannelFollower(this, channelid);
    }

    @Override
    public List<SubscribeChannelEvent> getFollowedChannel(int topnum) {
        return StatementFactory.getQuery().getUserChannelSubscriberRelation(USER_ID, this.userid, topnum);
    }

    @Override
    public void cancelFollowChannel(int channelid) {
        StatementFactory.getModify().removeChannelFollower(this, channelid);
    }

    @Override
    public void postToChannel(PostEvent post) {
        StatementFactory.getModify().insertPostToGroup(this, post);
        ArtificialBehavior.smartFollowUser(this);
    }

    @Override
    public void removePostFromChannel(int vid, IChannel c) {
        if (c.getAdministratorid() == this.userid) {
            StatementFactory.getModify().removeCollectChannelForce(c.getChannelid(), vid);
        } else {
            StatementFactory.getModify().removeCollectChannel(c.getChannelid(), vid, this.getUserid());
        }
    }

    @Override
    public List<PostEvent> getChannelEvents(int topnum) {
        return StatementFactory.getQuery().getPost(USER_ID, this.userid, topnum);
    }

    public boolean deleteChannel(IChannel c) {
        if (c != null && c.getAdministratorid() == this.userid) {
            StatementFactory.getModify().deleteChannel(c.getChannelid());
            return true;
        }
        return false;
    }

    @Override
    public List<IEvent> GetMyNewEvents(int topnum) {
        List<PostEvent> postEvent = this.getChannelEvents(topnum);
        List<RateEvent> rateEvent = this.getRatedVideo(0, topnum);
        List<CollectEvent> collectEvent = this.getCollectedVideo(0, topnum);
        List<SubmitEvent> submitEvent = this.getSubmitedVideo(0, topnum);
        List<VideoCommentEvent> commentEvent = this.getVideoCommented(topnum);
        List<JoinChannelEvent> joinEvent = this.getJoinedChannel(topnum);
        List<ShareEvent> shareEvent = this.getRecentShareEvent(topnum);
        List<SubscribeChannelEvent> followChannelEvent = this.getFollowedChannel(topnum);
        //List<VisitEvent> visitevent = this.getRecentVisitors(5);
        List<UserRelationEvent> followEvent = StatementFactory.getQuery().getUserRelation(
                "followerid", this.userid, Integer.MAX_VALUE);
        List<IEvent> events = new ArrayList<IEvent>();
        events.addAll(postEvent);
        events.addAll(rateEvent);
        events.addAll(collectEvent);
        events.addAll(submitEvent);
        events.addAll(commentEvent);
        events.addAll(joinEvent);
        events.addAll(shareEvent);
        events.addAll(followEvent);
        events.addAll(followChannelEvent);
        Collections.sort(events, new EventTimeDescComparator());
        if (events.size() > topnum) {
            events = events.subList(0, topnum);
        }
        return events;
    }

    @Override
    public List<IEvent> GetMoreMyNewEvents(int alreadyHas, int topnum) {
        List<IEvent> results = GetMyNewEvents(alreadyHas + topnum);
        if (results.size() > topnum) {
            results = results.subList(results.size() - topnum, results.size());
        }
        return results;
    }

    @Override
    public List<IEvent> GetFolloweeNewEvents(int topnum) {
        List<Integer> followee = getFollowee();
        Iterator<Integer> followit = followee.iterator();
        List<IEvent> events = new ArrayList<IEvent>();
        while (followit.hasNext()) {
            Integer followeeid = followit.next();
            IUser u = EntityFactory.getEmptyUser();
            u.setUserid(followeeid);
            List<IEvent> followeeEvent = u.GetMyNewEvents(topnum);
            events.addAll(followeeEvent);
        }
        Collections.sort(events, new EventTimeDescComparator());
        if (events.size() > topnum) {
            events = events.subList(0, topnum);
        }
        return events;
    }

    @Override
    public List<IEvent> GetMoreFolloweeNewEvents(int alreadyHas, int topnum) {
        List<IEvent> results = GetFolloweeNewEvents(alreadyHas + topnum);
        if (results.size() > topnum) {
            results = results.subList(results.size() - topnum, results.size());
        }
        return results;
    }

    @Override
    public List<IVideo> GetHotVideo(int topnum) {
        return Global.getHotVideo(topnum);
    }

    @Override
    public List<IVideo> GetMoreHotVideo(int alreadyHas, int videoNum) {
        return Global.getMoreHotVideo(alreadyHas, videoNum);
    }

    @Override
    public List<IVideo> GetNewVideo(int topnum) {
        return Global.getNewVideo(topnum);
    }

    @Override
    public List<IVideo> GetMoreNewVideo(int alreadyHas, int videoNum) {
        return Global.getMoreNewVideo(alreadyHas, videoNum);
    }

    @Override
    public CommentEvent leaveEventComment(long eventid, String comment, long parentid) {
        // create eventcomment
        CommentEvent ec = new CommentEvent();
        ec.setType(CommentEvent.HOST_TYPE.EVENT);
        ec.setComment(comment);
        ec.setHostid(eventid);
        ec.setUserid(userid);
        ec.setParentCommentid(parentid);
        StatementFactory.getModify().insertComment(ec);
        return ec;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "User");
        jobj.put("uid", userid);
        // jobj.put("email", email); this should not be exposed
        jobj.put("name", name);
        jobj.put("photo", this.getPhoto());
        jobj.put("photo_medium", this.getPhotoMedium());
        jobj.put("photo_small", this.getPhotoSmall());
        jobj.put("photo_mini", this.getPhotoMini());
        jobj.put("description", description);
        return jobj;
    }

    @Override
    public String toJSONString() {
        return toJSONObject().toString();
    }

    @Override
    public void visit(int hostuid) {
        database.StatementFactory.getModify().insertVisit(this, hostuid);
    }

    @Override
    public List<VisitEvent> getRecentVisitors(int topnum) {
        return database.StatementFactory.getQuery().getUserVisit("hostid", this.getUserid(), topnum);
    }

    @Override
    public int getUserVisitNum() {
        return database.StatementFactory.getQuery().getUserVisitCount("hostid", this.getUserid());
    }

    @Override
    public void shareVideo(int videoid, String comment, String sns_id) {
        ShareEvent e = new ShareEvent();
        e.setUserid(userid);
        e.setContent_type(ShareEvent.CONTENT_TYPE.VIDEO);
        e.setContentid(videoid);
        e.setComment(comment);
        e.setSns_id(sns_id);
        database.StatementFactory.getModify().insertShare(e);
    }

    @Override
    public List<ShareEvent> getRecentShareEvent(int topnum) {
        return database.StatementFactory.getQuery().getShare("userid", this.getUserid(), topnum, null);
    }
    @Override
    public List<ShareEvent> getRecentShareEvent(int topnum, logic.datatype.ShareEvent.CONTENT_TYPE contenttype) {
        return database.StatementFactory.getQuery().getShare("userid", this.getUserid(), topnum, contenttype);
    }

    @Override
    public int getShareNum() {
        return database.StatementFactory.getQuery().getShareCount("userid", this.getUserid());
    }


    @Override
    public CommentEvent leaveUserComment(int userid, String comment, int parentid) {
        CommentEvent ac = new CommentEvent();
        ac.setType(CommentEvent.HOST_TYPE.USER);
        ac.setComment(comment);
        ac.setHostid(userid);
        ac.setUserid(this.getUserid());
        ac.setParentCommentid(parentid);
        StatementFactory.getModify().insertComment(ac);
        return ac;
    }

    @Override
    public List<CommentEvent> getUserComments(int topnum) {
        List<CommentEvent> events = database.StatementFactory.getQuery().getUserComment("hostid", this.userid, topnum);
        return events;
    }
    
    @Override
    public int getUserCommentCount() {
        return (int)StatementFactory.getQuery().getUserCommentCount("hostid", this.userid);
    }
}
