package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello World!");
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/form.do");
		rd.forward(request, response);
     }
	
	@Override
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	    out.println("Hello POST");  
	    java.util.Enumeration<java.lang.String> data = request.getParameterNames();
	    while (data.hasMoreElements()) {
	    	String name = data.nextElement();
	    	out.println("DATA :" + name + " , " + request.getParameter(name));
	    }
	}
}
