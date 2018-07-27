package br.com.testehibernate.dados;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.testehibernate.dados.util.SessionFactoryUtil;
import br.com.testehibernate.model.clientes.Cliente;

public class RepositorioClientesHibernate implements IRepositorio<Cliente> {

	private Session session;
	
	public RepositorioClientesHibernate() {
		// TODO precisa de inicializar algo aqui?
	}
	
	@Override
	public void inserir(Cliente cliente) {
		session = SessionFactoryUtil.getSession();
		session.save(cliente);
		session.close();
	}

	@Override
	public void remover(String cpf) {
		session = SessionFactoryUtil.getSession();
		Cliente cliente = consultar(cpf);
		
		session.delete(cliente);
		session.close();
	}

	@Override
	public Cliente consultar(String cpf) {
		session = SessionFactoryUtil.getSession();
		Cliente cliente = (Cliente) session.get(Cliente.class, cpf);
		session.close();
		
		return cliente;
	}

	@Override
	public void atualizar(Cliente cliente) {
		session = SessionFactoryUtil.getSession();
		session.saveOrUpdate(cliente);
		session.close();
	}
	
	public void mostrarClientes() {
		session = SessionFactoryUtil.getSession();
		
		Query q = session.createQuery("FROM Cliente");
		List<Cliente> clientes = q.list();
		
		for (Cliente cliente : clientes) {
			System.out.print(" Nome: " + cliente.getNome());
			System.out.println(" CPF: " + cliente.getCpf());
		}
		
		session.close();
	}

}
