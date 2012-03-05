/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.update;

import logic.Global;

/**
 *
 * @author xuan
 */
public class UpdatePutVideo extends Updater {
    public static final int UPDATE_INTERVAL = 2 * 60 * 1000;

    @Override
    public int getUpdateInterval() {
        return  UPDATE_INTERVAL;
    }

    @Override
    public void run() {
        Global.updateCollectSNS();
    }
}
