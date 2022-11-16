package com.blo;

import java.util.List;

import com.dto.Ville;

public interface VilleBLO {

	/**
	 * Renvoie la liste de toutes les villes
	 * 
	 * @return liste de toutes les villes
	 */
	public List<Ville> getVilles();

	/**
	 * Renvoie une ville selon le code commune entré en paramètre
	 * 
	 * @param codeCommune le code commmune
	 * @return la ville correspondante
	 */
	public Ville getVilleByCodeCommune(String codeCommune);

	/**
	 * Créé une ville correspondant à la ville entrée en paramètre et la renvoie
	 * pour l'afficher en JSON
	 * 
	 * @param ville la ville à créer
	 * @return la ville créée
	 */
	public Ville postVille(Ville ville);

	/**
	 * Modifie la ville entrée en paramètre
	 * 
	 * @param ville la ville à modifier
	 * @return la ville modifiée
	 */
	public Ville putVille(Ville ville);

	/**
	 * Supprime la ville entrée en paramètre
	 * 
	 * @param ville la ville à supprimer
	 */
	public void deleteVille(Ville ville);

}
