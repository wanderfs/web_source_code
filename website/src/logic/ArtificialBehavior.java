/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.datatype.PostEvent;
import test.Test;
import utility.Constant;

/**
 * This class adds some artificial behavior for bootstrapping purpose
 * @author xuan
 */
public class ArtificialBehavior {
    private static ConcurrentHashMap<Integer, Long> accessTime;
    public static void smartFollowUser(IUser u) {
        if (Constant.ARTIFICIAL_USER_ID_MIN <= u.getUserid() && u.getUserid() <= Constant.ARTIFICIAL_USER_ID_MAX) {
            return ;
        }
        if (accessTime == null) {
            accessTime = new ConcurrentHashMap();
        }
        Long lastFollowAttemptTime = accessTime.get(u.getUserid());
        long currentTime = System.currentTimeMillis();
        if (lastFollowAttemptTime == null) {
            lastFollowAttemptTime = 0l;
        }
        if (u.getFollower().size() < 1) {
            int number = (int)(Math.random() * 5);
            followUser(u, number);
        } else if (u.getFollower().size() < 121 + (u.getUserid() * 45) % 100 ) {
            if (currentTime - lastFollowAttemptTime > 60 * 1000 /* follow gap*/) {
                if (Math.random() < Math.min(0.5, 10 / Math.pow(1 + u.getFollower().size(), 0.8)) ) {  // K / # of followers
                    followUser(u, 1);
                }
            }
            accessTime.put(u.getUserid(), System.currentTimeMillis());
         } else {
            if (currentTime - lastFollowAttemptTime > 3600 * 1000 /* follow gap*/) {
                if (Math.random() < Math.min(0.5, 10 / Math.pow(1 + u.getFollower().size(), 0.8)) ) {  // K / # of followers
                    followUser(u, 1);
                }
            }
            accessTime.put(u.getUserid(), System.currentTimeMillis());
         }
    }
    private static void followUser(IUser u, int times){
        Logger.getLogger(ArtificialBehavior.class.getSimpleName()).log(Level.INFO, "Follow {0} , {1}", new Object[]{u.getUserid(), times});
        int artificialMax = ((u.getUserid() + 4588) * 4187) % 1000;
        int followCount = u.getFollower().size();
        if (followCount < artificialMax) {
            for (int i = 0; i < times; ++i) {
                int id = Constant.ARTIFICIAL_USER_ID_MIN + (int)((Constant.ARTIFICIAL_USER_ID_MAX - Constant.ARTIFICIAL_USER_ID_MIN) * Math.random());

                IUser artificial_user = EntityFactory.getUser(id);
                artificial_user.followByID(u.getUserid());
                List<PostEvent> e = u.getChannelEvents(5);
                boolean isCollected = false;
                for (PostEvent p : e) {
                    artificial_user.watchVideo(p.getVideoid());
                    if (!e.isEmpty() && Math.random() < 0.2 && !isCollected) {
                        artificial_user.collectVideo(p.getVideoid(), "");
                        isCollected = true;
                    }
                }
            }
        }
    }
}
