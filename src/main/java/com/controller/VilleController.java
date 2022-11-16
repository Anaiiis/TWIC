package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	@GetMapping("/getVille")
	@ResponseBody
	public List<Ville> get() {
		return villeBLOService.getVilles();
	}

	@GetMapping("/getVille/{codeCommune}")
	@ResponseBody
	public Ville getByCodeCommune(@PathVariable(value = "codeCommune") String codeCommune) {
		return villeBLOService.getVilleByCodeCommune(codeCommune);
	}

	@PostMapping("/postVille")
	public ResponseEntity<Ville> post(@RequestBody Ville ville) {
		return new ResponseEntity<>(villeBLOService.postVille(ville), HttpStatus.CREATED);
	}

	@PutMapping("/putVille/{codeCommune}")
	public ResponseEntity<Ville> put(@PathVariable(value = "codeCommune") String codeCommune,
			@RequestBody Ville villeDetails) {
		Ville ville = villeBLOService.getVilleByCodeCommune(codeCommune);

		if (ville != null) {
			ville.setNomCommune(villeDetails.getNomCommune());
			ville.setCodePostal(villeDetails.getCodePostal());
			ville.setLibelleAcheminement(villeDetails.getLibelleAcheminement());
			ville.setLigne(villeDetails.getLigne());
			ville.setCoordonnees(villeDetails.getCoordonnees());

			Ville updatedVille = villeBLOService.putVille(ville);
			return ResponseEntity.ok(updatedVille);
		} else {
			return null;
		}
	}

	@DeleteMapping("/deleteVille/{codeCommune}")
	public Map<String, Boolean> delete(@PathVariable(value = "codeCommune") String codeCommune) {
		Ville ville = villeBLOService.getVilleByCodeCommune(codeCommune);
		Map<String, Boolean> response = new HashMap<>();

		if (ville != null) {
			villeBLOService.deleteVille(ville);
			response.put("deleted", Boolean.TRUE);
		} else {
			response.put("deleted", Boolean.FALSE);
		}
		
		return response;
	}

}
