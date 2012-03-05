/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.video;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.EntityFactory;
import logic.IUser;
import logic.IVideo;
import servlet.ServletCommon;
import servlet.ServletConfig;
import utility.Constant;
import utility.Misc;
import utility.Pair;

/**
 *
 * @author sen
 */
@WebServlet(name = "SimpleSubmitServlet", urlPatterns = {"/submitvideo"})
public class SimpleSubmitServlet extends HttpServlet {
    //Sen's variables
    public static final int CONFIRM_SUCCESS = 1000;
    public static final int CONFIRM_PREEMPTED = 1001;
    public static final int CONFIRM_TIMEOUT = 1002;
    public static final int COLLECT_SUCCESS = 1003;

    private VideoWaitingList vwl = new VideoWaitingList(ServletConfig.VIDEO_WAITINGLIST_TIMEOUT);
    //Sen's methods
    protected void submitVideoHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");

        StringBuilder sb = new StringBuilder();
        PrintWriter out = response.getWriter();
        try {
            String videoUrl = request.getParameter("videourl");
            Pair<Integer, IVideo> result = EntityFactory.getVideo(videoUrl);
            Integer status = result.getKey();
            sb.append("<status>").append(status).append("</status>");
            if(status == Constant.SUBMIT_SUCCESS || status == Constant.SUBMIT_BEFORE) {
                IVideo video = result.getValue();
                sb.append("<thumbnail>").append(video.getSnapshotURL()).append("</thumbnail>");
                sb.append("<title>").append(video.getTitle()).append("</title>");
                sb.append("<siteid>").append(video.getSiteSpecificID()).append("</siteid>");
                if (status == Constant.SUBMIT_SUCCESS /*|| video.getFirstSubmitUserid() == ServletCommon.nobodyId*/) {
                    vwl.add(video);
                } else if(status == Constant.SUBMIT_BEFORE) {
                    sb.append("<user>").append(EntityFactory.getUser(video.getFirstSubmitUserid()).getName()).append("</user>");
                    sb.append("<userid>").append(video.getFirstSubmitUserid()).append("</userid>");
                    sb.append("<vid>").append(video.getVideoid()).append("</vid>");
                    sb.append("<time>").append(Misc.pastTime(video.getTime())).append("</time>");
                }
            }
        } finally {
            out.write("<submitreply>" + sb + "</submitreply>");
            out.close();
        }
    }

    protected void confirmSubmitHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");

        StringBuilder sb = new StringBuilder();
        PrintWriter out = response.getWriter();
        try {
            String usertext = ServletCommon.ajaxChineseTranscoder(request, "usertext");
            //this.log(usertext);
            int vid = Integer.parseInt(request.getParameter("vid"));
            if (vid >= 0) { // a valid vid values means video comment.
                IUser user = ServletCommon.getCurrentUser(request.getSession());
                if (!usertext.isEmpty()) {
                    user.addVideoComment(vid, usertext, utility.Constant.VIDEO_COMMENT_COMMON_PARENT_ID);
                }
                user.collectVideo(vid);
                sb.append("<status>").append(COLLECT_SUCCESS).append("</status>");
            } else {  // else it's a submission confirmation
                String siteid = request.getParameter("siteid");
                IVideo video = vwl.retrieve(siteid);
                if(video == null) {
                    sb.append("<status>").append(CONFIRM_TIMEOUT).append("</status>");
                } else {
                    video.setSummary(usertext);
                    int uid = Integer.parseInt(request.getParameter("uid"));
                    IUser user = EntityFactory.getUser(uid);
                    int status = user.submitVideo(video); // video id is set inside submitVideo()
                    user.collectVideo(video.getVideoid());
                    sb.append("<status>").append(CONFIRM_SUCCESS).append("</status>");
                    sb.append("<videoid>").append(video.getVideoid()).append("</videoid>");
                    /*
                    sb.append("<thumbnail>" + video.getSnapshotURL() + "</thumbnail>");
                    sb.append("<title>" + video.getTitle() + "</title>");
                    sb.append("<description>" + video.getSummary() + "</description>");
                    sb.append("<embed>" + StringEscapeUtils.escapeXml(video.getEmbededUrl()) + "</embed>");
                    */
                }
            }
            out.write("<confirmreply>" + sb + "</confirmreply>");
        } finally {
            out.close();
        }
    }

    /*---------------------------------------------------------------------------*/

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int serviceType = Integer.parseInt(request.getParameter("service"));
        switch (serviceType) {
            case 0: //submit video
                submitVideoHandler(request, response);
                break;
            case 1: //confirm submission
                confirmSubmitHandler(request, response);
                break;
            default:
                break;
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
