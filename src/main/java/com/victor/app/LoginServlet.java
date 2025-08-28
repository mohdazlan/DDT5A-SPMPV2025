package com.victor.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>i-Daftar</h1>");
		// 2 label, 2 input, 1 button
		out.println("<form action='login' method='post'>");
		out.println("<label>User Name</label>");
		out.println("<input name='username' type='text' required><br><br>");
		out.println("<label> Password</label>");
		out.println("<input name='password' type='password' required><br><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String userString = request.getParameter("username");
		String passString = request.getParameter("password");
		
		String VALIDuserString = "user";
		String vALIDpassString = "pass";
		
		if(userString.equals(VALIDuserString) && passString.equals(vALIDpassString)){
			HttpSession session = request.getSession();
			session.setAttribute("namaPengguna", VALIDuserString);
			response.sendRedirect("welcome");
		} else {
			response.sendRedirect("error.html");
		}
	}

}
