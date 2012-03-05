/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.parse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.IVideo;
import logic.Video;
import net.sf.json.JSONObject;
import utility.Constant;
import utility.SimpleHttpClient;

/**
 *
 * @author xuan
 */
public class CNTVVideoParser implements IVideoParser {

    static String xiyouidentifier = "http://xiyou.cntv.cn/video/";

    @Override
    public IVideo parse(String refer) {
        IVideo v = null;
        if (refer.contains("cntv.cn")) {
            // some link are actually outside cntv.cn domain
            // e.g. http://space.tv.cctv.com/video/VIDE1252299930359889

            if (refer.contains("xiyou.cntv.cn")) {
                v = parseXiYou(refer);
            } else if (refer.contains("news.cntv.cn")
                    || refer.contains("sports.cntv.cn")
                    || refer.contains("worldcup.cntv.cn")
                    || refer.contains("jingji.cntv.cn")) {
                v = parseSpecialCNTV(refer);
                test.Test.println(refer + " " + v);
            } else {  // other
                v = parseNormalCNTV(refer);
            }
        }
        return v;
    }

    /*{"upCount":33,
     * "downCount":18,
     * "refHtml":"<embed src=\"http:\/\/xiyou.cntv.cn\/player\/OTvideoplayer.swf?type=video&VideoId=9f1f9e4a-2c2d-11df-be82-001e0bbb2454\" quality=\"high\" width=\"640\" height=\"390\" align=\"middle\" allowScriptAccess=\"always\" allowFullScreen=\"true\" mode=\"transparent\" type=\"application\/x-shockwave-flash\"><\/embed>",
     * "refFlash":"http:\/\/xiyou.cntv.cn\/player\/OTvideoplayer.swf?type=video&VideoId=9f1f9e4a-2c2d-11df-be82-001e0bbb2454",
     * "isRated":false,
     * "isDigged":false,
     * "digOper":null,
     * "title":"\u6700\u7f8e\u552e\u697c\u5c0f\u59d0\u7f57\u5a1f\u601d\u5ff5\u5bb6\u4eba\u6084\u7136\u6cea\u4e0b",
     * "userName":"luojuanshoulou",
     * "playCount":9084,
     * "commentCount":"19",
     * "timeSpan":"111",
     * "rateCount":4,
     * "rate":4.25,
     * "imagePath":"http:\/\/thumb3.iseeyoo.cn\/\/thumb\/2010\/03\/10\/9f1f9e4a-2c2d-11df-be82-001e0bbb2454-thumb.jpg",
     * "relation":"public",
     * "hasPriority":true,
     * "isCCTV":false,
     * "wrating_code":"860010-1208030100",
     * "userIP":"121.14.55.132"}
     */
    protected IVideo parseXiYou(String refer) {
        IVideo result = null;
        SimpleHttpClient client = null;
        try {
            IVideo v = new logic.Video();
            int index = refer.indexOf(xiyouidentifier);
            String siteID = refer.substring(index + xiyouidentifier.length()).trim();
            v.setResidentSite(Constant.XIYOU_CNTV);
            v.setSiteSpecificID(siteID);
            client = new SimpleHttpClient();
            String s = client.get("http://xiyou.cntv.cn/rpc.php?module=FlashVideoInitLoad&item_type=video&item_id=" + siteID);
            s = s.replaceAll("<!--remian-->", "");
            JSONObject json = JSONObject.fromObject(s);
            v.setTitle(json.getString("title"));
            v.setSnapshotURL(json.getString("imagePath"));
            if (v instanceof Video) {
                ((Video)v).setRefHtml(json.getString("refHtml"));
            }
            result = v;
        } catch (net.sf.json.JSONException ex) {
            Logger.getLogger(CNTVVideoParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /** example refer:
      * http://jingji.cntv.cn/20100314/101975.shtml
      * Json URL:
      * http://jingji.cntv.cn/flvxml/2009/03/14/20100314/101975.txt
      * examle JSON:
      * {"videoid":"20100314101975",
      * "duration":"0",
     * "isLive":"false",
     * "title":"æ–°é—»30åˆ† æ¸©å®¶å®ä¼šè§ä¸­å¤–è®°è€…å¹¶ç­”è®°è€…æé—®",
     * "imagePath":"http://p5.img.cctvpic.com/image/2009/qgds/2010/03/14/qgds_h264418000nero_aac32_20100314_1268543084569_2.jpg",
     * "isRtmp":"false",
     * "ack":"yes",
     * "relation":"public",
     * "refHtml":"<embed id='v_player_cctv' width='960' height='540' flashvars='videoId=20100314101975&isLogin=y&userId=001&articleId=VIDE0020100314101975&scheduleId=C2581500000241&filePath=/flvxml/2009/03/14/&configPath=http://jingji.cntv.cn/player/config.xml' allowscriptaccess='always' allowfullscreen='true' menu='false' quality='best' bgcolor='#000000' name='v_player_cctv' src='http://jingji.cntv.cn/player/OutSidePlayer.swf' type='application/x-shockwave-flash' lk_mediaid='lk_juiceapp_mediaPopup_1257416656250' lk_media='yes'/>",
     * "refURL":"http://jingji.cntv.cn/20100314/101975.shtml",
     * "chapters":[
     * {"url":"http://v.cctv.com/flash/mp4video3/qgds/2010/03/14/qgds_h264418000nero_aac32_20100314_1268543084569-1.mp4","duration":"300"},{"url":"http://v.cctv.com/flash/mp4video3/qgds/2010/03/14/qgds_h264418000nero_aac32_20100314_1268543084569-2.mp4","duration":"300"},{"url":"http://v.cctv.com/flash/mp4video3/qgds/2010/03/14/qgds_h264418000nero_aac32_20100314_1268543084569-3.mp4","duration":"22"}
     * ]
     * }<!--remian-->
     */
    protected IVideo parseSpecialCNTV(String refer) {  // news, sports, jingji
        IVideo result = null;
        try {
            IVideo v = new logic.Video();
            String site = null;
            String siteidentifier = null;
            if (refer.contains("jingji.cntv.cn")) {
                site = Constant.JINGJI_CNTV;
                siteidentifier = "jingji.cntv.cn";
            } else if (refer.contains("sports.cntv.cn")) {
                site = Constant.SPORTS_CNTV;
                siteidentifier = "sports.cntv.cn";
            } else if (refer.contains("news.cntv.cn")) {
                site = Constant.NEWS_CNTV;
                siteidentifier = "news.cntv.cn";
            } else if (refer.contains("worldcup.cntv.cn")) {
                site = Constant.SPORTS_CNTV;
                siteidentifier = "worldcup.cntv.cn";
            } else {
                return null;
            }
            int index = refer.indexOf(siteidentifier);
            int stopindex = refer.indexOf(".shtml");
            if (stopindex < 0)
                return null;
            String idstring = refer.substring(index + siteidentifier.length(), stopindex).replaceAll("\\D", "");
            String[] filepath = null;
            if (idstring.length() < 8) {
                return null;
            } else {
                filepath = new String[2];
                String postfix = idstring.substring(4,6) + "/" + idstring.substring(6,8) + "/";
                filepath[0] = "/flvxml/2009/" + postfix ;
                filepath[1] = "/flvxml/" + idstring.substring(0, 4) + "/" + postfix;
            }

            JSONObject json = this.getJSONFromEitherurl(
                    new String[]{
                    "http://" + siteidentifier + filepath[0] + idstring.substring(0,8) + "/" + idstring.substring(8) + ".txt",
                    "http://" + siteidentifier + filepath[1] + idstring.substring(0,8) + "/" + idstring.substring(8) + ".txt"});
            v.setResidentSite(site);
            v.setSiteSpecificID(idstring);
            v.setTitle(json.getString("title"));
            v.setSnapshotURL(json.getString("imagePath"));
            if (v instanceof Video) {
                ((Video)v).setRefHtml(json.getString("refHtml"));
            }
            result = v;
        } catch (net.sf.json.JSONException ex) {
            Logger.getLogger(CNTVVideoParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * example url
     * http://ent.cntv.cn/enttv/kaixincidian/classpage/video/20100310/100589.shtml
     * example json url
     * http://ent.cntv.cn/enttv/kaixincidian/classpage/video/20100310/100589.txt
     * json:
     * {
     * "videoid":"20100310100589",
     * "duration":"57:54",
     * "isLive":"false",
     * "title":"å¼€å¿ƒè¾žå…¸ï¼šå®¶åº­æ¢¦æƒ³ æ¸¸æˆç«žçŒœ",
     * "imagePath":"http://p2.img.cctvpic.com/image/2009/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854_2.jpg",
     * "isRtmp":"false",
     * "ack":"yes",
     * "relation":"public",
     * "refHtml":"<embed id='v_player_cctv' width='960' height='540' flashvars='videoId=20100310100589&isLogin=y&userId=001&articleId=VIDE0020100310100589&scheduleId=C12282000001&filePath=/enttv/kaixincidian/classpage/video/&sorts=å…¶ä»–,çŽ‹å°ä¸«,,ç»¼è‰º,C12282000001&url=http://ent.cntv.cn/enttv/kaixincidian/classpage/video/20100310/100589.shtml&configPath=http://ent.cntv.cn/nettv/Library/enttv/player/config.xml&widgetsConfig=http://ent.cntv.cn/nettv/Library/enttv/player/widgetsConfig.xml&languageConfig=http://ent.cntv.cn/nettv/Library/enttv/player/zh_cn.xml&sysSource=zongyi' allowscriptaccess='always' allowfullscreen='true' menu='false' quality='best' bgcolor='#000000' name='v_player_cctv' src='http://ent.cntv.cn/nettv/Library/tongyong/player/OutSidePlayer.swf' type='application/x-shockwave-flash' lk_mediaid='lk_juiceapp_mediaPopup_1257416656250' lk_media='yes'/>",
     * "refURL":"http://ent.cntv.cn/enttv/kaixincidian/classpage/video/20100310/100589.shtml",
     * "chapters":[
     * {"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-1.mp4","duration":"294"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-2.mp4","duration":"292"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-3.mp4","duration":"298"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-4.mp4","duration":"298"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-5.mp4","duration":"296"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-6.mp4","duration":"298"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-7.mp4","duration":"291"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-8.mp4","duration":"294"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-9.mp4","duration":"297"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-10.mp4","duration":"297"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-11.mp4","duration":"292"},{"url":"http://v.cctv.com/flash/mp4video3/kaixincidian/2010/03/09/kaixincidian_h264418000nero_aac32_20100309_1268147925854-12.mp4","duration":"227"}
     * ]
     * }<!--remian-->
     * @param refer
     * @return
     */
    protected IVideo parseNormalCNTV(String refer) {
        IVideo result = null;
        try {
            IVideo v = new logic.Video();
            String jsonurl = refer.replaceAll(".shtml", ".txt");
            SimpleHttpClient client = new SimpleHttpClient();
            String s = client.get(jsonurl);
            s = s.replaceAll("<!--remian-->", "");
            JSONObject json = JSONObject.fromObject(s);
            v.setResidentSite(Constant.NORM_CNTV);
            v.setSiteSpecificID(json.getString("videoid"));
            v.setTitle(json.getString("title"));
            v.setSnapshotURL(json.getString("imagePath"));
            if (v instanceof Video) {
                ((Video)v).setRefHtml(json.getString("refHtml"));
            }
            result = v;
        } catch (net.sf.json.JSONException ex) {
            Logger.getLogger(CNTVVideoParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    protected JSONObject getJSONFromEitherurl(String[] urls) throws net.sf.json.JSONException {
        SimpleHttpClient client = new SimpleHttpClient();
        JSONObject json = null;
        for (int i = 0; i != urls.length; ++i) {
            try {
                String s = client.get(urls[i]);
                s = s.replaceAll("<!--remian-->", "");
                json = JSONObject.fromObject(s);
                return json;
            } catch (net.sf.json.JSONException ex) {
               if (i == urls.length -1)
                   throw ex;
            }
        }
        return json;
    }
}
