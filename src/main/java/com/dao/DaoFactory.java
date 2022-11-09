package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

@Service
public class DaoFactory {
	
	private String url;
	private String username;
	private String password;
	private static final ResourceBundle DB_CONF = ResourceBundle.getBundle("DB");

	DaoFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.url = DB_CONF.getString("URL_DB");
		this.username = DB_CONF.getString("USERNAME_DB");
		this.password = DB_CONF.getString("PASSWORD_DB");
	}

	/**
	 * Create an instance of DaoFactory to handle SQL queries
	 * @return A DaoFactory instance
	 */
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new DaoFactory();
	}

	/**
	 * Create a connection to the database
	 * @return The new connection
	 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
