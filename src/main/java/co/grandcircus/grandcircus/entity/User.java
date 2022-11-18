package co.grandcircus.grandcircus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id		
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;

	@Column(length = 10, nullable = false)	
	private String userName;
	
	@Column(length = 25, nullable = false)
	private String lastName;	

	@Column(length = 25, nullable = false)
	private String firstName;	
	
	public User() {
		super();	
	}
	

	public User(int userId) {
		super();
		this.userId = userId;
	}

	public User(int userId, String userName, String lastName, String firstName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public User(String userName, String lastName, String firstName) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
}