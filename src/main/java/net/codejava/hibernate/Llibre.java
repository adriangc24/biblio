package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "llibre")
public class Llibre {
	@Id
	@Column(name = "idLlibre")
	private long idLlibre;
	@Column(name = "nomLlibre")
	private String nomLlibre;
	@Column(name = "editorial")
	private String editorial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAutor")
	private Autor autor;
	
	public Llibre() {}
	
	public Llibre(long idLlibre, String nomLlibre, String editorial, Autor autor) {
		super();
		this.idLlibre = idLlibre;
		this.nomLlibre = nomLlibre;
		this.editorial = editorial;
		this.autor = autor;
	}

	public long getIdLlibre() {
		return idLlibre;
	}

	public void setIdLlibre(long idLlibre) {
		this.idLlibre = idLlibre;
	}

	public String getNomLlibre() {
		return nomLlibre;
	}

	public void setNomLlibre(String nomLlibre) {
		this.nomLlibre = nomLlibre;
	}
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	

	

	@Override
	public String toString() {
		return "Llibre [idLlibre=" + idLlibre + ", nomLlibre=" + nomLlibre + ", editorial=" + editorial+", autor = "+autor+"]";
	}
	
	
}
