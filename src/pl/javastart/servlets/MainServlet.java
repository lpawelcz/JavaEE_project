package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cssTag="<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />";
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>\r\n" + 
				"	<meta charset=\"utf-8\" />\r\n" + 
				"	<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n" + 
				"	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>\r\n" + 
				"	<link href=\"kurs_css3/css/fontello.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n" + 
				"	<title>Rejestracja</title>\r\n" + 
				"</head>\r\n" + 
				"<body> \r\n" + 
				"<div class=\"wrapper\">\r\n" + 
				"\r\n" + 
				"	<div class=\"header\">\r\n" + 
				"		<div class=\"logo\">\r\n" + 
				"			<span style=\"color: #c34f4f\">Bash</span>ownik\r\n" + 
				"			<div style=\"clear:both;\"></div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	\r\n" + 
				"	<div class=\"nav\">\r\n" + 
				"		<ol>\r\n" + 
				"				<li><a href=\"http://localhost:8080/Bashownik/\">Strona glowna</a></li>\r\n" + 
				"				<li><a href=\"http://localhost:8080/Bashownik/Login.jsp\">Zaloguj</a></li>\r\n" + 
				"				<li><a href=\"http://localhost:8080/Bashownik/Register.jsp\">Rejestracja</a></li>\r\n" + 
				"		</ol>\r\n" + 
				"	</div>" +
				"   <div class=\"content\">");
		out.append("<form action=\"http://localhost:8080/Bashownik/Register.jsp\">\r\n" + 
				"    <input type=\"submit\" value=\"Rejestracja\" />\r\n" + 
				"</form>" + 
				"<form action=\"http://localhost:8080/Bashownik/Login.jsp\">\r\n" + 
				"    <input type=\"submit\" value=\"Logowanie\" />\r\n" + 
				"</form>"
				);
		out.println("</div>\r\n" +
				"</div>\r\n" +
				"</body>\r\n" + 
				"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
