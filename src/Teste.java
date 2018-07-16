
public class Teste {
	public static void main(String[] args) {
		
		RepositorioContasArray repoConta = new RepositorioContasArray();
		
		criarNObjetos(repoConta, 6);
		
		mostrarSaldo(repoConta, "123");
		mostrarSaldo(repoConta, "234");
		mostrarSaldo(repoConta, "345");
		mostrarSaldo(repoConta, "456");
		mostrarSaldo(repoConta, "567");
		mostrarSaldo(repoConta, "678");
		
		incrementarJurosNaPoupanca(repoConta, "123", 1);
		incrementarJurosNaPoupanca(repoConta, "234", 1);
		incrementarJurosNaPoupanca(repoConta, "345", 1);
		incrementarJurosNaPoupanca(repoConta, "456", 1);
		incrementarJurosNaPoupanca(repoConta, "567", 1);
		incrementarJurosNaPoupanca(repoConta, "678", 1);
		
		System.out.println("\nRENDEU JUROS PARA POUPANÇAS:");
		mostrarSaldo(repoConta, "123");
		mostrarSaldo(repoConta, "234");
		mostrarSaldo(repoConta, "345");
		mostrarSaldo(repoConta, "456");
		mostrarSaldo(repoConta, "567");
		mostrarSaldo(repoConta, "678");
		
	}
	
	private static void mostrarSaldo(RepositorioContasArray repoConta, String numeroConta)
	{
		if (repoConta.existe(numeroConta))
		{
			Conta conta = repoConta.procurar(numeroConta);
			
			// TODO String tipoConta é temporário
			String tipoConta = "";
			if (conta instanceof Poupanca)
			{
				tipoConta = "Poupança";
			}
			else if (conta instanceof Conta)
			{
				tipoConta = "Padrão";
			}
			// TODO fim do temporário
			
			System.out.println("Conta " + tipoConta + " " + conta.getNumero() + ": R$ " + conta.getSaldo());
		}
	}

	public static void criarNObjetos(RepositorioContasArray repositorioConta, int quantidade)
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
	
	public static void incrementarJurosNaPoupanca(RepositorioContasArray repositorioContaArray, String numero, double taxa)
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
