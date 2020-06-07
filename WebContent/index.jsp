<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database Interface</title>

	<script type="text/javascript">
		function changeDataType() {
			document.getElementById("choiceForm").submit();
		}
	</script>
	
</head>

<body>
	<jsp:useBean id="myBean" class="databasePackage.DataTypeBean"></jsp:useBean>
	<jsp:setProperty property="dataType" name="myBean" param="dataType"/>

	<form id="choiceForm" action="ChooseDataTypeServlet" method="get">
		<label for="select">Choose a type of data to add:</label>
		<select id="select" name="dataType" onchange="changeDataType()">
    		<c:forEach var="item" items="${myBean.dataTypeNames}">
		        <option value="${item}" ${item == myBean.dataType ? 'selected="selected"' : ''}>${item}</option>
		    </c:forEach>
		</select>
	</form>
			
	<form action="DatabaseInterfaceServlet" method="post">
		<jsp:include page="${myBean.dataType}-form.jsp"></jsp:include>
		<input type="text" name="dataType" value="${myBean.dataType}" hidden="true">
		<input type="submit" value="Add ${myBean.dataType}">
	</form>	

</body>
</html>
