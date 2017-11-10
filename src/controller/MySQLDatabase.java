package controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class MySQLDatabase {

	private Connection conn = null;
	private String server = "sql10.freemysqlhosting.net:3306";
	private String databaseName = "sql10203842";
	private String username = "sql10203842";
	private String password = "9pXfw48aSA";
	private String url = "jdbc:mysql://" + server + "/" + databaseName;

	public MySQLDatabase() {

	}

	public int startDB() {

		int returnCode;
		System.out.println(url);
		// Define the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			returnCode = 010; // Return code = Class defined successfully
		} catch (Exception e) {
			e.printStackTrace();
			returnCode = 011; // Return code = Error on defining class
			System.out.println("Driver load failed!!!");
		}

		// start DB Connection
		try {
			conn = DriverManager.getConnection(url, username, password);
			returnCode = 012; // Return code = Connection to DB performed successfully
		} catch (SQLException e) {
			returnCode = 013; // Return code = Connection to DB failed
			e.printStackTrace();
			System.out.println("Connection to DB failed!!!");
		}
		return returnCode;
	}

	// Execute query insert on table client
	public int insertOnClientTable(String nome, String cpf, String gender, String address, String phone) {

		int returnCode;
		PreparedStatement stmt;
		String query = "insert into clients values(null" + ",'" + nome + "','" + cpf + "','" + gender + "','" + address
				+ "','" + phone + "')";

		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; // Return code = Insert successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 017; // Return code = Insert failed
		}

		return returnCode;
	}

	// Execute query insert on table employee
	public int insertOnEmployeeTable(String nome, String cpf, String address, String type, String gender,
			String phone) {

		int returnCode;
		PreparedStatement stmt;
		String query = "insert into employees values(null" + ",'" + nome + "','" + cpf + "','" + address + "','" + type
				+ "','" + gender + "','" + phone + "')";

		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; // Return code = Insert successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 017; // Return code = Insert failed
		}

		return returnCode;
	}

	// Execute query insert on table pet
	public int insertOnPetTable(String clientID, String name, String type, String breed, String collor, String gender) {

		int returnCode;
		PreparedStatement stmt;
		String query = "insert into pets values(null" + ",'" + clientID + "','" + name + "','" + type + "','" + breed
				+ "','" + collor + "','" + gender + "')";

		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; // Return code = Insert successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 017; // Return code = Insert failed
		}

		return returnCode;
	}

	// Execute query insert on table user
	public int insertOnUserTable(String name, String username, String password) {

		int returnCode;
		PreparedStatement stmt;
		String query = "insert into users values(null" + ",'" + name + "','" + username + "','" + password
				+ "')";

		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; // Return code = Insert successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 017; // Return code = Insert failed
		}

		return returnCode;
	}

	// Execute query insert on table order
	public int insertOnOrderTable(String serviceID, String employeeID, String petID, String client_ID,
			String entryDateTime, String deliveryDateTime) {

		int returnCode;
		PreparedStatement stmt;
		String query = "insert into orders values(null" + ",'" + serviceID + "','" + employeeID + "','" + petID + "','"
				+ client_ID + "','" + entryDateTime + "','" + deliveryDateTime + "')";
		System.out.println(query);
		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; // Return code = Insert successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 017; // Return code = Insert failed
		}

		return returnCode;
	}

	// Execute query insert on table service
	public int insertOnServiceTable(String serviceDescription, String servicePrice) {

		int returnCode;
		PreparedStatement stmt;
		String query = "insert into services values(null" + ",'" + serviceDescription + "','" + servicePrice + "')";
		System.out.println(query);
		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; // Return code = Insert successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 017; // Return code = Insert failed
		}

		return returnCode;
	}

	// Execute query insert on table products
	public int insertOnProductsTable(String codigo, String description, double price, int estoqueAtual) {

		int returnCode;
		PreparedStatement stmt;
		String query = "insert into products values('" + codigo + "','" + description + "','" + price + "','"
				+ estoqueAtual + "')";
		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; // Return code = Insert successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 017; // Return code = Insert failed
		}

		return returnCode;
	}

	public int calculateStock(int actualStock, int qte) {
		int stock = actualStock + qte;

		return stock;
	}

	public String[] queryUsersTable(String username, String password) {
		
		String[] usernamePassword = new String[2];
		int returnCode = 0;
		boolean isUserOk = false;
		Statement stmt;
		ResultSet rs = null;
		String query = "select username,password from users where username = '" + username + "' and password = '" + password + "';";
		usernamePassword[0] = "";
		usernamePassword[1] = "";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println(rs.toString());
			while(rs.next()) {
				if(rs.getString("username").equals(username) && rs.getString("username").equals(username)) {
					
					usernamePassword[0] = rs.getString("username");
					usernamePassword[1] = rs.getString("password");
				}

				
			}
			returnCode = 020; //Return code = Select successfully
			
		}catch(Exception e) {
			e.printStackTrace();
			returnCode = 021; //Return code = Select failed
		}
				
		return usernamePassword;
	}

	// close DB connection
	public int closeDB() {
		int returnCode;

		try {
			conn.close();
			returnCode = 014; // Return code = close db successfully

		} catch (SQLException e) {
			e.printStackTrace();
			returnCode = 015; // Return code = failed to close DB
		}

		return returnCode;
	}

}
