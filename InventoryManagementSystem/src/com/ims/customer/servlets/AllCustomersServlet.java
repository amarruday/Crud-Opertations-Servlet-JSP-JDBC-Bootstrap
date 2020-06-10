package com.ims.customer.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.config.ApplicationCommonReturnObject;
import com.ims.config.ApplicationConstants;
import com.ims.dto.CustomerDTO;
import com.ims.service.CustomerService;

@WebServlet("/getAllCustomers")
public class AllCustomersServlet extends HttpServlet {
	private static Logger log = LogManager.getLogger(AllCustomersServlet.class);

	private CustomerDTO dto = null;
	private CustomerService service = null;
	private ApplicationCommonReturnObject commonReturnObject = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		service = new CustomerService();
		try {
			commonReturnObject = service.getAllCustomer();
			if (commonReturnObject.getOperationStatus() != null && commonReturnObject.getOperationStatus()
					.equals(ApplicationConstants.ReturnObjectDefaults.OPERATION_STATUS_SUCCESS)) {
				ArrayList<CustomerDTO> listDTO = new ArrayList<>();
				listDTO = (ArrayList<CustomerDTO>) commonReturnObject
						.getReturnMapValue(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_LIST);
				request.setAttribute(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_LIST, listDTO);
				request.setAttribute(ApplicationConstants.CustomerDefaults.STATUS,
						commonReturnObject.getOperationStatus());
				request.setAttribute(ApplicationConstants.CustomerDefaults.MESSAGE, commonReturnObject.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomers.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute(ApplicationConstants.CustomerDefaults.STATUS,
						commonReturnObject.getOperationStatus());
				request.setAttribute(ApplicationConstants.CustomerDefaults.MESSAGE, commonReturnObject.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomers.jsp");
				dispatcher.forward(request, response);
			}
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
