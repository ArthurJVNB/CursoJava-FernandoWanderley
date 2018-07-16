
public class CadastroContas {
	private IRepositorioContas contas;

	// CONSTRUCTOR
	public CadastroContas(IRepositorioContas contas)
	{
		this.contas = contas;
	}
	
	// Inserir
	public void cadastrar(ContaAbstrata conta)
	{
		contas.inserir(conta);
	}
	
	// Remover
	public void remover(ContaAbstrata conta)
	{
		contas.remover(conta);
	}
	
	// Consultar
	public ContaAbstrata consultar(String numeroConta)
	{
		return contas.procurar(numeroConta);
	}
	
	// Atualizar
	public void atualizar(ContaAbstrata conta)
	{
		contas.atualizar(conta);
	}
}
