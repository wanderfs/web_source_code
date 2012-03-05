/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.update.UpdateHotVideo;
import logic.update.UpdateNewVideo;
import logic.update.UpdatePutVideo;
import logic.update.Updater;

/**
 *
 * @author xuan
 */
public final class IweishiTimer {
    protected Timer timer = new Timer();
    public static IweishiTimer singleton = new IweishiTimer();
    private IweishiTimer() {
        // add your timer event here
        
        Logger.getLogger(IweishiTimer.class.toString()).log(Level.INFO, "Iweishi system timer started");
        Updater upNew = new UpdateNewVideo();
        Updater upHot = new UpdateHotVideo();
        Updater upPutVideo = new UpdatePutVideo();

        // please don't check in a comment out verison. 
        // for most of time, people forget to turn it on when deploy to iweishi.cn
        /* please don't check in commented out version, comment it out locally*/
        //this.scheduleAtFixedRate(upNew, 0, upNew.getUpdateInterval());
        /* please don't check in commented out version, comment it out locally*/
        this.scheduleAtFixedRate(upHot, upHot.getUpdateInterval()/2, upHot.getUpdateInterval());
        //this.scheduleAtFixedRate(upHot, 30*1000 + 0, upHot.getUpdateInterval());
        this.scheduleAtFixedRate(upPutVideo, 30*1000 + upPutVideo.getUpdateInterval()/2, upPutVideo.getUpdateInterval());
    }

    public static IweishiTimer getSingletonTimer() {
        return singleton;
    }

    public void schedule(TimerTask task, Date time) {
        timer.schedule(new WrappedTimerTask(task), time);
    }
       
    public void schedule(TimerTask task, Date firstTime, long period) {
       timer.schedule(new WrappedTimerTask(task), firstTime, period);
    }
     
    public void schedule(TimerTask task, long delay) {
       timer.schedule(new WrappedTimerTask(task), delay);
    }
    
    public void schedule(TimerTask task, long delay, long period) {
       timer.schedule(new WrappedTimerTask(task), delay, period);
    }
      
    public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
       timer.schedule(new WrappedTimerTask(task), firstTime, period);
    }
    
    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
       timer.schedule(new WrappedTimerTask(task), delay, period);
    }
}

class WrappedTimerTask extends TimerTask {
    private TimerTask task;
      
    WrappedTimerTask(TimerTask t) {
        this.task = t;
     }
    @Override
    public boolean cancel() {
        return task.cancel();
    }
    @Override
    public void run() {
         Thread t = new Thread(task);
         t.start();
    }
}
