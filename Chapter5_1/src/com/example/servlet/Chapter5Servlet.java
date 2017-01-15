package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;

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
       
       out.println("<h3>java.util.Enumeration e = getServletConfig().getInitParameterNames();</h3><br>");
       // public java.util.Enumeration getInitParameterNames() returns the names of the servlet's 
       // initialization parameters as an Enumeration of String objects, or an empty Enumeration if the
       // servlet has no initialization parameters.
       Enumeration enumeration = this.getServletConfig().getInitParameterNames();
       while (enumeration.hasMoreElements()) {
           out.println("<br>param name = " + enumeration.nextElement() + "<br>");
       }
       // its good idea to save object like this if you want to use more:
       ServletConfig servletConfig = this.getServletConfig();
       
       // Returns a reference to the ServletContext in which the caller is executing:
       ServletContext servletContext = servletConfig.getServletContext();
       
       // now we get getInitParameter() same style method but this time we calling from context
       // from whole app only one is per application, so you have to look in contex-param tag
       // which are NOT in servlet tag :
       String city = servletContext.getInitParameter("City");
       out.println("<hr><h3>getServletContext() we get ServletContext object, we can get from ServletConfig object</h3>");
       out.println("<br><i>From ServletContext object we want get initParam from whole app not just from servlet<i><br>");
       out.println("<b>web_app_context initParam City = " + city + "</b>");
       
       // simply get servlet name from this servlet tag:
       String servlet_name = servletConfig.getServletName();
       out.println("<hr><br>from ServletConfig method getServletName():<br>");
       out.println("<i>Servlet name is</i><b> " + servlet_name + "</b>");
       
       out.println("</body></html>");
  }
  public void doPost(HttpServletRequest request, 
		  HttpServletResponse response)throws ServletException,IOException{
	  
  }
}
