/*
 * Modifications made to video go here.
 */

package servlet.video;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.EntityFactory;
import logic.IUser;
import logic.datatype.VideoCommentEvent;
import servlet.ServletCommon;

/**
 *
 * @author sen
 */
@WebServlet(name="VideoCommentServlet", urlPatterns={"/vcs"})
public class VideoCommentServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String reply = null;
        String action = request.getParameter("action");
        if (action == null) {
            return;
        } else if (action.equals("comment")) {
            reply = commentVideo(request);
        } else if (action.equals("rate")) {
            reply = rateVideo(request);
        } else if (action.equals("watch")) {
            reply = watchVideo(request);
        }

        PrintWriter out = response.getWriter();
        response.setContentType("text/xml;charset=UTF-8");
        try {
            if (reply == null)
                out.write("<status>ERROR</status>");
            else
                out.write(reply);
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

    private String commentVideo(HttpServletRequest request) {
        int vid = Integer.parseInt(request.getParameter("vid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        //int rid = Integer.parseInt(request.getParameter("rid"));

        // convert Chinese encoding
        String comment = ServletCommon.ajaxChineseTranscoder(request, "comment");
        IUser user = ServletCommon.getCurrentUser(request.getSession());
        VideoCommentEvent vc = user.addVideoComment(vid, comment, pid);
        StringBuilder sb = new StringBuilder();
        sb.append("<vcsreply>");
        if (vc != null) {
            sb.append("<status>OK</status>");
            sb.append("<timestamp>").append(vc.getTime()).append("</timestamp>");
            sb.append("<vcid>").append(vc.getCommentid()).append("</vcid>");
        } else {
            sb.append("<status>FAIL</status>");
        }
        sb.append("</vcsreply>");
        return sb.toString();
    }

    private String rateVideo(HttpServletRequest request) {
        int vid = Integer.parseInt(request.getParameter("vid"));
        int rate = Integer.parseInt(request.getParameter("score"));
        IUser user = ServletCommon.getCurrentUser(request.getSession());
        user.rateVideo(vid, rate);
        return "<status>OK</status>";
    }

    private String watchVideo(HttpServletRequest request) {
        int vid = Integer.parseInt(request.getParameter("vid"));
        IUser user = ServletCommon.getCurrentUser(request.getSession());
        user.watchVideo(vid);
        return "<status>OK</status>";
    }
}
