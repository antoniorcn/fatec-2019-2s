package edu.tartaruga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mariadb://localhost:53080/entregas";
	private static final String USER = "azure";
	private static final String PASSWORD = "6#vWHD_$";
	private static DBUtil instancia;
	private Connection con;
	
	private DBUtil() throws DAOException { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}
	
	public Connection getConnection() throws DAOException {
		try {
			if (con == null || !con.isValid(500)) { 
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return con;
	}
	
	public static DBUtil getInstance() throws DAOException {
		if (instancia == null) { 
			instancia = new DBUtil();
		}
		return instancia;
	}

}
