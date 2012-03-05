/*
 * This servlet caches and periodically updates a list of global news feeds.
 * It is recommended that js asks this servlet for global news rather than
 * asks directly for DB-related classes.
 */

package servlet.feed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.EntityFactory;
import logic.Global;
import logic.IEvent;
import logic.datatype.CollectEvent;
import logic.datatype.PostEvent;
import logic.datatype.SubmitEvent;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Sen
 */
@WebServlet(name="GlobalFeedServlet", urlPatterns={"/gfeed"}, loadOnStartup=1)
public class GlobalFeedServlet extends HttpServlet {

    public static final int newsCacheNum = 500;
    public static final int newsUpdateInterval_sec = 600;
    private ArrayList<IEvent> feedList = new ArrayList<IEvent>();

    @Override
    public void init() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (feedList) {
                    List<IEvent> tmpList = Global.getActivity(newsCacheNum);
                    Iterator<IEvent> lit = tmpList.iterator();
                    while (lit.hasNext()) {
                        IEvent e = lit.next();
                        if (e instanceof CollectEvent
                            || e instanceof SubmitEvent
                            || e instanceof PostEvent) {
                            feedList.add(e);
                        }
                    }
                }
            }
        }, 0, newsUpdateInterval_sec * 1000);
    }
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if (feedList.isEmpty()) // make sure that feedList.size() > 0
            feedList.addAll(EntityFactory.getUser(1601).getCollectedVideo(0, 1));

        int feedNum = 1;
        if (request.getParameter("fn") != null)
            feedNum = Integer.parseInt(request.getParameter("fn"));

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            JSONObject jobj = new JSONObject();
            jobj.put("fn", feedNum);
            int rand = new Random(System.currentTimeMillis()).nextInt(feedList.size());
            JSONArray jarr = new JSONArray();
            for (int i = rand; i < rand + feedNum; ++i) {
                jarr.add(feedList.get(i % feedList.size()).toJsonObject());
            }
            jobj.put("feed", jarr);
            out.write(jobj.toString());
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet caches and periodically updates a list of global news feeds.";
    }// </editor-fold>

}
