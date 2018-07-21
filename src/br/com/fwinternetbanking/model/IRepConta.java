package br.com.fwinternetbanking.model;

public interface IRepConta extends IRepGen<ContaAbstrata>{

	public void inserir(ContaAbstrata conta);

	public void atualizar(ContaAbstrata conta);

	public void remover(ContaAbstrata conta);

	public ContaAbstrata procurar(String numeroConta);

}
