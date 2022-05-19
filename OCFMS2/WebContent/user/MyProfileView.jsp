<%@page import="in.co.common.model.UserModel"%>
<%@page import="in.co.ocha.bean.UserBean"%>
<%@page import="in.co.ocha.controller.BaseCtl"%>
<%@page import="in.co.ocha.controller.ORSView"%>
<%@page import="in.co.common.controller.MyProfileCtl"%>
<%@page import="in.co.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.util.DataUtility"%>
<%@page import="in.co.util.ServletUtility"%>

<jsp:useBean id="model" class="in.co.common.model.UserModel"
	scope="request" />
<jsp:useBean id="bean" class="in.co.ocha.bean.UserBean"
	scope="request"></jsp:useBean>
<p class="st-title">My Profile</p>

<%=HTMLUtility.getSuccessMessage(request)%>
<%=HTMLUtility.getErrorMessage(request)%>
<%
	//UserBean userBean = (UserBean) session.getAttribute("user");
	UserModel userBean = (UserModel) request.getAttribute("model");


%>
<form action="<%=ORSView.MY_PROFILE_CTL%>" class="form-horizontal">

	<input type="hidden" name="id" value="<%=userBean.getId()%>">

	<table>
		<tr>
			<th>Email</th>
			<td><%=userBean.getLogin()%></td>
		</tr>

		<tr>
			<th>First Name</th>
			<td><input type="text" name="firstName" size=30
				value="<%=DataUtility.getStringData(userBean.getFirstName())%>"><font
				color="red"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></td>
		</tr>

		<tr>
			<th>Last Name</th>
			<td><input type="text" name="lastName" size=30
				value="<%=DataUtility.getStringData(userBean.getLastName())%>"><font
				color="red"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></td>
		</tr>


		<tr>
			<th>Gender</th>
			<td>
				<%
					HashMap map = new HashMap();
					map.put("M", "Male");
					map.put("F", "Female");

					String htmlList = HTMLUtility.getList("gender", userBean.getGender(),
							map);
				%> <%=htmlList%>

			</td>
		</tr>

		<tr>
			<th>Date Of Birth(mm/dd/yyyy)*</th>
			<td><input type="text" name="dob" readonly="readonly"
				value="<%=DataUtility.getDateString(userBean.getDob())%>"> <a
				href="javascript:getCalendar(document.forms[0].dob);"> <img
					src="../img/cal.jpg" width="16" height="15" border="0"
					alt="Calender">
			</a><font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
		</tr>

		<tr>
			<th>Mobile *</th>
			<td><input type="text" name="mobileNo" size=30
				value="<%=DataUtility.getStringData(userBean.getMobileNo())%>"><font
				color="red"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></td>
		</tr>
		<tr>
			<th></th>
			<td colspan="2"><input type="submit" name="operation"
				value="<%=BaseCtl.OP_SAVE%>"> <input type="submit"
				name="operation" value="<%=MyProfileCtl.OP_CHANGE_MY_PASSWORD%>">
			</td>
		</tr>

	</table>
</form>

