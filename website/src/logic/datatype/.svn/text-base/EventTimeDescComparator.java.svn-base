/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.datatype;

import java.util.Comparator;
import logic.IEvent;

/**
 *
 * @author xuan
 */
public class EventTimeDescComparator implements Comparator<IEvent> {

    @Override
    public int compare(IEvent t, IEvent t1) {
        if (t.getTime().after(t1.getTime())) {
            return -1;
        } else {
            return 1;
        }
    }

}
