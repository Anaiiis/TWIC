package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Coordonnees;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	private static final Logger LOG = LogManager.getLogger(VilleDAOImpl.class);

	@Autowired
	private DaoFactory daoFactory;

	public List<Ville> findAllVilles() {

		String sql = "SELECT * FROM ville_france;";
		List<Ville> villes = new ArrayList<>();

		try (Connection co = daoFactory.getConnection()) {

			try (Statement s = co.createStatement()) {

				try (ResultSet rs = s.executeQuery(sql)) {

					while (rs.next()) {
						Coordonnees coordonnees = new Coordonnees(rs.getInt("Latitude"), rs.getInt("Longitude"));
						Ville ville = new Ville(rs.getString("Code_commune_INSEE"), rs.getString("Nom_commune"),
								rs.getString("Code_postal"), rs.getString("Libelle_acheminement"),
								rs.getString("Ligne_5"), coordonnees);
						villes.add(ville);
					}
				}
			}

		} catch (SQLException e) {
			LOG.fatal(e);
		}

		return villes;

	}

	public Ville findVilleByCodeCommune(String codeCommune) {

		String sql = "SELECT * FROM ville_france WHERE Code_commune_INSEE = ?;";
		Ville ville = null;

		try (Connection co = daoFactory.getConnection()) {

			try (PreparedStatement ps = co.prepareStatement(sql)) {

				ps.setString(1, codeCommune);

				try (ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Coordonnees coordonnees = new Coordonnees(rs.getInt("Latitude"), rs.getInt("Longitude"));
						ville = new Ville(rs.getString("Code_commune_INSEE"), rs.getString("Nom_commune"),
								rs.getString("Code_postal"), rs.getString("Libelle_acheminement"),
								rs.getString("Ligne_5"), coordonnees);
					}
				}
			}

		} catch (SQLException e) {
			LOG.fatal(e);
		}

		return ville;

	}

	public Ville createVille(Ville ville) {

		String sql = "INSERT INTO ville_france VALUES(?, ?, ?, ?, ?, ?, ?);";

		try (Connection co = daoFactory.getConnection()) {

			try (PreparedStatement ps = co.prepareStatement(sql)) {

				ps.setString(1, ville.getCodeCommune());
				ps.setString(2, ville.getNomCommune());
				ps.setString(3, ville.getCodePostal());
				ps.setString(4, ville.getLibelleAcheminement());
				ps.setString(5, ville.getLigne());
				ps.setDouble(6, ville.getCoordonnees().getLatitude());
				ps.setDouble(7, ville.getCoordonnees().getLongitude());

				ps.executeUpdate();

			}

		} catch (SQLException e) {
			LOG.fatal(e);
		}

		return ville;

	}

	public Ville updateVille(Ville ville) {

		String sql = "UPDATE ville_france SET Nom_commune = ?, Code_postal = ?, Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, Longitude = ? WHERE Code_commune_INSEE = ?;";

		try (Connection co = daoFactory.getConnection()) {

			try (PreparedStatement ps = co.prepareStatement(sql)) {

				ps.setString(1, ville.getNomCommune());
				ps.setString(2, ville.getCodePostal());
				ps.setString(3, ville.getLibelleAcheminement());
				ps.setString(4, ville.getLigne());
				ps.setDouble(5, ville.getCoordonnees().getLatitude());
				ps.setDouble(6, ville.getCoordonnees().getLongitude());
				ps.setString(7, ville.getCodeCommune());

				ps.executeUpdate();

			}

		} catch (SQLException e) {
			LOG.fatal(e);
		}

		return ville;

	}
	
	public void removeVille(Ville ville) {

		String sql = "DELETE FROM ville_france WHERE Code_commune_INSEE = ?;";

		try (Connection co = daoFactory.getConnection()) {

			try (PreparedStatement ps = co.prepareStatement(sql)) {

				ps.setString(1, ville.getCodeCommune());
				ps.executeUpdate();

			}

		} catch (SQLException e) {
			LOG.fatal(e);
		}
	}

}
