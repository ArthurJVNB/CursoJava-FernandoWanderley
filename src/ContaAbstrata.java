import java.util.Map;

public abstract class ContaAbstrata implements Map<String, ContaAbstrata>{
	private String numero;
	private double saldo;
	private Cliente cliente;
	
	// CONSTRUTORES
	public ContaAbstrata (String numero, double saldo, Cliente cliente)
	{
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	// GETS
	public String getNumero() {	return numero; }
	public double getSaldo() { return saldo; }
	
	// SETS
	protected void setSaldo(double valor) { saldo = valor; }
	
	// CREDITAR E DEBITAR
	public void creditar (double valor) { this.saldo += valor; }
	public abstract void debitar (double valor);
	
	// TRANSFERENCIA
	public void transferir (ContaAbstrata destino, double valor)
	{
		this.debitar(valor);
		destino.creditar(valor);
	}
	
	// MÉTODOS PARA O HASHMAP
	@Override
	public boolean equals(Object obj)
	{
		boolean isEqual = false;
		if (obj instanceof ContaAbstrata)
		{	// se entrou aqui é porque ele é ao menos uma ContaAbstrata
			// se o número dessa conta for igual à conta do objeto que foi passado, o isEqual recebe o true dessa comparação
			isEqual = this.getNumero().equals( ( (ContaAbstrata)obj ).getNumero() );
		}
		
		return isEqual;
	}
	
	@Override
	public int hashCode()
	{
		// "numero" da conta é um tipo String. A classe String já implementou o método "hashCode()"
		return this.getNumero().hashCode();
	}
	
	@Override
	public String toString() {
		return this.getNumero();
	}
}
