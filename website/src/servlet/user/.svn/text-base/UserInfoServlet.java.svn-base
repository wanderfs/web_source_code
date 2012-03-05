/*
 * modify user's info
 */
package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "UserInfoServlet", urlPatterns = {"/uinfo"})
public class UserInfoServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IUser user = ServletCommon.getCurrentUser(request.getSession());
        boolean error = false;
        try {
            String name = request.getParameter("name");
            if (name != null && !name.isEmpty()) {
                name = new String(name.getBytes("iso-8859-1"), "UTF-8");
                user.setName(name);
            }

            String email = request.getParameter("email");
            if (email != null && !email.isEmpty()) {
                user.setEmail(email);
            }

            String city = ServletCommon.ajaxChineseTranscoder(request, "city");
            String province = ServletCommon.ajaxChineseTranscoder(request, "province");
            if (province != null && !province.isEmpty()) {
                if (city != null) {
                    user.setLocation(province + "|" + city);
                } else {
                    user.setLocation(province + "|");
                }
            }

            String gender = ServletCommon.ajaxChineseTranscoder(request, "gender");
            if (gender != null && !gender.isEmpty()) {
                user.setGender(gender);
            }

            Date date = new Date();
            boolean isSet = false;
            int year = 0;
            int month = 0;
            int day = 0;
            //yyyy-mm-dd
            String yearString = request.getParameter("year");
            if (yearString != null && !yearString.isEmpty()) {
                year = Integer.parseInt(yearString);
                isSet = true;
            }
            String monthString = request.getParameter("month");
            if (monthString != null && !monthString.isEmpty()) {
                month = Integer.parseInt(monthString);
                isSet = true;
            }
            String dayString = request.getParameter("day");
            if (dayString != null && !dayString.isEmpty()) {
                day = Integer.parseInt(dayString);
                isSet = true;
            }
            if (isSet) {
                Calendar c = Calendar.getInstance();
                c.set(year, month - 1, day);
                user.setBirthday(c.getTime());
            }

            String motto = request.getParameter("motto");
            if (motto != null && !motto.isEmpty()) {
                motto = new String(motto.getBytes("iso-8859-1"), "UTF-8");
                this.log("motto: " + motto);
                user.setDescription(motto);
            }

            String password = request.getParameter("password");
            if (password != null && !password.isEmpty()) {
                user.setPassword(password);
            }

            String photo = request.getParameter("photo");
            if (photo != null && !photo.isEmpty()) {
                user.setPhoto("pic/face/" + photo + "160.png");
                user.setPhotoMedium("pic/face/" + photo + "75.png");
                user.setPhotoSmall("pic/face/" + photo + "45.png");
                user.setPhotoMini("pic/face/" + photo + "25.png");
            }
            // String df = request.getParameter("default_portrait");
            // if (df != null && !df.isEmpty())
            //   user.s
            System.out.println(this.getClass().getName() + ": " + user);
            user.commit();
        } catch (Exception e) {
            error = true;
        }

        if (!error) {
            //response.sendRedirect("iweishi2.0/home.jsp?uid=" + user.getUserid());
        }

        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (error) {
                out.write("<status>ERROR</status>");
            } else {
                out.write("<status>OK</status>");
            }
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
