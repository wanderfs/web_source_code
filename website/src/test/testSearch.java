/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import utility.Searcher;
import java.util.ArrayList;
import logic.IVideo;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class testSearch {
    public static void testIweishiSearch() {
        Searcher searcher = new Searcher();
        ArrayList<String> urls = searcher.searchByKeyword("yale");
        for (String url : urls) {
            System.out.println(url);
        }
        ArrayList<IVideo> vurls = searcher.iweishiSearch("yale");
        Iterator<IVideo> it = vurls.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getTitle());
        }
    }
}
