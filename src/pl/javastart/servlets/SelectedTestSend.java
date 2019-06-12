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


@WebServlet("/SelectedTestSend")
public class SelectedTestSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageTest manageTests = new ManageTest();  
	public Test test;

    public SelectedTestSend() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test_ID = request.getParameter("test_ID");								// pobierz z requesta id testu
        test = manageTests.GetTest(Integer.parseInt(test_ID));							// pobierz test o danym id
        
        request.setAttribute("Test", test);												// zapisz obiekt testu w sesji
        
        request.getRequestDispatcher("SelectedTest.jsp").forward(request, response);	// przekieruj sterowanie do jsp        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
