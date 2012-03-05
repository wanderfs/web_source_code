package logic;

import java.util.*;

import logic.datatype.*;
import net.sf.json.JSONObject;

public interface IVideo {
    /*=================================
     * Property Section
     *=================================*/

    public int getVideoid();

    public void setVideoid(int videoid);

    public String getSiteSpecificID();

    public void setSiteSpecificID(String siteSpecificID);

    public String getResidentSite();

    public void setResidentSite(String residentSite);

    public String getTitle();

    public void setTitle(String title);

    public void setFirstSubmitUserid(int id);

    public String getSnapshotURL();

    public void setSnapshotURL(String snapshotURL);

    public String getSummary();

    public void setSummary(String summary);

    public double getScore();

    public int getFirstSubmitUserid();

    public Date getTime();

    public void setTime(Date time);

    public String getEmbededUrl();

    public String getEmbededUrl(int width, int height);

    public int commit();

    /**
     * 
     * @param limit
     * @return
     */
    public List<WatchEvent> getWatch(int limit);

    /**
     * 
     * @return
     * if error, return value < 0
     */
    public int getWatchUserCount();

    public List<RateEvent> getRate(int limit);

    public int getRateUserCount();

    public List<SubmitEvent> getSubmit(int limit);

    public int getSubmitUserCount();

    public List<CollectEvent> getCollect(int limit);

    public int getCollectUserCount();

    public List<ShareEvent> getRecentShare(int topnum);
    public int getShareCount();

    /**
     * Pair<Integer, String> = userid, comments
     * @return
     */
    public List<VideoCommentEvent> getComment(int limit);

    public int getCommentCount();

    public List<VideoRelation> getRelatedVideo(int limit);

    public int getRelatedVideoCount();

    public List<PostEvent> getPost(int limit);

    public int getPostCount();

    /*==========================================
     * Network
     *==========================================*/
    public JSONObject toJSONObject();

    public String toJSONString();
}
