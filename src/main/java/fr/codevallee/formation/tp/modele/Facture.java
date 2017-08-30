package fr.codevallee.formation.tp.modele;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Client client;
	
	@Column
	private Date date;
	
	@OneToOne
	private Adresse adresseFacturation;
	
	@OneToMany//(nullable=true)
	private Set<LigneDeFacture> ligneDeFacture;
	
	@Column
	private Status status;
	
	
	public Facture(Client client, Date date, Adresse adresseFacturation, Set<LigneDeFacture> ligneDeFacture,
			Status status) {
		super();
		this.client = client;
		this.date = date;
		this.adresseFacturation = adresseFacturation;
		this.ligneDeFacture = ligneDeFacture;
		this.status = status;
	}


	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public void setLigneDeFacture(Set<LigneDeFacture> ligneDeFacture) {
		this.ligneDeFacture = ligneDeFacture;
	}


	@Override
	public String toString() {
		return "Facture [id=" + id + ", client=" + client + ", date=" + date + ", adresseFacturation="
				+ adresseFacturation + ", ligneDeFacture=" + ligneDeFacture + ", status=" + status + "]\n";
	}
	

}
