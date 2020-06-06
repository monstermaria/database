<form action="AddDriveServlet" method="post">
	Drive name: <input type="text" name="drive-name" maxlength="50"><br>
	Serial number: <input type="text" name=serial-number required maxlength="50"><br>
	Customer ID: <input type="number" name=customer-id><br>
	Settings ID: <input type="number" name=settings-id><br>
	<input type="text" value="drive" hidden="true">
	<input type="submit" value="Add drive">
</form>
