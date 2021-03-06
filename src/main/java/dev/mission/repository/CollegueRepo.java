package dev.mission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.mission.entite.Collegue;

public interface CollegueRepo extends JpaRepository<Collegue, Integer> {
	
	@Query("select c.matricule from Collegue c where c.nom=:nom")
	List<String> findByNom(@Param("nom") String nom);
	
	@Modifying
	@Query("UPDATE Collegue c SET c.email = :newEmail WHERE c.email = :oldEmail")
	void changerEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);

	@Modifying
	@Query("UPDATE Collegue c SET c.photoUrl = :newPhotoUrl WHERE c.photoUrl = :oldPhotoUrl")
	void changerPhotoUrl(@Param("oldPhotoUrl") String oldPhotoUrl, @Param("newPhotoUrl") String newPhotoUrl);

}
