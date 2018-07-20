package br.com.fwinternetbanking.model.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

import java.sql.Connection;

public class JDBCConnectionUtil {

	private static String driver = "org.hsqldb.jdbcDriver";
	private static String url = "jdbc:hsqldb:hsql://localhost:9090/qib";
	private static String user = "sa";
	private static String pass = "";
	
	private static Connection connection;
	
	static {
		try {	
			Class.forName(driver);
		} catch (ClassNotFoundException ex) {
			System.out.println("Erro ao carregar o driver JDBC do HSQLDB.");
			System.exit(-1);
		}
		
	}
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url,user,pass);
		}
		return connection;
	}
	
	public static void createTransaction() throws SQLException {
		getConnection();
		connection.setAutoCommit(false);
	}
	public static void createSavePoint() throws SQLException {
		getConnection();
		connection.setSavepoint();
	}
	public static void commitTransaction() throws SQLException {
		getConnection();
		connection.commit();
		connection.setAutoCommit(true);
	}
	public static void rollbackTransaction() throws SQLException {
		getConnection();
		connection.rollback();
		connection.setAutoCommit(true);
	}
	public static void rollbackTransaction(Savepoint savepoint) throws SQLException {
		getConnection();
		connection.rollback(savepoint);
		connection.setAutoCommit(true);
	}
}