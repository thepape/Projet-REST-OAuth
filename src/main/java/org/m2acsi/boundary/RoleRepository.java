package org.m2acsi.boundary;

import java.util.Optional;
import org.m2acsi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByNom(String nom);
}