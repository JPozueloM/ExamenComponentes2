package com.cenfotec.examen.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "categoria")
	private Set<Taller> taller;

	
	public Categoria(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Categoria() {
		
	}
	


	public Set<Taller> getTaller() {
		return taller;
	}


	public void setTaller(Set<Taller> taller) {
		this.taller = taller;
	}


	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
