package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Maire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 40)
	private String nom;
	
	@OneToOne
	private Commune commune;
	
	@OneToMany
	private Set<Elu> Elu;

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Maire [id=" + id + ", nom=" + nom + ", commune=" + commune + "]";
	}

}