package org.m2acsi.boundary;

import java.util.Optional;
import org.m2acsi.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    Optional<Utilisateur> findByUsername(String username);
}