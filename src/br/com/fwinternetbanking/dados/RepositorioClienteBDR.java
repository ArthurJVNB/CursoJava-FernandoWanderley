package br.com.fwinternetbanking.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fwinternetbanking.model.IRepCliente;
import br.com.fwinternetbanking.model.clientes.Cliente;
import br.com.fwinternetbanking.model.util.JDBCConnectionUtil;

public class RepositorioClienteBDR implements IRepCliente {

	@Override
	public void inserir(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO TB_CLIENTE " + "(CPF, NOME)" + "VALUES(?, ?)";
		
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cliente != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, cliente.getCpf());
				stmt.setString(2, cliente.getNome());
				stmt.executeUpdate();
				String sql2 = "INSERT INTO TB_ENDERECO " + "(CEP, NUMERO, COMPLEMENTO, TB_CLIENTE_CPF)" + "VALUES(?, ?, ?, ?)";
				
				stmt = conn.prepareStatement(sql2);
				stmt.setString(1, cliente.getEndereco().getCep());
				stmt.setString(2, cliente.getEndereco().getNumero());
				stmt.setString(3, cliente.getEndereco().getComplemento());
				stmt.setString(4, cliente.getCpf());
				
				stmt.close();
			}
		} catch (SQLException ex) {
			throw ex;
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws Exception{
		// TODO Auto-generated method stub
		String sql = "UPDATE TB_CLIENTE SET CPF = ?, NOME = ?,  TIPO = ? WHERE CPF = ?";
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cliente != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, cliente.getCpf());
				stmt.setString(2, cliente.getNome());
				stmt.setInt(3, cliente.getTipo().ordinal());
				stmt.executeUpdate();
				stmt.close();	
			}
		} catch (SQLException ex) {
			throw ex;
		}

	}

	@Override
	public Cliente procurar(String cpf) throws Exception{
		// TODO Auto-generated method stub
		Cliente cliente = null;

		String sql = "SELECT * FROM TB_CLIENTE WHERE CPF = ?";
		String sql2 = "SELECT * FROM TB_ENDERECO WHERE TB_CLIENTE_CPF = ?";
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cpf != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, cpf);
				ResultSet rs = stmt.executeQuery(sql);
				ResultSet rs2 = stmt.executeQuery(sql2);

				// cliente = new Cliente(rs.getString("NOME"), rs.getString("CPF"), rs2.getString("CEP"), rs2.getString("NUMERO"), rs2.getString("COMPLEMENTO"));
//				cliente = new Cliente(rs.getString("NOME"), rs.getString("CPF"), rs.getInt("TIPO")));
//				Nao tem TIPO no TB_CLIENTE
				stmt.close();
			}
		} catch (SQLException ex) {
			throw ex;
		}
		return cliente;
	}

	@Override
	public void remover(Cliente cliente) throws Exception{
		// TODO Auto-generated method stub
		String sql = "DELETE FROM TB_CLIENTE WHERE CPF = ?";
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (cliente != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, cliente.getCpf());
				stmt.executeUpdate();
				stmt.close();
			}
		} catch (SQLException ex) {
			throw ex;
		}

	}

}
