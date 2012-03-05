/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.video;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.IUser;
import servlet.ServletCommon;

/**
 *
 * @author sen
 */
@WebServlet(name="HotlistServlet", urlPatterns={"/hotlist"})
public class HotlistServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        StringBuilder sb = null;
        IUser user = ServletCommon.getCurrentUser(request.getSession());
        
        if (user != null) {
            String action = request.getParameter("action");

            if (action.equals("collect"))
                sb = processVideoCollect(user, Integer.parseInt(request.getParameter("vid")), request.getParameter("comment"));
        }

        PrintWriter out = response.getWriter();
        try {
            if (user != null && sb != null)
                out.write(sb.toString());
            else
                out.write("<status>ERROR</status>");
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

    private StringBuilder processVideoCollect(IUser user, int vid, String comment) {
        StringBuilder ret = new StringBuilder();
        if (comment == null)
            user.collectVideo(vid);
        else
            user.collectVideo(vid, comment);
        ret.append("<status>OK</status>");
        return ret;
    }

}
