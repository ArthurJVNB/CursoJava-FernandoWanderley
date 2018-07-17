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
public interface IRepCliente {
   void inserir(Cliente cliente);
   public boolean existe(String cpf);
   public void atualizar(Cliente cliente);
   public Cliente procurar(String cpf);
   public void remover(String cpf);
}
