/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.util.Date;

/**
 *
 * @author xuan
 */
public class AD {
    int adid;
    String text = "";
    String url;
    Date time;

    // one should call EntityFactory.getEmptyAD instead;
    public AD() {
        adid = -1;
        text = null;
        url = null;
    }

    public int getAdid() {
        return adid;
    }

    public void setAdid(int id) {
        this.adid = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AD: adid =" + adid + ", text = " + text + ", url =" + url;
    }

    // return adid;
    public int commit() {
        int ret = 0;
        if (this.adid < 0) {  // should insert user
            ret = database.StatementFactory.getModify().insertAD(this);
            this.setAdid(ret);
        } else {
            ret = database.StatementFactory.getModify().updateAD("adid", this.adid, this);
            if (ret > 0) { // no error
                ret = adid;
            }
        }
        return ret;
    }
}
