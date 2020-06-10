package com.ims.customer.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.config.ApplicationConstants;
import com.ims.dto.CustomerDTO;
import com.ims.service.CustomerService;

@WebServlet("/deleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {

	private static Logger log = LogManager.getLogger(DeleteCustomerServlet.class);
	private CustomerDTO dto = null;
	private CustomerService service = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		String msg = "";

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// call service
			service = new CustomerService();
			msg = service.deleteCustomer(id);
			response.setContentType("text/plain");

			
			if (msg.equals("SUCCESS"))
				response.getWriter().write("SUCCESS");
			else
				response.getWriter().write("FAILURE");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
