package com.ims.customer.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.config.ApplicationCommonReturnObject;
import com.ims.config.ApplicationConstants;
import com.ims.dto.CustomerDTO;
import com.ims.service.CustomerService;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(AddCustomerServlet.class);

	private CustomerDTO dto = null;
	private CustomerService service = null;
	private ApplicationCommonReturnObject commonReturnObject = null;
	HttpSession session = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		dto = new CustomerDTO();
		service = new CustomerService();

		try {
			dto.setFirstName(request.getParameter("firstName"));
			dto.setLastName(request.getParameter("lastName"));
			dto.setAddress(request.getParameter("address"));
			dto.setEmail(request.getParameter("email"));
			dto.setMobileNumber(request.getParameter("phone"));
			dto.setStatus(request.getParameter("status"));

			commonReturnObject = service.addCustomer(dto);

			if (commonReturnObject != null && commonReturnObject.getOperationStatus()
					.equals(ApplicationConstants.ReturnObjectDefaults.OPERATION_STATUS_SUCCESS)) {
				log.info(commonReturnObject.getOperationStatus());
				log.info(commonReturnObject.getMessage());
				// session = request.getSession();
				request.setAttribute("ADDSUCCESS", ApplicationConstants.CustomerDefaults.ADD_CUSTOMER_SUCCESS_MSG);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/getAllCustomers");
				dispatcher.forward(request, response);
				// response.sendRedirect("localhost:8080/InventoryManagementSystem/manageCustomer?nextStep=viewAllCustomers");
			} else {
				log.info(commonReturnObject.getOperationStatus());
				log.info(commonReturnObject.getMessage());

				request.setAttribute("ADDFAILURE", ApplicationConstants.CustomerDefaults.ADD_CUSTOMER_FAILURE_MSG);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/getAllCustomers");
				dispatcher.forward(request, response);
				// response.sendRedirect("localhost:8080/InventoryManagementSystem/manageCustomer?nextStep=viewAllCustomers");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response.sendRedirect("list");
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
