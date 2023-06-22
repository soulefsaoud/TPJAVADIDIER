package tp;

import tp.dao.PersonneDaoSimu;
import tp.entity.Personne;

import java.util.List;

import tp.dao.PersonneDAO;
import tp.dao.PersonneDaoJDB;


public class MyApp {

	public static void main(String[] args) {
		//testCrud();
		//stConnection();
		testCrudJDBC();
	}
	
	public static void testCrudJDBC() {
		PersonneDAO pDAO = new PersonneDaoJDB();
		
		Personne p1 = new Personne(null, "benoit","OKbon");  // id méconnu
		Personne savedP1 = pDAO.createPersonne(p1);
		System.out.println("saveP1= "+ savedP1.toString());
		
		System.out.print("MyApp.testCrudJDBC()" +pDAO.rechercherToutesPersonnes());
		
		List<Personne> personnes = pDAO.rechercherToutesPersonnes();
		System.out.println("personnes  :");
		for (Personne personne : personnes) {
			System.out.println("\t" + personne);
		}
		
	}
	
	public static void testConnection() {
		PersonneDaoJDB pDAO = new PersonneDaoJDB();
		System.out.println("Connexion établie =" + pDAO.etablirConnexion());
		
	}
	
	
	public static void testCrud() {
		//créer quelques personnes
		
		PersonneDAO pDAO = new PersonneDaoSimu();
		
		Personne p1 = new Personne(null, "jean","bon");  // id méconnu
		Personne savedP1 = pDAO.createPersonne(p1);
		System.out.println("saveP1= "+ savedP1.toString());
		
		Personne p2 = new Personne(null, "oloui","joli");  // id méconnu
		Personne savedP2 = pDAO.createPersonne(p2);
		System.out.println("saveP1= "+ savedP2.toString());
	
		p2.setPrenom("lola");
		pDAO.updatePersonne(p2);
		
		Personne pMisAJour= pDAO.rechercherPersonneParId(p2.getId());
		System.out.println("p2MisAJour=" + pMisAJour.toString());;
		
		pDAO.deletePersonne(p2.getId());
		
		List<Personne> personnes = pDAO.rechercherToutesPersonnes();
		System.out.println("personnes");
		for (Personne personne : personnes) {
			System.out.println("\t" +personne);
		}
	}
}
