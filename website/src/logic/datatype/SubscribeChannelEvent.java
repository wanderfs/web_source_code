/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.datatype;

import java.util.Date;
import logic.IEvent;
import net.sf.json.JSONObject;
import utility.Constant;

/**
 *
 * @author xuan
 */
public class SubscribeChannelEvent extends BaseEvent {

    int channelid;
    int userid;
    Date time;
    long subscribeid;

    public void setSubscribeid(long subscribeid) {
        this.subscribeid = subscribeid;
    }
    
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
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
        return this.getClass().getSimpleName() + ": " + "channelid = " + channelid +
                "; userid = " + userid + "; time = " + time  + "; eventid = " + getEventID();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "UserChannelSubscriberRelation");
        jobj.put("uid", userid);
        jobj.put("cid", channelid);
        jobj.put("time", time);
        return jobj;
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.subscribeid;
    }
}
