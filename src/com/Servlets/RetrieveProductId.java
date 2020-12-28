package com.Servlets;

import java.io.IOException;
import com.Dao.*;
import com.Product.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrieveProductId
 */
@WebServlet("/RetrieveProductId")
public class RetrieveProductId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveProductId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("ID"));
		
		ProductIdDao productDao = new ProductIdDao();
		
		Product p = productDao.getRecordById(id);
		
		if(p != null)
			response.getWriter().println(p);
		else
			response.getWriter().println("This product is not in the database");
	}

}