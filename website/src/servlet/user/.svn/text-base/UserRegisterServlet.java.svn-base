/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.EntityFactory;
import logic.IUser;
import servlet.ServletConfig;
import utility.Constant;
import utility.alpha.InvitationCodeManager;

/**
 *
 * @author Sen
 */
@WebServlet(name="UserRegisterServlet", urlPatterns={"/join"})
public class UserRegisterServlet extends HttpServlet {

    public static InvitationCodeManager icMgr = new InvitationCodeManager();
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String icode = request.getParameter("invite_code");
        if (!icMgr.redeem(icode)) {
            response.setContentType("text/xml;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println("<reply>");
                out.println("<status>ERROR</status>");
                out.println("<icode>" + icode + "</icode>");
                out.println("<msg>Out of quota</msg>");
                out.println("</reply>");
            } finally {
                out.close();
            }
            return;
        }

        IUser newbie = EntityFactory.getEmptyUser();

        String email = request.getParameter("email");
        newbie.setEmail(email);

        String password = request.getParameter("password");
        newbie.setPassword(password);

        String name = /*request.getParameter("name");
                if(name.equals(""))
                name = */ email.substring(0, email.indexOf('@'));
        newbie.setName(name);

        /*
        String photo = request.getParameter("photo");
        if(photo == null)
        photo = "1"; */

        int status = newbie.commit();

        if (status > 0) {  // everthing ok
            newbie = EntityFactory.getUser(email);
            log("IWEISHI_ICODE " + newbie.getUserid() + " " + icode);
            request.getSession().setAttribute(ServletConfig.SN_USER, newbie);
            
            // auto follow
            newbie.followByID(1598);
            newbie.followByID(1599);
            newbie.followByID(1600);
            newbie.followByID(1601);
            // follow self
            newbie.followByID(newbie.getUserid());

            if (request.getHeader("Referer").contains("iweishi2.0"))
                response.sendRedirect("iweishi2.0/user_settings.jsp");
            else
                response.sendRedirect("user_settings.jsp");
        } else if (status == Constant.USER_ENTRY_EMAIL_DUPLICATED) {
            response.sendRedirect("registry.jsp?result=duplicated&email=" + email);
        } else {
            response.sendRedirect("registry.jsp?result=error");
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
        return "This servlet is used for user registery";
    }// </editor-fold>

}
