package br.com.fwinternetbanking.model;

public class CadConta extends CadGen<ContaAbstrata> {

    private IRepConta contas;

    // CONSTRUCTOR
    public CadConta(IRepConta contas) {
        this.contas = contas;
    }

    // Inserir
    @Override
    public void inserir(ContaAbstrata conta) throws Exception{
    	if(contas.procurar(conta.getNumero()) == null){
            contas.inserir(conta);
        }else{
            System.out.println("Conta ja cadastrada");
        }
    }

    // Remover
    @Override
    public void remover(ContaAbstrata conta) throws Exception{
        contas.remover(conta);
    }

    // Consultar
    @Override
    public ContaAbstrata consultar(String numeroConta) throws Exception{
        return contas.procurar(numeroConta);
    }

    // Atualizar
    @Override
    public void atualizar(ContaAbstrata conta) throws Exception{
        contas.atualizar(conta);
    }

    // Creditar
    public void creditar(String numeroConta, double valor) throws Exception{
        if (valor > 0) {
            if (contas.procurar(numeroConta) != null) {
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
    public void debitar(String numeroConta, double valor) throws Exception{
        if (contas.procurar(numeroConta) != null) {
            ContaAbstrata conta = consultar(numeroConta);
            conta.debitar(valor);
        } else {
            System.out.println();	// TODO exce��o
        }
    }

    // Transferir
    public void transferir(String numOrigem, String numDestino, double valor) throws Exception{
        if(contas.procurar(numOrigem) != null && contas.procurar(numDestino) != null){
            ContaAbstrata contaOrigem = consultar(numOrigem);
            ContaAbstrata contaDestino = consultar(numDestino);
            
            contaOrigem.transferir(contaDestino, valor);
        }
    }
}
