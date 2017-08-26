package fr.codevallee.formation.tp.modele;


import javax.persistence.*;

@Entity
public class Commune {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 40)
	private String nom;
	@OneToOne(mappedBy = "commune")
	private Maire maire;
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setMaire(Maire maire) {
		this.maire = maire;
	}
}
