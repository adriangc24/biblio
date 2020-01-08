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
		Autor a2 = new Autor(2,"Jose");

		Biblioteca b = new Biblioteca(1,"Josep Tarradelles");
		Biblioteca b2 = new Biblioteca(2,"Biblioteca los libros");

		Llibre l = new Llibre(1,"Canigó","Barcino",a);
		Llibre l2 = new Llibre(2,"barco de luz","La galera",a2);

		Persona p = new Persona(46532,"Jacint Verdaguer","63345465");
		Persona p2 = new Persona(63529,"Socrates","633456566");

		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(a);
		manager.persist(a2);
		a.setNomAutor("Paco");
		
		manager.persist(b);
		manager.persist(b2);
		b.setNom("Biblioteca Cornella");
		
		manager.persist(l);
		manager.persist(l2);
		l.setEditorial("Batrcanova");
		
		manager.persist(p);
		manager.persist(p2);
		p.setTelefon("64444444");

		manager.getTransaction().commit();
		
		imprimir();
		
		manager.getTransaction().begin();
		
		manager.remove(a2);
		manager.remove(b2);
		manager.remove(l2);
		manager.remove(p2);

		manager.getTransaction().commit();
		
		System.out.println("------------------------------");
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
