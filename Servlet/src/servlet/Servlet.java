/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    private static final long serialVersionUID= 1L;
    
    public Servlet() {       
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();      
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Debug Page</title></head>");
         out.println("<body>");
         out.println("<h1>Student Registration Debug Page</h1>");
         out.println("<h2>Please enter Username and Password</h2>");
         out.println("<form method=\"POST\">");
         out.println("<label for=\"user\">Username:</label>");
         out.println("<input type=\"text\" name=\"user\"> ");
         out.println("<label for=\"pw\">Password:</label>");
         out.println("<input type=\"text\" name=\"pw\">");
         out.println("<input type=\"submit\" value=\"Submit\">");
         out.println("<form>");
         out.println("</body>");
         out.println("</html>");       
    } 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if ( "admin".equals(request.getParameter("user")) && "abc123".equals(request.getParameter("pw")) ){       
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Debug Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Thank you </h3>");
        out.println("<p>Student Name: Jon Lester </p>");
        out.println("<p>Student Id: S153491 </p>");
        out.println("<p>Student Email: les13010@byui.edu</p>");
        out.println("<p>Class List: CIT 360 - CIT 495</p>");
        out.println("</body>");
        out.println("</html>");
        } else {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Failed</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Username and Password not Recognized!</h3>");
        out.println("</body>");
        out.println("</html>");
        }
        
    }
}
