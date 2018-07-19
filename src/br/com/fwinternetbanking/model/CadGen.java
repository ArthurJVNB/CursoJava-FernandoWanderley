package br.com.fwinternetbanking.model;

public abstract class CadGen<G> {
	
	public abstract void inserir(G obj);
	public abstract void remover(String id);
	public abstract G consultar(String id);
	public abstract void atualizar(G obj);
	
}
