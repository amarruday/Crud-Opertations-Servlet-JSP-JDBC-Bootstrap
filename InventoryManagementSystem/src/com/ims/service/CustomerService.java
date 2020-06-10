package com.ims.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.bo.CustomerBO;
import com.ims.config.ApplicationCommonReturnObject;
import com.ims.config.ApplicationConstants;
import com.ims.dao.CustomerDAO;
import com.ims.dto.CustomerDTO;
import com.ims.utility.DateUtility;

public class CustomerService {
	private static Logger log = LogManager.getLogger(CustomerService.class);
	private CustomerDAO dao = null;
	private CustomerBO bo = null;
	private CustomerDTO dto = null;

	public ApplicationCommonReturnObject addCustomer(CustomerDTO dto) throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		ApplicationCommonReturnObject commonReturnObject = null;
		int result = 0;
		try {
			bo = new CustomerBO();

			bo.setFirstName(dto.getFirstName().trim());
			bo.setLastName(dto.getLastName().trim());
			bo.setAddress(dto.getAddress().trim());
			bo.setEmail(dto.getEmail().trim().toLowerCase());
			bo.setMobileNumber(dto.getMobileNumber().trim());
			bo.setStatus(dto.getStatus().trim());
			bo.setAddedDate(DateUtility.getCurrentTimestamp());

			if (bo != null) {
				dao = new CustomerDAO();
				result = dao.addCustomer(bo);
				commonReturnObject = new ApplicationCommonReturnObject();
				if (result == 1) {
					commonReturnObject
							.setOperationStatus(ApplicationConstants.ReturnObjectDefaults.OPERATION_STATUS_SUCCESS);
					commonReturnObject.setMessage(ApplicationConstants.CustomerDefaults.ADD_CUSTOMER_SUCCESS_MSG);
				} else {
					commonReturnObject
							.setOperationStatus(ApplicationConstants.ReturnObjectDefaults.OPERATION_STATUS_FAILURE);
					commonReturnObject.setMessage(ApplicationConstants.CustomerDefaults.ADD_CUSTOMER_FAILURE_MSG);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return commonReturnObject;
	}// addCustomer

	public ApplicationCommonReturnObject getAllCustomer() throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		ApplicationCommonReturnObject commonReturnObject = null;
		ArrayList<CustomerDTO> listDTO = null;
		CustomerDTO dto = null;
		ArrayList<CustomerBO> listBO = null;

		try {
			// copy data to new list
			dao = new CustomerDAO();
			listBO = dao.getAllCustomers();

			if (listBO != null) {
				listDTO = new ArrayList<>();
				for (int i = 0; i < listBO.size(); i++) {
					dto = new CustomerDTO();
					dto.setCustomerId(listBO.get(i).getCustomerId());
					dto.setFirstName(listBO.get(i).getFirstName());
					dto.setLastName(listBO.get(i).getLastName());
					dto.setAddress(listBO.get(i).getAddress());
					dto.setEmail(listBO.get(i).getEmail());
					dto.setMobileNumber(listBO.get(i).getMobileNumber());
					dto.setStatus(listBO.get(i).getStatus());
					dto.setSince(DateUtility.TimeStampToDate(listBO.get(i).getAddedDate()));
					dto.setAddedDate(listBO.get(i).getAddedDate());
					listDTO.add(dto);
				}
				commonReturnObject = new ApplicationCommonReturnObject();
				if (listDTO != null) {
					commonReturnObject
							.setOperationStatus(ApplicationConstants.ReturnObjectDefaults.OPERATION_STATUS_SUCCESS);
					commonReturnObject.setMessage(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_SUCCESS);
					commonReturnObject.setReturnMapValue(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_LIST,
							listDTO);
				}

			} else {
				commonReturnObject
						.setOperationStatus(ApplicationConstants.ReturnObjectDefaults.OPERATION_STATUS_FAILURE);
				commonReturnObject.setMessage(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_FAILURE);
			}
		} catch (Exception e) {
			throw e;
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return commonReturnObject;
	}

	public CustomerDTO editCustomer(int id) throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		dto = new CustomerDTO();
		try {
			dao = new CustomerDAO();
			bo = dao.editCustomer(id);
			if (bo != null) {
				dto.setCustomerId(bo.getCustomerId());
				dto.setFirstName(bo.getFirstName());
				dto.setLastName(bo.getLastName());
				dto.setAddress(bo.getAddress());
				dto.setEmail(bo.getEmail());
				dto.setMobileNumber(bo.getMobileNumber());
				dto.setStatus(bo.getStatus());
			}
		} catch (Exception e) {
			throw e;
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return dto;
	}

	public String deleteCustomer(int id) throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		int status = 0;
		String msg = "FAILURE";
		try {
			// call DAO
			dao = new CustomerDAO();
			status = dao.deleteCustomer(id);
			if (status > 0)
				msg = "SUCCESS";
			else
				msg = "FAILURE";
		} catch (Exception e) {
			throw e;
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return msg;
	}

	public String updateCustomer(CustomerDTO dto) throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		int updateStatus = 0;
		String msg = "FAILURE";
		CustomerBO bo = null;
		try {
		bo = new CustomerBO();
		bo.setCustomerId(dto.getCustomerId());
		bo.setFirstName(dto.getFirstName());
		bo.setLastName(dto.getLastName());
		bo.setAddress(dto.getAddress());
		bo.setEmail(dto.getEmail());
		bo.setMobileNumber(dto.getMobileNumber());
		bo.setStatus(dto.getStatus());
		
		dao = new CustomerDAO();
		 updateStatus = dao.updateCustomer(bo);
		if(updateStatus > 0)
			msg = "SUCCESS";
		else
			msg = "FAILURE";
		}
		catch(Exception e)
		{
			throw e;
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return msg;
	}
}
