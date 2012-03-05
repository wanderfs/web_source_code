package logic.datatype;

import java.util.Date;

import net.sf.json.JSONObject;
import utility.Constant;
import utility.Misc;

public class SubmitEvent extends BaseEvent {

    int userid;
    int videoid;
    Date time;
    long submitid;
    String comment = "";

    public String getComment() {
        if (comment == null || comment.equals("null")) comment = "";
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSubmitid(long submitid) {
        this.submitid = submitid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SubmitEvent: " + "userid = " + userid
                + "; videoid = " + videoid + "; time = " + time + "; comment = " + comment  + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "SubmitEvent");
        jobj.put("uid", userid);
        jobj.put("vid", videoid);
        jobj.put("time", time);
        jobj.put("ago", Misc.pastTime(time));
        jobj.put("comment", comment);
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.submitid;
    }
}
