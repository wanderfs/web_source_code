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
 * @author Sen
 */
public class ShareEvent extends BaseEvent {

    private long shareeventid;
    private int userid;
    private long contentid;
    private Date time;
    private String comment = "";
    private String sns_id;
    public enum CONTENT_TYPE {VIDEO, ALBUM, EVENT};
    private CONTENT_TYPE content_type;

    public long getContentid() {
        return contentid;
    }

    public void setContentid(long contentid) {
        this.contentid = contentid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userintd) {
        this.userid = userintd;
    }
    public void setShareeventid(long shareeventid) {
        this.shareeventid = shareeventid;
    }
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the sns_id
     */
    public String getSns_id() {
        return sns_id;
    }

    /**
     * @param sns_id the sns_id to set
     */
    public void setSns_id(String sns_id) {
        this.sns_id = sns_id;
    }

    /**
     * @return the content_type
     */
    public CONTENT_TYPE getContent_type() {
        return content_type;
    }

    /**
     * @param content_type the content_type to set
     */
    public void setContent_type(CONTENT_TYPE content_type) {
        this.content_type = content_type;
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
        return "ShareEvent: userid = " + userid + " , contentid = " + contentid + " , contenttype = " + content_type
                + " , snsid = " + sns_id + " , time = " + time + " , shareeventid = " + shareeventid  + ", eventid = " + getEventID();
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
        return shifted + this.shareeventid;
   }

}
