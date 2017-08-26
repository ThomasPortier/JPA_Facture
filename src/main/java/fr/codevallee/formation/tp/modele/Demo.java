package fr.codevallee.formation.tp.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demo_tp")

public class Demo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nom;
	private String prenom;
	private String civilite;



	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + "]";
	}

	
}
