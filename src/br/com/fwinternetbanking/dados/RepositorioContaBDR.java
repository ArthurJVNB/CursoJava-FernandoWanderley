package br.com.fwinternetbanking.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.FactoryContas;
import br.com.fwinternetbanking.model.IRepGen;
import br.com.fwinternetbanking.util.JDBCConnectionUtil;
import br.com.fwinternetbanking.util.SqlUtil;

public class RepositorioContaBDR implements IRepGen<ContaAbstrata> {

	@Override
	public void inserir(ContaAbstrata conta) throws Exception {
		String sql = SqlUtil.getProperties().getProperty("insert.conta");
		PreparedStatement stmt = null;

		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (conta != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, conta.getCliente().getCpf());
				stmt.setString(2, conta.getNumero());
				stmt.setDouble(3, conta.getSaldo());
				stmt.setString(4, conta.getTipo());
				stmt.executeUpdate(sql);
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
	public void atualizar(ContaAbstrata conta) throws Exception {
		String sql = SqlUtil.getProperties().getProperty("update.conta");
		PreparedStatement stmt = null;

		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (conta != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, conta.getCliente().getCpf());
				stmt.setString(2, conta.getNumero());
				stmt.setDouble(3, conta.getSaldo());
				stmt.setString(4, conta.getTipo());
				stmt.executeUpdate(sql);
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
	public void remover(ContaAbstrata conta) throws Exception {
		String sql = SqlUtil.getProperties().getProperty("delete.conta");
		PreparedStatement stmt = null;
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (conta != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, conta.getNumero());
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
	public ContaAbstrata procurar(String chave) throws Exception {
		ContaAbstrata conta = null;
		PreparedStatement stmt = null;
		FactoryContas factoryContas = new FactoryContas();
		String sql = SqlUtil.getProperties().getProperty("select.conta");
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (chave != null) {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);

				String numero = rs.getString("NUMERO");
				double saldo = rs.getDouble("SALDO");
				int tipoInt = rs.getInt("TIPO");
				conta = factoryContas.getTipoConta(tipoInt);
				conta.setCliente(null);
				conta.setNumero(numero);
				conta.creditar(saldo);
			}
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return conta;
	}

//	// TODO se comunicar com o repositorio de clientes e obter o cliente pelo cpf
//	private Cliente procurarCliente(String cpf) throws Exception {
//		IRepGen<Cliente> clientes = null;
//		// Estah incompleto. Dara um excecao de ponteiro
//		Cliente cliente = clientes.procurar(cpf);
//
//		return cliente;
//	}
}
