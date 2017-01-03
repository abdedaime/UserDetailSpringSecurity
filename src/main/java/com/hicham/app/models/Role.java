package com.hicham.app.models;

import java.io.Serializable;
/***
 * 
 * @author hicham-abdedaime
 *
 */

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Role  implements  Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String    nom;
	private String  description;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
