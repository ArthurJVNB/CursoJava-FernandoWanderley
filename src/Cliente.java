package fwinternetbanking;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Euller
 */
public class Cliente {

    public enum TipoCliente {
        Standard, Class, Vip;
    }

    private final String cpf;
    private String nome;
    private TipoCliente tipo;
    private Endereco endereco;
    private RepositorioClienteArray repos;

    public Cliente(String nome, String cpf, Endereco endereco, TipoCliente tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.tipo = tipo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
