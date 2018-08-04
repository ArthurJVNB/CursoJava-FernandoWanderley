package br.com.fwinternetbanking.test;

import java.io.File;

import br.com.fwinternetbanking.dados.*;
import br.com.fwinternetbanking.model.*;

public class testeArthur {
	public static void main(String[] args) {
		
		
		
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
	
	public static void usarTreeSet() {
		Cliente c1 = new Cliente("123", "Arthur Jorge", TipoCliente.Class, "090", "999", "casa");
		RepositorioClienteTreeSet repoCliente = new RepositorioClienteTreeSet();
		
		repoCliente.inserir(c1);
		System.out.println(repoCliente.procurar(c1.getCpf()));
		
		c1.setNome("Arthur Mudado");
		repoCliente.atualizar(c1);
		System.out.println(repoCliente.procurar(c1.getId()));
		
		c1 = new Cliente("222", "Jorge", TipoCliente.Vip, "909", "000", "casa");
		repoCliente.inserir(c1);
		System.out.println(repoCliente.procurar(c1.getId()));
		
		c1.setNome("Jorge Arthur");
		repoCliente.atualizar(c1);
		System.out.println(repoCliente.procurar(c1.getCpf()));
		
		c1 = repoCliente.procurar("123");
		System.out.println(c1);
		
		c1 = repoCliente.procurar("222");
		System.out.println(c1);
	}
}
