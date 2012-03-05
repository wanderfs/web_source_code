/*
 * manage event comments.
 */
package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.ServletCommon;
import utility.alpha.HotEventCommentManager;

/**
 *
 * @author sen
 */
@WebServlet(name = "HotEventServlet", urlPatterns = {"/hot_event"})
public class HotEventServlet extends HttpServlet {

    public static HotEventCommentManager hemgr = new HotEventCommentManager();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        hotEventCommentHandler(request, response);
    }

    protected void hotEventCommentHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String event_name = ServletCommon.ajaxChineseTranscoder(request, "event_name");

        if (!hemgr.getMap().containsKey(event_name)) {
            hemgr.insertMap(event_name);
        }
        response.setContentType("text/xml;charset=UTF-8");
        Date date = new Date();
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateformat.format(new Date());
        hemgr.appendComment(event_name, ServletCommon.getCurrentUser(request.getSession()).getUserid(), ServletCommon.ajaxChineseTranscoder(request, "comment"), time);

        StringBuilder sb = new StringBuilder();
        PrintWriter out = response.getWriter();
        try {
            sb.append("<time>").append(time).append("</time>");
        } finally {
            out.write("<hoteventreply>" + sb + "</hoteventreply>");
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
     * @throws ServletException if a servlet-specific error occursz
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
        return "handles user feedback";
    }// </editor-fold>
}
