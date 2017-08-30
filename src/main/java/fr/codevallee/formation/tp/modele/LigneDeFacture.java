package fr.codevallee.formation.tp.modele;

import javax.persistence.*;

@Entity
public class LigneDeFacture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 10)
	private Integer nombreArticle;
	@OneToOne
	private Article article;

	
	double totalLigneFacture(){
		return nombreArticle * article.getPrix();
	}

	public LigneDeFacture(Integer nombreArticle, Article article) {
		super();
		this.nombreArticle = nombreArticle;
		this.article = article;
	}

	public LigneDeFacture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setNombreArticle(Integer nombreArticle) {
		this.nombreArticle = nombreArticle;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "LigneDeFacture [id=" + id + ", nombreArticle=" + nombreArticle + ", article=" + article + "]";
	}

	
}
