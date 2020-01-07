package net.codejava.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_biblioteca")
public class Biblioteca {
	@Id
	@ManyToMany(cascade = {CascadeType.ALL})
	@Column(name = "idBiblioteca")
	private long idBiblioteca;
	
	@Column(name = "nom")
	private String nom;
	
	public Biblioteca() {}
	
	public Biblioteca(long idBiblioteca, String nom) {
		this.idBiblioteca = idBiblioteca;
		this.nom = nom;
	}

	public long getIdBiblioteca() {
		return idBiblioteca;
	}

	public void setIdBiblioteca(long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Biblioteca [idBiblioteca=" + idBiblioteca + ", nom=" + nom + "]";
	}
	
}
