/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.album;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.AD;
import logic.EntityFactory;
import logic.IChannel;
import net.sf.json.JSONObject;
import servlet.ServletCommon;

/**
 *
 * @author sen
 */
@WebServlet(name="AlbumUpdateAd", urlPatterns={"/updateAlbumAd"})
public class AlbumUpdateAd extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String adname = ServletCommon.ajaxChineseTranscoder(request, "adname");
            String adlink = request.getParameter("adlink").trim();
            if (!adlink.startsWith("http://"))
                adlink = "http://" + adlink;
            int aid = Integer.parseInt(request.getParameter("aid"));
            IChannel album = EntityFactory.getGroup(aid);
            AD ad = EntityFactory.getAD(adname, adlink);
            album.addAd(ad);
            JSONObject jobj = new JSONObject();
            jobj.put("status", "OK");
            //System.out.println(jobj.toString());
            out.write(jobj.toString());
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
