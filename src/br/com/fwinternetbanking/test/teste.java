package br.com.fwinternetbanking.test;

import br.com.fwinternetbanking.model.Cliente;
import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.ContaBonificada;
import br.com.fwinternetbanking.model.ContaImposto;
import br.com.fwinternetbanking.model.Fachada;
import br.com.fwinternetbanking.model.Poupanca;
import br.com.fwinternetbanking.model.TipoCliente;
import br.com.fwinternetbanking.model.TipoConta;

public class teste {
	public static void main(String[] args) throws Exception {
		int op;
		ContaAbstrata c1, c2, c3, tc1, tc2, tc3;
		Cliente cl1, cl2, cl3, tcl1, tcl2, tcl3;
		Fachada servicos = Fachada.obterInstancia();

		// Teste Cliente
		cl1 = new Cliente("123", "Euller", TipoCliente.Class, "52024", "numero123", "ap101");
		System.out.println(cl1.toString());
		cl2 = new Cliente("456", "Lucas", TipoCliente.Standard, "53031", "numero456", "ap202");
		System.out.println(cl2.toString());
		cl3 = new Cliente("789", "Arthur", TipoCliente.Vip, "55056", "numero789", "ap303");
		System.out.println(cl3.toString());

		// Teste Contas

		c1 = new ContaBonificada("123", 100, cl1, TipoConta.ContaBonificada);
		System.out.println(c1.toString());
		c2 = new ContaImposto("456", 200, cl2, TipoConta.ContaImposto);
		System.out.println(c2.toString());
		c3 = new Poupanca("789", 300, cl3, TipoConta.ContaPoupanca);
		System.out.println(c3.toString());

		// Cadastrar Conta

//		servicos.cadastrarConta(c1);
//		servicos.cadastrarConta(c2);
//		servicos.cadastrarConta(c3);
		
		//Consultando contas do Array
		tc1 = servicos.procurarConta("223");
		System.out.println(tc1.toString());
		
		tc2 = servicos.procurarConta("456");
		System.out.println(tc2.toString());
		
		tc3 = servicos.procurarConta("789");
		System.out.println(tc3.toString());

	}
}
