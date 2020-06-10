package com.ims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.bo.CustomerBO;
import com.ims.config.ApplicationConstants;

public class CustomerDAO extends DatabaseConnection {
	private static Logger log = LogManager.getLogger(CustomerDAO.class);
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	/* SQL queries */
	private static final String INSERT_CUSTOMER = "INSERT INTO ims_customer  (customer_firstName, customer_lastName, customer_address, customer_Email, customer_mobileNumber, customer_status, customer_addedDate) VALUES  (?, ?, ?, ?, ?, ?, ?)";
	private static final String ALL_CUSTOMERS = "SELECT customer_id,customer_firstName, customer_lastName, customer_address, customer_Email, customer_mobileNumber, customer_status, customer_addedDate FROM ims_customer";
	private static final String EDIT_CUSTOMER = "SELECT customer_id,customer_firstName, customer_lastName, customer_address, customer_Email, customer_mobileNumber, customer_status FROM ims_customer  where customer_id = ?";
	private static final String DELETE_CUSTOMER = "DELETE FROM ims_customer WHERE customer_id=?";
	private static final String UPDATE_CUSTOEMR = "UPDATE ims_customer SET customer_firstName=?, customer_lastName=?, customer_address=?, customer_Email=?, customer_mobileNumber=?, customer_status=? WHERE customer_id=?";
	
	public int addCustomer(CustomerBO customer) throws SQLException {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		int result = 0;
		try {
			con = getConnection();
			if(con != null)
			{
				ps = con.prepareStatement(INSERT_CUSTOMER);
				ps.setString(1, customer.getFirstName());
				ps.setString(2, customer.getLastName());
				ps.setString(3, customer.getAddress());
				ps.setString(4, customer.getEmail());
				ps.setString(5, customer.getMobileNumber());
				ps.setString(6, customer.getStatus());
				ps.setTimestamp(7, customer.getAddedDate());
				result =  ps.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null)
					ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try {
				if(con != null)
					con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return result;
	}//addCustomer

	public ArrayList<CustomerBO> getAllCustomers() throws SQLException {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		ArrayList<CustomerBO> listBO = null;
		CustomerBO bo = null;
		con = getConnection();
		if(con != null)
		{
			ps = con.prepareStatement(ALL_CUSTOMERS);
			rs = ps.executeQuery();
			
			if(rs != null)
			{
				listBO = new ArrayList<>();
				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					bo = new CustomerBO();
					bo.setCustomerId(rs.getInt(1));
					bo.setFirstName(rs.getString(2));
					bo.setLastName(rs.getString(3));
					bo.setAddress(rs.getString(4));
					bo.setEmail(rs.getString(5));
					bo.setMobileNumber(rs.getString(6));
					bo.setStatus(rs.getString(7));
					bo.setAddedDate(rs.getTimestamp(8));
					listBO.add(bo);
				}
			}
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return listBO;
	}

	public CustomerBO editCustomer(int id) throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		log.info("Received id is:  " + id);
		CustomerBO bo = null;
		con = getConnection();
		try {
			if(con != null)
			{
				ps = con.prepareStatement(EDIT_CUSTOMER);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				
				if(rs != null)
				{
					while (rs.next()) {
						bo = new CustomerBO();
						bo.setCustomerId(rs.getInt(1));
						bo.setFirstName(rs.getString(2));
						bo.setLastName(rs.getString(3));
						bo.setAddress(rs.getString(4));
						bo.setEmail(rs.getString(5));
						bo.setMobileNumber(rs.getString(6));
						bo.setStatus(rs.getString(7));
					}
				}
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return bo;
	}
	
	public int updateCustomer(CustomerBO bo) throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		log.info("Received id is:  " + bo.getCustomerId());
		int updateStatus = 0;
		con = getConnection();
		try {
			if(con != null)
			{
				ps = con.prepareStatement(UPDATE_CUSTOEMR);
				ps.setString(1, bo.getFirstName());
				ps.setString(2,bo.getLastName());
				ps.setString(3, bo.getAddress());
				ps.setString(4, bo.getEmail());
				ps.setString(5,bo.getMobileNumber());
				ps.setString(6, bo.getStatus());
				ps.setInt(7, bo.getCustomerId());
				updateStatus = ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return updateStatus;
	}
	
	public int deleteCustomer(int id) throws Exception {
		log.info(ApplicationConstants.Logging.METHOD_ENTRY_LOG_MESSAGE);
		log.info("Received id is:  " + id);
		CustomerBO bo = null;
		con = getConnection();
		int status = 0;
		try {
			if(con != null)
			{
				ps = con.prepareStatement(DELETE_CUSTOMER);
				ps.setInt(1, id);
				status = ps.executeUpdate();	
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		log.info(ApplicationConstants.Logging.METHOD_EXIT_LOG_MESSAGE);
		return status;
	}
}
