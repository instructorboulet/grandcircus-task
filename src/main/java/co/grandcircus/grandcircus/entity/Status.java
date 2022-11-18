package co.grandcircus.grandcircus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "status")
public class Status {
	
	@Id
	@Column(length = 3,nullable = false, unique = true)
	private String statusCode;
	
	@Column(length = 50, nullable = false)
	private String description;	
	
	public Status() {
		super();
	
	}

	public Status(String statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public Status(String statusCode, String description) {
		super();
		this.statusCode = statusCode;
		this.description = description;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Status [statusCode=" + statusCode + ", description=" + description + "]";
	}
	
	
}
