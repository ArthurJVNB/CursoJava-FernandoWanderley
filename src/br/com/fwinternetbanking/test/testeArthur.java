package br.com.fwinternetbanking.test;

import java.io.File;
import java.util.Scanner;

import br.com.fwinternetbanking.dados.*;
import br.com.fwinternetbanking.model.*;

public class testeArthur {
	public static void main(String[] args) {
		RepositorioContaMap repoConta = new RepositorioContaMap();
		
		Cliente cliente = new Cliente("098", "arthur", TipoCliente.Vip, "500", "112", "bloco b");
		ContaAbstrata conta = new Conta("111", 1000, cliente, TipoConta.ContaPadrao);
		
		repoConta.atualizar(conta);
		System.out.println(repoConta.procurar("111"));
		
		repoConta.inserir(conta);
		System.out.println(repoConta.procurar("111"));
		
		conta = null;
		conta = repoConta.procurar("111");
		conta.creditar(800);
		System.out.println(repoConta.procurar("111").getSaldo());
		repoConta.atualizar(conta);
		System.out.println(repoConta.procurar("111").getSaldo());
		
		
		conta = new Poupanca("222", 10000, cliente, TipoConta.ContaPoupanca);
		repoConta.atualizar(conta);
		System.out.println(repoConta.procurar("222"));
		repoConta.inserir(conta);
		System.out.println(repoConta.procurar("222"));
		
		System.out.println(repoConta.procurar("000"));
		System.out.println(repoConta.procurar("111"));
		System.out.println(repoConta.procurar("222"));
		
		conta = repoConta.procurar("222");
		System.out.println(conta.getSaldo());
		conta.creditar(200);
		System.out.println(conta.getSaldo());
		((Poupanca) conta).renderJuros();
		repoConta.atualizar(conta);
		System.out.println(repoConta.procurar("222").getSaldo());
		
		
		conta = new ContaImposto("222", 900, cliente, TipoConta.ContaImposto);
		repoConta.inserir(conta);
		System.out.println(repoConta.procurar("222"));
		conta.setNumero("333");
		repoConta.atualizar(conta);
		System.out.println(repoConta.procurar("333"));
		repoConta.inserir(conta);
		System.out.println(repoConta.procurar("333"));
	}
	
	public static void usarContaMap() {
		RepositorioContaMap repoConta = new RepositorioContaMap();
		
		Cliente cliente = new Cliente("000", "aaa fff", TipoCliente.Class, "8989", "777", "ap");
		ContaAbstrata conta = new ContaBonificada("111", 1000, cliente, TipoConta.ContaBonificada);
		
		repoConta.inserir(conta);
		System.out.println(cliente);
		System.out.println(conta);
		
		conta.creditar(100);
		repoConta.atualizar(conta);
		System.out.println(repoConta.procurar(conta.getId()));
		System.out.println(conta);
	}
	
	// Falhando
	public static void usarContaBDR() {
		try {
			RepositorioContaBDR repoConta = new RepositorioContaBDR();
			
			Cliente cliente = new Cliente("111", "aaa bbb", TipoCliente.Vip, "090", "11", "apartamento");
			ContaAbstrata conta = new Poupanca("111", 100, cliente, TipoConta.ContaPoupanca);
			
			repoConta.inserir(conta);
			System.out.println(repoConta.procurar("111"));
			
			conta = new ContaImposto("222", 2000, cliente, TipoConta.ContaImposto);
			repoConta.inserir(conta);
			System.out.println(repoConta.procurar(conta.getId()));
			
			conta = new Poupanca("333", 980, cliente, TipoConta.ContaPoupanca);
			repoConta.inserir(conta);
			System.out.println(conta);
			System.out.println(repoConta.procurar(conta.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void limparSerializacao() {
		File arqContas = new File("contas.ser");
		if (arqContas.exists()) {
			arqContas.delete();
		}
	}
	
	public static void usarSerializacao() {
		try {
			limparSerializacao();
			RepositorioContaSerializada repoConta = new RepositorioContaSerializada();
			
			Cliente cliente = new Cliente("111", "aaa bbb", TipoCliente.Vip, "090", "11", "apartamento");
			ContaAbstrata conta = new Poupanca("111", 100, cliente, TipoConta.ContaPoupanca);
			
			repoConta.inserir(conta);
			System.out.println(repoConta.procurar("111"));
			
			conta = new ContaImposto("222", 2000, cliente, TipoConta.ContaImposto);
			repoConta.inserir(conta);
			System.out.println(repoConta.procurar(conta.getId()));
			
			conta = new Poupanca("333", 980, cliente, TipoConta.ContaPoupanca);
			repoConta.inserir(conta);
			System.out.println(conta);
			System.out.println(repoConta.procurar(conta.getId()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void usarTreeSetInterativo() {

		Scanner sc = new Scanner(System.in);
		RepositorioClienteTreeSet repoCliente = new RepositorioClienteTreeSet();
		
		Cliente c = null;
		
		System.out.println("BEM-VINDO, CLIENTE");
		System.out.println("Nome:");
		String nome = sc.nextLine();
		
		System.out.println("CPF:");
		String cpf = sc.next();
		
		System.out.println("CEP:");
		String cep = sc.next();
		
		System.out.println("Numero residencia:");
		String numero = sc.next();
		
		System.out.println("Complemento:");
		String complemento = sc.next();
		
		System.out.println("Tipo do cliente:");
		System.out.println("1- Classico\n2- Padrao\n3- VIP");
		int op;
		TipoCliente tc = null;
		do {
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				tc = TipoCliente.Class;
				break;

			case 2:
				tc = TipoCliente.Standard;
				
			case 3:
				tc = TipoCliente.Vip;
				
			default:
				System.out.println("Opcao incorreta. Digite novamente:");
			}
		} while (op < 1 || op > 3);
		
		c = new Cliente(cpf, nome, tc, cep, numero, complemento);
		repoCliente.inserir(c);
		c = null;
		System.out.println(repoCliente.procurar(cpf));
		
		c = repoCliente.procurar(cpf);
		Endereco endereco = new Endereco(cpf, "122", "222", "ap");
		c.setEndereco(endereco);
		repoCliente.atualizar(c);
		
		System.out.println("Mudança de endereço");
		System.out.println(endereco);
		System.out.println("Cliente atualizado:");
		System.out.println(repoCliente.procurar(cpf));
		
		sc.close();
	}
	
	public static void usarTreeSet() {
		System.out.println("-------------TREESET DE CLIENTES--------------");
		
		Cliente c1 = new Cliente("123", "Arthur Jorge", TipoCliente.Class, "090", "999", "casa");
		RepositorioClienteTreeSet repoCliente = new RepositorioClienteTreeSet();
		
		repoCliente.inserir(c1);
		System.out.println("---Cliente novo---");
		System.out.println(repoCliente.procurar(c1.getCpf()));
		
		c1.setNome("Arthur Mudado");
		repoCliente.atualizar(c1);
		System.out.println("---Cliente atualizado---");
		System.out.println(repoCliente.procurar(c1.getId()));
		
		c1 = new Cliente("222", "Jorge", TipoCliente.Vip, "909", "000", "casa");
		repoCliente.inserir(c1);
		System.out.println("---Cliente novo---");
		System.out.println(repoCliente.procurar(c1.getId()));
		
		c1.setNome("Jorge Arthur");
		repoCliente.atualizar(c1);
		System.out.println("---Cliente atualizado---");
		System.out.println(repoCliente.procurar(c1.getCpf()));
		
		c1 = repoCliente.procurar("123");
		System.out.println("---Recuperado cliente de cpf 123---");
		System.out.println(c1);
		
		System.out.println("---Recuperado cliente de cpf 222---");
		c1 = repoCliente.procurar("222");
		System.out.println(c1);
	}
}
