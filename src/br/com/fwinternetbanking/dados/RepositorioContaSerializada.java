package br.com.fwinternetbanking.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import br.com.fwinternetbanking.exceptions.ContaExisteException;
import br.com.fwinternetbanking.exceptions.ContaNaoEncontradaException;
import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepConta;

public class RepositorioContaSerializada implements IRepConta {

	private static String ARQUIVO = "contas.ser";
	private Map<String, ContaAbstrata> contas;
	
	public RepositorioContaSerializada() throws Exception {
		prepararRepositorio();
	}
	
	private void prepararRepositorio() throws Exception {
		File arq = new File(ARQUIVO);
		
		if (!arq.exists()) {
			contas = new HashMap<>();
			gravarRepositorio(contas);
		} else {
			contas = lerRepositorio();
		}
	}

	@Override
	public void inserir(ContaAbstrata conta) throws Exception {
		if (!existe(conta)) {
			contas.put(conta.getId(), conta);
			gravarRepositorio(contas);
		} else {
			throw new ContaExisteException();
		}
	}

	@Override
	public void atualizar(ContaAbstrata conta) throws Exception {
		if (existe(conta)) {
			contas.put(conta.getId(), conta);
			gravarRepositorio(contas);
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	@Override
	public void remover(ContaAbstrata conta) throws Exception {
		if (existe(conta)) {
			contas.remove(conta.getId(), conta);
			gravarRepositorio(contas);
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	@Override
	public ContaAbstrata procurar(String chave) throws Exception {
		sincronizarRepositorio();
		ContaAbstrata resultado = null;
		
		resultado = contas.get(chave);
		
		return resultado;
	}

	private boolean existe(ContaAbstrata conta) throws Exception {
		sincronizarRepositorio();
		boolean resultado = false;
		
		if (contas.containsKey(conta.getId())) {
			resultado = true;
		}
		
		return resultado;
	}
	
	private void gravarRepositorio(Map<String, ContaAbstrata> contas) throws Exception {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
			
			oos.writeObject(contas);
			
		} catch (IOException e) {
			throw e;
		}
	}
	
	private Map<String, ContaAbstrata> lerRepositorio() throws Exception {
		Map<String, ContaAbstrata> resultado;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
			
			// TODO verificar se o objeto lido tem instância de Map<String, ContaAbstrata>
			resultado = (Map<String, ContaAbstrata>) ois.readObject();
			
		} catch (IOException e) {
			throw e;
		}
		
		return resultado;
	}
	
	private void sincronizarRepositorio() throws Exception {
		contas = lerRepositorio();
	}
}
