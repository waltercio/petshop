package controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class MySQLDatabase {

	private Connection conn = null;
	private String server = "sql10.freemysqlhosting.net:3306";
	private String databaseName = "sql10202368";
	private String username = "sql10202368";
	private String password = "y7NIv5hd9w";
	private String url = "jdbc:mysql://" + server + "/" + databaseName;
			
	public MySQLDatabase() {
		
	}
	
	public int startDB() {
		
		int returnCode;
		System.out.println(url);
		//Define the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			returnCode = 010; //Return code = Class defined successfully
		}catch(Exception e) {
			e.printStackTrace();
			returnCode = 011; //Return code = Error on defining class
			System.out.println("Driver load failed!!!");
		}
		
		//start DB Connection
		try {
		conn = DriverManager.getConnection(url,username,password);
		returnCode = 012; //Return code = Connection to DB performed successfully
		}catch(SQLException e) {
			returnCode = 013; //Return code = Connection to DB failed
			e.printStackTrace();
			System.out.println("Connection to DB failed!!!");
		}
		return returnCode;
	}
	
	//Execute query insert on table client
	public int insertOnClientTable(String nome, String cpf, String gender, String address, String phone) {
		
		int returnCode;
		PreparedStatement stmt;
		String query = "insert into client values(null" + ",'" + nome + "','" + cpf + "','" + gender + "','" + address + "','" + phone + "')";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; //Return code = Insert successfully
			
		}catch(SQLException e) {
			e.printStackTrace();
			returnCode = 017; //Return code = Insert failed
		}
				
		return returnCode;
	}
	
	public int insertOnUserTable(String nome, String cpf, String address, String type, String gender, String phone) {
		
		int returnCode;
		PreparedStatement stmt;
		String query = "insert into employee values(null" + ",'" + nome + "','" + cpf + "','" + address + "','" + type + "','" + gender + "','" + phone + "')";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; //Return code = Insert successfully
			
		}catch(SQLException e) {
			e.printStackTrace();
			returnCode = 017; //Return code = Insert failed
		}
				
		return returnCode;
	}
	
	public int insertOnPetTable(String clientID, String name, String type,  String breed, String collor, String gender) {
		
		int returnCode;
		PreparedStatement stmt;
		String query = "insert into pet values(null" + ",'" + clientID + "','" + name + "','" + type + "','" + breed + "','" + collor + "','" + gender + "')";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; //Return code = Insert successfully
			
		}catch(SQLException e) {
			e.printStackTrace();
			returnCode = 017; //Return code = Insert failed
		}
				
		return returnCode;
	}
	
	public int insertOnUserTable(String name, String username,  String password) {
		
		int returnCode;
		PreparedStatement stmt;
		String query = "insert into users values(null" + ",'" + name + "','" + username + "','" + password +  "')";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.execute();
			returnCode = 016; //Return code = Insert successfully
			
		}catch(SQLException e) {
			e.printStackTrace();
			returnCode = 017; //Return code = Insert failed
		}
				
		return returnCode;
	}	
	
	public int closeDB() {
		int returnCode;
		
		try {
			conn.close();
			returnCode = 014; //Return code = close db successfully
			
		}catch(SQLException e) {
			e.printStackTrace();
			returnCode = 015; //Return code = failed to close DB
		}
		
		return returnCode;
	}
	
}
