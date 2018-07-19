/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

/**
 *
 * @author Euller
 */
public class CadCliente extends CadGen<Cliente>{
     private IRepCliente clientes;
    
        public CadCliente (IRepCliente rep){
            this.clientes = rep;
        }
        
        @Override
        public void inserir(Cliente cliente){
            if(!clientes.existe(cliente.getCpf())){
                clientes.inserir(cliente);
            }else{
                System.out.println("Cliente ja cadastrado");
            }
        }
        
        @Override
        public void atualizar(Cliente cliente){
            clientes.atualizar(cliente);
        }
        
        @Override
        public Cliente consultar(String cpf){
            return clientes.procurar(cpf);
        }
        
        @Override
        public void remover (String cpf){
            clientes.remover(cpf);
        }
}
