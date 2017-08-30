package fr.codevallee.formation.tp;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import org.hibernate.sql.ordering.antlr.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.FacesRequestAttributes;

import fr.codevallee.formation.tp.modele.Adresse;
import fr.codevallee.formation.tp.modele.Article;
import fr.codevallee.formation.tp.modele.ArticleDescription;
import fr.codevallee.formation.tp.modele.Client;
import fr.codevallee.formation.tp.modele.Facture;
import fr.codevallee.formation.tp.modele.LigneDeFacture;
import fr.codevallee.formation.tp.modele.Status;

public class Router implements SparkApplication {

	public void init() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
		EntityManager em = emf.createEntityManager();

		///////////////////////////////////////////////////////////////////////////////////////

		// CREATE ADRESSE
		Adresse uneAdresse = new Adresse("La Taverne", "Kaamelott", 88888, "Royaume de Bretagne");
		Adresse uneAutreAdresse = new Adresse("Le Chateau", "Kaamelott", 88888, "Royaume de Bretagne");
		
		
		
		// CREATE CLIENT
		Client unClient = new Client("De Vannes", "Karadic", uneAdresse);
		Client unAutreClient = new Client("De Galle", "Perceval", uneAutreAdresse);

		///////////////////////////////////////////////////////////////////////////////////////////

		// CREATE ARTICLE DESCRIPTION
		ArticleDescription uneDescription = new ArticleDescription("Graal","Bocal a anchois ou une pierre incandescente");
		ArticleDescription uneAutreDescription = new ArticleDescription("Catapulte","Grosse Catapulte a ne pas monter dans l'enceinte de chateau");

		// CREATE ARTICLE
		Article unArticle = new Article(24.5, 8765432, uneDescription);
		Article unAutreArticle = new Article(655, 3425432, uneDescription);
		Article unFinalArticle = new Article(3420, 3487902, uneAutreDescription);

		///////////////////////////////////////////////////////////////////////////////////////

		Date uneDate = new Date();

		// CREATE LIGNE FACTURE

		LigneDeFacture uneLigneFacture = new LigneDeFacture(5, unArticle);
		LigneDeFacture uneAutreLigneFacture = new LigneDeFacture(3, unAutreArticle);
		LigneDeFacture uneFinalLigneFacture = new LigneDeFacture(8, unFinalArticle);

		Set<LigneDeFacture> listeLigneFacture = new HashSet<LigneDeFacture>();
		Set<LigneDeFacture> autreListeLigneFacture = new HashSet<LigneDeFacture>();

		listeLigneFacture.add(uneLigneFacture);
		listeLigneFacture.add(uneAutreLigneFacture);
		
		autreListeLigneFacture.add(uneFinalLigneFacture);

		Facture uneFacture = new Facture(unClient, uneDate, uneAdresse, listeLigneFacture, Status.NONPAYE);
		Facture uneAutreFacture = new Facture(unAutreClient, uneDate, uneAutreAdresse, autreListeLigneFacture, Status.NONPAYE);
		

		// ASSIGNED ADRESSE TO CLIENT
		//unClient.setAdresseLivraison(uneAdresse);
		//unAutreClient.setAdresseLivraison(uneAutreAdresse);

		// LINK TO DATABASE
		em.getTransaction().begin();
		// SEND STUFF TO DATABASE
		
		em.persist(uneAdresse);
		em.persist(uneAutreAdresse);
		
		em.persist(unClient);
		em.persist(unAutreClient);

		em.persist(uneDescription);
		em.persist(uneAutreDescription);

		em.persist(unArticle);
		em.persist(unAutreArticle);
		em.persist(unFinalArticle);


		em.persist(uneLigneFacture);
		em.persist(uneAutreLigneFacture);
		em.persist(uneFinalLigneFacture);

		em.persist(uneFacture);
		em.persist(uneAutreFacture);

		em.getTransaction().commit();

		Query query = em.createQuery("from Client", Client.class);
		Query query2 = em.createQuery("from Facture", Facture.class);
		
		System.out.println(query.getResultList());
		System.out.println(query2.getResultList());
		em.close();

	}


}
