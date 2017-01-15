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
       // when you are become Servlet object remeber servlet life cycle with constructor and init method
       // so This getServletConfig() method come from Servlet interface, so using this you can
       // get servlet config object, and using that object you can get init parameter which are 
       // always set in DD inside <servlet> when we talking about servlet init parameter, no where
       // else can be set. method getInitParamter(String): String :
       out.println("<i>" + this.getServletConfig().getInitParameter("adminEmail") + "</i><hr>");
       out.println("<body><h3>getServletConfig().getInitParameter(\"otherEmail\"):</h3><br>");
       out.println("<i>" + this.getServletConfig().getInitParameter("otherEmail") + "</i><hr>");
       out.println("</body></html>");
  }
  public void doPost(HttpServletRequest request, 
		  HttpServletResponse response)throws ServletException,IOException{
	  
  }
}
