package br.com.fwinternetbanking.model;

public abstract class ContaAbstrata {
	
	public enum TipoConta{
		ContaPoupanca,
		ContaImposto,
		ContaBonificada,
		ContaPadrao;
		
		public TipoConta getTipo() {
			return this;
		}
		
		// TODO descobrir um jeito de nao duplicar esse codigo em RepositorioContaBDR.procurar(String chave)
		public TipoConta getTipo(String tipo) {
			TipoConta resultado = null;

			// todos sao elseif para que fique facil expandir os tipos de contas no futuro
			// (evitar erros nas comparacoes)
			if (tipo.equals(TipoConta.ContaBonificada)) {
				resultado = TipoConta.ContaBonificada;
			} else if (tipo.equals(TipoConta.ContaImposto)) {
				resultado = TipoConta.ContaImposto;
			} else if (tipo.equals(TipoConta.ContaPadrao)) {
				resultado = TipoConta.ContaPadrao;
			} else if (tipo.equals(TipoConta.ContaPoupanca)) {
				resultado = TipoConta.ContaPoupanca;
			}
			
			return resultado;
		}
	}

    private String numero;
    private double saldo;
    private Cliente cliente;
    private TipoConta tipo;

    // CONSTRUTORES
    public ContaAbstrata(String numero, double saldo, Cliente cliente, TipoConta tipo) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    // GETS
    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public String getTipo() {
		return tipo.toString();
	}

	public Cliente getCliente() {
    	return cliente;
    }

    // SETS
    protected void setSaldo(double valor) {
        saldo = valor;
    }
    
    // TODO nao sei se esse metodo eh util ---Arthur
    protected void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

    // CREDITAR E DEBITAR
    public void creditar(double valor) {
        this.saldo += valor;
    }

    public abstract void debitar(double valor);

    // TRANSFERENCIA
    public void transferir(ContaAbstrata destino, double valor) {
        this.debitar(valor);
        destino.creditar(valor);
    }

    // METODOS PARA O HASHMAP
    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof ContaAbstrata) {	// se entrou aqui eh porque ele eh ao menos uma ContaAbstrata
            // se o numero dessa conta for igual aa conta do objeto que foi passado, o isEqual recebe o true dessa comparacao
            isEqual = this.getNumero().equals(((ContaAbstrata) obj).getNumero());
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        // "numero" da conta eh um tipo String. A classe String ja implementou o metodo "hashCode()"
        return this.getNumero().hashCode();
    }

    @Override
    public String toString() {
        return this.getNumero();
    }
    
    // TODO colocar como override quando a classe abstrata com ID for criada
    // nao retirar esse metodo
    public String getId() {
    	return this.getNumero();
    }
}
