package org.m2acsi.boundary;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.m2acsi.entity.Role;
import org.m2acsi.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class UtilisateurDetailsService implements UserDetailsService {

    private final UtilisateurRepository accountRepository;
    
    @PersistenceContext
	EntityManager em;

    @Autowired
    public UtilisateurDetailsService(UtilisateurRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	Optional<Utilisateur> ouser = this.accountRepository.findByUsername(username);
    	
    	if(ouser.get() == null){
    		throw new UsernameNotFoundException("Pb!");
    	}
    	
    	Utilisateur user = ouser.get();
    	
    	User u = new User(
    			user.getUsername(),
    			user.getPassword(),
    			user.isActive(), 
                user.isActive(), 
                user.isActive(), 
                user.isActive(),
                AuthorityUtils.createAuthorityList());
    	
    	return u;
    	
    	/*
        return this.accountRepository.findByUsername(s)
                .map(account -> new User(
                        account.getUsername(),
                        account.getPassword(),
                        account.isActive(), 
                        account.isActive(), 
                        account.isActive(), 
                        account.isActive(),
                        AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN")
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Pb!"));*/
    }
}