
public class Conta extends ContaAbstrata {
	
	// CONSTRUTORES
	public Conta(String numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
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