package fr.codevallee.formation.tp.modele;

import javax.persistence.*;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 40)
	private double prix;
	@Column(length = 40)
	private Integer reference;
	@ManyToOne
	private ArticleDescription articleDescription;

	public Article() {
		super();
	}

	public Article(double prix, Integer reference, ArticleDescription articleDescription) {
		super();
		this.prix = prix;
		this.reference = reference;
		this.articleDescription = articleDescription;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	public void setArticleDescription(ArticleDescription articleDescription) {
		this.articleDescription = articleDescription;
	}

}
