
public class Cliente {

	public enum Tipocliente {

		Class, Standard, Vip;
	}

	private String nome;
	private String sobrenome;
	private String cpf;
	private Tipocliente tipo;

	public Cliente(String nome, String sobrenome, String cpf, Tipocliente tipo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTipo(Tipocliente tipo) {
		this.tipo = tipo ;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public Tipocliente getTipo() {
		return tipo;
	}

}
