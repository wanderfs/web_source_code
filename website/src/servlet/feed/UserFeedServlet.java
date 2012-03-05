/*
 * lookup user info by giving uid or other keywords
 */
package servlet.feed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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
@WebServlet(name = "UserFeedServlet", urlPatterns = {"/ufeed"})
public class UserFeedServlet extends HttpServlet {

    // TODO(sen): use a timeout map from guava to do caching
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // if no keyword specified, random sample in first 1600 users
        int uid = new Random().nextInt(1600);

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String email = request.getParameter("email");
            if (email != null) {
                uid = EntityFactory.getUser(email).getUserid();
            }
            String suid = request.getParameter("uid");
            if (suid != null) {
                uid = Integer.parseInt(suid);
            }
            IUser user = EntityFactory.getUser(uid);
            out.write(user.toJSONString());
        } catch (NullPointerException e) {
            // exception means this user doesn't exist
            out.write("{\"result\": \"none\"}");
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
