package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	public List<Ville> getVilles() {
		return villeDAO.findAllVilles();
	}
	
	public Ville getVilleByCodeCommune(String codeCommune) {
		return villeDAO.findVilleByCodeCommune(codeCommune);
	}
	
	public Ville postVille(Ville ville) {
		return villeDAO.createVille(ville);
	}
	
	public Ville putVille(Ville ville) {
		return villeDAO.updateVille(ville);
	}
	
	public void deleteVille(Ville ville) {
		villeDAO.removeVille(ville);
	}

}
