package br.com.fwinternetbanking.model;

public abstract class EntidadeGen {
	private String id;
	
	public EntidadeGen(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
