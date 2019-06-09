package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.entities.Test;	//import wszystkich klas z bazy danych
import Manage.ManageTest;

/**
 * Servlet implementation class SelectedTestSend
 */
@WebServlet("/SelectedTestSend")
public class SelectedTestSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageTest manageTests = new ManageTest();  
	public Test test;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedTestSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request.setAttribute("test_id", 1);
		//request.getRequestDispatcher("Bashownik/SelectedTest.jsp").forward(request, response);
		
		//PrintWriter out = response.getWriter();

        String test_ID = request.getParameter("test_ID");
        test = manageTests.GetTest(Integer.parseInt(test_ID));
        //out.println("ID wybranego testu:");
        //out.println(test_ID);
        
        request.setAttribute("Test", test);

        // Forward to to the JSP file.
        request.getRequestDispatcher("SelectedTest.jsp").forward(request, response);
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
