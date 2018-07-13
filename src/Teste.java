
public class Teste {
	public static void main(String[] args) {
		
		testarTransferencias();
		
	}
	
	public static void testarTransferencias()
	{
		Conta c1 = new Conta("123", 10);
		Conta c2 = new Conta("456", 20);
		
		System.out.println("Saldo c1 = R$ " + c1.getSaldo());
		System.out.println("Saldo c2 = R$ " + c2.getSaldo());
		
		c1.transferir(c2, 5);
		
		System.out.println("\nAP�S TRANSFER�NCIA:");
		System.out.println("Saldo c1 = R$ " + c1.getSaldo());
		System.out.println("Saldo c2 = R$ " + c2.getSaldo());
	}
}
