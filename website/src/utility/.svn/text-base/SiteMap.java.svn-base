/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import java.util.List;
import logic.IVideo;

/**
 *
 * @author xuan
 */
public class SiteMap {
    public static String GenerateSiteMap() {
        List<IVideo> videos = database.StatementFactory.getQuery().getVideo("1", "1", 100);
        StringBuilder sb = new StringBuilder();
        for (IVideo video : videos) {
            sb.append("http://iweishi.cn/website/video.jsp?vid=").append(video.getVideoid()).append("\n");
        }
        return sb.toString();
    }
}
