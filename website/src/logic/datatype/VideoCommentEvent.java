package logic.datatype;

import java.util.Date;
import net.sf.json.JSONObject;
import utility.Constant;

public class VideoCommentEvent extends BaseEvent {

    int commentid;
    int parentCommentid;
    int userid;
    int videoid;
    String comment = "";
    Date time;

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

    public String getComment() {
        return comment;
    }

    public void setComments(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getParentCommentid() {
        return parentCommentid;
    }

    public void setParentCommentid(int parentCommentid) {
        this.parentCommentid = parentCommentid;
    }

    @Override
    public String toString() {
        return "VideoComment: " + "commentid = " + commentid
                + "; parentCommentid = " + parentCommentid + "; userid = " + userid
                + "; videoid = " + videoid + "; comment = " + comment + "; time = " + time  + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "VideoComment");
        jobj.put("commentid", commentid);
        jobj.put("parentCommentid", parentCommentid);
        jobj.put("userid", userid);
        jobj.put("comment", comment);
        jobj.put("time", time);
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.commentid;
    }
}
