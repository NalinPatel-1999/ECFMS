
<%@page import="in.co.ocha.controller.ORSView"%>
<%@page import="in.co.ocha.controller.ForgetPasswordCtl"%>
<%@page import="in.co.util.DataUtility"%>
<%@page import="in.co.util.ServletUtility"%>


<html>
<head>
<link rel="stylesheet" href="<%=ORSView.CSS_FOLDER%>/sunrays.css">

<script type="text/javascript"
	src="<%=ORSView.JS_FOLDER%>/calendar.js"></script>
</head>

<body>


	<%@ include file="Header.jsp"%>

	<%
		String bodyPage = null;

		bodyPage = (String) request.getAttribute("bodyPage");
	%>

	<jsp:include page="<%=bodyPage%>"></jsp:include>

	<%@ include file="Footer.jsp"%>

</body>
</html>


