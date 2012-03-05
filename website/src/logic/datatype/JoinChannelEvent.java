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
 * @author xuan
 */
public class JoinChannelEvent extends BaseEvent {
    int userid;
    int channelid;
    double score;
    Date time;
    long joinchannelid;

    public void setJoinchannelid(long joinchannelid) {
        this.joinchannelid = joinchannelid;
    }

    public int getGroupid() {
        return channelid;
    }

    public void setGroupid(int groupid) {
        this.channelid = groupid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
        return this.getClass().getSimpleName() + ": " + userid + "; groupid " + channelid + "; score " + score + "; time " + time + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "UserChannelMemberRelation");
        jobj.put("uid", userid);
        jobj.put("cid", channelid);
        jobj.put("time", time);
        jobj.put("score", score);
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.joinchannelid;
    }
}
