package com.stock.dao;


 
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.mapping.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name="Registration")
public class User implements UserDetails {


 

	private String first_name;
	

	private String last_name;
	
	@Id
	private String username;
	

	private String email;
	

	private String dob;
	
	private String password;
	
	private boolean enabled=true;
	
	
	
	public User() {
		this(null, null, null, null, null, null);
	}
	
	
	
	

	public User(String first_name, String last_name, String username, String email, String dob, String password) {
		 
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.dob = dob;
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}





	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", username=" + username + ", email="
				+ email + ", dob=" + dob + ", password=" + password + "]";
	}



	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      
    
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

	

}
