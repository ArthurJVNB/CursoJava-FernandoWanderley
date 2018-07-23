package br.com.fwinternetbanking.model;

public abstract class CadGen<G> {
	
	public abstract void inserir(G obj) throws Exception;
	public abstract void remover(G g) throws Exception;
	public abstract G consultar(String id) throws Exception;
	public abstract void atualizar(G obj) throws Exception;
	
}
