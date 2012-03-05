package logic.datatype;

import java.sql.Time;
import java.util.Date;
import logic.EntityFactory;

import logic.IEvent;
import net.sf.json.JSONObject;
import utility.Constant;
import utility.Misc;

public class PostEvent extends BaseEvent {

    int userid;
    int channelid;
    int videoid;
    String comment = "";
    Date time;
    long postid;
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    

    public void setPostid(long postid) {
        this.postid = postid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGroupid() {
        return channelid;
    }

    public void setGroupid(int channelid) {
        this.channelid = channelid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PostEvent: " + "userid = " + userid + "; channelid = " + channelid
                + "; videoid = " + videoid + "; time = " + time + "; comment = " + comment  + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "PostEvent");
        jobj.put("uid", userid);
        jobj.put("cid", channelid);
        jobj.put("vid", videoid);
        jobj.put("time", time);
        jobj.put("ago", Misc.pastTime(time));
        jobj.put("comment", comment);
        // entries that might slow down
        jobj.put("album-name", EntityFactory.getGroup(channelid).getName());
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.postid;
    }
}
