
public class CadastroContas {
	private IRepositorioContas contas;

	// CONSTRUCTOR
	public CadastroContas(IRepositorioContas contas)
	{
		this.contas = contas;
	}
	
	// Cadastrar
	public void cadastrar(ContaAbstrata conta)
	{
		contas.inserir(conta);
	}
	
	// Descadastrar
	public void descadastrar(ContaAbstrata conta)
	{
		contas.remover(conta);
	}
	
	// Consultar
	public ContaAbstrata consultar(String numeroConta)
	{
		ContaAbstrata conta = null;
		
		if (contas.existe(numeroConta))
		{
			conta = contas.procurar(numeroConta);
		}
		else
		{
			System.out.println("Erro: Conta não existe");	// TODO exceção
		}
		
		return contas.procurar(numeroConta);
	}
	
	// Atualizar
	public void atualizar(ContaAbstrata conta)
	{
		contas.atualizar(conta);
	}
	
	// Creditar
	public void creditar(String numeroConta, double valor)
	{
		if (valor > 0)
		{
			if (contas.existe(numeroConta))
			{
				ContaAbstrata conta = consultar(numeroConta);
				conta.creditar(valor);
				contas.atualizar(conta);
			}
			else
			{
				System.out.println("Erro: Conta inexistente"); // TODO exceção
			}
		}
		else
		{
			System.out.println("Erro: Valor inválido");	// TODO exceção
		}
	}
	
	// Debitar
	public void debitar(String numeroConta, double valor)
	{
		if (contas.existe(numeroConta))
		{
			ContaAbstrata conta = consultar(numeroConta);
			conta.debitar(valor);
		}
		else
		{
			System.out.println();	// TODO exceção
		}
	}
	
	// Transferir
	
}
