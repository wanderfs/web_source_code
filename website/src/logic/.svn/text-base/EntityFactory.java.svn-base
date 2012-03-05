/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import database.StatementFactory;
import java.util.ArrayList;
import java.util.List;
import logic.datatype.CollectEvent;
import logic.datatype.JoinChannelEvent;
import logic.datatype.PostEvent;
import logic.datatype.RateEvent;
import logic.datatype.SubmitEvent;
import logic.datatype.SubscribeChannelEvent;
import logic.datatype.UserRelationEvent;
import logic.datatype.VideoCommentEvent;
import logic.datatype.WatchEvent;
import logic.parse.GenericVideoParser;
import logic.parse.IVideoParser;
import utility.Constant;
import utility.DatabaseFieldName;
import utility.Pair;

/**
 *
 * @author xuan
 */
public class EntityFactory {
    public static IUser getEmptyUser() {
        return new User();
    }

    public static IVideo getEmptyVideo() {
        return new Video();
    }

    public static IChannel getEmptyGroup() {
        return new Channel();
    }

    public static AD getAD(String text, String url) {
        AD ad = new AD();
        ad.setText(text);
        ad.setUrl(url);
        ad.commit();// we should get the adid back.
        return ad;
    }

    /**
     * This function has two pharse.
     * a. parse the url and turned it into a video object
     * b. query to see if we already have it
     * @param url
     * @return <status, IVideo>
     * For error code,
     * 1. Constant.SUBMIT_URL_ERROR, null
     * 2. Constant.SUBMIT_UNKNOWN_ERROR, parsed video object
     * 3. Constant.SUBMIT_BEFORE,  original video object
     * 4. Constant.SUBMIT_SUCCESS, parsed video object
     */
    public static Pair<Integer, IVideo> getVideo(String url){
        IVideoParser parser = (IVideoParser)GenericVideoParser.getGenericVideoParser();
        IVideo v = parser.parse(url);
        if (v != null) {
            ArrayList<String> conditions = new ArrayList<String>();
            ArrayList<Object> values = new ArrayList<Object>();
            conditions.add(DatabaseFieldName.VIDEO_RESIDENT_SITE);
            values.add(v.getResidentSite());
            conditions.add(DatabaseFieldName.VIDEO_SITE_SPECIFIC_ID);
            values.add(v.getSiteSpecificID());
            List<IVideo> videos = database.StatementFactory.getQuery().getVideo(conditions, values, 1);
            if (videos == null) {
                return new Pair<Integer, IVideo>(Constant.SUBMIT_UNKNOWN_ERROR, v);
            } else if (videos.isEmpty()) {
                return new Pair<Integer, IVideo>(Constant.SUBMIT_SUCCESS, v);
            } else if (!videos.isEmpty()) {
                return new Pair<Integer, IVideo>(Constant.SUBMIT_BEFORE, videos.get(0));
            }
        }
        return new Pair<Integer, IVideo>(Constant.SUBMIT_URL_ERROR, null);
    }

    public static IVideo getVideo(int id) {
        IVideo result = null;
        List<IVideo> videos = StatementFactory.getQuery().getVideo(Video.VIDEO_ID, id, 1);
        if (videos != null && !videos.isEmpty())
              result = videos.get(0);
        return result;
    }

    public static IChannel getGroup(int groupid) {
        List<IChannel> groups = StatementFactory.getQuery().getGroup(Channel.CHANNEL_ID, groupid, 1);
        IChannel result = null;
        if (groups != null && !groups.isEmpty()) {
            result = groups.get(0);
        }
        return result;
    }

    public static IUser getUser(int userid) {
        IUser result = null;
        List<IUser> users = StatementFactory.getQuery().getUser(User.USER_ID, userid, 1);
        if (users != null && !users.isEmpty()) {
            result = users.get(0);
        }
        return result;
    }

    public static IUser getUser(String email) {
        IUser result = null;
        List<IUser> users = StatementFactory.getQuery().getUser(User.USER_EMAIL, email, 1);
        if (users != null && !users.isEmpty()) {
            result = users.get(0);
        }
        return result;
    }

    public static IUser getUserByRenrenid(int renrenid) {
        IUser result = null;
        List<IUser> users = StatementFactory.getQuery().getUser(User.USER_RENREN_ID, renrenid, 1);
        if (users != null && !users.isEmpty()) {
            result = users.get(0);
        }
        return result;
    }

    public static IEvent getEventByEventID(long eventid) {
        int seq = (int) (eventid >> (63 - Constant.mask_length));
        long mask = ~((~((long) 0)) << (63 - Constant.mask_length));
        IEvent event = null;
        if (seq == Constant.EventIdSeqNum(CollectEvent.class)) {
            event = StatementFactory.getQuery().getCollect("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(JoinChannelEvent.class)) {
            event = StatementFactory.getQuery().getUserChannelMemberRelation("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(PostEvent.class)) {
            event = StatementFactory.getQuery().getPost("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(RateEvent.class)) {
            event = StatementFactory.getQuery().getRate("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(SubmitEvent.class)) {
            event = StatementFactory.getQuery().getSubmit("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(SubscribeChannelEvent.class)) {
            event = StatementFactory.getQuery().getUserChannelSubscriberRelation("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(UserRelationEvent.class)) {
            event = StatementFactory.getQuery().getUserRelation("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(VideoCommentEvent.class)) {
            event = StatementFactory.getQuery().getVideoComment("id", eventid & mask, 1).get(0);
        } else if (seq == Constant.EventIdSeqNum(WatchEvent.class)) {
            event = StatementFactory.getQuery().getWatch("id", eventid & mask, 1).get(0);
        }
        return event;
    }

    // can be null or empty
    public static List<IUser> searchUser(String name) {
        return StatementFactory.getQuery().searchUser(name);
    }
}
