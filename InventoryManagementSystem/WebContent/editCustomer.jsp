<%@page import="com.ims.config.ApplicationConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import = "com.ims.*" %>
	 <%@ page import = "java.util.*" %>
	 <%@ page import = "com.ims.dto.*" %>
 <jsp:include page="header.jsp"></jsp:include>
 <style>
 	.error {
 		font-weight: normal;
 		font-size: 15px;
 	}
 	label:not(.form-check-label):not(.custom-file-label) {
    font-weight: 400;
}
 .alerts
 {
 	width: 40%;
	margin-left: 30%;
 }
 </style>
 <!-- SELECT2 EXAMPLE -->
 
 <br>
 
 <%
 	CustomerDTO dto = (CustomerDTO) request.getAttribute("edit");
 %>
 
 <%
 	if(dto != null) {
 %>
 		
  <div class="container-fluid" style="margin-top:10px;">
        <div class="card card-info">
          <div class="card-header">
            <h3 class="card-title">Edit Customer</h3>

            <div class="card-tools">
              <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
              <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-remove"></i></button>
            </div>
          </div>
          <!-- /.card-header -->
          <div class="card-body">
          <form id="updateCustomerForm" name="updateCustomerForm">
            <div class="row">        
              <div class="col-md-6">
                <div class="form-group">
                  <input type="hidden" name="id" value="<%=dto.getCustomerId()%>" />
                  <input type="text" id="firstName" class="form-control" name="firstName" placeholder="First Name"  value="<%=dto.getFirstName()%>">
                </div>
              </div>
              <div class="col-md-6"> 
               <div class="form-group">
                  <input type="text" id="lastName" class="form-control" name="lastName" placeholder="Last Name" value="<%=dto.getLastName()%>">
                </div>              
              </div>            
            </div> 
            
            <div class="row">
             <div class="col-md-6">
              <div class="form-group">
               <input  type="email" id="email" class="form-control" name="email" placeholder="Email Address" value="<%=dto.getEmail()%>">
              </div>
             </div>
             <div class="col-md-6">
              <div class="form-group">
               <input  type="text" id="phone" class="form-control" name="phone" placeholder="Mobile Number"  value="<%=dto.getMobileNumber()%>">
              </div>
             </div>
            </div>
            
            <div class="row">
             <div class="col-md-6">
              <div class="form-group">
               <select id="status" name="status" class="form-control select2" style="width: 100%;">
                    <option val="-1">Select Status</option>
                    <%
						if(dto.getStatus().equals(ApplicationConstants.AppDefaults.STATUS_ACTIVE))
						{
                    %>
                    <option val="<%=ApplicationConstants.AppDefaults.STATUS_ACTIVE%>" selected="selected">Active</option>
                    <option val="<%=ApplicationConstants.AppDefaults.STATUS_INACTIVE %>">Inactive</option>
                    <%
						} else {                    
                    %>
                    <option val="<%=ApplicationConstants.AppDefaults.STATUS_ACTIVE%>">Active</option>
                    <option val="<%=ApplicationConstants.AppDefaults.STATUS_INACTIVE %>" selected="selected">Inactive</option>
                    <%
						}
                    %>
                  </select>
              </div>
             </div>
             <div class="col-md-6">
              <div class="form-group">
               <textarea id="address" class="form-control" name="address" placeholder="Address" ><%=dto.getAddress()%></textarea>
              </div>
             </div>
            </div>
            <div style="text-align:center">
             <button type="button" class="btn .btn-sm btn-outline-primary" onclick="javascript:add()">Update</button>
            </div>
            </form>
         </div>
          <!-- /.card-body -->
        </div>
        <!-- /.card -->
</div>
<%
	}
 %>
        <!-- SELECT2 EXAMPLE -->
 <jsp:include page="footer.jsp"></jsp:include>
 <script>
 $(document ).ready(function() {
   
	 $('#updateCustomerForm').validate({
		  rules: {
		    firstName: 'required',
		    lastName : 'required',
		    email: {
		    required: true,
		      email: true,
		    },
		    address: {
		      required: true,
		      minlength: 5,
		    },
		   phone : {
			   required : true,
		       minlength : 10,
		       maxlength : 10,
		       number : true
		      }
		  
		   },
		  messages: {
		    firstName: 'This field is required',
		    lastName: 'This field is required',
		    email: {
		    	required : 'Enter a valid email',
		    	email : 'Enter a valid email'
		    },
		    address : {
		      	required : 'Address is required',
		    	minlength: 'Address must be at least 5 characters long'
		    },
		    phone : { required : 'Mobile Number is required..!', minlength : 'Please enter valid mobile number', maxlength : 'Please enter valid mobile number', number : 'Please enter valid mobile number'}
		    
		  }
		   });
 });
 
 function add()
 {
   var formStatus = $("#updateCustomerForm").valid();
   if(formStatus){
     document.updateCustomerForm.method = "POST";
     document.updateCustomerForm.action = "updateCustomer";
     document.updateCustomerForm.submit(); 
   }
 }
 
	function successMessage(message){
		Swal.fire({
		 	 position: 'top-end',
		  	 icon: 'success',
		  	 title: message,
		 	 showConfirmButton: false,
		  	timer: 1500
		})	
	}
	
	function errorMessage(message){
		Swal.fire({
			icon: 'error',
			title: 'Oops...',
			text: message,
			footer: '<a href>Why do I have this issue?</a>'
		})	
	}
 
</script>