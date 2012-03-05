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
 * @author xuan
 */
public class CommentEvent extends BaseEvent {
    public enum HOST_TYPE {USER, EVENT};
    long commentid;
    long parentCommentid;
    int userid;
    long hostid;
    String comment = "";
    Date time;
    HOST_TYPE type;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    public long getHostid() {
        return hostid;
    }

    public void setHostid(long eventid) {
        this.hostid = eventid;
    }

    public HOST_TYPE getType() {
        return type;
    }

    public void setType(HOST_TYPE type) {
        this.type = type;
    }

    public long getParentCommentid() {
        return parentCommentid;
    }

    public void setParentCommentid(long parentCommentid) {
        this.parentCommentid = parentCommentid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String toString() {
        return this.getClass().getName() + ": commentid = " + this.getCommentid() + ", userid = " + this.getUserid() + ", parentcommentid = " +
                this.getParentCommentid() + ", eventid = " + this.getHostid() + ", comment = " + this.getComment() + ", time = " + this.time;
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
        return shifted + this.commentid;
    }
}
