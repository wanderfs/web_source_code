/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.datatype.CollectEvent;

/**
 * class Misc contains all static member functions that
 * I don't feel reasonable elsewhere...
 * @author Sen
 */
public class Misc {
    static final long secInYear = 60*60*24*356;
    static final long secInMonth = 60*60*24*30;
    static final long secInWeek = 60*60*24*7;
    static final long secInDay = 60*60*24;
    static final long secInHour = 60*60;
    static final long secInMin = 60;

    static final int timeQuorum = 2; //display at most two levels of time units.

    public static String pastTime(long ts) {
        long te = System.currentTimeMillis();

        int quorum = 0;
        StringBuffer ret = new StringBuffer();
        long sec, reminder;
        sec = (te-ts)/1000;

        long year = sec/secInYear;
        if(year > 1) {
            ++quorum;
            ret.append(year + "年");
        }
        if(quorum >= timeQuorum)
            return ret.toString();

        reminder = sec%secInYear;
        long month = reminder/secInMonth;
        if(month > 1) {
            ++quorum;
            ret.append(month + "个月");
        }
        if(quorum >= timeQuorum)
            return ret.toString();

        reminder = sec%secInMonth;
        long week = reminder/secInWeek;
        if(week > 1) {
            ++quorum;
            ret.append(week + "周");
        }
        if(quorum >= timeQuorum)
            return ret.toString();

        reminder = sec%secInWeek;
        long day = reminder/secInDay;
        if(day > 1) {
            ++quorum;
            ret.append(day + "天");
        }
        if(quorum >= timeQuorum)
            return ret.toString();

        reminder = sec%secInDay;
        long hour = reminder/secInHour;
        if(hour > 1) {
            ++quorum;
            ret.append(hour + "小时");
        }
        if(quorum >= timeQuorum)
            return ret.toString();

        reminder = sec%secInHour;
        long min = reminder/secInMin;
        if(min > 1) {
            ++quorum;
            ret.append(min + "分钟");
        }
        if(quorum >= timeQuorum)
            return ret.toString();

        sec = sec%secInMin;
        ret.append(sec + "秒");

        return ret.toString();
    }
    
    public static String pastTime(Time startTime) {
        return pastTime(startTime.getTime());
    }

    public static String pastTime(Date startDate) {
        return pastTime(startDate.getTime());
    }

    public static String hardCodedChinese(String hardCodedChineseStr) {
        try {
            return new String(hardCodedChineseStr.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Misc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hardCodedChineseStr;
    }

    public static String hardCodedChinese(String hardCodedChineseStr, String alteranteStr) {
        try {
            return new String(hardCodedChineseStr.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Misc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alteranteStr;
    }

    /**
     * @deprecated
     * @param ce
     * @return
     */
    public static String retriveVideoHeadline(CollectEvent ce) {
        return "";
    }
}
