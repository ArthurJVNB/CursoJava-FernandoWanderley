
public interface IRepConta {

	void inserir(Conta conta);
	
	void atualizar(Conta conta);
	
	void remover(Conta conta);
	
	boolean existe(String numeroConta);
	
	Conta procurar(String numeroConta);

}
