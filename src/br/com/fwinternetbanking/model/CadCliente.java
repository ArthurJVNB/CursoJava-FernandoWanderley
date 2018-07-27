/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

import br.com.fwinternetbanking.model.clientes.Cliente;

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
        public void inserir(Cliente cliente) throws Exception{
            if(clientes.procurar(cliente.getCpf()) == null){
                clientes.inserir(cliente);
            }else{
                System.out.println("Cliente ja cadastrado");
            }
        }
        
        @Override
        public void atualizar(Cliente cliente) throws Exception{
            clientes.atualizar(cliente);
        }
        
        @Override
        public Cliente consultar(String cpf) throws Exception{
            return clientes.procurar(cpf);
        }
        
        @Override
        public void remover (Cliente cliente) throws Exception{
            clientes.remover(cliente);
        }
}
