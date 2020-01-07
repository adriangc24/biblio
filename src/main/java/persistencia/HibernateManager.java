package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.codejava.hibernate.Autor;
import net.codejava.hibernate.Biblioteca;
import net.codejava.hibernate.Llibre;
import net.codejava.hibernate.Persona;

public class HibernateManager {
private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		
		Autor a = new Autor(1,"Pepe");
		Biblioteca b = new Biblioteca(1,"Josep Tarradelles");
		Llibre l = new Llibre(1,"Canigó","Barcino",a);
		//Llibre l = new Llibre(1,"Canigó","Barcino","prueba");
		Persona p = new Persona(46532,"Jacint Verdaguer","63345465");
		
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(a);
		manager.persist(b);
		manager.persist(l);
		manager.persist(p);

		manager.getTransaction().commit();
		
		imprimir();
		manager.close();
				
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimir() {
		List<Autor> autores = (List<Autor>) manager.createQuery("FROM Autor").getResultList();
		System.out.println("Hay "+autores.size()+" Autor/es");
		for (Autor x : autores) {
			System.out.println(x.toString());
		}
		
		List<Biblioteca> bibliotecas = (List<Biblioteca>) manager.createQuery("FROM Biblioteca").getResultList();
		System.out.println("Hay "+bibliotecas.size()+" Biblioteca/s");
		for (Biblioteca x : bibliotecas) {
			System.out.println(x.toString());
		}
		
		List<Llibre> llibres = (List<Llibre>) manager.createQuery("FROM Llibre").getResultList();
		System.out.println("Hay "+llibres.size()+" Llibre/s");
		for (Llibre x : llibres) {
			System.out.println(x.toString());
		}
		
		List<Persona> personas = (List<Persona>) manager.createQuery("FROM Persona").getResultList();
		System.out.println("Hay "+personas.size()+" Persona/s");
		for (Persona x : personas) {
			System.out.println(x.toString());
		}
	}
}
