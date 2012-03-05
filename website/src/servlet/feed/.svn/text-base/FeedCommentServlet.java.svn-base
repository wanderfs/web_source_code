/*
 * Comment on feeds, and set "new feed" flag to push to users.
 */

package servlet.feed;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.EntityFactory;
import logic.IUser;
import logic.datatype.CommentEvent;
import net.sf.json.JSONObject;
import servlet.ServletCommon;

/**
 *
 * @author Sen
 */
@WebServlet(name="FeedCommentServlet", urlPatterns={"/fcs"})
public class FeedCommentServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        long fid = Long.parseLong(request.getParameter("fid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        String comment = request.getParameter("comment");
        IUser u = ServletCommon.getCurrentUser(request.getSession());
        CommentEvent ce = u.leaveEventComment(fid, comment, pid);
        // if vid is also specified, add this comment to that video too.
        try {
            int vid = Integer.parseInt(request.getParameter("vid"));
            u.addVideoComment(vid, comment, pid);
        } catch (Exception e) {
            // do nothing
        }

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            JSONObject json = new JSONObject();
            json.put("result", "OK");
            json.put("cid", ce.getCommentid());
            json.put("timestamp", ce.getTime());
            out.write(json.toString());
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
