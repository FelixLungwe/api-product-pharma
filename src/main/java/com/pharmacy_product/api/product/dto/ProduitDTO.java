package com.pharmacy_product.api.product.dto;

public class ProduitDTO {
    private Long id;
    private String nom;
    private String dci;
    private String categorie;
    private Boolean necessiteOrdonnance;
    private String forme;
    
	public ProduitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProduitDTO(Long id, String nom, String dci, String categorie, Boolean necessiteOrdonnance, String forme) {
		super();
		this.id = id;
		this.nom = nom;
		this.dci = dci;
		this.categorie = categorie;
		this.necessiteOrdonnance = necessiteOrdonnance;
		this.forme = forme;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDci() {
		return dci;
	}
	public void setDci(String dci) {
		this.dci = dci;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Boolean getNecessiteOrdonnance() {
		return necessiteOrdonnance;
	}
	public void setNecessiteOrdonnance(Boolean necessiteOrdonnance) {
		this.necessiteOrdonnance = necessiteOrdonnance;
	}
	public String getForme() {
		return forme;
	}
	public void setForme(String forme) {
		this.forme = forme;
	}
    
    
}
