package br.com.testehibernate.model.testes;

import br.com.testehibernate.dados.RepositorioClientesHibernate;
import br.com.testehibernate.model.clientes.Cliente;

public class TesteHibernate {
	
	public static void main(String[] args) {
		RepositorioClientesHibernate clientes = new RepositorioClientesHibernate();
		
		Cliente cliente = new Cliente("1235", "Fulano", "95215", "562");
		clientes.inserir(cliente);
		
		clientes.mostrarClientes();
	}
}
