package com.xjh.mapper;

import java.util.List;

import com.xjh.entity.Task;

public interface TaskMapper {
	public List<Task> queryAllTask();
	public Task queryTaskById(int taskId);
	public void releaseTask(Task task);
}
