package application;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class myConnection {
	//function to connect to mysql
	public static Connection getConnection() {
		Connection connect=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return connect;
	}

}
