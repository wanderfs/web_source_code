/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import database.StatementFactory;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.datatype.*;
import logic.timer.IweishiTimer;
import offline.crawler.GenericHotVideoCrawler;
import offline.crawler.HotVideoCrawlInfo;
import utility.Constant;
import utility.Pair;
import utility.alg.RandomAlg;

/**
 *
 * @author xuan
 */
public class Global {
    protected static IweishiTimer timer = IweishiTimer.getSingletonTimer();
    protected static List<IVideo> hotVideoPool;
    protected static List<IVideo> newVideoPool;
    protected static ReentrantReadWriteLock hotVideoPoolLock = new ReentrantReadWriteLock();
    protected static ReentrantReadWriteLock newVideoPoolLock = new ReentrantReadWriteLock();
    protected static Vector<Pair<HotVideoCrawlInfo, IVideo>> renrenpool;  // concurrency
    protected static Vector<Pair<HotVideoCrawlInfo, IVideo>> kaixinpool;
    protected static Vector<Pair<HotVideoCrawlInfo, IVideo>> qqpool;

    public static void updateCollectSNS() {
        System.out.println("updateCollectSnS");
        if (renrenpool == null) {
            renrenpool = new Vector<Pair<HotVideoCrawlInfo, IVideo>>(30);
        }
        if (qqpool == null) {
            qqpool = new Vector<Pair<HotVideoCrawlInfo, IVideo>>(30);
        }
        if (kaixinpool == null) {
            kaixinpool = new Vector<Pair<HotVideoCrawlInfo, IVideo>>(30);
        }
        if (!renrenpool.isEmpty()) {
            System.out.println("updateCollectSnS renren");
            Pair<HotVideoCrawlInfo, IVideo> p = renrenpool.remove(0);
            IUser renren = EntityFactory.getUser(1598);
            renren.collectVideo(p.getValue().getVideoid(), "");
        }
        if (!qqpool.isEmpty()) {
            System.out.println("updateCollectSnS qq");
            Pair<HotVideoCrawlInfo, IVideo> p = qqpool.remove(0);
            IUser qq = EntityFactory.getUser(1600);
            qq.collectVideo(p.getValue().getVideoid(), "");
        }
        if (!kaixinpool.isEmpty()) {
            System.out.println("updateCollectSnS kaixin");
            Pair<HotVideoCrawlInfo, IVideo> p = kaixinpool.remove(0);
            IUser kaixin = EntityFactory.getUser(1599);
            kaixin.collectVideo(p.getValue().getVideoid(), "");
        }
    }
    
    public static void updateHotVideoPool() {
        Logger.getLogger(Global.class.toString()).log(Level.INFO, "updateHotVideoPool");
        ArrayList<HotVideoCrawlInfo> videos = GenericHotVideoCrawler.getGenericLinker().crawlHotVideos();
        ArrayList<IVideo> newHotVideoPool = new ArrayList<IVideo>();
        int validVideoNum = 0;
        System.out.println("updateHotVideoPool: videos.size() = " + videos.size());
        for (int i = 0; i != videos.size(); ++i) {
            int id = Constant.ARTIFICIAL_USER_ID_MIN + (int)((Constant.ARTIFICIAL_USER_ID_MAX - Constant.ARTIFICIAL_USER_ID_MIN) * Math.random());

            IUser user = EntityFactory.getUser(id);
            System.out.println("updatehotvideopool: " + videos.get(i));
            Pair<Integer, IVideo> result = EntityFactory.getVideo(videos.get(i).url);
            if (result.getKey() == Constant.SUBMIT_SUCCESS) {
                result.getValue().setSummary("");
                if (result.getValue().getTitle() != null && result.getValue().getSnapshotURL() != null ) {
                    user.submitVideo(result.getValue());
                    ++validVideoNum;
                }
            }
            if (result.getKey() != Constant.SUBMIT_URL_ERROR && result.getKey() != Constant.SUBMIT_UNKNOWN_ERROR) {
                if (videos.get(i).source.equals("renren.com")) {
                    if (renrenpool.size() > 30) {
                        continue;
                    }
                    renrenpool.add(new Pair<HotVideoCrawlInfo, IVideo>(videos.get(i), result.getValue()));
                    //renren.collectVideo(result.getValue().getVideoid(), "");
                } else if (videos.get(i).source.equals("qzone.qq.com")) {
                    if (qqpool.size() > 30) {
                        continue;
                    } 
                    qqpool.add(new Pair<HotVideoCrawlInfo, IVideo>(videos.get(i), result.getValue()));
                    //qq.collectVideo(result.getValue().getVideoid(), "");
                } else if (videos.get(i).source.equals("kaixin001.com")) {
                    if (kaixinpool.size() > 30) {
                        continue;
                    } 
                    kaixinpool.add(new Pair<HotVideoCrawlInfo, IVideo>(videos.get(i), result.getValue()));
                    //kaixin.collectVideo(result.getValue().getVideoid(), "");
                }
            }
        }
        Logger.getLogger(Global.class.toString()).log(Level.INFO, "finishHotVideoPool: " + validVideoNum + "/" + videos.size());

    }

    public static void updateNewVideoPool() {
        Logger.getLogger(Global.class.toString()).log(Level.INFO, "updateNewVideoPool");
        ArrayList<HotVideoCrawlInfo> videos = GenericHotVideoCrawler.getGenericLinker().crawlNewVideos();
        ArrayList<IVideo> newNewVideoPool = new ArrayList<IVideo>();
        int validVideoNum = 0;
        for (int i = 0; i != videos.size(); ++i) {
            int id = Constant.ARTIFICIAL_USER_ID_MIN + (int)((Constant.ARTIFICIAL_USER_ID_MAX - Constant.ARTIFICIAL_USER_ID_MIN) * Math.random());
            IUser user = EntityFactory.getUser(id);
            Pair<Integer, IVideo> result = EntityFactory.getVideo(videos.get(i).url);
            if (result.getKey() == Constant.SUBMIT_SUCCESS) {
                result.getValue().setSummary("");
                if (result.getValue().getTitle() != null && result.getValue().getSnapshotURL() != null ) {
                    user.submitVideo(result.getValue());
                    ++validVideoNum;
                }
            }
        }
        newVideoPoolLock.writeLock().lock();
        newVideoPool = null;
        newVideoPoolLock.writeLock().unlock();
        Logger.getLogger(Global.class.toString()).log(Level.INFO, "finishNewVideoPool: " + validVideoNum + "/" + videos.size());
    }

    public static List<IVideo> getHotVideo(int topnum) {
        List<IVideo> result = new ArrayList<IVideo>();
        hotVideoPoolLock.readLock().lock();
        List<IVideo> tmp = hotVideoPool;
        hotVideoPoolLock.readLock().unlock();
        if (tmp == null) {
            tmp = StatementFactory.getQuery().getVideo(new ArrayList<String>(), new ArrayList<Object>(), 100);
            hotVideoPoolLock.writeLock().lock();
            hotVideoPool = tmp;
            hotVideoPoolLock.writeLock().unlock();
        }
        //Logger.getLogger(Global.class.toString()).log(Level.INFO, "tmp size: " + tmp.size());
        int[] candidates = RandomAlg.RandomChooseInRange(0, tmp.size(), topnum);
        for (int i = 0; i != candidates.length; ++i) {
            int index = candidates[i];
            //Logger.getLogger(Global.class.toString()).log(Level.INFO, "i=" + i + "; index=" + index);
            result.add(tmp.get(index));
        }
        return result;
    }

    public static List<IVideo> getMoreHotVideo(int alreadyHas, int topnum) {
        return getHotVideo(topnum);
    }

    public static List<IVideo> getNewVideo(int topnum) {
        List<IVideo> result = new ArrayList<IVideo>();
        newVideoPoolLock.readLock().lock();
        List<IVideo> tmp = newVideoPool;
        newVideoPoolLock.readLock().unlock();
        if (tmp == null) {
            tmp = StatementFactory.getQuery().getVideo(new ArrayList<String>(), new ArrayList<Object>(), 100);
            newVideoPoolLock.writeLock().lock();
            newVideoPool = tmp;
            newVideoPoolLock.writeLock().unlock();
        }
        int[] candidates = RandomAlg.RandomChooseInRange(0, tmp.size(), topnum);
        for (int index : candidates) {
            result.add(tmp.get(index));
        }
        return result;
    }

    public static List<IVideo> getMoreNewVideo(int alreadyHas, int topnum) {
        return getNewVideo(topnum);
    }

    public static List<IEvent> getActivity(int topnum) {
        List<IEvent> result = new ArrayList<IEvent>();
        List<RateEvent> rateEvent = StatementFactory.getQuery().getRate("1", "1", topnum);
        List<SubmitEvent> submitEvent = StatementFactory.getQuery().getSubmit("1", "1", topnum);
        List<PostEvent> postEvent = StatementFactory.getQuery().getPost("1", "1", topnum);
        List<JoinChannelEvent> joinGroupEvent = StatementFactory.getQuery().getUserChannelMemberRelation("1", "1", topnum);
        List<UserRelationEvent> followEvent = StatementFactory.getQuery().getUserRelation("1", "1", topnum);
        List<VideoCommentEvent> commentEvent = StatementFactory.getQuery().getVideoComment("1", "1", topnum);
        List<IEvent> events = new ArrayList<IEvent>();

        events.addAll(rateEvent);
        events.addAll(submitEvent);
        events.addAll(postEvent);
        events.addAll(joinGroupEvent);
        events.addAll(followEvent);
        events.addAll(commentEvent);


        Collections.sort(events, new EventTimeDescComparator());
        if (events.size() > topnum) {
            result = events.subList(0, topnum);
        }

        return result;
    }

    public static List<IEvent> getMoreActivity(int alreadyHas, int topnum) {
        List<IEvent> results = getActivity(alreadyHas + topnum);
        if (results.size() > topnum) {
            results = results.subList(results.size() - topnum, results.size());
        }
        return results;
    }

    /**
     *
     * @param timewindow
     *  counting period:  [now - timewindow, now)
     *  if timewindow = -1, the counting period is (0, now)
     * @param limit
     * @return
     */
    public static List<Pair<IUser, Integer>> getTopRecentSubmitUser(long timewindow, int limit) {
          return getTopRecentUser("submit", timewindow, limit);
    }

    public static List<Pair<IUser, Integer>> getTopRecentCollectUser(long timewindow, int limit) {
        return getTopRecentUser("collect", timewindow, limit);
    }

    public static List<Pair<IUser, Integer>> getTopRecentFolloweeUser(long timewindow, int limit) {
        return getTopRecentUser("followee", timewindow, limit);
    }

    protected static List<Pair<IUser, Integer>> getTopRecentUser(String type, long timewindow, int limit) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        long startTime = currentTime - timewindow;
        if (timewindow < 0 || currentTime < timewindow) {
            startTime = 0;
        }
        List<Pair<Integer, Integer>> count_list = StatementFactory.getQuery().getTopUser(type, startTime, currentTime, limit);
        List<Pair<IUser, Integer>> result = new ArrayList<Pair<IUser, Integer>>();
        for (Pair<Integer, Integer> p : count_list) {
            Pair<IUser, Integer> user_p = new Pair<IUser, Integer>();
            IUser u = EntityFactory.getUser(p.getKey());
            if (u == null)
                continue;
            user_p.setKey(u);
            user_p.setValue(p.getValue());
            result.add(user_p);
        }
        return result;
    }

    public static List<Pair<IChannel, Integer>> getTopRecentSubscribeChannel(long timewindow, int limit) {
        return getTopRecentChannel("subscribe", timewindow, limit);
    }

    protected static List<Pair<IChannel, Integer>> getTopRecentChannel(String type, long timewindow, int limit) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        long startTime = currentTime - timewindow;
        if (timewindow < 0 || currentTime < timewindow) {
            startTime = 0;
        }
        List<Pair<Integer, Integer>> count_list = StatementFactory.getQuery().getTopChannel(type, startTime, currentTime, limit);
        List<Pair<IChannel, Integer>> result = new ArrayList<Pair<IChannel, Integer>>();
        for (Pair<Integer, Integer> p : count_list) {
            Pair<IChannel, Integer> channel_p = new Pair<IChannel, Integer>();
            IChannel u = EntityFactory.getGroup(p.getKey());
            if (u == null)
                continue;
            channel_p.setKey(u);
            channel_p.setValue(p.getValue());
            result.add(channel_p);
        }
        return result;
    }
}

