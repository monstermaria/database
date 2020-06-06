package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


public class SQLConnection {
	
	static Connection connection;
	
	static void ensureConnection() throws SQLException {
		
		// connection already established
		if (connection != null) {
			return;
		}
		
		// try to establish connection
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3308/customers_drives_settings?serverTimezone=UTC", "root", "");
		
		System.out.println("Database connection established");
	}
	
	static void handleCustomer(HttpServletRequest request) throws SQLException {
		
		// note to self: CustomerID is AUTO_INCREMENT, and does not have to be given
		String insertCommand = "INSERT INTO customers (CustomerName, CustomerAddress, ContactName, TelephoneNumber) ";
		insertCommand += "VALUES (?, ?, ?, ?);";
		
		System.out.println(insertCommand);
		
		PreparedStatement statement = connection.prepareStatement(insertCommand);
		
		// gather data
		statement.setString(1, request.getParameter("customer-name"));
		statement.setString(2, request.getParameter("customer-address"));
		statement.setString(3, request.getParameter("contact-name"));
		statement.setString(4, request.getParameter("telephone-number"));
		
		// send update command
		int result = statement.executeUpdate();
		
		System.out.println("Result (should always be 1): " + result);
		
		request.setAttribute("databaseResult", "Customer added");
	}

	static void handleDrive(HttpServletRequest request) throws SQLException {
		
		// note to self: DriveID is AUTO_INCREMENT, and does not have to be given
		String insertCommand = "INSERT INTO drives (DriveName, SerialNumber, CustomerID, SettingsID) ";
		insertCommand += "VALUES (?, ?, ?, ?);";
		
		System.out.println(insertCommand);
				
		PreparedStatement statement = connection.prepareStatement(insertCommand);
		
		// gather data
		statement.setString(1, request.getParameter("drive-name"));
		statement.setString(2, request.getParameter("serial-number"));
		statement.setInt(3, Integer.valueOf(request.getParameter("customer-id")));
		statement.setInt(4, Integer.valueOf(request.getParameter("settings-id")));
		
		// send update command
		int result = statement.executeUpdate();
		
		System.out.println("Result (should always be 1): " + result);
		
		request.setAttribute("databaseResult", "Drive added");
	}
	
	static void handleSettings(HttpServletRequest request) throws SQLException {
		
		// note to self: SettingsID is AUTO_INCREMENT, and does not have to be given
		String insertCommand = "INSERT INTO customers (SettingsName, CustomerID, Setting1, Setting2, Setting3) ";
		insertCommand += "VALUES (?, ?, ?, ?);";
		
		System.out.println(insertCommand);
				
		PreparedStatement statement = connection.prepareStatement(insertCommand);
		
		// gather data
		statement.setString(1, request.getParameter("settings-name"));
		statement.setInt(2, Integer.valueOf(request.getParameter("customer-id")));
		statement.setInt(3, Integer.valueOf(request.getParameter("setting1")));
		statement.setInt(4, Integer.valueOf(request.getParameter("setting2")));
		statement.setInt(5, Integer.valueOf(request.getParameter("setting3")));
		
		// send update command
		int result = statement.executeUpdate();
		
		System.out.println("Result (should always be 1): " + result);
		
		request.setAttribute("databaseResult", "Settings added");
	}
	
	static void handleRequest(HttpServletRequest request) throws SQLException {
		
		// check database connection. will throw an exception if connection can't be established
		ensureConnection();

		// check what table to add data to
		String table = request.getParameter("table");
		
		switch (table) {
		case "customer":
			handleCustomer(request);
			break;
		case "drive":
			handleDrive(request);
			break;
		case "settings":
			handleSettings(request);
			break;
		default:
			// this should never happen
			request.setAttribute("databaseResult", "Table " + table + " not handled");
		}
	}
}
