
public class Conta {
	private String numero;
	private float saldo;
	
	// CONSTRUTORES
	public Conta (String numero, float saldo)
	{
		this.numero = numero;
		this.saldo = saldo;
	}
	public Conta (String numero)
	{
		this.numero = numero;
		this.saldo = 0;
	}

	// GETS
	public String getNumero() {	return numero; }
	public float getSaldo() { return saldo; }
	
	// CREDITAR E DEBITAR
	public void creditar (float valor) { this.saldo += valor; }
	public void debitar (float valor) { this.saldo -= valor; }
	
	
}

/*
*/