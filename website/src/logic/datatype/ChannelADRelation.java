/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.datatype;

import java.util.Date;
/**
 *
 * @author xuan
 */
public class ChannelADRelation {
    int channelid;
    int adid;
    Date time;
    int id;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
    }

    @Override
    public String toString() {
        return "ChannelADRelation: channelid = " + channelid + ", adid = " + adid + ", time = " + time;
    }
}
