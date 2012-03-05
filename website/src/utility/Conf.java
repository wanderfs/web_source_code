package utility;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles all the global configurations.
 * 
 * @author xuan
 *
 */
public class Conf {
	public static String DATABASE_ACCESS_LOG = "DATABASE_ACCESS_LOG";
	public static String DATABASE_PATH = "DATABASE_PATH";
	
	static protected Properties properties;
	static String default_conf_file = "website_app_configure.conf";

    static Conf c = null;

    private Conf() {
        
    }
    
	public static Conf getConf() {
        if (c == null) {
            try {
                c = new Conf();
                c.init();
            } catch (IOException ex) {
                Logger.getLogger(Conf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }
	public void init() throws IOException {
		File conf = new File(default_conf_file);
        properties = new Properties();
		if (!conf.exists()) {
			properties.setProperty(DATABASE_ACCESS_LOG, "log/database_log.txt");
			properties.setProperty(DATABASE_PATH, "jdbc/mysql/main");
			properties.list(new PrintStream(conf));
		} else {
			properties.load(new FileInputStream(conf));
		}
	}
	
	public String getConfigure(String configureName) {
		return properties.getProperty(configureName);
	}
}
