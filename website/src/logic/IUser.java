package logic;

import logic.datatype.*;
import java.util.*;

import net.sf.json.JSONObject;
import utility.ConstellationUtil.Constellation;
import utility.Pair;

/**
 * 
 * This interface provides all the high-level operations of a user. 
 * JSP should use these function directly without composing anything.
 * This helps us to keep JSP simple and easy to read.
 * 
 * Current Features:
 * 1. property access
 * 2. User/Video  watch, suggest, submit, collect
 * 3. User/User   follow, disfollow
 * 4. User/Group  join/post
 * 
 * To add a new User, 
 * One can getEmptyUser from EntityFactory, set part of the fields (except userid) and commit.
 *
 * @author xuan
 *
 */
public interface IUser {
    // Property Section

    // F: female, M: Male, O: other
    public String getGender();
    public void setGender(String gender);
    
    public int getUserid();

    public void setUserid(int userid);

    public String getName();

    public void setName(String name);

    public String getEmail();

    public void setEmail(String email);

    public String getPassword();

    public void setPassword(String password);

    public Date getJoinTime();

    public void setJoinTime(Date joinTime);

    public String getDescription();

    public void setDescription(String description);

    public String getAuthenticator();
    /**
     * one should call commit to write it back to database
     * @return
     */
    public void setAuthenticator(String auth);

    public String getPhoto();  // returns the large photo
    public String getPhotoMedium();
    public String getPhotoSmall();
    public String getPhotoMini();

    public void setPhoto(String photoPath);
    public void setPhotoMedium(String photoPath);
    public void setPhotoSmall(String photoPath);
    public void setPhotoMini(String photoPath);

    public String getRenrenid();

    public void setRenrenid(String renrenid);
    /**
     * Call commit after you make any property changes
     * @return Status Code:
     * Constant.USER_ENTRY_EMAIL_DUPLICATED
     * >0: success
     */
    public int commit();
    /*=======================================
     * User <===> Video interaction
     *=======================================*/

    /**
     * @param v
     * Video.
     * @return Status Code:
     * GlobalConstant.SUBMIT_SUCCESS: success
     * GlobalConstant.SUBMIT_URL_ERROR: url invalid
     * GlobalConstant.SUBMIT_BEFORE: submitted before
     */
    public int submitVideo(IVideo v);
     /**
     * This function retrieves first topnum submitted videos by this user according to some metrics.
     * @param topnum
     * @return
     */
    public List<SubmitEvent> getSubmitedVideo(int from, int num);
    public int getSubmitedVideoNumber();

    public void rateVideo(int videoID, double score);
    public void rateVideo(int videoID, double score, String comment);

    /**
     * This function retrieves first topnum suggest videos by this user according to some metrics.
     * @param topnum
     * @return
     */
    public List<RateEvent> getRatedVideo(int from, int num);
    public int getRatedVideoNumber();

    public void watchVideo(int videoID);


    /**
     * This function retrieves first topnum watched videos by this user according to some metrics.
     * @param topnum
     * @return
     */
    public List<WatchEvent> getWatchedVideo(int from, int num);
    public int getWatchedVideoNumber();

    public void collectVideo(int videoID);
    public void collectVideo(int videoID, String comment);
    public void cancelCollectVideo(int videoID);
    /**
     * This function retrieves first topnum watched videos by this user according to some metrics.
     * @param topnum
     * @return
     */
    public List<CollectEvent> getCollectedVideo(int from, int num);
    public int getCollectedVideoNumber();

    /**
     * 
     * @param videoid
     * @param comment
     * @param parentid
     *  parent comment. If no parent exists, set it to Constant.VIDEO_COMMENT_COMMON_PARENT_ID
     */
    public VideoCommentEvent addVideoComment(int videoid, String comment, int parentid);

    /**
     * This function retrieves first topnum commented videos by this user according to some metrics.
     * @param topnum
     * @return
     */
    public List<VideoCommentEvent> getVideoCommented(int topnum);
    public int getCommentNumber();

    /*=======================================
     * User <===> User interaction
     *=======================================*/
    public int followByID(int userid);
    public int cancelFollowByID(int userid);
    /**
     * Avoid using this function if you can use ID/Email instead.
     * Since name is not unique, we have to guess.
     * @param name
     *
     */
    //public void followByNameAndGuess(String name);
    public int followByEmail(String email);
    public int cancelFollowByEmail(String email);

    /**
     * Users that follow this user.
     * @return
     */
    public List<Integer> getFollower();

    /**
     * Users followed by this user.
     * @return
     */    
    public List<Integer> getFollowee();
    //public void addUserComments(UserComment uc);
    ///**
    // * This function retrieves first topnum comments of this user according to some metrics.
    // * @param topnum
    // * @return
    // */
    //public List<UserComment> getUserComments(int topnum);

    /*========================================
     * User <===> Channel interaction
     *========================================*/
    public void joinChannel(int groupid);

    /**
     *
     * @param name
     * @return <Status Code, IGroup>
     * Constant.DATABASE_INSERT_DUPLICATE
     * Constant.DATABASE_SUCCESS
     */
    public Pair<Integer, IChannel> setupChannel(String name);

    /**
     * This function retrieves first topnum joined group by this user according to some metrics.
     * @param topnum
     * @return
     */
    public List<JoinChannelEvent> getJoinedChannel(int topnum);

    public void postToChannel(PostEvent post);
    public void removePostFromChannel(int vid, IChannel c);

    public void followChannel(int channelid);
    public List<SubscribeChannelEvent> getFollowedChannel(int topnum);
    public void cancelFollowChannel(int channelid);
    /**
     *
     * @param c
     * @return
     * true: delete successfully
     * false: permission denied. Only administrator can delete the Channel
     */
    public boolean deleteChannel(IChannel c);

    /**
     * This function retrieves first topnum joined group by this user according to some metrics.
     * @param topnum
     * @return
     * Pair: <channelid, videoid>
     */
    public List<PostEvent> getChannelEvents(int topnum);

    /*==========================================
     * Advanced Features
     *==========================================*/
    /**
     * This function retrieves first topnum Events related this user according to some metrics.
     * 
     * @param topnum
     * @return
     */
    public List<IEvent> GetMyNewEvents(int topnum);

    public List<IEvent> GetMoreMyNewEvents(int alreadyHas, int topnum);

    public List<IEvent> GetFolloweeNewEvents(int topnum);

    public List<IEvent> GetMoreFolloweeNewEvents(int alreadyhas, int topnum);
    
    public List<IVideo> GetHotVideo(int topnum);

    public List<IVideo> GetMoreHotVideo(int alreadyHas, int videonum);

    public List<IVideo> GetNewVideo(int topnum);

    public List<IVideo> GetMoreNewVideo(int alreadyHas, int videonum);

    // if not parenet comment, please use Constant.EVENT_COMMENT_COMMON_PARENT
    public CommentEvent leaveEventComment(long eventid, String comment, long parentid);
    
    public void shareVideo(int videoid, String comment, String sns_id);
    public List<ShareEvent> getRecentShareEvent(int topnum);
    public List<ShareEvent> getRecentShareEvent(int topnum, logic.datatype.ShareEvent.CONTENT_TYPE contenttype);
    public int getShareNum();

    /*==========================================
     * Network
     *==========================================*/
    public JSONObject toJSONObject();
    public String toJSONString();

    public void visit(int userid);
    public List<VisitEvent> getRecentVisitors(int topnum);
    public int getUserVisitNum();

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public String getLocation();

    public void setLocation(String location);

    public Constellation getConstellation();

    public CommentEvent leaveUserComment(int userid, String comment, int parentid);
    public List<CommentEvent> getUserComments(int topnum);
    public int getUserCommentCount();
}
