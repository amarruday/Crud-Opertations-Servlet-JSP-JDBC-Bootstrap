package com.ims.customer.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.dto.CustomerDTO;
import com.ims.service.CustomerService;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/editCustomer")
public class EditCustomerServlet extends HttpServlet {

	private static Logger log = LogManager.getLogger(AddCustomerServlet.class);

	private CustomerDTO dto = null;
	private CustomerService service = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if (id > 0) {
				service = new CustomerService();
				dto = service.editCustomer(id);
				if(dto != null)
				{
					request.setAttribute("edit", dto);
					RequestDispatcher dispatcher = request.getRequestDispatcher("editCustomer.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

