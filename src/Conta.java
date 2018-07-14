
public class Conta extends ContaAbstrata {
	
	// CONSTRUTORES
	public Conta(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public Conta(String numero) {
		super(numero);
	}
	
	@Override
	public void debitar (double valor)
	{
		if (getSaldo() >= valor)
		{
			setSaldo(getSaldo() - valor);
		}
		else
		{
			System.out.println("Saldo insuficiente");	// TODO forma temporária de avisar erro
		}
	}
}