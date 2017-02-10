package org.m2acsi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {

	 @Id
	 @Column(name = "id")
	 private String id;
	 
	 @Column(name = "nom")
	 private String nom;
	 
	 @ManyToMany(mappedBy="roles")
	 private List<Utilisateur> utilisateurs;
	 
	 public Role(){
		 super();
		 
		 this.init();
	 }
	 
	 public Role(String nom){
		 this.nom = nom;
		 this.init();
	 }
	 
	 private void init(){
		 this.id = UUID.randomUUID().toString();
		 this.utilisateurs = new ArrayList<Utilisateur>();
	 }

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	 
	public boolean equals(Object o){
		if(o instanceof Role){
			if(((Role) o).id.equals(this.id)){
				return true;
			}
		}
		
		return false;
	}
	
	protected boolean addUtilisateur(Utilisateur user){
    	if(!this.utilisateurs.contains(user)){
    		this.utilisateurs.add(user);
    		return true;
    	}
    	
    	return false;
    }
    
    protected boolean removeUtilisateur(Utilisateur user){
    	if(this.utilisateurs.contains(user)){
    		this.utilisateurs.remove(user);
    		return true;
    	}
    	
    	return false;
    }
}
