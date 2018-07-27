package br.com.testehibernate.dados;

public interface IRepositorio<T> {

	void inserir(T t);
	void remover(String id);
	T consultar(String id);
	void atualizar(T t);
	
}
