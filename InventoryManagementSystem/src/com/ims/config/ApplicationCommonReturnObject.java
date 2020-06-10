package com.ims.config;

import java.util.HashMap;

public class ApplicationCommonReturnObject {
	private String operationStatus = null;
	  private String reasonCode = null;
	  private String[] reasonCodeArgs = {};
	  private String extraInfo = null;
	  private String message = null;
	  private HashMap<String, Object> returnMap = null;

	  public ApplicationCommonReturnObject()
	  {
	    this.operationStatus = ApplicationConstants.ReturnObjectDefaults.OPERATION_STATUS_DEFAULT;
	    this.reasonCode = ApplicationConstants.ReturnObjectDefaults.REASON_CODE_DEFAULT;
	    this.extraInfo = "";
	    this.message = ApplicationConstants.ReturnObjectDefaults.MESSAGE_DEFAULT;
	    this.returnMap = new HashMap<String, Object>();
	  }

	  public String getOperationStatus ()
	  {
	    return this.operationStatus;
	  }

	  public void setOperationStatus (String operationStatus)
	  {
	    this.operationStatus = operationStatus;
	  }

	  public String getReasonCode ()
	  {
	    return this.reasonCode;
	  }

	  public void setReasonCode (String reasonCode)
	  {
	    this.reasonCode = reasonCode;
	  }

	  public String[] getReasonCodeArgs ()
	  {
	    return reasonCodeArgs;
	  }

	  public void setReasonCodeArgs (String[] reasonCodeArgs)
	  {
	    this.reasonCodeArgs = reasonCodeArgs;
	  }

	  public String getMessage ()
	  {
	    return this.message;
	  }

	  public void setMessage (String message)
	  {
	    this.message = message;
	  }

	  public HashMap<String, Object> getReturnMap ()
	  {
	    return this.returnMap;
	  }

	  public void setReturnMap (HashMap<String, Object> returnMap)
	  {
	    this.returnMap = returnMap;
	  }

	  public Object getReturnMapValue (String key)
	  {
	    return this.returnMap.get(key);
	  }

	  public void setReturnMapValue (String key, Object objValue)
	  {
	    this.returnMap.put(key, objValue);
	  }

	  public String getExtraInfo ()
	  {
	    return this.extraInfo;
	  }

	  public void setExtraInfo (String extraInfo)
	  {
	    this.extraInfo = extraInfo;
	  }
}
