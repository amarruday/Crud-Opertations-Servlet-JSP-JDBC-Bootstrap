<%@page import="com.ims.config.ApplicationConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ims.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ims.dto.*"%>
<link rel="stylesheet" href="resources/css/sweetalert2.min.css"
	type="text/css" />
<script type="text/javascript" src="resources/js/sweetalert2.min.js"></script>
<jsp:include page="header.jsp"></jsp:include>
<style>
.badge {
	line-height: 2;
	padding: 0px 5px;
}

a {
	color: black;
}

#hyper:hover {
	font-size: 22px;
	color: red;
}

.alerts
 {
 	width: 50%;
	margin-left: 30%;
 }
</style>
<br>

 <%
    String updateSuccessMessage = (String) request.getAttribute ("UPDATESUCCESS");
    String updateErrorMessage = (String) request.getAttribute ("UPDATEFAILURE");
    if(updateSuccessMessage!=null && !updateSuccessMessage.equals(""))
    {
 	%>
 	 <script>
 		sessionStorage.setItem("updateSuccessResult", "Customer updated successfully..!");
 		window.location.href = "getAllCustomers";
 	 </script>
 	<%	
 	}
    else if(updateErrorMessage != null && !updateErrorMessage.equals(""))
 	{
 	%>
 	  <script>
 		sessionStorage.setItem("updateErrorResult", " Failed to  update customer..!");
 		window.location.href = "getAllCustomers";
 	 </script>
	<%
 	}
 %>

<%
    String addSuccessMessage = (String) request.getAttribute ("ADDSUCCESS");
    String addErrorMessage = (String) request.getAttribute ("ADDFAILURE");
    if(addSuccessMessage!=null && !addSuccessMessage.equals(""))
    {
 	%>
 	 <script>
 		sessionStorage.setItem("addSuccessResult", "Customer added successfully..");
 		window.location.href = "getAllCustomers";
 	 </script>
 	<%	
 	}
    else if(addErrorMessage != null && !addErrorMessage.equals(""))
 	{
 	%>
 	 <script>
 		sessionStorage.setItem("addErrorResult", "Failed to add Customer..!");
		window.location.href = "getAllCustomers";
 	 </script>
	<%
 	}
 %>

<%
	String status = (String) request.getAttribute(ApplicationConstants.CustomerDefaults.STATUS);
	String message = (String) request.getAttribute(ApplicationConstants.CustomerDefaults.MESSAGE);

	if (status != null && status.equals(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_FAILURE)) {
%>
<h2>Failed to Fetch Records</h2>
<%
	}
%>

<%
	if (status != null && status.equals(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_SUCCESS)) {
		ArrayList<CustomerDTO> listDto = (ArrayList<CustomerDTO>) request	.getAttribute(ApplicationConstants.CustomerDefaults.ALL_CUSTOMER_LIST);
		if (listDto != null) {
%>

<div class="container-fluid" style="margin-top: 10px;">
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">All Customers</h3>
		</div>
		<!-- /.card-header -->
		<div class="card-body">
			<section class="content">
				<div class="container-fluid">
					<div class="card">
						<!-- /.card-header -->
						<div class="card-body">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="width: 10px">#</th>
										<th>Name</th>
										<th>Email</th>
										<th>Phone</th>
										<th>Status</th>
										<th>Since</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<%
										int j = 1;
												for (int i = 0; i < listDto.size(); i++) {
									%>
									<tr>
										<td><%=j%>.</td>
										<%
											String name = listDto.get(i).getFirstName() + " " + listDto.get(i).getLastName();
										%>
										<td><%=name%></td>
										<td><%=listDto.get(i).getEmail()%></td>
										<td><%=listDto.get(i).getMobileNumber()%></td>
										<%
											if (listDto.get(i).getStatus().equals(ApplicationConstants.AppDefaults.STATUS_ACTIVE)) {
										%>
										<td><span class="badge bg-success"><%=listDto.get(i).getStatus()%></span></td>
										<%
											} else {
										%>
										<td><span class="badge bg-danger"><%=listDto.get(i).getStatus()%></span></td>
										<%
											}
										%>
										<td><%=listDto.get(i).getSince()%></td>
										<td style="text-align: center;"><a id="hyper"
											href="editCustomer?id=<%=listDto.get(i).getCustomerId()%>"><i
												class="fas fa-edit"></i></a></td>
										<td style="text-align: center;"><a id="hyper"
											href="javascript:void(0)"
											onclick="deleteFunction(<%=listDto.get(i).getCustomerId()%>)"><i
												class="far fa-trash-alt"></i></a></td>
									</tr>
									<%
										j++;
												}
									%>
									<%
										} //ifdtonull
											else {
									%>
									<h2>No Records Found..!</h2>
									<%
										}
										}
									%>
								</tbody>
							</table>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</section>
		</div>
		<!-- /.card-body -->
	</div>
	<!-- /.card -->
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script>
	function deleteFunction(id)
	{
		var url = "deleteCustomer?id=" + id;
		
		Swal.fire({
  			title: 'Are you sure?',
  			text: "You won't be able to revert this!",
  			type: 'warning',
 			showCancelButton: true,
  			confirmButtonColor: '#3085d6',
  			cancelButtonColor: '#d33',
  			confirmButtonText: 'Yes, delete it!'
			}).then((result) => {
  				if (result.value) {	
  				     $.ajax({
  				          type: "POST",
  				          contentType : "application/text",
  				          url: url,
  				          data : id,
  				          timeout : 100000,
  				          success: function(response) {
  				           	if(response)
  				           	{
  				           		sessionStorage.setItem("message", response);
  				           		window.location.href = "getAllCustomers";
  				           	}
  				          },//success
  				          error: function(error) {
  				        	Swal.fire(
  				      				'Failed!',
  				      				'Failed to delete your record',
  				      				'error')
  				          }//error
  				         });
  				}
			})//then
			
	}//function
	
	
</script>

<script>
$( document ).ready(function() {
    if(sessionStorage.getItem("message") != null)
    {
    	messageFunction(sessionStorage.getItem("message"));
    	sessionStorage.removeItem("message");
    }
    
    if(sessionStorage.getItem("addSuccessResult") != null)
    {
    	console.log(sessionStorage.getItem("addSuccessResult"));
    	addSuccessResultFunction(sessionStorage.getItem("addSuccessResult"));
    	sessionStorage.removeItem("addSuccessResult");
    }
    
    if(sessionStorage.getItem("addErrorResult") != null)
    {
    	console.log(sessionStorage.getItem("addErrorResult"));
    	addErrorResultFunction(sessionStorage.getItem("addErrorResult"));
    	sessionStorage.removeItem("addErrorResult");
    }
    
    if(sessionStorage.getItem("updateSuccessResult") != null)
    {
    	updateSuccessResultFunction(sessionStorage.getItem("updateSuccessResult"));
    	sessionStorage.removeItem("updateSuccessResult");
    }
    
    if(sessionStorage.getItem("updateErrorResult") != null)
    {
    	console.log(sessionStorage.getItem("updateErrorResult"));
    	updateErrorResultFunction(sessionStorage.getItem("updateErrorResult"));
    	sessionStorage.removeItem("updateErrorResult");
    }
});

function messageFunction(message)
{
	if(message === 'SUCCESS')
	{
			Swal.fire(
    		'Deleted!',
    		'Your record has been deleted.',
    		'success') 
    		/* Swal.fire({
    			  position: 'top-end',
    			  type: 'success',
    			  title: 'Your record has been deleted.',
    			  showConfirmButton: false,
    			  timer: 3000
    			}) */
	}
	else {
			 Swal.fire(
    		'Failed!',
    		'Failed to delete your record',
    		'error')
    		/* Swal.fire({
  			  position: 'top-end',
  			  type: 'error',
  			  title: 'Failed to delete your record.',
  			  showConfirmButton: false,
  			  timer: 3000
  			}) */
	}
}

function addSuccessResultFunction(addSuccessResult)
{
	console.log('AddSuccessResultFunction');
	Swal.fire(
    		'Added.!',
    		'Your record has been added successfully.',
    		'success') 
}

function addErrorResultFunction(addErrorResult)
{
	 Swal.fire(
	    		'Failed!',
	    		'Failed to add your record',
	    		'error')
}

function updateSuccessResultFunction(addSuccessResult)
{
	Swal.fire(
    		'Updated..!',
    		'Your record has been updated successfully.',
    		'success') 
}

function updateErrorResultFunction(addErrorResult)
{
	 Swal.fire(
	    		'Failed..!',
	    		'Failed to update your record',
	    		'error')
}

</script>