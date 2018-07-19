package br.com.fwinternetbanking.model;


public interface IRepConta {

	void inserir(ContaAbstrata conta);	
	void atualizar(ContaAbstrata conta);
	void remover(ContaAbstrata conta);
	boolean existe(String numeroConta);
	ContaAbstrata procurar(String numeroConta);

}
