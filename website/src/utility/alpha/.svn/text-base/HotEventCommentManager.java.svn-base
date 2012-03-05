/*
 * Read the comments in hot_event jsp file from hot event log file.
 */
package utility.alpha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author wei
 */
public class HotEventCommentManager {

    private ConcurrentHashMap<String, HotEventHandler> chm = new ConcurrentHashMap<String, HotEventHandler>();

    public ConcurrentHashMap<String, HotEventHandler> getMap() {
        return chm;
    }

    public void insertMap(String event_name) {
        chm.put(event_name, new HotEventHandler(event_name));
    }

    public void appendComment(String event_name, int uid, String comment, String time) {
        chm.get(event_name).appendComment(uid, comment, time);
    }

    public static ArrayList<HotEventInfo> getComments(String event_name) {
        ArrayList<HotEventInfo> al = new ArrayList<HotEventInfo>();
        File log = new File(event_name);
        if (log.exists()) {
            try {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(log));
                } catch (FileNotFoundException ex) {
                }
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] msg = line.split("\\|")[2].split("\\+");
                    HotEventInfo hei = new HotEventInfo(Integer.parseInt(msg[0]), msg[1], msg[2]);
                    al.add(hei);
                }
            } catch (IOException ex) {
            }
        }
        return al;
    }

    public static void main(String[] args) {
        HotEventCommentManager hemgr = new HotEventCommentManager();
        hemgr.appendComment("starcraft.log", 16, "是劳动纠纷", "是拉动房价");
        List<HotEventInfo> comments = HotEventCommentManager.getComments("starcraft.log");
        Iterator<HotEventInfo> coit = comments.iterator();
        while (coit.hasNext()) {
            HotEventInfo hei = coit.next();
            System.out.println(hei.comment);
            System.out.println(hei.time);
            System.out.println(hei.userid);
        }
    }
}

class HotEventHandler {

    Logger logger = null;

    private class SimpleFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return record.getLevel() + "|" + record.getMillis() + "|" + record.getMessage() + "\n";
        }
    }

    public HotEventHandler(String event_name) {
        logger = Logger.getLogger(event_name);
        try {
            FileHandler fileHandler = new FileHandler(event_name, Integer.MAX_VALUE, 1, true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException ex) {
            Logger.getLogger(InvitationCodeManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(InvitationCodeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void appendComment(int uid, String comment, String time) {
        logger.info(uid + "+" + comment + "+" + time);
    }

    @Override
    public void finalize() throws Throwable {
        logger.getHandlers()[0].close();
    }
}
