package com.cenfotec.examen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tarea {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "textoLeido")
	private String textoLeido;
	
	@Column(name = "tiempo")
	private String tiempo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "taller_id")
	private Taller taller;
	
	public Tarea() {
		
	}
	
	public Tarea (long id) {
		this.id = id;
	}



	public Tarea(long id, String name, String descripcion, String textoLeido, String tiempo, Taller taller) {
		super();
		this.id = id;
		this.name = name;
		this.descripcion = descripcion;
		this.textoLeido = textoLeido;
		this.tiempo = tiempo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTextoLeido() {
		return textoLeido;
	}

	public void setTextoLeido(String textoLeido) {
		this.textoLeido = textoLeido;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	public Taller getTaller() {
		return taller;
	}

	public void setTaller(Taller taller) {
		this.taller = taller;
	}
	
	
}
