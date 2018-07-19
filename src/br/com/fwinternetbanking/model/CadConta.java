package br.com.fwinternetbanking.model;

public class CadConta extends CadGen<ContaAbstrata> {

    private IRepConta contas;

    // CONSTRUCTOR
    public CadConta(IRepConta contas) {
        this.contas = contas;
    }

    // Inserir
    @Override
    public void inserir(ContaAbstrata conta) {
        contas.inserir(conta);
    }

    // Remover
    @Override
    public void remover(String num) {
        contas.remover(num);
    }

    // Consultar
    @Override
    public ContaAbstrata consultar(String numeroConta) {
        return contas.procurar(numeroConta);
    }

    // Atualizar
    @Override
    public void atualizar(ContaAbstrata conta) {
        contas.atualizar(conta);
    }

    // Creditar
    public void creditar(String numeroConta, double valor) {
        if (valor > 0) {
            if (contas.existe(numeroConta)) {
                ContaAbstrata conta = consultar(numeroConta);
                conta.creditar(valor);
                contas.atualizar(conta);
            } else {
                System.out.println("Erro: Conta inexistente"); // TODO exce��o
            }
        } else {
            System.out.println("Erro: Valor inv�lido");	// TODO exce��o
        }
    }

    // Debitar
    public void debitar(String numeroConta, double valor) {
        if (contas.existe(numeroConta)) {
            ContaAbstrata conta = consultar(numeroConta);
            conta.debitar(valor);
        } else {
            System.out.println();	// TODO exce��o
        }
    }

    // Transferir
    public void transferir(String numOrigem, String numDestino, double valor){
        if(contas.existe(numOrigem) && contas.existe(numDestino)){
            ContaAbstrata contaOrigem = consultar(numOrigem);
            ContaAbstrata contaDestino = consultar(numDestino);
            
            contaOrigem.transferir(contaDestino, valor);
        }
    }
}
