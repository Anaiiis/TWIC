package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	
	public List<Ville> findAllVilles();
	
	public List<Ville> findAllVillesByZip(String codePostal);

}
