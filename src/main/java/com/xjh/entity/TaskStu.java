package com.xjh.entity;

public class TaskStu {
	private int taskId;
	private int stuNo;
	private String state;
	private String fileNmae;

	
	
	@Override
	public String toString() {
		return "TaskStu [taskId=" + taskId + ", stuNo=" + stuNo + ", state=" + state + ", fileNmae=" + fileNmae + "]";
	}


	public TaskStu(int taskId, int stuNo, String state, String fileNmae) {
		super();
		this.taskId = taskId;
		this.stuNo = stuNo;
		this.state = state;
		this.fileNmae = fileNmae;
	}
	
	
	public TaskStu(int taskId, int stuNo, String state) {
		super();
		this.taskId = taskId;
		this.stuNo = stuNo;
		this.state = state;
	}


	public String getFileNmae() {
		return fileNmae;
	}
	public void setFileNmae(String fileNmae) {
		this.fileNmae = fileNmae;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public TaskStu(int taskId, int stuNo) {
		this.taskId = taskId;
		this.stuNo = stuNo;
	}
	public TaskStu() {
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	
}
