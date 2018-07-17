
public class TesteArthur {
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
		
		
		// 16.07.2018
		criarEDebitarContasTipoDiferente();
	}
	
	private static void mostrarSaldo(RepositorioContasArray repoConta, String numeroConta)
	{
		if (repoConta.existe(numeroConta))
		{
			ContaAbstrata conta = repoConta.procurar(numeroConta);
			
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
			ContaAbstrata conta = repositorioContaArray.procurar(numero);
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
	
	public static void criarEDebitarContasTipoDiferente()
	{
		ContaAbstrata[] c = new ContaAbstrata[4];
		c[0] = new Conta("000", 100);	// Conta
		c[1] = new Poupanca("111", 100);	// Poupanca
		c[2] = new Conta("222", 100);	// TODO ContaBonificada
		c[3] = new ContaImposto("333", 100);	// ContaImposto
		
		System.out.println("\n------------------");
		System.out.println("CRIAR E DEBITAR CONTAS DE TIPOS DIFERENTES (saldo inicial de R$ 100,00)");
		System.out.println("------------------");
		
		System.out.println("\nANTES DE DEBITAR (R$ 10,00)");
		mostrarSaldosEmArray(c);
		debitarEmArray(c);
		System.out.println("\nDEPOIS DE DEBITAR (R$ 10,00)");
		mostrarSaldosEmArray(c);
	}
	
	public static void mostrarSaldosEmArray(ContaAbstrata[] c)
	{
		String tipoConta = null;
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] instanceof ContaImposto)
			{
				tipoConta = "IMPOSTO";
			}
			else if (c[i] instanceof Poupanca)
			{
				tipoConta = "POUPANÇA";
			}
			else if (c[i] instanceof Conta)
			{
				tipoConta = "PADRÃO";
			}
			// TODO testar com ContaBonificada
			
			System.out.println("Saldo da Conta " + c[i].getNumero() + " do tipo " + tipoConta + ": R$ " + c[i].getSaldo());
		}
	}
	
	public static void debitarEmArray(ContaAbstrata[] c)
	{
		double VALOR = 10;
		
		for (int i = 0; i < c.length; i++)
		{
			c[i].debitar(VALOR);
		}
	}
}
