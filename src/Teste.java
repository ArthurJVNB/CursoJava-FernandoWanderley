import javax.crypto.ExemptionMechanismSpi;

public class Teste {
	public static void main(String[] args) {
		
		RepositorioContaArray repoConta = new RepositorioContaArray();
		
		criarNObjetos(repoConta, 6);
		
		mostrarSaldo(repoConta, "123");
		mostrarSaldo(repoConta, "234");
		mostrarSaldo(repoConta, "345");
		mostrarSaldo(repoConta, "456");
		mostrarSaldo(repoConta, "567");
		mostrarSaldo(repoConta, "678");
		
		incrementarJurosNaPoupanca(repoConta, "123", 10);
		incrementarJurosNaPoupanca(repoConta, "234", 10);
		incrementarJurosNaPoupanca(repoConta, "345", 10);
		incrementarJurosNaPoupanca(repoConta, "456", 10);
		incrementarJurosNaPoupanca(repoConta, "567", 10);
		incrementarJurosNaPoupanca(repoConta, "678", 10);
		
		System.out.println("\nRENDEU JUROS PARA POUPANÇAS:");
		mostrarSaldo(repoConta, "123");
		mostrarSaldo(repoConta, "234");
		mostrarSaldo(repoConta, "345");
		mostrarSaldo(repoConta, "456");
		mostrarSaldo(repoConta, "567");
		mostrarSaldo(repoConta, "678");
		
	}
	
	private static void mostrarSaldo(RepositorioContaArray repoConta, String numeroConta)
	{
		if (repoConta.existe(numeroConta))
		{
			Conta conta = repoConta.procurar(numeroConta);
			
			// TODO String tipoConta é temporário
			String tipoConta = "";
			
			
			System.out.println("Conta " + conta.getNumero() + ": R$ " + conta.getSaldo());
		}
	}

	public static void criarNObjetos(RepositorioContaArray repositorioConta, int quantidade)
	{
		Conta conta = new Conta("123", 5);
		repositorioConta.inserir(conta);
		
		conta = new Conta("234", 10);
		repositorioConta.inserir(conta);
		
		conta = new Conta("345", 15);
		repositorioConta.inserir(conta);
		
		conta = new Poupanca("456", 20);
		repositorioConta.inserir(conta);
		
		conta = new Poupanca("567", 25);
		repositorioConta.inserir(conta);
		
		conta = new Poupanca("678", 30);
		repositorioConta.inserir(conta);
	}
	
	public static void incrementarJurosNaPoupanca(RepositorioContaArray repositorioContaArray, String numero, double taxa)
	{
		if (repositorioContaArray.existe(numero))
		{
			Conta conta = repositorioContaArray.procurar(numero);
			if (conta instanceof Poupanca)
			{
				((Poupanca) conta).renderJuros(taxa);
			}
		}
	}
	
	public static void testarTransferencias()
	{
		Conta c1 = new Conta("123", 10);
		Conta c2 = new Conta("456", 20);
		
		System.out.println("Saldo c1 = R$ " + c1.getSaldo());
		System.out.println("Saldo c2 = R$ " + c2.getSaldo());
		
		c1.transferir(c2, 5);
		
		System.out.println("\nAPÓS TRANSFERÊNCIA:");
		System.out.println("Saldo c1 = R$ " + c1.getSaldo());
		System.out.println("Saldo c2 = R$ " + c2.getSaldo());
	}
}
