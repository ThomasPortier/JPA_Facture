package fr.codevallee.formation.tp1;

import static spark.Spark.get;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

public class Router implements SparkApplication {

	public void init() {

		get("/exemple1", (request, response) -> {
			Map<String, Object> attributes;
			attributes = new HashMap<>();
			try {
				System.out.println("hello");
				ConnectionJDBC conn = new ConnectionJDBC();
				Statement stmt = conn.getConn().createStatement();
				String querry = "Select ID_Plat, nom, tarif from Plat";
				ResultSet rset = stmt.executeQuery(querry);
				ArrayList<Plat> listePlat = new ArrayList<>();
				System.out.println("hello2");
				while (rset.next()) {
					// listePlat.add(new Plat(id_Plat, nom, tarif))
					listePlat.add(new Plat(rset.getInt("id_Plat"), rset.getString("nom"), rset.getInt("tarif")));
				}

				attributes.put("listePlat", listePlat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
