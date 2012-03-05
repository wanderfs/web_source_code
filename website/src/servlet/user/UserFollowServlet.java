/*
 * User follow / disfollow
 */

package servlet.user;

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
 * @author senhu
 */
@WebServlet(name="UserFollowServlet", urlPatterns={"/follow"})
public class UserFollowServlet extends HttpServlet {
   
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
        IUser user = ServletCommon.getCurrentUser(request.getSession());
        String followee = request.getParameter("followee");
        String action = request.getParameter("action");

        StringBuilder sb = new StringBuilder();
        sb.append("<status>");
        if (user == null || followee == null || action == null) {
            sb.append("ERROR");
        } else {
            if (action.equals("follow")) {
                user.followByID(Integer.parseInt(followee));
                sb.append("OK");
            }
            if (action.equals("disfollow")) {
                user.cancelFollowByID(Integer.parseInt(followee));
                sb.append("OK");
            }
        }
        sb.append("</status>");

        PrintWriter out = response.getWriter();
        try {
            out.write(sb.toString());
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
