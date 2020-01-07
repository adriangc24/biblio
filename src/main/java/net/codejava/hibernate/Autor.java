package net.codejava.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_autor")
public class Autor {
	
	@Id
	@Column(name = "idAutor")
	private long idAutor;
	
	@Column(name = "nomAutor")
	private String nomAutor;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Llibre> libros = new ArrayList<Llibre>();
	
	public Autor() {}
	

	public Autor(long idAutor, String nomAutor) {
		this.idAutor = idAutor;
		this.nomAutor = nomAutor;
	}

	
	public long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNomAutor() {
		return nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nomAutor=" + nomAutor + "]";
	}
	
	
	}

