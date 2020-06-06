<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database Interface</title>

	<script type="text/javascript">
		function changeTable() {
			document.getElementById("tableForm").submit();
		}
	</script>
	
</head>

<body>
	<jsp:useBean id="myBean" class="databasePackage.TableBean"></jsp:useBean>
	<jsp:setProperty property="table" name="myBean" param="table"/>

	<form id="tableForm" action="ChooseTableServlet" method="get">
		<label for="select">Choose a table to add data to:</label>
		<select id="select" name="table" onchange="changeTable()">
    		<c:forEach var="item" items="${myBean.tableNames}">
		        <option value="${item}" ${item == myBean.table ? 'selected="selected"' : ''}>${item}</option>
		    </c:forEach>
		</select>
	</form>
			
	<jsp:include page="${myBean.table}-form.jsp"></jsp:include>

</body>
</html>
