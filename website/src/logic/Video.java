package logic;

import database.StatementFactory;
import java.util.ArrayList;
import java.util.Date;
import logic.datatype.*;
import java.util.List;
import net.sf.json.JSONObject;
import servlet.WebpageLayoutParam;
import utility.Constant;
import utility.Misc;

public class Video implements IVideo {

    public final static String VIDEO_ID = "videoid";
    int videoid;
    String siteSpecificID;
    String residentSite;
    String title;
    String snapshotURL;
    String summary = "";
    int firstSubmitUserid;
    Date time;
    String refHtml;

    public String getRefHtml() {
        return refHtml;
    }

    public void setRefHtml(String refHtml) {
        this.refHtml = refHtml;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "videoid: " + videoid + ";siteSpecificID: " + siteSpecificID + ";residentSite " + residentSite
                + ";title " + title + ";snapshotURL: " + snapshotURL + ";summary: " + summary
                + "; firstSubmitUserid: " + firstSubmitUserid + "; EmbededUrl: " + this.getEmbededUrl() + "; time: " + time;
    }

    public Video() {
    }

    public Video(int videoid) {
        this.videoid = videoid;
    }

    @Override
    public int getVideoid() {
        return videoid;
    }

    @Override
    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    @Override
    public String getSiteSpecificID() {
        return siteSpecificID;
    }

    @Override
    public void setSiteSpecificID(String siteSpecificID) {
        this.siteSpecificID = siteSpecificID;
    }

    @Override
    public String getResidentSite() {
        return residentSite;
    }

    @Override
    public void setResidentSite(String residentSite) {
        this.residentSite = residentSite;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSnapshotURL() {
        return snapshotURL;
    }

    @Override
    public void setSnapshotURL(String snapshotURL) {
        this.snapshotURL = snapshotURL;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public int getFirstSubmitUserid() {
        return firstSubmitUserid;
    }

    public void setFirstSubmitUserid(int id) {
        firstSubmitUserid = id;
    }

    @Override
    public double getScore() {
        return StatementFactory.getQuery().getRateScoreAverage(VIDEO_ID, videoid);
    }

    @Override
    public List<WatchEvent> getWatch(int limit) {
        return StatementFactory.getQuery().getWatch(VIDEO_ID, this.videoid, limit);
    }

    @Override
    public List<RateEvent> getRate(int limit) {
        return StatementFactory.getQuery().getRate(VIDEO_ID, this.videoid, limit);
    }

    @Override
    public List<SubmitEvent> getSubmit(int limit) {
        return StatementFactory.getQuery().getSubmit(VIDEO_ID, this.videoid, limit);
    }

    @Override
    public List<VideoCommentEvent> getComment(int limit) {
        return StatementFactory.getQuery().getVideoComment(VIDEO_ID, this.videoid, limit);
    }

    @Override
    public List<VideoRelation> getRelatedVideo(int limit) {
        IUser submitter = EntityFactory.getUser(getFirstSubmitUserid());
        List<VideoRelation> vrl = new ArrayList<VideoRelation>();
        List<SubmitEvent> sl = null;
        List<CollectEvent> cl = null;
        List<WatchEvent> wl = null;

        int sn = submitter.getSubmitedVideoNumber();
        sl = submitter.getSubmitedVideo(0, Math.min(sn, limit));
        limit -= sn;
        for (SubmitEvent se : sl) {
            vrl.add(new VideoRelation(videoid, se.getVideoid()));
        }

        if (limit > 0) {
            int cn = submitter.getCollectedVideoNumber();
            cl = submitter.getCollectedVideo(0, Math.min(cn, limit));
            limit -= cn;
            for (CollectEvent ce : cl) {
                vrl.add(new VideoRelation(videoid, ce.getVideoid()));
            }
        }

        if (limit > 0) {
            int wn = submitter.getWatchedVideoNumber();
            wl = submitter.getWatchedVideo(0, Math.min(wn, limit));
            limit -= wn;
            for (WatchEvent we : wl) {
                vrl.add(new VideoRelation(videoid, we.getVideoid()));
            }
        }

        return vrl;
    }

    @Override
    public List<PostEvent> getPost(int limit) {
        return StatementFactory.getQuery().getPost(VIDEO_ID, this.videoid, limit);
    }

    @Override
    public int getWatchUserCount() {
        return StatementFactory.getQuery().getWatchCount(VIDEO_ID, videoid);
    }

    @Override
    public int getShareCount() {
        return StatementFactory.getQuery().getShareCount("contentid", videoid);
    }

    @Override
    public int getRateUserCount() {
        return StatementFactory.getQuery().getRateCount(VIDEO_ID, videoid);
    }

    @Override
    public int getSubmitUserCount() {
        return StatementFactory.getQuery().getSubmitCount(VIDEO_ID, videoid);
    }

    @Override
    public int commit() {
        return StatementFactory.getModify().updateVideo(Video.VIDEO_ID, this.getVideoid(), this);
    }

    @Override
    public String getEmbededUrl(int width, int height) {
        String site = this.getResidentSite();
        String url = null;
        if (site.equals(Constant.YOUKU_SITE)) {
            //url = "<embed src=\"http://player.youku.com/player.php/sid/" + this.getSiteSpecificID() +  "XMTYyOTgyMjky/v.swf\" flashvars=\"isAutoPlay=true\" quality=\"high\" width=\"560\" height=\"467\" align=\"middle\" allowScriptAccess=\"sameDomain\" type=\"application/x-shockwave-flash\"></embed>";
            url = "<embed wmode=\"transparent\" src=\"http://player.youku.com/player.php/sid/" + this.getSiteSpecificID() + "/v.swf\" flashvars=\"isShowRelatedVideo=false&amp;isAutoPlay=true&amp;winType=interior&amp;\" type=\"application/x-shockwave-flash\" quality=\"high\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
        } else if (site.equals(Constant.TUDOU_SITE)) {
            // url = "<embed src=\"http://www.tudou.com/player/outside/player_outside.swf?iid=" + this.getSiteSpecificID() + "&default_skin=http://js.tudouui.com/bin/player2/outside/Skin_outside_42.swf&autostart=true&autoPlay=true&rurl=\" quality=\"high\" width=\"560\" height=\"467\" align=\"middle\" allowScriptAccess=\"sameDomain\" type=\"application/x-shockwave-flash\"></embed>";
            // url = "<embed src=\"http://www.tudou.com/player/outside/player_outside.swf?iid=" + this.getSiteSpecificID() + "&amp;default_skin=http://js.tudouui.com/bin/player2/outside/Skin_outside_43.swf&amp;autoPlay=true&amp;rurl=&amp;withLogo=false&amp;withRecommendList=false&amp;\" quality=\"high\" type=\"application/x-shockwave-flash\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
            url = "<embed wmode=\"transparent\" src=\"http://www.tudou.com/v/" + this.getSiteSpecificID() + "\" flashvars=\"autoPlay=true&amp;rurl=&amp;withLogo=false&amp;withRecommendList=false&amp;\" type=\"application/x-shockwave-flash\" quality=\"high\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
        } else if (site.equals(Constant.BUGU_CNTV)) {
            url = this.refHtml;
        } else if (site.equals(Constant.JINGJI_CNTV)) {
            url = this.refHtml;
        } else if (site.equals(Constant.NEWS_CNTV)) {
            url = this.refHtml;
        } else if (site.equals(Constant.SPORTS_CNTV)) {
            url = this.refHtml;
        } else if (site.equals(Constant.NORM_CNTV)) {
            url = this.refHtml;
        } else if (site.equals(Constant.KU6_SITE)) {
            url = "<embed wmode=\"transparent\" src=\"" + this.refHtml + "&auto=1" /* refswf */ + "\"   flashvars=\"isShowRelatedVideo=false&amp;winType=interior&amp;\" type=\"application/x-shockwave-flash\" quality=\"high\" allowScriptAccess=\"sameDomain\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
        } else if (site.equals(Constant._6_SITE)) {
            url = "<embed wmode=\"transparent\" src=\"" + this.refHtml + "&flag=1" /* refswf */ + "\" flashvars=\"isShowRelatedVideo=false&amp;winType=interior&amp;\" type=\"application/x-shockwave-flash\" quality=\"high\" allowScriptAccess=\"sameDomain\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
        } else if (site.equals(Constant._56_SITE)) {
            url = "<embed wmode=\"transparent\" src=\"" + this.refHtml + "?autoplay=1" /* refswf */ + "\" flashvars=\"autoPlay=true\" type=\"application/x-shockwave-flash\" quality=\"high\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
        } else if (site.equals(Constant.SINA_SITE)) {
            url = "<embed wmode=\"transparent\" src=\"" + this.refHtml + "?autoplay=1" /* refswf */ + "\" flashvars=\"autoPlay=true\" type=\"application/x-shockwave-flash\" quality=\"high\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
        } else {
            url = "<embed wmode=\"transparent\" src=\"" + this.refHtml/* refswf */ + "\" flashvars=\"isAutoPlay=true\" type=\"application/x-shockwave-flash\" quality=\"high\" allowfullscreen=\"true\" align=\"middle\" height=\"467\" width=\"560\"></embed>";
        }
        /*
        if(url.contains("width=\"")) { //youku, tudou case
        url = url.replaceFirst("width=[\"|']?[0-9]+\"", "width=\"" + WebpageLayoutParam.SCREEN_WIDTH +"\"");
        url = url.replaceFirst("height=\"[0-9]+\"", "height=\"" + WebpageLayoutParam.SCREEN_HEIGHT + "\"");
        } else if(url.contains("width='")) { //cntv case
        url = url.replaceFirst("width='[0-9]+'", "width='" + WebpageLayoutParam.SCREEN_WIDTH +"'");
        url = url.replaceFirst("height='[0-9]+'", "height='" + WebpageLayoutParam.SCREEN_HEIGHT + "'");
         */
        url = url.replaceFirst("width=[\"|']?[0-9]+[\"|']?", "width='" + width + "'");
        url = url.replaceFirst("height=[\"|']?[0-9]+[\"|']?", "height='" + height + "'");
        return url;
    }

    @Override
    public String getEmbededUrl() {
        return getEmbededUrl(WebpageLayoutParam.SCREEN_WIDTH, WebpageLayoutParam.SCREEN_HEIGHT);
    }

    // TODO:
    @Override
    public int getCommentCount() {
        return StatementFactory.getQuery().getVideoCommentCount(Video.VIDEO_ID, this.videoid);
    }

    @Override
    public int getRelatedVideoCount() {
        return 20;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getPostCount() {
        return StatementFactory.getQuery().getPostCount(VIDEO_ID, videoid);
    }

    @Override
    public List<CollectEvent> getCollect(int limit) {
        return StatementFactory.getQuery().getCollect(Video.VIDEO_ID, this.videoid, limit);
    }

    @Override
    public int getCollectUserCount() {
        return StatementFactory.getQuery().getCollectCount(Video.VIDEO_ID, this.videoid);
    }

    @Override
    public List<ShareEvent> getRecentShare(int topnum) {
        return database.StatementFactory.getQuery().getShare("contentid", videoid, topnum, logic.datatype.ShareEvent.CONTENT_TYPE.VIDEO);
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject jobj = new JSONObject();
        jobj.put("class-name", "Video");
        jobj.put("vid", videoid);
        jobj.put("title", title);
        jobj.put("summary", summary);
        jobj.put("thumbnail", snapshotURL);
        jobj.put("submitter", firstSubmitUserid);
        jobj.put("embed", getEmbededUrl(WebpageLayoutParam.WIDTH_EMBEDEDURL, WebpageLayoutParam.HEIGHT_EMBEDEDURL));
        jobj.put("time", time.toString());
        jobj.put("ago", Misc.pastTime(time));
        // entries that might slow down
        jobj.put("submitter-name", EntityFactory.getUser(firstSubmitUserid).getName());
        jobj.put("watch-count", getWatchUserCount());
        jobj.put("share-count", getShareCount());
        jobj.put("comment-count", getCommentCount());
        if (jobj.getInt("comment-count") > 0) {
            VideoCommentEvent e = getComment(1).get(0);
            jobj.put("first-comment", e.getComment());
            jobj.put("first-commentator", e.getUserid());
        }
        return jobj;
    }

    @Override
    public String toJSONString() {
        return toJSONObject().toString();
    }
}
