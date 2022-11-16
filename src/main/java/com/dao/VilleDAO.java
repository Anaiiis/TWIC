package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	
	/**
	 * Renvoie la liste de toutes les villes
	 * 
	 * @return liste de toutes les villes
	 */
	public List<Ville> findAllVilles();
	
	/**
	 * Renvoie une ville selon le code commune entré en paramètre
	 * 
	 * @param codeCommune le code commmune
	 * @return la ville correspondante
	 */
	public Ville findVilleByCodeCommune(String codeCommune);
	
	/**
	 * Créé une ville correspondant à la ville entrée en paramètre et la renvoie
	 * pour l'afficher en JSON
	 * 
	 * @param ville la ville à créer
	 * @return la ville créée
	 */
	public Ville createVille(Ville ville);
	
	/**
	 * Modifie la ville entrée en paramètre
	 * 
	 * @param ville la ville à modifier
	 * @return la ville modifiée
	 */
	public Ville updateVille(Ville ville);
	
	/**
	 * Supprime la ville entrée en paramètre
	 * 
	 * @param ville la ville à supprimer
	 */
	public void removeVille(Ville ville);

}
