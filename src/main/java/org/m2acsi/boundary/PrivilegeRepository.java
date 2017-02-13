package org.m2acsi.boundary;

import java.util.Optional;

import org.m2acsi.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

    Optional<Privilege> findByNom(String nom);
}
