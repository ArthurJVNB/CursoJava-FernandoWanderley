
public class RepositorioContaArray implements IRepositorioConta {
	private Conta[] contas;
	private int indice;
	
	public RepositorioContaArray() {
		contas = new Conta[100];
		indice = 0;
	}

	@Override
	public void inserir(Conta conta)
	{
		if (!existe(conta.getNumero()))
		{
			contas[indice] = conta;
			indice++;
		}
	}

	@Override
	public void atualizar(Conta conta)
	{
		if (existe(conta.getNumero()))
		{
			int resultadoIndice = procurarIndice(conta.getNumero());
			contas[resultadoIndice] = conta;
		}
	}

	@Override
	public void remover(Conta conta)
	{
		if (existe(conta.getNumero()))
		{	
			int resultadoIndice = procurarIndice(conta.getNumero()); // o índice da conta que se quer apagar
			
			for (int posSeguinte = resultadoIndice+1; posSeguinte < indice; posSeguinte++) // até o ÍNDICE, pois ele está sempre à frente
			{
				int posAtual = posSeguinte-1;	// <<<<----- só para estudo
				contas[posAtual] = contas[posSeguinte];
			}
			
			indice--;
		}
	}
	
	private int procurarIndice(String numeroConta)
	{
		int resultado = -1;
		
		for (int i = 0; i < contas.length; i++)
		{
			if (contas[i] != null && contas[i].getNumero().equals(numeroConta))
			{
				resultado = i;
			}
		}
		
		return resultado;
	}

	@Override
	public boolean existe(String numeroConta)
	{
		boolean resultado = false;
		
		if (procurarIndice(numeroConta) >= 0)
		{
			resultado = true;
		}
		
		return resultado;
	}
	
	@Override
	public Conta procurar(String numeroConta)
	{
		Conta resultadoConta = null;
		
		if (existe(numeroConta))
		{
			int resultadoIndice = procurarIndice(numeroConta);
			resultadoConta = contas[resultadoIndice];
		}
		
		return resultadoConta;
	}
}
