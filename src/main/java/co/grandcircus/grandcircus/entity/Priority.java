package co.grandcircus.grandcircus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Priority {
	
	@Id
	@Column(length = 3,  unique = true)
	private String priorityCode;
	
	@Column(length = 20)
	private String description;	

	public Priority() {
		super();
	}	

	public Priority(String priorityCode) {
		super();
		this.priorityCode = priorityCode;
	}

	public Priority(String priorityCode, String description) {
		super();
		this.priorityCode = priorityCode;
		this.description = description;
	}		

	public String getPriorityCode() {
		return priorityCode;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Status [priorityCode=" + priorityCode + ", description=" + description + "]";
	}	
}
