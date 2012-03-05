/*
 * InvitationCodeManager keeps persistent records of icode usage (new/add/decrease/redeem).
 */

package utility.alpha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 *
 * @author sen
 */
public class InvitationCodeManager {
    private ConcurrentHashMap<String, Integer> codeQuota = new ConcurrentHashMap<String, Integer>();
    Logger logger = Logger.getLogger("InvitationCodeManager");

    private class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + "|" + record.getMillis() + "|" + record.getMessage() + "\n";
        }
    }

    public InvitationCodeManager() {
        recover();
        try {
            FileHandler fileHandler = new FileHandler("icode.log", Integer.MAX_VALUE, 1, true);
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

    public HashMap<String, Integer> snapshot() {
        HashMap<String, Integer> curQuota = new HashMap<String, Integer>();
        for (String key : codeQuota.keySet()) {
            curQuota.put(key, codeQuota.get(key));
        }
        return curQuota;
    }

    // if given code still has quota left, return true and decrease quota by 1
    // otherwise return false;
    public boolean redeem(String code) {
        Integer quota = codeQuota.get(code);
        if (quota != null && quota > 0) {
            if (quota - 1 <= 0)
                codeQuota.remove(code);
            else
                codeQuota.put(code, quota - 1);
            logger.info(code);
            return true;
        } else {
            logger.warning(code);  // insufficient code quota
            return false;
        }
    }

    public void addQuota(String code, int quota_incr) {
        Integer quota = codeQuota.get(code);
        if (quota == null)
            quota = 0;
        quota += quota_incr;
        codeQuota.put(code, quota);
        logger.info(code + " + " + quota_incr);
    }

    private void recover() {
        File log = new File("icode.log");
        if (log.exists()) {
            try {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(log));
                } catch (FileNotFoundException ex) {
                    return;
                }
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("WARNING")) continue;
                    //System.out.println(line);
                    /*
                    System.out.println(line);
                    System.out.println("0000 " + line.split("\\|")[0]);
                    System.out.println("1111 " + line.split("\\|")[1]);
                    System.out.println("2222 " + line.split("\\|")[2]); */
                    String[] msg = line.split("\\|")[2].split(" \\+ ");
                    if (msg.length == 1)
                        codeQuota.put(msg[0], codeQuota.get(msg[0]) - 1);
                    else {
                        int quota = 0;
                        if (codeQuota.containsKey(msg[0]))
                            quota = codeQuota.get(msg[0]);
                        codeQuota.put(msg[0], quota + Integer.parseInt(msg[1]));
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(InvitationCodeManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        logger.getHandlers()[0].close();
    }

    public static void main(String[] args) {
        String a = "a + b + c";
        System.out.println(a.split(" \\+ ")[1]);
        
        InvitationCodeManager test = new InvitationCodeManager();
        test.addQuota("husen", 100);
        InvitationCodeManager test2 = new InvitationCodeManager();
        test.redeem("husen");
        test.redeem("husen");
        test2.addQuota("mibaby", 10);
        test.redeem("husen");
    }
}
