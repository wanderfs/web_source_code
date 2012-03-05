/*
 * Simple servlet that handles user uploaded files
 */

package servlet.upload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import servlet.ServletConfig;

/**
 *
 * @author sen
 */
@WebServlet(name="SimpleUploadServlet", urlPatterns={"/upload"})
public class SimpleUploadServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.getLogger(SimpleUploadServlet.class.getSimpleName()).log(Level.INFO, "creating thumbnail directory...");
        File thumbnail_dir = new File(ServletConfig.THUMBNAIL_ROOT_DIR);
        if (!thumbnail_dir.exists())
            thumbnail_dir.mkdirs();
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
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        // Create a factory for disk-based file items
        FileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Parse the request
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            Logger.getLogger(SimpleUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Process the uploaded items
        Iterator iter = items.iterator();
        String filename = null;
        String category = null;
        FileItem fileItem = null;
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()) {
                if (item.getFieldName().equals("fname"))
                    filename = item.getString();
                else if (item.getFieldName().equals("category"))
                    category = item.getString();
            } else {
                fileItem = item;
            }
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(ServletConfig.THUMBNAIL_ROOT_DIR).append('/').append(category).append('/');
            File dirs = new File(sb.toString());
            if (!dirs.exists()) {
                dirs.mkdirs();
            }
            fileItem.write(new File(sb.append(filename).toString()));
        } catch (Exception ex) {
            Logger.getLogger(SimpleUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

