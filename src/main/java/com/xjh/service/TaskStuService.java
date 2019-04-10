package com.xjh.service;

import com.xjh.entity.TaskStu;

public interface TaskStuService {
	public int queryTaskStu(TaskStu taskStu);
	public void insertTaskStu(TaskStu taskStu);
	public String queryTaskState(TaskStu taskStu);
	public void acceptTask(TaskStu taskStu);
	public void finishTask(TaskStu taskStu);
}
