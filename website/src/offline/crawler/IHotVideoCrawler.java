/*
 * 
 */

package offline.crawler;

import java.util.ArrayList;

/**
 * classes in this package is for offline only. Don't use it in front end.
 * @author xiaoxiao
 */
public interface IHotVideoCrawler {
    /**
     * To test the "useful", crawler may use GenericVideoParser to see if it can parse it.
     * @return useful links.
     */
    public ArrayList<HotVideoCrawlInfo> crawlVideos();
    public ArrayList<HotVideoCrawlInfo> crawlNewVideos();
    public ArrayList<HotVideoCrawlInfo> crawlHotVideos();
}
