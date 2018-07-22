/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;
import br.com.fwinternetbanking.dados.RepositorioClienteArray;
import br.com.fwinternetbanking.dados.RepositorioContasArray;
/**
 *
 * @author Euller
 */
public class Fachada {
    private static Fachada instancia;
    private CadCliente clientes;
    private CadConta contas;
    
    public static Fachada obterInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    private Fachada(){
        initCadastros();
    }
    
    private void initCadastros(){
        RepositorioClienteArray repClientes = new RepositorioClienteArray();
        RepositorioContasArray repContas = new RepositorioContasArray();
        
        contas = new CadConta(repContas);
        clientes = new CadCliente(repClientes);
    }
//    metodos de conta
    public void cadastrarConta(Conta c){
        contas.inserir(c);
    }
    
    public void atualizarConta(Conta c){
        contas.atualizar(c);
    }
    
    public ContaAbstrata procurarConta(String num){
        return contas.consultar(num);
    }
    
    public void descadastrarConta(Conta c){
        contas.remover(c);
    }
    
    public void creditar(String num, double valor){
        contas.creditar(num, valor);
    }
    
    public void debitar(String num, double valor){
        contas.debitar(num, valor);
    }
    
    public void transferir(String numOrigem, String numDestino, double valor){
        ContaAbstrata origem = contas.consultar(numOrigem);
        ContaAbstrata destino = contas.consultar(numDestino);
        
        if (origem != null && destino != null)
        {
        	origem.transferir(destino, valor);
        }
    }
    
//    metodos de cliente
    
    public void cadastrarCliente(Cliente c){
        clientes.inserir(c);
    }
    
    public void atualizarCliente(Cliente c){
        clientes.atualizar(c);
    }
    
    public Cliente procurarCliente(String cpf){
        return clientes.consultar(cpf);
    }
    
    public void descadastrarCliente(Cliente c){
        clientes.remover(c);
    }
}
