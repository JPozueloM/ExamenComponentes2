package com.cenfotec.examen.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Taller {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "autor")
	private String autor;
	
	@Column(name = "objetivo")
	private String objetivo;
	
	@Column(name = "keywords")
	private String keywords;
	
	@ManyToOne
	@JoinColumn(name="taller", nullable=false)
	private Categoria categoria;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taller")
	private List<Tarea> tarea;
	
	@Transient
	private int categoriaId;



	public Taller(long id, String name, String autor, String objetivo, String keywords, List<Tarea> tarea,
			Taller taller) {
		super();
		this.id = id;
		this.name = name;
		this.autor = autor;
		this.objetivo = objetivo;
		this.keywords = keywords;
		this.tarea = tarea;
		
	}

	public Taller() {
		
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<Tarea> getTareas() {
		return tarea;
	}

	public void setTareas(List<Tarea> tarea) {
		this.tarea = tarea;
	}

	
	public long getIdCategoria() {
		return categoriaId;
	}

	public void setIdCategoria(long categoriaId) {
		this.categoriaId =  (int) categoriaId;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	 

}
