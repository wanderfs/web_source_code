/*
 * This filter checks http session and fill in user information.
 * This filter should be applied to all pages that a normal user could visit.
 */

package servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.EntityFactory;
import logic.IUser;

/**
 *
 * @author sen
 */
public class WebFilter implements Filter {

    private static final boolean debug = true;
    private static final boolean trace = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public WebFilter() {
    } 

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
	throws IOException, ServletException {
	if (debug) log("WebFilter:DoBeforeProcessing");

	HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);

        // deal with user of the session
        if(req.getRequestURI().contains("logout")) {
            // for any page, logout means clear cookies and remain on current page
            ServletCommon.clearAutoLogin(session);
            // System.out.println("Referer: " + req.getHeader("Referer"));
            ((HttpServletResponse)response).sendRedirect(req.getHeader("Referer"));
        } else if(ServletCommon.getCurrentUser(session) == ServletCommon.nobody) {
            // session without real user! check cookies.
            Cookie[] cookies = req.getCookies();
            if(cookies == null) {
                log("no cookie attached!");
                return;
            }
            String userid = null;
            String authenCode = null;
            for(int i = 0; i < cookies.length; ++i) {
                if(cookies[i].getName().equals(ServletConfig.CKNANE_USERID))
                    userid = cookies[i].getValue();
                if(cookies[i].getName().equals(ServletConfig.CKNAME_AUTENTICATOR))
                    authenCode = cookies[i].getValue();
            }

            if(userid != null && authenCode != null) {
                IUser user = EntityFactory.getUser(Integer.parseInt(userid));
                //if(user.getAuthenticator().equals(authenCode))
                    session.setAttribute(ServletConfig.SN_USER, user);
            }
        }

        if (trace) {
            log("IWEISHI_TRACE: " + System.currentTimeMillis() + "||" + req.getRequestURI() + "||" + session.getId() + "||" + session.getAttribute("user") + "||" + req.getHeader("Referer"));
        }
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("WebFilter:DoAfterProcessing");
        }
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {

	if (debug) log("WebFilter:doFilter()");

	doBeforeProcessing(request, response);
	
	Throwable problem = null;
	try {
	    chain.doFilter(request, response);
	}
	catch(Throwable t) {
	    // If an exception is thrown somewhere down the filter chain,
	    // we still want to execute our after processing, and then
	    // rethrow the problem after that.
	    problem = t;
	    t.printStackTrace();
	}

	doAfterProcessing(request, response);

	// If there was a problem, we want to rethrow it if it is
	// a known type, otherwise log it.
	if (problem != null) {
	    if (problem instanceof ServletException) throw (ServletException)problem;
	    if (problem instanceof IOException) throw (IOException)problem;
	    sendProcessingError(problem, response);
	}
    }
    
    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
	return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
	this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter 
     */
    public void destroy() { 
    }

    /**
     * Init method for this filter 
     */
    public void init(FilterConfig filterConfig) { 
	this.filterConfig = filterConfig;
	if (filterConfig != null) {
	    if (debug) { 
		log("WebFilter:Initializing filter");
	    }
	}
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
	if (filterConfig == null) return ("WebFilter()");
	StringBuffer sb = new StringBuffer("WebFilter(");
	sb.append(filterConfig);
	sb.append(")");
	return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
	String stackTrace = getStackTrace(t); 

	if(stackTrace != null && !stackTrace.equals("")) {
	    try {
		response.setContentType("text/html");
		PrintStream ps = new PrintStream(response.getOutputStream());
		PrintWriter pw = new PrintWriter(ps); 
		pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N
		    
		// PENDING! Localize this for next official release
		pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n"); 
		pw.print(stackTrace); 
		pw.print("</pre></body>\n</html>"); //NOI18N
		pw.close();
		ps.close();
		response.getOutputStream().close();
	    }
	    catch(Exception ex) {}
	}
	else {
	    try {
		PrintStream ps = new PrintStream(response.getOutputStream());
		t.printStackTrace(ps);
		ps.close();
		response.getOutputStream().close();
	    }
	    catch(Exception ex) {}
	}
    }

    public static String getStackTrace(Throwable t) {
	String stackTrace = null;
	try {
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    t.printStackTrace(pw);
	    pw.close();
	    sw.close();
	    stackTrace = sw.getBuffer().toString();
	}
	catch(Exception ex) {}
	return stackTrace;
    }

    public void log(String msg) {
	filterConfig.getServletContext().log(msg); 
    }

}
