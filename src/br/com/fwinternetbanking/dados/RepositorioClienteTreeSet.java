package br.com.fwinternetbanking.dados;

import java.util.TreeSet;

import br.com.fwinternetbanking.model.IRepCliente;
import br.com.fwinternetbanking.model.clientes.Cliente;

public class RepositorioClienteTreeSet implements IRepCliente {
	private TreeSet<Cliente> clientes;

	public RepositorioClienteTreeSet() {
		clientes = new TreeSet<>();
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO Auto-generated method stub
		clientes.add(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		if (clientes.contains(cliente)) {
			clientes.remove(cliente);
			clientes.add(cliente);
		}
	}

	@Override
	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		for (Cliente c : clientes) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void remover(Cliente cliente) {
		// TODO Auto-generated method stub
		for (Cliente c : clientes) {
			if(c.getCpf().equals(cliente.getClass())) {
				clientes.remove(c);
				return;
			}
		}
	}

}
