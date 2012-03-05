/*
 * lookup video info by giving vid or other keywords
 */

package servlet.feed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.EntityFactory;

/**
 *
 * @author Sen
 */
@WebServlet(name="VideoFeedServlet", urlPatterns={"/vfeed"})
public class VideoFeedServlet extends HttpServlet {

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
        int vid = new Random().nextInt(30000); // random sample in first 30K videos
        String svid = request.getParameter("vid");
        if ( svid != null)
            vid = Integer.parseInt(svid);

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.write(EntityFactory.getVideo(vid).toJSONString());
        } catch (NullPointerException e) {
            // exception means this video doesn't exist
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
