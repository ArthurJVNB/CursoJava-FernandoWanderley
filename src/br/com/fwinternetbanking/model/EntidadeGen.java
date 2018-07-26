package br.com.fwinternetbanking.model;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class EntidadeGen {
	
	@Id
	@Column (name = "id")
	private String id;
	
	public EntidadeGen() {}
	
	public EntidadeGen(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
