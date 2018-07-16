
public interface IRepositorioContas {

	void inserir(ContaAbstrata conta);	
	void atualizar(ContaAbstrata conta);
	void remover(ContaAbstrata conta);
	boolean existe(String numeroConta);
	ContaAbstrata procurar(String numeroConta);

}
