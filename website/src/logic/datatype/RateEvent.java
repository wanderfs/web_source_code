package logic.datatype;

import java.sql.Time;
import java.util.Date;

import logic.IEvent;
import net.sf.json.JSONObject;
import utility.Constant;

/**
 * 
 * @author xuan
 *
 */
public class RateEvent extends BaseEvent {

    int userid;
    int videoid;
    Date time;
    double score;
    long rateid;
    String comment = "";

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRateid(long rateid) {
        this.rateid = rateid;
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

    public Date getTime() {
        return time;
    }

    /**
     * time can be null when write into database
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "RateEvent: " + "userid = " + userid
                + "; videoid = " + videoid + "; time = " + time
                + "; score = " + score + "; comment = " + comment  + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "RateEvent");
        jobj.put("uid", userid);
        jobj.put("vid", videoid);
        jobj.put("time", time);
        jobj.put("score", score);
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.rateid;
    }
}
