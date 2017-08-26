package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.codevallee.formation.tp.modele.Commune;
import fr.codevallee.formation.tp.modele.Demo;
import fr.codevallee.formation.tp.modele.Elu;
import fr.codevallee.formation.tp.modele.Maire;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Router implements SparkApplication {

	public void init() {

		Map<String, Object> attributes = new HashMap<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Demo> query = em.createQuery("from Demo", Demo.class);
		attributes.put("objets", query.getResultList());

		// Commune uneCommune = new Commune();
		// uneCommune.setNom("Cregftrezhgfdst");
		// Commune uneAutreCommune = new Commune();
		// uneAutreCommune.setNom("Valytgrfertytrenjhgfce");
		//
		// Maire unMaire = new Maire();
		// unMaire.setNom("Monbugfdytregfdisson");
		// Maire unAutreMaire = new Maire();
		// unAutreMaire.setNom("Marjhhgfdsgfmgfdelade");
		//
		// //uneCommune.setMaire(unMaire);
		// //uneAutreCommune.setMaire(unAutreMaire);
		//
		// unMaire.setCommune(uneCommune);
		// unAutreMaire.setCommune(uneAutreCommune);
		//
		//
		// em.getTransaction().begin();
		// em.persist(unMaire);
		// em.persist(unAutreMaire);
		// em.persist(uneAutreCommune);
		// em.persist(uneCommune);
		// em.getTransaction().commit();
		// em.close();

		get("/ajouter", (request, response) -> {
			return new ModelAndView(attributes, "ajouter.ftl");
		}, getFreeMarkerEngine());

		get("/resultat_ajouter", (request, response) -> {
			String nomCommune = request.queryParams("nomCommune");
			String nomMaire = request.queryParams("nomMaire");

			Maire unMaire = new Maire();
			unMaire.setNom(nomMaire);

			Commune uneCommune = new Commune();
			uneCommune.setNom(nomCommune);

			unMaire.setCommune(uneCommune);

			em.getTransaction().begin();
			em.persist(uneCommune);
			em.persist(unMaire);
			em.getTransaction().commit();
			em.close();

			attributes.put("nomCommune", nomCommune);
			attributes.put("nomMaire", nomMaire);

			return new ModelAndView(attributes, "resultat_ajouter.ftl");
		}, getFreeMarkerEngine());

		get("/supprimer", (request, response) -> {
			return new ModelAndView(attributes, "supprimer.ftl");
		}, getFreeMarkerEngine());

		get("/resultat_supprimer", (request, response) -> {
			int idMaireInt = Integer.parseInt(request.queryParams("id"));
			System.out.println(idMaireInt);
			//String idMaire = request.queryParams("id");
			//int idMaireInt = Integer.parseInt(idMaire);
			//Id supprimé ${idMaire} 
			Maire unMaireToDelete = em.find(Maire.class, idMaireInt);
			//System.out.println(unMaireToDelete);
			
			em.getTransaction().begin();
			em.remove(unMaireToDelete);
			em.getTransaction().commit();
			em.close();
			
			//attributes.put("id", idMaire);
			return new ModelAndView(attributes, "resultat_supprimer.ftl");
		}, getFreeMarkerEngine());

		get("/home", (request, response) -> {
			// System.out.println(listePersonne);
			attributes.put("objets", query.getResultList());
			return new ModelAndView(attributes, "home.ftl");
		}, getFreeMarkerEngine());
	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}
}

//
// Elu unElu2 = new Elu();
// unElu2.setNom("Vladimir");
//
// Elu unAutreElu = new Elu();
// unAutreElu.setNom("Rodrigue");
//
//
//
//
//
// em.getTransaction().begin();
// em.persist(unElu2);
// em.persist(unAutreElu);
// em.remove(unElu);
// em.getTransaction().commit();
// em.close();

// final Logger logger = LoggerFactory.getLogger(Router.class);
//
// get("/exemple1", (request, response) -> {
//
// logger.debug("start");
//
// Map<String, Object> attributes = new HashMap<>();
//
// // Exemple 1 (à déplacer dans une classe statique !):
// EntityManagerFactory entityManagerFactory =
// Persistence.createEntityManagerFactory("formation");
// EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//
// // J'ajoute un métier :
// Demo metier = new Demo();
// metier.setNom("exemple1");
//
// TypedQuery<Demo> query = entityManager.createQuery("from Demo", Demo.class);
// attributes.put("objets", query.getResultList());
//
// entityManager.getTransaction().begin();
// entityManager.persist(metier);
// entityManager.getTransaction().commit();
// entityManager.close();
//
// return new ModelAndView(attributes, "home.ftl");
// }, getFreeMarkerEngine());

/////////////////////////////////////////////////////////////////////////////////

// get("/lecture", (request, response) -> {
// Map<String, Object> attributes = new HashMap<>();
// return new ModelAndView(attributes, "lecture.ftl");
// }, getFreeMarkerEngine());
//
// get("/update", (request, response) -> {
// Map<String, Object> attributes = new HashMap<>();
// return new ModelAndView(attributes, "update.ftl");
// }, getFreeMarkerEngine());
//
// get("/suppression", (request, response) -> {
// Map<String, Object> attributes = new HashMap<>();
// return new ModelAndView(attributes, "suppression.ftl");
// }, getFreeMarkerEngine());

///////////////////////////////////////////////////////////////////////////////////

//// List<String> listePersonne = entityManager.createQuery("SELECT nom FROM
//// Demo").getResultList();

/////////////////////////////////////////////////////////////////////////////////////
//
//// <thead><th>Civilite</th><th>Nom</th><th>Prenom</th></thead>
////
// </tbody>
// <thead><th>Civilite</th><th>Nom</th><th>Prenom</th></thead>

// <td>${obj.prenom}</td><td>${obj.civilite}</td>