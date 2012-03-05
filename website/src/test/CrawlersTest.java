/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import offline.crawler.*;

/**
 *
 * @author jiawei
 * There're three crawlers, when you use whichone, delete the notation
 */
public class CrawlersTest {

    public static void main(String[] args) throws Exception {

        ArrayList<HotVideoCrawlInfo> al = new ArrayList<HotVideoCrawlInfo>();

        //al = GenericHotVideoCrawler.getGenericLinker().crawlVideos();

        QzoneHotVideoCrawler qhvc = new QzoneHotVideoCrawler();
        al = qhvc.crawlVideos();
        al = qhvc.crawlNewVideos();
        al = qhvc.crawlHotVideos();
        //  qhvc.init();al =  qhvc.parseNEWLinkList();
        //  qhvc.init();al = qhvc.parseTODAYHOTLinkList();
        //  qhvc.init();al = qhvc.parseWEEKHOTLinkList();
        //  qhvc.init(); al = qhvc.parseMONTHHOTLinkList();

        RenrenHotVideoCrawler rhvc = new RenrenHotVideoCrawler();
        al = rhvc.crawlVideos();
        al = rhvc.crawlHotVideos();
        //rhvc.init();al = rhvc.parseTODAYHOTLinkList();rhvc.destroy();
        //rhvc.init();al = rhvc.parseNEWLinkList();rhvc.destroy();

        //Kaixin001HotVideoCrawler khvc = new Kaixin001HotVideoCrawler();
        // al = khvc.crawlVideos();
        //al = khvc.crawlNewVideos();
        //al = khvc.crawlHotVideos();
        //al.addAll(khvc.crawlHotVideos());
        //   khvc.init();al = khvc.parseNEWLinkList();
        //    khvc.init();al = khvc.parseTODAYHOTLinkList();

        for (HotVideoCrawlInfo q : al) {
            System.out.println(q);
        }
        System.out.println(al.size());
    }
}
