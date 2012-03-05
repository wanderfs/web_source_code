/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.datatype;

import java.util.Date;
import net.sf.json.JSONObject;
import utility.Constant;

/**
 *
 * @author xiaoxiao
 */
public class VisitEvent extends BaseEvent {

    long visiteventid;
    int hostid;
    int visitorid;
    Date time;

    public void setVisiteventid(long visiteventid) {
        this.visiteventid = visiteventid;
    }

    public int getHostid() {
        return hostid;
    }

    public void setHostid(int hostid) {
        this.hostid = hostid;
    }

    public int getVisitorid() {
        return visitorid;
    }

    public void setVisitorid(int visitorid) {
        this.visitorid = visitorid;
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
        return "VisitEvent: hostid = " + this.hostid + " , visitorid = " + this.visitorid + " , time = " + time +
                " , visiteventid = " + visiteventid  + "; eventid = " + getEventID();
    }
    @Override
    public String toJsonString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JSONObject toJsonObject() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getEventID() {
        long classid = Constant.EventIdSeqNum(this.getClass());
        long shifted = classid << (63 - Constant.mask_length);
        return shifted + this.visiteventid;
    }

}
