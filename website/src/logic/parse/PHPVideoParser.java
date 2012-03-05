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
 * @author xiaoxiao
 */
public class PHPVideoParser implements IVideoParser {

    @Override
    public IVideo parse(String refer) {
        if (!refer.contains("youku.com") && !refer.contains("tudou.com") && !refer.contains("56.com")
                && !refer.contains("ku6.com") && !refer.contains("sina.com") && !refer.contains("6.cn")) {
            return null;
        }
        SimpleHttpClient client = new SimpleHttpClient();
        String jsonstring = client.get("http://iweishi.cn:10080/cnvideoapi/parse.php?url=" + refer);
        int index = jsonstring.indexOf("{");
        if (index < 0) {
            return null;
        }
        jsonstring = jsonstring.substring(index);

        Logger.getLogger(this.getClass().getSimpleName()).log(Level.INFO, "jsonstring: |" + jsonstring);
        if (jsonstring.startsWith("UNKNOWN")) {
            return null;
        } else {
            Video v = new Video();
            JSONObject json = JSONObject.fromObject(jsonstring);
            v.setSiteSpecificID(json.getString("id"));
            v.setSnapshotURL(json.getString("thumb"));
            v.setTitle(json.getString("title"));
            v.setSummary(json.getString("tags"));
            v.setRefHtml(json.getString("swf"));
            if (refer.contains("youku.com")) {
                v.setResidentSite(Constant.YOUKU_SITE);
                String largeSnapshot = v.getSnapshotURL();
                // change large snapshot to smaller one
                v.setSnapshotURL(largeSnapshot.replaceFirst("ykimg.com/1", "ykimg.com/0"));
            } else if (refer.contains("tudou.com")) {
                v.setResidentSite(Constant.TUDOU_SITE);
            } else if (refer.contains("6.cn")) {
                v.setResidentSite(Constant._6_SITE);
            } else if (refer.contains("56.com")) {
                v.setResidentSite(Constant._56_SITE);
            } else if (refer.contains("sina.com")) {
                v.setResidentSite(Constant.SINA_SITE);
                String largeSnapshot = v.getSnapshotURL();
                v.setSnapshotURL(largeSnapshot.replaceFirst("_\\d\\.jpg", "_0.jpg"));
            } else if (refer.contains("ku6.com")) {
                v.setResidentSite(Constant.KU6_SITE);
            }
            return v;
        }
    }

}
