package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Coordonnees;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	@Autowired
    private DaoFactory daoFactory;

	public List<Ville> findAllVilles() {
		
        String sql = "SELECT * FROM ville_france;";
        List<Ville> villes = new ArrayList<>();
        
        try (Connection co = daoFactory.getConnection()) {
        	
        	try (Statement s = co.createStatement()) {

                try (ResultSet rs = s.executeQuery(sql)) {
                	
                	while(rs.next()) {
                		Coordonnees coordonnees = new Coordonnees(rs.getInt("Latitude"),
                				rs.getInt("Longitude"));
                		Ville ville = new Ville(rs.getString("Code_commune_INSEE"),
                				rs.getString("Nom_commune"),
                				rs.getString("Code_postal"),
                				rs.getString("Libelle_acheminement"),
                				rs.getString("Ligne_5"), coordonnees
                				);
		            	villes.add(ville);
                	}           	
                }  
        	}
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        return villes;
        
	}
	
	public List<Ville> findAllVillesByZip(String codePostal) {
		
        String sql = "SELECT * FROM ville_france WHERE Code_postal = ?;";
        List<Ville> villes = new ArrayList<>();
        
        try (Connection co = daoFactory.getConnection()) {
        	
        	try (PreparedStatement ps = co.prepareStatement(sql)) {
        		
        		ps.setString(1, codePostal);

                try (ResultSet rs = ps.executeQuery()) {
                	
                	while(rs.next()) {
                		Coordonnees coordonnees = new Coordonnees(rs.getInt("Latitude"),
                				rs.getInt("Longitude"));
                		Ville ville = new Ville(rs.getString("Code_commune_INSEE"),
                				rs.getString("Nom_commune"),
                				rs.getString("Code_postal"),
                				rs.getString("Libelle_acheminement"),
                				rs.getString("Ligne_5"), coordonnees
                				);
		            	villes.add(ville);
                	}           	
                }  
        	}
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        return villes;
        
	}

}
