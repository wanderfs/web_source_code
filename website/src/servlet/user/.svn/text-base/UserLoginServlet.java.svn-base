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

/**
 *
 * @author Sen
 */
@WebServlet(name="UserLoginServlet", urlPatterns={"/login"})
public class UserLoginServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //look up user by email
        String email = request.getParameter("email");
        IUser user = EntityFactory.getUser(email);
        //if user doesn't exist...
        if(user == null) {
            genErrorMsg(response, "用户" + email + "目前不存在。");
            return;
        }
        //check passward
        if( !request.getParameter("password").equals(user.getPassword()) ) {
            genErrorMsg(response, "用户名或密码错误。");
            return;
        }

        //everything is ok, set user.
        request.getSession(true).setAttribute("user", user);
        String mode = request.getParameter("mode");
        if (mode == null || !mode.equals("silent")) {
            //  if not in silent mode, redirect to previous page
            String prev_page = request.getHeader("Referer");
            if (prev_page == null)
                prev_page = "user_index.jsp";
            else if (prev_page.contains("status=logout")) {
                prev_page = prev_page.replace("status=logout", "");
            } else {
                prev_page = prev_page.replace("index.jsp", "user_index.jsp");
            }
            response.sendRedirect(prev_page);
        } else {
            // silent mode is used for ajax
            response.setContentType("text/xml;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.print("<uid>" + user.getUserid() + "</uid>");
                out.print("<name>" + user.getName() + "</name>");
            } finally {
                out.close();
            }
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

    private void genErrorMsg(HttpServletResponse response, String msg) throws IOException {
        response.sendRedirect("/website/login_error.jsp?");
    }
}
