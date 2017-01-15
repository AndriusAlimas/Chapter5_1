package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Chapter5Servlet extends HttpServlet {
  public void doGet(HttpServletRequest request, 
		  HttpServletResponse response)throws ServletException,IOException{
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   
	   out.println("<html>");
       out.println("<head><title>Test ServletConfig()</title></head>");
       out.println("<body><h3>getServletConfig().getInitParameter(\"adminEmail\"):</h3><br>");
       out.println("</body></html>");
  }
  public void doPost(HttpServletRequest request, 
		  HttpServletResponse response)throws ServletException,IOException{
	  
  }
}
