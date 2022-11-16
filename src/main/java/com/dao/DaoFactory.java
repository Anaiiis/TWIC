package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory {
	
	private String url;
	private String username;
	private String password;
	private static final ResourceBundle DB_CONF = ResourceBundle.getBundle("DB");
	private static final Logger logger = LoggerFactory.getLogger(DaoFactory.class);

	DaoFactory() {
		this.url = DB_CONF.getString("URL_DB");
		this.username = DB_CONF.getString("USERNAME_DB");
		this.password = DB_CONF.getString("PASSWORD_DB");
	}

	/**
	 * Crée une instance de DaoFactory pour traiter les requêtes SQL
	 * @return Une instance de DaoFactory
	 */
	public static DaoFactory getInstance() {
		return new DaoFactory();
	}

	/**
	 * Crée une connexion à la base de données
	 * @return La nouvelle connexion
	 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			logger.error("Error : {}", e.getMessage());
		}
		return connection;
	}

}
