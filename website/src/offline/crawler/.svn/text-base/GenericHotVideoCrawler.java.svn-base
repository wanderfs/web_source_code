/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package offline.crawler;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuan
 */
public class GenericHotVideoCrawler implements IHotVideoCrawler {

    private static IHotVideoCrawler genericCrawler = null;
    protected ArrayList<IHotVideoCrawler> crawlers;
    public static IHotVideoCrawler getGenericLinker() {
        if (genericCrawler == null) {
            genericCrawler = new GenericHotVideoCrawler();
        }
        return genericCrawler;
    }

    /**
     * When you implement a new crawler, please add it here.
     */
    private GenericHotVideoCrawler() {
        crawlers = new ArrayList<IHotVideoCrawler>();
        crawlers.add(new QzoneHotVideoCrawler());
        crawlers.add(new RenrenHotVideoCrawler());
        crawlers.add(new Kaixin001HotVideoCrawler());
    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlVideos() {
        ArrayList<HotVideoCrawlInfo> results = new ArrayList<HotVideoCrawlInfo>();
        for (IHotVideoCrawler crawler : this.crawlers) {
            results.addAll(crawler.crawlVideos());
        }
        return results;
    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlHotVideos() {
        ArrayList<HotVideoCrawlInfo> results = new ArrayList<HotVideoCrawlInfo>();
        System.out.println("crawler number: " + this.crawlers.size());
        for (IHotVideoCrawler crawler : this.crawlers) {
            System.out.println(crawler.getClass().getCanonicalName());
            try {
                results.addAll(crawler.crawlHotVideos());
            } catch (Throwable o) {
                o.printStackTrace();
            }
        }
        return results;
    }

    @Override
    public ArrayList<HotVideoCrawlInfo> crawlNewVideos() {
        ArrayList<HotVideoCrawlInfo> results = new ArrayList<HotVideoCrawlInfo>();
        for (IHotVideoCrawler crawler : this.crawlers) {
            results.addAll(crawler.crawlNewVideos());
        }
        return results;
    }

}
