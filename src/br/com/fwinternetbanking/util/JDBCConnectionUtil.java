package br.com.fwinternetbanking.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Properties;

public class JDBCConnectionUtil {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	private static Properties p;

	private static Connection connection;

	static {
		p = new Properties();
		try {
			p.load(new FileInputStream("InicializacaoJDBC.properties"));
		} catch (FileNotFoundException ex) {
			System.out.println("Arquivo nao encontrado");
		} catch (IOException ex) {
			System.out.println("Erro ao ler InicializacaoJDBC.properties");
		}
		driver = p.getProperty("jdbc.driver");
		url = p.getProperty("jdbc.url");
		user = p.getProperty("jdbc.user");
		pass = p.getProperty("jdbc.pass");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ex) {
			System.out.println("Erro ao carregar o driver JDBC do HSQLDB.");
			System.exit(-1);
		}

	}

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, pass);
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