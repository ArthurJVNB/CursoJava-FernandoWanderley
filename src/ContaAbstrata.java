
public abstract class ContaAbstrata {
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
	public ContaAbstrata (String numero)
	{
		this.numero = numero;
		this.saldo = 0f;
	}

	// GETS
	public String getNumero() {	return numero; }
	public double getSaldo() { return saldo; }
	
	// SETS
	protected void setSaldo(double valor) { saldo = valor; }
	
	// CREDITAR E DEBITAR
	public void creditar (double valor) { this.saldo += valor; }
	public abstract void debitar (double valor);
	
	// TRANSFERÊNCIA
	public void transferir (ContaAbstrata destino, double valor)
	{
		this.debitar(valor);
		destino.creditar(valor);
	}
}
