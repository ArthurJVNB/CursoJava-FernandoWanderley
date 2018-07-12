
public class Conta {
	private String numero;
	private double saldo;
	
	// CONSTRUTORES
	public Conta (String numero, double saldo)
	{
		this.numero = numero;
		this.saldo = saldo;
	}
	public Conta (String numero)
	{
		this.numero = numero;
		this.saldo = 0f;
	}

	// GETS
	public String getNumero() {	return numero; }
	public double getSaldo() { return saldo; }
	
	// CREDITAR E DEBITAR
	public void creditar (double valor) { this.saldo += valor; }
	public void debitar (double valor) { this.saldo -= valor; }
	
	// TRANSFERÊNCIA
	public void transferir (Conta destino, double valor)
	{
		this.debitar(valor);
		destino.creditar(valor);
	}
}