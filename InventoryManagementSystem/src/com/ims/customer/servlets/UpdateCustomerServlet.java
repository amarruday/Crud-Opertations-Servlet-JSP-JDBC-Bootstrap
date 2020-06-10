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

import com.ims.config.ApplicationConstants;
import com.ims.dto.CustomerDTO;
import com.ims.service.CustomerService;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {

	private static Logger log = LogManager.getLogger(UpdateCustomerServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
	CustomerDTO dto = null;
	CustomerService service = null;
	String msg = null;
	
	try
	{
		dto = new CustomerDTO();
		dto.setCustomerId(Integer.parseInt(request.getParameter("id")));
		dto.setFirstName(request.getParameter("firstName"));
		dto.setLastName(request.getParameter("lastName"));
		dto.setAddress(request.getParameter("address"));
		dto.setEmail(request.getParameter("email"));
		dto.setMobileNumber(request.getParameter("phone"));
		dto.setStatus(request.getParameter("status"));
		
		if(dto != null)
		{
			service = new CustomerService();
			msg = service.updateCustomer(dto);
			
			if(msg.equals("SUCCESS"))
			{
				request.setAttribute("UPDATESUCCESS", "Your record - ( " + dto.getFirstName() + " " + dto.getLastName() + " ) Updated Succssfully..!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/getAllCustomers");
				dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("UPDATEFAILURE", "Failed to update Your record - ( " + dto.getFirstName() + " " + dto.getLastName());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/getAllCustomers");
				dispatcher.forward(request, response);
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
