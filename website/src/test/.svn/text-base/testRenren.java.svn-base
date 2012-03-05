/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.xiaonei.api.XiaoneiException;
import com.xiaonei.api.XiaoneiRestClient;
import com.xiaonei.api.schema.Friend;
import com.xiaonei.api.schema.FriendsGetFriendsResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xuan
 */
public class testRenren extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                String apikey = "21f64fe81ad84f6b8673529b0dc9a34b";
                String secret = "2371ac37e26d4ae2842cfecec73abb0d";
                String sessionKey = null;
                Cookie[] cookies = request.getCookies();
                if (cookies == null) {
                    out.println("cookie disable");
                    return;
                }
                for (Cookie acookie : cookies) {
                    if (acookie.getName().equals(apikey + "_session_key")) {
                       sessionKey = acookie.getValue();
                    }
                }
                out.println("sessionKey : " + sessionKey);
                XiaoneiRestClient client = new XiaoneiRestClient(
                        apikey, secret, sessionKey);
                client.friends_getFriends();
                FriendsGetFriendsResponse resp = (FriendsGetFriendsResponse) client.getResponsePOJO();
                List<Friend> friends = resp.getFriend();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet testRenren</title>");
                out.println("</head>");
                out.println("<body>");
                for (Friend friend : friends) {
                    out.println("friends|getFriends|Id| "+friend.getId());
                    out.println("<br>");
                    out.println("friends|getFriends|Name| "+friend.getName());
                    out.println("<br>");
                    out.println("friends|getFriends|Headurl| "+friend.getHeadurl());
                    out.println("<br>");
                    out.println("<br>");
                    out.println("<br>");
                }
                out.println("</body>");
                out.println("</html>");
            } catch (XiaoneiException ex) {
                Logger.getLogger(testRenren.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace(out);
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
