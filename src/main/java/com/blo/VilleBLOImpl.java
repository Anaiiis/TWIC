package com.blo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	public List<Ville> getInfoVilles(String codePostal) {
		List<Ville> villes = new ArrayList<>();
		villes = villeDAO.findAllVillesByZip(codePostal);
		return villes;
	}

}
