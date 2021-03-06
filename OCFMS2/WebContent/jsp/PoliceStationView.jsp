<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="in.co.ocha.controller.PoliceStationCtl"%>
<%@page import="in.co.util.DataUtility"%>
<%@page import="in.co.util.ServletUtility"%>
<%@page import="in.co.util.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.ocha.controller.ORSView"%>

<jsp:useBean id="model"
	class="in.co.ocha.model.PoliceStationModel" scope="request"></jsp:useBean>

<p class="st-title">Police Station</p>

<%=HTMLUtility.getSuccessMessage(request)%>
<%=HTMLUtility.getErrorMessage(request)%>
<form action="<%=ORSView.POLICESTATION_CTL%>" method="POST">

	<input type="hidden" name="id" value="<%=model.getId()%>">
	<table>

		<tr>
			<th>Name Of Police Station*</th>
			<td><input type="text" name="nameOfPoliceStation"
				value="<%=DataUtility.getStringData(model.getNameOfPoliceStation())%>"><font
				color="red"> <%=ServletUtility.getErrorMessage("nameOfPoliceStation", request)%></font></td>
		</tr>
		<tr>
			<th>Code Of Police Station*</th>
			<td><input type="text" name="codeOfPoliceStation"
				value="<%=DataUtility.getStringData(model.getCodeOfPoliceStation())%>"><font
				color="red"> <%=ServletUtility.getErrorMessage("codeOfPoliceStation",
					request)%></font></td>
		</tr>
		<tr>
			<th>Area Covered*</th>
			<td><input type="text" name="areaCovered"
				value="<%=DataUtility.getStringData(model.getAreaCovered())%>"><font
				color="red"> <%=ServletUtility.getErrorMessage("areaCovered", request)%></font></td>
		</tr>
		<tr>
			<th>ContactNo*</th>
			<td><input type="text" name="contactNo"
				value="<%=DataUtility.getStringData(model.getContactNo())%>"><font
				color="red"> <%=ServletUtility.getErrorMessage("contactNo", request)%></font></td>
		</tr>
		<tr>
			<th></th>
			<td colspan="2">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				<input type="submit" name="operation"
				value="<%=PoliceStationCtl.OP_SAVE_UP%>">
			</td>
		</tr>
	</table>
</form>

