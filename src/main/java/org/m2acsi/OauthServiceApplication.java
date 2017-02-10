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

/*

@Component
class AccountCLR implements CommandLineRunner {

	
    private UtilisateurRepository utilisateursRepository;
    private RoleRepository roleRepository;

    @Autowired
    public void AccountCLR(UtilisateurRepository accountRepository) {
        this.utilisateursRepository = accountRepository;
    }
    
    @Autowired
    public void rolesCLR(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Utilisateur u1 = new Utilisateur("romain","password", true);
        Role r1 = new Role("admin");
        
        u1.addRole(r1);
        
        this.utilisateursRepository.save(u1);
        this.roleRepository.save(r1);
    }
}
*/
