package co.grandcircus.grandcircus.handlingformsubmission;

import co.grandcircus.grandcircus.entity.Task;

public class TaskForm {

	private int taskId;
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String description;
	private String priorityCode;
	private String statusCode;
	private String startDate;
	private String endDate;
	private float complete;
	private String notes;

	public float getComplete() {
		return complete;
	}

	public void populateForm(Task task) {
		this.taskId = task.getTaskId();
		this.userId = task.getUser().getUserId();
		this.userName = task.getUser().getUserName();
		this.firstName = task.getUser().getFirstName();
		this.lastName = task.getUser().getLastName();
		this.priorityCode = task.getPriority().getPriorityCode();
		this.statusCode = task.getStatus().getStatusCode();
		this.description = task.getDescription();
		this.startDate = task.getStartDate().replace(".", "-");
		this.endDate = task.getEndDate().replace(".", "-");
		this.complete = task.getComplete();
		this.notes = task.getNotes();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setComplete(float complete) {
		this.complete = complete;
	}

	

	public TaskForm() {
		super();
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

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "TaskForm [taskId=" + taskId + ", userId=" + userId + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", description=" + description + ", priorityCode="
				+ priorityCode + ", statusCode=" + statusCode + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", complete=" + complete + ", notes=" + notes + "]";
	}

}
