/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility.alpha;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class HotEventInfo {
    public int userid;
    public String comment;
    public String time;

    public HotEventInfo(int userid, String comment, String time){
        this.userid = userid;
        this.comment = comment;
        this.time = time;
    }
}
