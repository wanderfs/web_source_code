/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.user;

import com.xiaonei.api.XiaoneiException;
import com.xiaonei.api.XiaoneiRestClient;
import com.xiaonei.api.schema.Friend;
import com.xiaonei.api.schema.FriendsGetFriendsResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.EntityFactory;
import logic.IUser;
import logic.link.EmailLinkKey;
import logic.link.GmailLinker;
import logic.link.ILinkFriend;
import logic.link.RenrenConnect;
import logic.link.RenrenUser;

/**
 *
 * @author senhu
 */
@WebServlet(name="UserIgniteServlet", urlPatterns={"/ignite"})
public class UserIgniteServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String which = request.getParameter("which");
        if (which.equals("renren")) {
            igniteRenren(request, response);
        } else if (which.equals("gmail")) {
            igniteGmail(request, response);
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

    private void igniteRenren(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        String apikey = "21f64fe81ad84f6b8673529b0dc9a34b";
        String secret = "2371ac37e26d4ae2842cfecec73abb0d";
        String sessionKey = null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            sb.append("<status>ERROR</status>");
            sb.append("<info>Cookie</info>");
        } else {
            for (Cookie acookie : cookies) {
                if (acookie.getName().equals(apikey + "_session_key")) {
                    sessionKey = acookie.getValue();
                    break;
                }
            }
            RenrenConnect rrcon = new RenrenConnect(apikey, secret, sessionKey);
            List<RenrenUser> friendlist = rrcon.GetUserFriends();
            if (friendlist == null) {
                sb.append("<status>ERROR</status>");
                sb.append("<info>Empty Friend List</info>");
            } else {
                sb.append("<status>ERROR</status>");
                Iterator<RenrenUser> it = friendlist.iterator();
                while(it.hasNext()) {
                    RenrenUser friend = it.next();
                    sb.append("<friend>");
                    sb.append("<name>" + friend.Name + "</name>");
                    sb.append("<head>" + friend.HeadUrl + "</head>");
                    sb.append("</friend>");
                }
            }
        }

        response.setContentType("text/xml;charset=UTF-8");
        try {
            response.getWriter().write(sb.toString());
        } finally {
            response.getWriter().close();
        }
    }

    private void igniteGmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String gmail = request.getParameter("mail");
        String passwd = request.getParameter("passwd");

        //System.out.println(gmail + ":" + passwd);

        StringBuilder sb = new StringBuilder();
        GmailLinker gl = new GmailLinker();
        List<ILinkFriend> friendList = new ArrayList<ILinkFriend>();
        sb.append("<reply>");
        if (gl.getGmailContact(new EmailLinkKey(gmail, passwd), friendList)) {
            for (ILinkFriend friend : friendList) {
                String femail = friend.getEmail().get(0); // only check the first email now.
                IUser fuser = EntityFactory.getUser(femail);
                if (fuser != null ) {
                    String fname= friend.getName();
                    if (fname != null && !fname.equals("null"))
                        sb.append("<contact>" + friend.getName() + "</contact>");
                }
            }
        } else {
            sb.append("<status>ERROR</status>");
        }
        sb.append("</reply>");

        response.setContentType("text/xml;charset=UTF-8");
        try {
            response.getWriter().write(sb.toString());
        } finally {
            response.getWriter().close();
        }
    }

}
