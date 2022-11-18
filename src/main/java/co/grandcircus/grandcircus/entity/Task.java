package co.grandcircus.grandcircus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import co.grandcircus.grandcircus.handlingformsubmission.TaskForm;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private int taskId;

	@Column(length = 35, nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	@ManyToOne
	@JoinColumn(name = "priority_code", nullable = false)
	private Priority priority;

	@ManyToOne
	@JoinColumn(name = "status_code", nullable = false)
	private Status status;

	@Column(nullable = false)
	private String startDate;

	@Column(nullable = false)
	private String endDate;

	@Column(nullable = false)
	private float complete;

	@Column(length = 200)
	private String notes;

	public Task() {
		super();
	}

	public Task(int taskId) {
		super();
		this.taskId = taskId;
	}

	public Task(int taskId, String description, User user, Priority priority, Status status, String startDate,
			String endDate, float complete, String notes) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.user = user;
		this.priority = priority;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.complete = complete;
		this.notes = notes;
	}

	public int getTaskId() {
		return taskId;
	}

	public String getDescription() {
		return description;
	}

	public User getUser() {
		return user;
	}

	public Priority getPriority() {
		return priority;
	}

	public Status getStatus() {
		return status;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public float getComplete() {
		return complete;
	}

	public String getNotes() {
		return notes;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", *user=" + user.getUserName()
				+ ", *priority=" + priority.getDescription() + ", *status=" + status.getDescription() + ", startDate="
				+ startDate + ", endDate=" + endDate + ", complete=" + complete + ", notes=" + notes + "]";
	}

	public void insert(TaskForm taskForm) {
		this.complete = taskForm.getComplete();
		this.description = taskForm.getDescription();
		this.endDate = taskForm.getEndDate().replace("-", ".");
		this.priority =  new Priority(taskForm.getPriorityCode());
		this.startDate = taskForm.getStartDate().replace("-", ".");
		this.status = new Status(taskForm.getStatusCode());
		this.user = new User(taskForm.getUserId());			
	}

}
