package br.com.fwinternetbanking.model.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Properties;

public class TesteProperties {

	public static void main(String[] args) {
		
		try {
			exemploDeRandomAccessFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void mostrarArquivo() {
		String nomeArquivo = "C:\\Users\\Arthur Ultrabook\\Desktop\\Milestones.txt";
		File arq = new File(nomeArquivo);
		
		if (!arq.exists()) {
			System.out.println("Arquivo nao existe: " + nomeArquivo);
		} else {
			System.out.println("Nome: " + arq.getName());
			System.out.println("Caminho abstrato: " + arq.getPath());
			System.out.println("Caminho absoluto: " + arq.getAbsolutePath());
			System.out.println("Tamanho: " + arq.length() + "bytes");
			
			long horaModificacao = arq.lastModified();
			System.out.println("Hora de modificacao: " + new Date(horaModificacao));
		}
	}
	
	public static void mostrarArquivo(String caminho) {
		// esse metodo foi repetido de proposito (para estudo)
		File arq = new File(caminho);
		
		if (!arq.exists()) {
			System.out.println("Arquivo nao existe: " + caminho);
		} else {
			System.out.println("Nome: " + arq.getName());
			System.out.println("Caminho abstrato: " + arq.getPath());
			System.out.println("Caminho absoluto: " + arq.getAbsolutePath());
			System.out.println("Tamanho: " + arq.length() + "bytes");
			
			long horaModificacao = arq.lastModified();
			System.out.println("Hora de modificacao: " + new Date(horaModificacao));
		}
	}
	
	public static void mostrarDiretorio() {
		// Mostrar diretorio
		String nomeDiretorio = ".";	// "." eh o diretorio atual do projeto
		nomeDiretorio = System.getProperty("user.dir"); // Diretorio atual foi pego (dessa vez nao explicitamente escrito)
		File dir = new File(nomeDiretorio);
		dir.getParentFile(); // Diretorio pai foi pego. Explicitamente seria ".." (acho que ".." eh apenas o diretorio anterior ao atual)
		
		if (!dir.exists()) {
			System.out.println("Diretorio " + dir.getAbsolutePath() + " nao encontrado");
		} else if (dir.isDirectory()) {
			String[] listaArquivos = dir.list();
			
			if (listaArquivos != null) {
				for (int i = 0; i < listaArquivos.length; i++) {
					System.out.println(listaArquivos[i]);
				}
			}
		}
	}
	
	public static void escreverArquivo(String name) throws IOException{
		// Esse metodo cria um arquivo, mas substitui o arquivo se tiver com o mesmo nome
		
		FileWriter fileOutput = new FileWriter(name);
		BufferedWriter bw = new BufferedWriter(fileOutput);
		
		bw.write("chave valor da chave");
		
		// SEMPRE se deve fechar os canais de alto e baixo nivel para gravacao ou leitura
		bw.close();
		fileOutput.close();
	}
	
	public static void escreverELerArquivo() {
		try {
			escreverArquivo("sistema.properties");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			String arquivo = "sistema.properties";
			Properties properties = new Properties();
			
			FileInputStream fileInputStream = new FileInputStream(arquivo);
			properties.load(fileInputStream);
			properties.list(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void exemploDeRandomAccessFile() throws IOException {
		System.out.println("----------ESCRITA----------");
		// ESCREVER
		RandomAccessFile randomAccessFile = new RandomAccessFile("teste.dat", "rw");
		
		for (int i = 0; i < 10; i++) {
			double num = i*3.00;
			randomAccessFile.writeDouble(num);
			System.out.println(num);
		}
		System.out.println("\n----------LEITURA----------");
		// LER
		int bytesLidos = 0;
		long totalBytes = randomAccessFile.length();
		
		randomAccessFile.seek(bytesLidos); // esse metodo precisa saber por onde vai comecar?
		while (bytesLidos*8 < totalBytes) {
			double num = randomAccessFile.readDouble();
			System.out.println(num);
			bytesLidos++;
			randomAccessFile.seek(bytesLidos*8);
		}
		
		randomAccessFile.close();
		
		System.out.println("\n---------------------\n");
		mostrarArquivo("C:\\Users\\Arthur Ultrabook\\Desktop\\Curso Java\\FWInternetBanking\\teste.dat");
	}
}
