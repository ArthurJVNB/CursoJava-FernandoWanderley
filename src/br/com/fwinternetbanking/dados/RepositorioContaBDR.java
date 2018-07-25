package br.com.fwinternetbanking.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fwinternetbanking.model.Cliente;
import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.FactoryContas;
import br.com.fwinternetbanking.model.IRepGen;
import br.com.fwinternetbanking.model.util.JDBCConnectionUtil;

public class RepositorioContaBDR implements IRepGen<ContaAbstrata> {
	private Connection con;
	private static String TABELA_CONTA = "TB_CONTA";
	private static String COLUNA_NUMERO = "NUMERO";
	private static String COLUNA_SALDO = "SALDO";
	private static String COLUNA_CLIENTE_CPF = "CLIENTE";
	private static String COLUNA_TIPO = "TIPO";

	@Override
	public void inserir(ContaAbstrata conta) throws Exception {
		try {
			con = JDBCConnectionUtil.getConnection();

			Statement stmt = con.createStatement();

			String sql = "INSERT INTO " + TABELA_CONTA + " VALUES (" + conta.getId() + ", "
					+ conta.getCliente().getCpf() + ", " + conta.getNumero() + ", " + conta.getSaldo() + ", " + null
					+ ")"; // tipo da conta

			stmt.executeUpdate(sql);

			stmt.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void atualizar(ContaAbstrata conta) throws Exception {
		try {
			con = JDBCConnectionUtil.getConnection();

			JDBCConnectionUtil.createTransaction(); // esperando atualizacao

			String sql = "UPDATE " + TABELA_CONTA + " " + "SET TB_CLIENTE_CPF = ?, " + "NUMERO = ?, " + "SALDO = ?, "
					+ "TIPO = ? " + "WHERE = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, conta.getCliente().getCpf());
			stmt.setString(2, conta.getNumero());
			stmt.setDouble(3, conta.getSaldo());
			stmt.setString(4, conta.getTipo());
			stmt.setString(4, conta.getId());

			stmt.executeUpdate();
			JDBCConnectionUtil.commitTransaction(); // servidor atualizado

			stmt.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void remover(ContaAbstrata conta) throws Exception {
		try {
			con = JDBCConnectionUtil.getConnection();

			Statement stmt = con.createStatement();
			String sql = "DELETE FROM " + TABELA_CONTA + " VALUE(" + conta.getId() + ")";
			stmt.execute(sql);

			stmt.close();
		} catch (SQLException e) {
			throw e;

		}
	}

	public boolean existe(String chave) throws Exception {
		boolean resultado = false;

		procurar(chave);

		return resultado;
	}

	@Override
	public ContaAbstrata procurar(String chave) throws Exception {
		ContaAbstrata conta = null;
		FactoryContas factoryContas = new FactoryContas();

		try {
			con = JDBCConnectionUtil.getConnection();
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM " + TABELA_CONTA;

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next() && conta == null) {
				// ira procurar enquanto tiver um proximo elemento na tabela
				// e enquanto ainda nao tiver encontrado alguem com o mesmo ID
				if (chave.equals(rs.getString("ID"))) {
					// TODO ver uma forma melhor de descobrir o tipo <-------------------- parei
					// aqui

					String numero = rs.getString(COLUNA_NUMERO);
					double saldo = rs.getDouble(COLUNA_SALDO);
					String clienteCpf = rs.getString(COLUNA_CLIENTE_CPF);
					int tipoInt = rs.getInt(COLUNA_TIPO);

					Cliente cliente = procurarCliente(clienteCpf);

					conta = factoryContas.getTipoConta(tipoInt, saldo, numero, cliente);

				}
			}

			stmt.close();
		} catch (SQLException e) {
			throw e;
		}

		return conta;
	}

	// TODO se comunicar com o repositorio de clientes e obter o cliente pelo cpf
	private Cliente procurarCliente(String cpf) throws Exception {
		IRepGen<Cliente> clientes = null;
		// Estah incompleto. Dara um excecao de ponteiro
		Cliente cliente = clientes.procurar(cpf);

		return cliente;
	}
}
