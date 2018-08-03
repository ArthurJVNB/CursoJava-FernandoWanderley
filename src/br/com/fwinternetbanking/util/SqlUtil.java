package br.com.fwinternetbanking.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SqlUtil {
	private static Properties p = null;

	static {
		if (p == null) {
			p = new Properties();
			try {
				p.load(new FileInputStream("ComandosSQL.properties"));
			} catch (FileNotFoundException ex) {
				System.out.println("Arquivo ComandosSQL.properties nao encontrado!");
			} catch (IOException ex) {
				System.out.println("Erro ao ler arquivo ComandosSQL.properties");
			}
		}

	}

	public static Properties getProperties() {
		return p;
	}

}
