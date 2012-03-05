/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.datatype;

import java.sql.Time;
import java.util.Date;
import logic.IEvent;
import net.sf.json.JSONObject;
import utility.Constant;

/**
 *
 * @author xiaoxiao
 */
public class UserRelationEvent extends BaseEvent {
    int followeeid;
    int followerid;
    Date time;
    long userrelationid;

    public void setUserrelationid(long userrelationid) {
        this.userrelationid = userrelationid;
    }

    public int getFolloweeid() {
        return followeeid;
    }

    public void setFolloweeid(int followeeid) {
        this.followeeid = followeeid;
    }

    public int getFollowerid() {
        return followerid;
    }

    public void setFollowerid(int followerid) {
        this.followerid = followerid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserRelation: followeeid" + followeeid + "; followerid " + followerid + "; time " + time  + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "UserRelation");
        jobj.put("followeeid", followeeid);
        jobj.put("followerid", followerid);
        jobj.put("time", time);
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.userrelationid;
    }    
}