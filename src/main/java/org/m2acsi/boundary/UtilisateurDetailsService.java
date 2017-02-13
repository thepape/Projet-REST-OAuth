package org.m2acsi.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.m2acsi.entity.Privilege;
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
                asGrantedAuthorities(getPrivilegesFromUtilisateur(user)));	//ici, on recupere les privileges associe a cet utilisateur
    	
    	
    	return u;
    }
    
    /**
     * Permet de recuperer les privileges d'un utilisateur
     * @param user utilisateur present en base
     * @return liste des privileges de cet utilisateur en base, sous forme de strings
     */
    private List<String> getPrivilegesFromUtilisateur(Utilisateur user){
    	List<String> privileges = new ArrayList<String>();
    	
    	for(Role role : user.getRoles()){
    		for(Privilege privilege : role.getPrivileges()){
    			if(!privileges.contains(privilege.getNom())){
    				privileges.add(privilege.getNom());
    			}
    		}
    	}
    	
    	return privileges;
    }
    
    /**
     * Permet de convertir une liste de privileges sous forme de strings en liste de GrantedAuthority, 
     * pour la passer dans OAuth
     * @param privileges
     * @return
     */
    private List<GrantedAuthority> asGrantedAuthorities(List<String> privileges){
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    	
    	for(String privilege : privileges){
    		authorities.add(new SimpleGrantedAuthority(privilege));
    	}
    	
    	return authorities;
    }
}