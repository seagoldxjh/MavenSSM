package com.xjh.service;

import java.util.List;

import com.xjh.entity.Task;

public interface TaskService {
	public List<Task> queryAllTask();
	public Task queryTaskById(int taskId);
	public void releaseTask(Task task);
}
