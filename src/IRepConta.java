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
public interface IRepConta {
   void inserir(ContaAbstrata conta);
   public boolean existe(String num);
   public void atualizar(ContaAbstrata c);
   public ContaAbstrata procurar(String num);
   public void remover(String num);
    
}
