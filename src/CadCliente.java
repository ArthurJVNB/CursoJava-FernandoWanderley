/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwinternetbanking;

/**
 *
 * @author Euller
 */
public class CadCliente {
     private IRepCliente clientes;
    
        public CadCliente (IRepCliente rep){
            this.clientes = rep;
        }
        
        public void inserir(Cliente cliente){
            if(!clientes.existe(cliente.getCpf())){
                clientes.inserir(cliente);
            }else{
                System.out.println("Cliente ja cadastrado");
            }
        }
        
        public void atualizar(Cliente cliente){
            clientes.atualizar(cliente);
        }
        
        public Cliente consultar(String cpf){
            return clientes.procurar(cpf);
        }
        
        public void remover (String cpf){
            clientes.remover(cpf);
        }
}
