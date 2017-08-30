package fr.codevallee.formation.tp.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArticleDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 40)
	private String nom;
	@Column(length = 400)
	private String description;

	
	
	public ArticleDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDescription(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
