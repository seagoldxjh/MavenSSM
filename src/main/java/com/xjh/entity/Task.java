package com.xjh.entity;

import java.util.Date;

public class Task {
	private int taskId;
	private String taskTitle;
	private Date taskStart;
	private Date taskEnd;
	private String taskDetails;
	private String taskCreator;
	
	public Task() {
	}
	
	public Task(int taskId, String taskTitile, Date taskStart, Date taskEnd, String taskDetails, String taskCreator) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitile;
		this.taskStart = taskStart;
		this.taskEnd = taskEnd;
		this.taskDetails = taskDetails;
		this.taskCreator = taskCreator;
	}
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public Date getTaskStart() {
		return taskStart;
	}
	public void setTaskStart(Date taskStart) {
		this.taskStart = taskStart;
	}
	public Date getTaskEnd() {
		return taskEnd;
	}
	public void setTaskEnd(Date taskEnd) {
		this.taskEnd = taskEnd;
	}
	public String getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	public String getTaskCreator() {
		return taskCreator;
	}
	public void setTaskCreator(String taskCreator) {
		this.taskCreator = taskCreator;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskStart=" + taskStart + ", taskEnd="
				+ taskEnd + ", taskDetails=" + taskDetails + ", taskCreator=" + taskCreator + "]";
	}
}
