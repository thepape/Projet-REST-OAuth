package org.m2acsi;

import java.util.stream.Stream;

import org.m2acsi.boundary.RoleRepository;
import org.m2acsi.boundary.UtilisateurRepository;
import org.m2acsi.entity.Role;
import org.m2acsi.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Component;

@EnableResourceServer
@SpringBootApplication
public class OauthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServiceApplication.class, args);
	}
}
