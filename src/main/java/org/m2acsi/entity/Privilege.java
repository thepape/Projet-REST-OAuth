package org.m2acsi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * represente un privilege dans la BDD
 *
 */
@Entity
@Table(name = "Privilege")
public class Privilege {
  
    @Id
    private String id;
 
    private String nom;
 
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
    
    public Privilege(){
    	super();
    	
    	this.init();
    }
    
    private void init(){
    	this.id = UUID.randomUUID().toString();
    	this.roles = new ArrayList<Role>();
    }

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public List<Role> getRoles() {
		return roles;
	}
    
}
