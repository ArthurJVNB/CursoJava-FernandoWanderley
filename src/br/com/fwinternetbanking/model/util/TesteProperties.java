package br.com.fwinternetbanking.model.util;

import java.io.File;
import java.util.Date;

public class TesteProperties {

	public static void main(String[] args) {
		
		mostrarArquivo();
		System.out.println("---------------------------------------");
		mostrarDiretorio();
		
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
}
