package logic;

import java.util.Date;
import java.util.List;
import logic.datatype.CommentEvent;
import net.sf.json.JSONObject;

/**
 * Currently IEvent includes:
 *
 * User-Video Relation:
 * 1. Post a video to a group   (in PostEvent)
 * 2. Rate a video              (in RateEvent)
 * 3. Submit a video            (in SubmitEvent)
 * 4. Comment a video           (in VideoComment)
 *
 * Use-Group Relation:
 * 4. Join Group                (in UserGroupRelation)
 *
 * User-User Relation:
 * 5. Follow another user       (in UserRelation)
 *
 * @author xuan
 */

public interface IEvent {

    public Date getTime();

    public void setTime(Date time);

    public String toJsonString();

    public JSONObject toJsonObject();

    public long getEventID();

    public List<CommentEvent> getEventComments(int from, int topnum);

    public int getEventCommentNum();
}
