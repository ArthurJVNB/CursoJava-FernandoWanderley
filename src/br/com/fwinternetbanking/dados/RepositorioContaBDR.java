package br.com.fwinternetbanking.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fwinternetbanking.model.Conta;
import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.ContaBonificada;
import br.com.fwinternetbanking.model.ContaImposto;
import br.com.fwinternetbanking.model.IRepGen;
import br.com.fwinternetbanking.model.Poupanca;
import br.com.fwinternetbanking.model.util.JDBCConnectionUtil;

public class RepositorioContaBDR implements IRepGen<ContaAbstrata> {
	private Connection con;
	private static String TABELA_CONTA = "tb_conta";
	
	@Override
	public void inserir(ContaAbstrata conta) {
		Statement stmt = null;
		
		try {
			con = JDBCConnectionUtil.getConnection();
			
			stmt = con.createStatement();
			
			String sql = "INSERT INTO " + TABELA_CONTA + " VALUES (" + 
					conta.getId() + ", " + 
					conta.getCliente().getCpf() + ", " + 
					conta.getNumero() + ", " +
					conta.getSaldo() + ", " + 
					null + ")"; // tipo da conta
			
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	@Override
	public void atualizar(ContaAbstrata conta) {
		PreparedStatement stmt = null;
		String tipo = getTipo(conta);
		
		try {
			con = JDBCConnectionUtil.getConnection();
			
			JDBCConnectionUtil.createTransaction();	// esperando atualizacao
			
			String sql = "UPDATE " + TABELA_CONTA + " "
					+ "SET TB_CLIENTE_CPF = ?, "
					+ "NUMERO = ?, "
					+ "SALDO = " + conta.getSaldo() + ", "
					+ "TIPO = ? "
					+ "WHERE = ?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, conta.getCliente().getCpf());
			stmt.setString(2, conta.getNumero());
			stmt.setString(3, tipo); // tipo
			stmt.setString(4, conta.getId());
			
			stmt.executeUpdate();
			JDBCConnectionUtil.commitTransaction(); // servidor atualizado
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void remover(String chave) {
		Statement stmt = null;
		
		try {
			con = JDBCConnectionUtil.getConnection();
			
			stmt = con.createStatement();
			String sql = "DELETE FROM " + TABELA_CONTA + " VALUE(" + chave + ")";
			stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean existe(String chave) {
		boolean resultado = false;
		
		procurar(chave);
		
		return resultado;
	}

	@Override
	public ContaAbstrata procurar(String chave) {
		Statement stmt = null;
		ContaAbstrata resultado = null;
		
		try {
			con = JDBCConnectionUtil.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM " + TABELA_CONTA;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next() && resultado == null) {	// ira procurar enquanto tiver um proximo elemento na tabela
														// e enquanto ainda nao tiver encontrado alguem com o mesmo ID
				if (chave.equals(rs.getString("ID"))) {
					// TODO ver uma forma melhor de descobrir o tipo <-------------------- parei aqui
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultado;
	}
	
	// TODO metodo TEMPORARIO para o Tipo da Conta
	private String getTipo(ContaAbstrata conta) {
		String resultado = null;
		
		if (conta instanceof ContaImposto) {
			resultado = "IMPOSTO";
		} else if (conta instanceof ContaBonificada) {
			resultado = "BONIFICADA";
		} else if (conta instanceof Poupanca) {
			resultado = "POUPANCA";
		} else if (conta instanceof Conta) {
			resultado = "PADRAO";
		}
		
		return resultado;
	}
}
