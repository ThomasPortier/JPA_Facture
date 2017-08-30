package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 80)
	private String champAdresse;
	@Column(length = 40)
	private String ville;
	@Column(length = 10)
	private Integer zipCode;
	@Column(length = 40)
	private String pays;

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(String champAdresse, String ville, Integer zipCode, String pays) {
		super();
		this.champAdresse = champAdresse;
		this.ville = ville;
		this.zipCode = zipCode;
		this.pays = pays;
	}

	public void setChampAdresse(String champAdresse) {
		this.champAdresse = champAdresse;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}


	@Override
	public String toString() {
		return "Adresse [id=" + id + ", champAdresse=" + champAdresse + ", ville=" + ville + ", zipCode=" + zipCode
				+ ", pays=" + pays + "]";
	}

}
