package br.com.fwinternetbanking.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fwinternetbanking.model.Cliente;
import br.com.fwinternetbanking.model.IRepCliente;
import br.com.fwinternetbanking.util.JDBCConnectionUtil;
import br.com.fwinternetbanking.util.SqlUtil;

public class RepositorioClienteBDR implements IRepCliente {

	@Override
	public void inserir(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		String sql = SqlUtil.getProperties().getProperty("insert.cliente");
		PreparedStatement stmt = null;

		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cliente != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, cliente.getCpf());
				stmt.setString(2, cliente.getNome());
				stmt.executeUpdate();

				inserirEndereco(cliente);

			}
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	private void inserirEndereco(Cliente cliente) throws Exception {
		String sql = SqlUtil.getProperties().getProperty("insert.cliente.endereco");
		PreparedStatement stmt = null;
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cliente != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, cliente.getEndereco().getCep());
				stmt.setString(2, cliente.getEndereco().getNumero());
				stmt.setString(3, cliente.getEndereco().getComplemento());
				stmt.setString(4, cliente.getCpf());
				stmt.executeUpdate();
			}
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	@Override
	public void atualizar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		String sql = SqlUtil.getProperties().getProperty("update.cliente");
		PreparedStatement stmt = null;
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cliente != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, cliente.getCpf());
				stmt.setString(2, cliente.getNome());
				stmt.executeUpdate();
			}
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	@Override
	public Cliente procurar(String cpf) throws Exception {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		PreparedStatement stmt = null;
		String sql = SqlUtil.getProperties().getProperty("select.cliente");
		String sql2 = SqlUtil.getProperties().getProperty("select.cliente.endereco");
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cpf != null) {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);
				ResultSet rs2 = stmt.executeQuery(sql2);

				String CPF = rs.getString("CPF");
				String nome = rs.getString("NOME");
				String cep = rs2.getString("CEP");
				String numero = rs2.getString("NUMERO");
				String complemento = rs2.getString("COMPLEMENTO");

				cliente = new Cliente(CPF, nome, null, cep, numero, complemento);

			}
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return cliente;
	}

	@Override
	public void remover(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		String sql = SqlUtil.getProperties().getProperty("delete.cliente");
		PreparedStatement stmt = null;
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cliente != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, cliente.getCpf());
				stmt.executeUpdate();
			}
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

}
