package org.m2acsi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@NamedQuery(name="utilisateursParUsername",
		query = " SELECT u FROM Utilisateur u WHERE"
				+ " u.username = :username")


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @Column(name="id")
    private String id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="active")
    private boolean active;
    
    

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "Utilisateur_Role",
    	joinColumns=@JoinColumn(name="id_utilisateur"),
    	inverseJoinColumns=@JoinColumn(name="id_role"))
   	private List<Role> roles;

    public Utilisateur() {
    	super();
    	this.init();
    }

    public Utilisateur(String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
        
        this.init();
    }
    
    private void init(){
    	this.id = UUID.randomUUID().toString();
    	this.roles = new ArrayList<Role>();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }
    
    public boolean addRole(Role role){
    	if(!this.roles.contains(role)){
    		this.roles.add(role);
    		role.addUtilisateur(this);
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean removeRole(Role role){
    	if(this.roles.contains(role)){
    		this.roles.remove(role);
    		role.removeUtilisateur(this);
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean equals(Object o){
		if(o instanceof Utilisateur){
			if(((Utilisateur) o).id.equals(this.id)){
				return true;
			}
		}
		
		return false;
	}
    
    public List<Role> getRoles() {
		return roles;
	}
}