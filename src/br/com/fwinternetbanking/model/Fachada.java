/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;
import br.com.fwinternetbanking.dados.RepositorioClienteArray;
import br.com.fwinternetbanking.dados.RepositorioContasArray;
import br.com.fwinternetbanking.model.clientes.Cliente;
import br.com.fwinternetbanking.model.contas.Conta;
import br.com.fwinternetbanking.model.contas.ContaAbstrata;
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
    
    private void initCadastros() {
        RepositorioClienteArray repClientes = new RepositorioClienteArray();
        RepositorioContasArray repContas = new RepositorioContasArray();
        
        contas = new CadConta(repContas);
        clientes = new CadCliente(repClientes);
    }
//    metodos de conta
    public void cadastrarConta(Conta c) throws Exception{
        contas.inserir(c);
    }
    
    public void atualizarConta(Conta c) throws Exception{
        contas.atualizar(c);
    }
    
    public ContaAbstrata procurarConta(String num) throws Exception{
        return contas.consultar(num);
    }
    
    public void descadastrarConta(Conta c) throws Exception{
        contas.remover(c);
    }
    
    public void creditar(String num, double valor) throws Exception{
        contas.creditar(num, valor);
    }
    
    public void debitar(String num, double valor) throws Exception{
        contas.debitar(num, valor);
    }
    
    public void transferir(String numOrigem, String numDestino, double valor) throws Exception{
        ContaAbstrata origem = contas.consultar(numOrigem);
        ContaAbstrata destino = contas.consultar(numDestino);
        
        if (origem != null && destino != null)
        {
        	origem.transferir(destino, valor);
        }
    }
    
//    metodos de cliente
    
    public void cadastrarCliente(Cliente c) throws Exception{
        clientes.inserir(c);
    }
    
    public void atualizarCliente(Cliente c) throws Exception{
        clientes.atualizar(c);
    }
    
    public Cliente procurarCliente(String cpf) throws Exception{
        return clientes.consultar(cpf);
    }
    
    public void descadastrarCliente(Cliente c) throws Exception{
        clientes.remover(c);
    }
}
