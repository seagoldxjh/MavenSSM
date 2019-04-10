package com.xjh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjh.entity.Task;
import com.xjh.mapper.TaskMapper;
import com.xjh.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMapper;
	
	@Override
	public List<Task> queryAllTask() {
		return taskMapper.queryAllTask();
	}

	@Override
	public Task queryTaskById(int taskId) {
		return taskMapper.queryTaskById(taskId);
	}

	@Override
	public void releaseTask(Task task) {
		taskMapper.releaseTask(task);
	}

}
