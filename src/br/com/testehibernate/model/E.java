package br.com.testehibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class E<e> {
	
	@Id
	@Column (name="ID")
	private String id;
	
	public E() {}
	
	public E(String id) {
		this.id = id;
	}
	
	protected String getId() {
		return id;
	}
}
