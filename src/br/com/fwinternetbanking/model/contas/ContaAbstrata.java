package br.com.fwinternetbanking.model.contas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fwinternetbanking.model.EntidadeGen;
import br.com.fwinternetbanking.model.clientes.Cliente;


@Entity
@Table (name = "TB_CONTA")
public abstract class ContaAbstrata extends EntidadeGen {
	
	@Id
	@Column (name = "NUMERO")
    private String numero;
	
	@Column (name = "SALDO")
    private double saldo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TB_CLIENTE_CPF")
    private Cliente cliente;
	
	@Column (name = "TIPO")
    private TipoConta tipo;

    // CONSTRUTORES
    public ContaAbstrata() {}
    
    public ContaAbstrata(String numero, double saldo, Cliente cliente, TipoConta tipo) {
        super(numero);
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
}