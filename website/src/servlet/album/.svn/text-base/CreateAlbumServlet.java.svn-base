/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.album;

/**
 *
 * @author voenix
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.IUser;
import logic.EntityFactory;
import utility.Pair;
import logic.IChannel;
import utility.Constant;
import servlet.ServletCommon;
import servlet.WebpageLayoutParam;

@WebServlet(name = "CreateAlbumServlet", urlPatterns = {"/createAlbum"})
public class CreateAlbumServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sAlbumName = ServletCommon.ajaxChineseTranscoder(request, "name");
        String sDescription = ServletCommon.ajaxChineseTranscoder(request, "description");
        int nUserId = Integer.parseInt(ServletCommon.ajaxChineseTranscoder(request, "uid"));
        IUser iUser = EntityFactory.getUser(nUserId);

        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");

        StringBuilder sb = new StringBuilder();
        PrintWriter out = response.getWriter();

        try {
            final int overflow = 0;
            final int created = 1;
            final int num_created_albums = iUser.getJoinedChannel(WebpageLayoutParam.NUM_TOPLIMIT_ALBUMS).size();
            
            if (num_created_albums < WebpageLayoutParam.NUM_TOPLIMIT_ALBUMS) {
                Pair<Integer, IChannel> cPaire = iUser.setupChannel(sAlbumName);
                Integer result = cPaire.getKey();
                if (result == Constant.DATABASE_INSERT_DUPLICATE) {
                    sb.append("<status>").append(Constant.DATABASE_INSERT_DUPLICATE).append("</status>");
                } else {
                    IChannel new_album = cPaire.getValue();
                    new_album.setAdministratorid(nUserId);
                    new_album.setDescription(sDescription);
                    sb.append("<status>").append(created).append("</status>").append("<cid>").append(new_album.getChannelid()).append("</cid>");
                }
            } else {
                sb.append("<status>").append(overflow).append("</status>").append("<albumtoplimit>").append(WebpageLayoutParam.NUM_TOPLIMIT_ALBUMS).append("</albumtoplimit>");
            }
        } finally {
            out.write("<createreply>" + sb.toString() + "</createreply>");
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
        return "This servlet is used for user creating album";
    }// </editor-fold>
}
