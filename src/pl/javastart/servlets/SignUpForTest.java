package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpForTest")
public class SignUpForTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user_ID = request.getParameter("user_ID");								// pobierz z requesta id testu
        
		out.print("Hello World " + user_ID);
		
		//request.getRequestDispatcher("Tests.jsp").forward(request, response);
	}
}