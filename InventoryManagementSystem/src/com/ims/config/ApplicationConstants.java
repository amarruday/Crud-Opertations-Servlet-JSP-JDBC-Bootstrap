package com.ims.config;

public interface ApplicationConstants
{
  public interface SessionManagement
  {
    public static final String USER_SESSION_INFO = "USER-SESSION-INFO";
  }

  public interface AppDefaults
  {
    public static final String DEFAULT_DESTINATION = "genericError";
    
    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_INACTIVE = "Inactive";
  }

  public interface Logging
  {
    public static final String METHOD_ENTRY_LOG_MESSAGE = "Safely Entered.";
    public static final String METHOD_EXIT_LOG_MESSAGE = "Safely Exited.";
  }

  public interface ExceptionMessages
  {
    public static final String MESSAGE_SYSTEM_EXCEPTION = "A Generic System Exception has occured, Please try after some time.";
    public static final String MESSAGE_DB_CONNECTION_EXCEPTION = "Connectivity with the database could not be established, Please try after some time.";
    public static final String MESSAGE_DB_EXCEPTION = "A Database Exception has occured, Please try after some time.";
  }

  public interface ReturnObjectDefaults
  {
    public static final String OPERATION_STATUS_SUCCESS = "SUCCESS";
    public static final String OPERATION_STATUS_FAILURE = "FAILURE";
    public static final String OPERATION_STATUS_INPROCESS = "INPROCESS";
    public static final String OPERATION_STATUS_DEFAULT = ReturnObjectDefaults.OPERATION_STATUS_FAILURE;
    public static final String MESSAGE_DEFAULT = "Operation failed";
    public static final String MESSAGE_INVALID_SESSION = "Your current session has either timed out due to inactivity or you have not logged in. You will now be redirected to the logout screen. You can again login into the application using the Launch Application option on the main window.";
    public static final String REASON_CODE_DEFAULT = "NO-REASON-CODE";
    public static final String REASON_CODE_INCORRECT_INPUT_PARAMS = "INCORRECT_INPUT_PARAMS";
    public static final String REASON_CODE_GENERIC_ERROR = "GENERIC-ERROR";
    public static final String REASON_CODE_LOGOUT = "LOGOUT";
  }

  public interface ErrorMessages
  {
    
  }

  
  public interface EmailDefaults
  {
    public static final String SMTP_HOST_NAME = "smtp.gmail.com";
    public static final String SMTP_AUTH_USER = "amarruday@gmail.com";
    public static final String SMTP_AUTH_PWD = "testingOIBC";
    public static final String SMTP_PORT_NUMBER = "587";
    public static final String MAIL_TRANSPORT_PROTOCOL = "smtp";
    //public static final String DEFAULT_CC_RECEIVER_EMAIL_ID = "ananda.c@obeliskinfo.com";     //TODO comment it while live
    //public static final String DEFAULT_SENDER_EMAIL_ID = "ananda.c@obeliskinfo.com";
  }

  /*public interface VisitorDefaults
  {
    public static final String COOKIE_NAME_FOR_FINRAE_VISITOR = "finare_visitor";
    public static final String VISITOR_STATUS_INPROGRESS = "Inprogress";
    public static final String VISITOR_STATUS_ACTIVATED = "Activated";
    public static final String SITE_USER = "user";
    public static final BigDecimal TOTAL_POINTS = new BigDecimal("52.00"); 
    public static final int COOKIE_MAX_AGE = 7776000; // i.e 60*60*24*90 for 90 days  
	public static final String VISITOR_TYPE_RETAIL_CUSTOMER = "Retail Customer";
    public static final String VISITOR_TYPE_DISTRIBUTOR = "Distributor";	
  }*/
  
  public interface CustomerDefaults
  {
	  public static final String ADD_CUSTOMER_SUCCESS = "";
	  public static final String ADD_CUSTOMER_SUCCESS_MSG = "Customer added successfully..!";
	  
	  public static final String ADD_CUSTOMER_FAILURE = "";
	  public static final String ADD_CUSTOMER_FAILURE_MSG = "Fail to add customer, Please try again..!";
	  public static final String ALL_CUSTOMER_SUCCESS = "Record(s) found..!";
	  public static final String ALL_CUSTOMER_FAILURE = "No Record(s) found..!";	  
	  public static final String ALL_CUSTOMER_LIST = "CUSTOMER_LIST";
	  public static final String STATUS = "";
	  public static final String MESSAGE = "";
  }
}