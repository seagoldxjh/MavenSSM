package com.xjh.mapper;

import com.xjh.entity.TaskStu;

public interface TaskStuMapper {
	public int queryTaskStu(TaskStu taskStu);
	public void insertTaskStu(TaskStu taskStu);
	public String queryTaskState(TaskStu taskStu);
	public void acceptTask(TaskStu taskStu);
	public void finishTask(TaskStu taskStu);
}
