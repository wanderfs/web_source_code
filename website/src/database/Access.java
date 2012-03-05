package database;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;

import utility.*;

public class Access {
	
	protected static Logger accessLogger;
	protected static DataSource datasource;
	protected static InitialContext context;
    protected static Conf c = Conf.getConf();
	
	public static void main(String args[]) throws Exception {
		System.out.println(examplesimpleConnection());
		System.out.println(examplepoolingConnection());
	}
	
	public static void init(){
		accessLogger = Logger.getLogger(c.getConfigure(Conf.DATABASE_ACCESS_LOG));
		try {
			context = new InitialContext();
			datasource = (DataSource)context.lookup(c.getConfigure(Conf.DATABASE_PATH));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			accessLogger.log(Level.SEVERE, "Naming Error", e);
		}
	}
	
	/*
	 * Get a pooling connection.
	 * Remember to close the connection in any case. (usually called in finally block)
	 */
	public static Connection getConnection() throws SQLException {
        if (datasource == null) {
            init();
            accessLogger.log(Level.WARNING, "datasource == null in access.getConnection()");
        }
        return datasource.getConnection();
	}
	
	static private String examplesimpleConnection() {
		StringBuffer sb = new StringBuffer();
		sb.append("SimpleConnection");
		Connection conn = null;
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost:4500/main?" +
		                                   "user=root&password=");
		    Statement s = conn.createStatement();
		    ResultSet rt = null;
		    if (s.execute("select * from user")){
		    	rt = s.getResultSet();
		    }
		    
		    while(rt.next()) {
		    	int columns = rt.getMetaData().getColumnCount();
		    	for (int i = 0; i != columns; ++i) {
		    		sb.append(rt.getString(i + 1) + " ");
		    	}
		    	sb.append("");
		    }
		    
		    s.close();
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return sb.toString();
	}
	
	static public String examplepoolingConnection() throws Exception {
		StringBuffer sb = new StringBuffer("");
		sb.append("poolingConnection\r\n");
        /*
         * Create a JNDI Initial context to be able to
         *  lookup  the DataSource
         *
         * In production-level code, this should be cached as
         * an instance or static variable, as it can
         * be quite expensive to create a JNDI context.
         *
         * Note: This code only works when you are using servlets
         * or EJBs in a J2EE application server. If you are
         * using connection pooling in standalone Java code, you
         * will have to create/configure datasources using whatever
         * mechanisms your particular connection pooling library
         * provides.
         */

        InitialContext ctx = new InitialContext();

         /*
          * Lookup the DataSource, which will be backed by a pool
          * that the application server provides. DataSource instances
          * are also a good candidate for caching as an instance
          * variable, as JNDI lookups can be expensive as well.
          */

        DataSource ds =
          (DataSource)ctx.lookup(c.getConfigure(Conf.DATABASE_PATH));

        
        return JDBCWork(ds.getConnection());
    }

    /*
     * The following code is what would actually be in your
     * Servlet, JSP or EJB 'service' method...where you need
     * to work with a JDBC connection.
     */

    public static String JDBCWork(Connection conn) throws SQLException {
        StringBuffer sb = new StringBuffer();
        Statement stmt = null;
         try {

            /*
             * Now, use normal JDBC programming to work with
             * MySQL, making sure to close each resource when you're
             * finished with it, which allows the connection pool
             * resources to be recovered as quickly as possible
             */

            stmt = conn.createStatement();

            ResultSet rt = null;
		    if (stmt.execute("select * from user")){
		    	rt = stmt.getResultSet();
		    }

		    while(rt.next()) {
		    	int columns = rt.getMetaData().getColumnCount();
		    	for (int i = 0; i != columns; ++i) {
		    		sb.append(rt.getString(i + 1) + " ");
		    	}
		    	sb.append("\r\n");
		    }

            stmt.close();
            stmt = null;

            conn.close();
            conn = null;
        } finally {
            /*
             * close any jdbc instances here that weren't
             * explicitly closed during normal code path, so
             * that we don't 'leak' resources...
             */

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlex) {
                    // ignore -- as we can't do anything about it here
                }

                stmt = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlex) {
                    // ignore -- as we can't do anything about it here
                }

                conn = null;
            }
        }
        return sb.toString();
    }
}