package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_persona")
public class Persona {
	@Id
	@Column(name = "dni")
	private long dni;
	@Column(name = "nomPersona")
	private String NomPersona;
	@Column(name = "telefon")
	private String telefon;
	
	public Persona() {}
	
	public Persona(long dni, String nomPersona, String telefon) {
		this.dni = dni;
		NomPersona = nomPersona;
		this.telefon = telefon;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNomPersona() {
		return NomPersona;
	}

	public void setNomPersona(String nomPersona) {
		NomPersona = nomPersona;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", NomPersona=" + NomPersona + ", telefon=" + telefon + "]";
	}
	
}
