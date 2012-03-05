/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import logic.datatype.CollectEvent;
import logic.datatype.CommentEvent;
import logic.datatype.JoinChannelEvent;
import logic.datatype.PostEvent;
import logic.datatype.RateEvent;
import logic.datatype.ShareEvent;
import logic.datatype.SubmitEvent;
import logic.datatype.SubscribeChannelEvent;
import logic.datatype.UserRelationEvent;
import logic.datatype.VideoCommentEvent;
import logic.datatype.VisitEvent;
import logic.datatype.WatchEvent;

/**
 *
 * @author xuan
 */
public class Constant {
    public final static String YOUKU_SITE = "youku";
    public final static String TUDOU_SITE = "tudou";
    public final static String BUGU_CNTV = "bugu.cntv";
    public final static String XIYOU_CNTV = "xiyou.cntv";
    public final static String NEWS_CNTV = "news.cntv";
    public final static String SPORTS_CNTV = "sports.cntv";
    public final static String JINGJI_CNTV = "jingji.cntv";
    public final static String NORM_CNTV = "cntv";
    public final static String _6_SITE = "6";
    public final static String SINA_SITE = "sina";
    public final static String KU6_SITE = "ku6";
    public final static String _56_SITE = "_56";

    // Submit Video Related
    public static final int SUBMIT_BEFORE = -1;
    public static final int SUBMIT_URL_ERROR = -2;
    public static final int SUBMIT_SUCCESS = -3;
    public static final int SUBMIT_UNKNOWN_ERROR = -4;

    // Modify User Related
    public static final int USER_ENTRY_EMAIL_DUPLICATED = -5;
    public static final int USER_ENTRY_UNKNOW_ERROR = -6;

    // Insert General
    public static int DATABASE_UNKNOWN_ERROR = -7;
    public static final int DATABASE_MODIFY_SUCCESS = -8;
    public static final int DATABASE_INSERT_DUPLICATE = -9;

    // MYSQL Related
    public static final int MYSQL_INSERT_DUPLICATE_CODE = 1062;
    public static final String MYSQL_INSERT_DUPLICATE_STATE = "23000";

    // other
    public static final int VIDEO_COMMENT_COMMON_PARENT_ID = -10;
    public static final int EVENT_COMMENT_COMMON_PARENT_ID = 0;
    public static final int FOLLOWEE_NOT_EXIST = -11;

    // artificial users' id range
    public static final int ARTIFICIAL_USER_ID_MIN = 328;
    public static final int ARTIFICIAL_USER_ID_MAX = 1468;
    public static final int CHANNEL_NOT_EXIST = -12;

    
    public static String toInfoString(int error_code) {
        String result = null;
        switch(error_code) {
            case -1:
                result = "SUBMIT_BEFORE"; break;
            case -2:
                result = "SUBMIT_URL_ERROR"; break;
            case -3:
                result = "SUBMIT_SUCCESS"; break;
            case -4:
                result = "SUBMIT_UNKNOWN_ERROR"; break;
            case -5:
                result = "USER_ENTRY_EMAIL_DUPLICATED"; break;
            case -6:
                result = "USER_ENTRY_UNKNOW_ERROR"; break;
            case -7:
                result = "DATABASE_UNKNOWN_ERROR"; break;
            case -8:
                result = "DATABASE_Modify_SUCCESS"; break;
            case -9:
                result = "DATABASE_INSERT_DUPLICATE"; break;
            case -10:
                result = "VIDEO_COMMENT_COMMON_PARENT_ID"; break;
            case -11:
                result = "FOLLOWEE_NOT_EXIST"; break;
            case -12:
                result = "CHANNEL_NOT_EXIST"; break;
            default:
                result = "Unknow Error Code"; break;
        }
        return result;
    }

    public static long EventIdSeqNum(Class eventclass) {
        if (eventclass == CollectEvent.class) {
            return 0;
        } else if (eventclass == JoinChannelEvent.class) {
            return 1;
        } else if (eventclass == PostEvent.class) {
            return 2;
        } else if (eventclass == RateEvent.class) {
            return 3;
        } else if (eventclass == SubmitEvent.class) {
            return 4;
        } else if (eventclass == SubscribeChannelEvent.class) {
            return 5;
        } else if (eventclass == UserRelationEvent.class) {
            return 6;
        } else if (eventclass == VideoCommentEvent.class) {
            return 7;
        } else if (eventclass == WatchEvent.class) {
            return 8;
        } else if (eventclass == VisitEvent.class) {
            return 9;
        } else if (eventclass == ShareEvent.class) {
            return 10;
        } else if (eventclass == CommentEvent.class) {
            return 11;
        } else {
            System.out.println("unknown event class" + eventclass.getCanonicalName());
            return 255;
        }
    }

    public static int mask_length = 8;
}
