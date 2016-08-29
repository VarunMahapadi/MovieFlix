package io.egen.movieflix.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

//import org.springframework.context.annotation.Lazy;

//import org.hibernate.annotations.GenericGenerator;

/**
 * @author thomas
 *
 */
@NamedQueries({
	
	//@NamedQuery(name = "User.insertUser", query = "SELECT u FROM User u WHERE u.email=:pEmail"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email=:pEmail"),
	@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id=:pId")
})

@Entity
@Table 
public class User {

	@Id
	private String id;
	
	private String password;
	
	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String email;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	
}

