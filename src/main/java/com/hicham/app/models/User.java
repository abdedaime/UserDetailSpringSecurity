package com.hicham.app.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/***
 * 
 * @author hicham-abdedaime
 *
 */
@Entity
@Table(name="users")
public class User   implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    private String   username;
    private String  password;
    private   boolean  actived;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="users_roles")
    private Set<Role> roles;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
    
	
	
	
}
