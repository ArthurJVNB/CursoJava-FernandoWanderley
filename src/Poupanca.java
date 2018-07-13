
public class Poupanca extends Conta {

	// CONSTRUCTOR 1
	public Poupanca(String numero, double saldo) {
		super(numero, saldo);
	}
	
	// CONSTRUCTOR 2
	public Poupanca(String numero) {
		super(numero);
	}
	
	public void renderJuros(double taxa)
	{
		double saldoAtual = getSaldo();
		creditar(saldoAtual * (taxa/100));
	}
}
