package logic.datatype;

import java.sql.Time;
import java.util.Date;

import logic.IEvent;
import net.sf.json.JSONObject;
import utility.Constant;

public class WatchEvent extends BaseEvent {

    int userid;
    int videoid;
    Date time;
    long watchid;

    public void setWatchid(long watchid) {
        this.watchid = watchid;
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
        return "WatchEvent: " + "userid = " + userid
                + "; videoid = " + videoid + "; time = " + time  + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "WatchEvent");
        jobj.put("videoid", videoid);
        jobj.put("userid", userid);
        jobj.put("time", time);
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.watchid;
    }
}
