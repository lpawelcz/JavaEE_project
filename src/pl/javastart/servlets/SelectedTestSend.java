package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.DataSource;
import database.entities.*;	

/**
 * Servlet implementation class SelectedTestSend
 */
@WebServlet("/SelectedTestSend")
public class SelectedTestSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		DataSource ds=new DataSource();
		Test t;
		
		PrintWriter out = response.getWriter();

        String test_ID = request.getParameter("test_ID");
        String url = "/SelectedTest.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        String autor;
        String opis;
        
        out.println("ID wybranego testu:");
        out.println(test_ID);
        out.println("\n");
        t = ds.getTestsDataFromDB().get(Integer.parseInt(test_ID));
        out.println("Autor: " + t.getAuthor().getName()+"\n");
        out.println("Opis: " + t.getDescription().getDescription()+"\n");
        
        autor = t.getAuthor().getName();
        opis = t.getDescription().getDescription();
        
        request.setAttribute("test_ID", test_ID);
        request.setAttribute("autor", autor);
        request.setAttribute("opis", opis); 
        
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
