package br.com.fwinternetbanking.dados;

import java.util.HashMap;
import java.util.Map;

import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepConta;

public class RepositorioContaSerializada implements IRepConta {

	private static String ARQUIVO = "contas.ser";
	private Map contas;
	
	public RepositorioContaSerializada() {
		prepararHashMap();
	}
	
	private void prepararHashMap() {
		// TODO percorrer todas contas salvas no arquivo "contas.ser" e colocar em "contas" um HashMap delas
		
	}

	@Override
	public void inserir(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ContaAbstrata procurar(String chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO GRAVAR
	private void gravarRepositorio(Map contas) {
		
	}
	
	// TODO LER
	private Map lerRepositorio() {
		
		return null;
	}
	
}
