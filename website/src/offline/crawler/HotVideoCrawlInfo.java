/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package offline.crawler;

/**
 *
 * @author xuan
 */
public class HotVideoCrawlInfo {

    public enum type {

        NEW, TODAYHOT, WEEKHOT, MONTHHOT, HOT
    };
    public String url;
    public String source; // e.g. renren.com
    public double scoreAtSrc;
    public type videoType;
    public String description;

    HotVideoCrawlInfo(String url, String source, double scoreAtSrc, type videoType, String description) {
        this.url = url;
        this.source = source;
        this.scoreAtSrc = scoreAtSrc;
        this.videoType = videoType;
        this.description = description;
    }

    @Override
    public String toString() {
        return "HotVideoCrawlInfo: url = " + url + ", source = " + source + ", scoreAtSrc = " + scoreAtSrc + ", videoType = " + videoType + ", description = " + description;
    }
}
