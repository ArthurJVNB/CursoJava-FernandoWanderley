package br.com.testehibernate.model;

public abstract class E<e> {
	private String id;
	
	public E(){}
	public E(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
