package com.dto;

public class Ville {

	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne;
	private Coordonnees coordonnees;

	public Ville() {
		super();
	}

	/**
	 * @param codeCommune
	 * @param nomCommune
	 * @param codePostal
	 * @param libelleAcheminement
	 * @param ligne
	 * @param coordonnees
	 */
	public Ville(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne,
			Coordonnees coordonnees) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne = ligne;
		this.coordonnees = coordonnees;
	}

	/**
	 * @return the codeCommune
	 */
	public String getCodeCommune() {
		return codeCommune;
	}

	/**
	 * @param codeCommune the codeCommune to set
	 */
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	/**
	 * @return the nomCommune
	 */
	public String getNomCommune() {
		return nomCommune;
	}

	/**
	 * @param nomCommune the nomCommune to set
	 */
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the libelleAcheminement
	 */
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	/**
	 * @param libelleAcheminement the libelleAcheminement to set
	 */
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	/**
	 * @return the ligne
	 */
	public String getLigne() {
		return ligne;
	}

	/**
	 * @param ligne the ligne to set
	 */
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	/**
	 * @return the coordonnees
	 */
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	/**
	 * @param coordonnees the coordonnees to set
	 */
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

}
