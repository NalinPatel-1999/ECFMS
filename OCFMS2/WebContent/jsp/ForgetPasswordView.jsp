
<%@page import="in.co.ocha.controller.ORSView"%>
<%@page import="in.co.ocha.controller.ForgetPasswordCtl"%>
<%@page import="in.co.util.DataUtility"%>
<%@page import="in.co.util.ServletUtility"%>

<jsp:useBean id="bean" class="in.co.ocha.bean.UserBean"
	scope="request"></jsp:useBean>

<h1>Forgot your password?</h1>

<H2>Submit your email address and we'll send you password.</H2>

<form action="<%=ORSView.FORGET_PASSWORD_CTL%> " method="Post">

	<b>Email Id :</b> <input type="text" name="login"
		placeholder="Enter ID Here"
		value="<%=ServletUtility.getParameter("login", request)%>">&emsp;

	<input type="submit" name="operation"
		value="<%=ForgetPasswordCtl.OP_GO%>"> <br> <font
		color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font>

	<H2>
		<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
		</font>
	</H2>
	<H2>
		<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
		</font>
	</H2>
</form>

