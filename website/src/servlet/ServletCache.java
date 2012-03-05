/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import com.google.common.collect.MapMaker;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import logic.IEvent;

/**
 *
 * @author Sen
 */
public class ServletCache {

    private static ConcurrentMap<Integer, List<IEvent>> feed_cache = new MapMaker()
            .weakValues().makeMap();

    public static void addFeed(int uid, IEvent event) {
        List<IEvent> val = feed_cache.putIfAbsent(uid, new ArrayList<IEvent>());
        val.add(event);
    }
    
    public static List<IEvent> getFeeds(int uid) {
        // clear cached events
        return feed_cache.remove(uid);
    }
}
