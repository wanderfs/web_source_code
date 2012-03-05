/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.video;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import logic.IVideo;

/**
 *
 * @author sen
 */
public class VideoWaitingList {

    public VideoWaitingList(long timeout) {
        this.timeout = timeout;
        timer.schedule(new Cleaner(this), 0, timeout/2);
    }

    private class VideoTimeStampPair {
        private IVideo video;
        private long timestamp;
        public VideoTimeStampPair(IVideo video, long timestamp) {
            this.video = video;
            this.timestamp = timestamp;
        }
        public IVideo getVideo() { return video; }
        public long getTimestamp() { return timestamp; }
        public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    }

    private class Cleaner extends TimerTask {
        private VideoWaitingList vwl;
        public Cleaner(VideoWaitingList vwl) {
            this.vwl = vwl;
        }
        @Override
        public void run() {
            if(vwl != null)
                vwl.checkTimeout();
        }
    }
    /**
     * (SiteSpecificID, IVideo) pair.
     * When user submits a video, it goes to this container, only after user confirms the submission will
     * the video be removed from this container and really gets into the database. This exists for user's
     * last-minute cancellation.
     * NOTE: this object probably need be memcached.
     */
    private Map<String, VideoTimeStampPair> waitingList = new HashMap<String, VideoTimeStampPair>();

    private long timeout;
    private Timer timer = new Timer();

    private void checkTimeout() {
        long curTime = System.currentTimeMillis();
        synchronized(waitingList) {
            Iterator it = waitingList.keySet().iterator();
            while(it.hasNext()) {
                String siteId = (String) it.next();
                VideoTimeStampPair pair = waitingList.get(siteId);
                if(curTime - pair.getTimestamp() > timeout)
                    it.remove();
            }
        }
    }

    public void add(IVideo video) {
        synchronized(waitingList) {
            String siteId = video.getSiteSpecificID();
            long curTime = System.currentTimeMillis();
            if(waitingList.containsKey(siteId)) {
                waitingList.get(siteId).setTimestamp(curTime);
            } else {
                waitingList.put(siteId, new VideoTimeStampPair(video, curTime));
            }
        }
    }

    public IVideo retrieve(String siteId) {
        VideoTimeStampPair pair = null;
        synchronized(waitingList) {
            pair = waitingList.remove(siteId);
        }
        if(pair == null) return null;
        else return pair.getVideo();
    }
}
