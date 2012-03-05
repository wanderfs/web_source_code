/*
 * This servlet caches recent feed events. It response to ajax queries so that
 * users get feeds pushed to their screens.
 */

package servlet.feed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.IEvent;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import servlet.ServletCache;
import servlet.ServletCommon;

/**
 *
 * @author Sen
 */
@WebServlet(name="EventFeedServlet", urlPatterns={"/efeed"})
public class EventFeedServlet extends HttpServlet {
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int uid = ServletCommon.getCurrentUser(request.getSession()).getUserid();
        List<IEvent> l = ServletCache.getFeeds(uid);

        JSONObject jobj = new JSONObject();
        if (l == null)
            jobj.put("fn", 0);
        else {
            jobj.put("fn", l.size());
            JSONArray jarr = new JSONArray();
            for (IEvent e : l) {
                jarr.add(e.toJsonObject());
            }
            jobj.put("feed", jarr);
        }

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
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
        return "Short description";
    }// </editor-fold>

}
