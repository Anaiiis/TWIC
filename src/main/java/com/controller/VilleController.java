package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;
	
	// Fonction pour récupérer le contenu de la BDD
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal) {
		System.out.println("get");
		
		// Mon code vers la BDD
		List<Ville> villes = villeBLOService.getInfoVilles(codePostal);
		
		return villes;
	}

}
