package com.xjh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjh.entity.TaskStu;
import com.xjh.mapper.TaskStuMapper;
import com.xjh.service.TaskStuService;

@Service
public class TaskStuServiceImpl implements TaskStuService {

	@Autowired
	private TaskStuMapper taskStumapper;
	
	@Override
	public int queryTaskStu(TaskStu taskStu) {
		return taskStumapper.queryTaskStu(taskStu);
	}

	@Override
	public void insertTaskStu(TaskStu taskStu) {
		taskStumapper.insertTaskStu(taskStu);
	}

	@Override
	public String queryTaskState(TaskStu taskStu) {
		return taskStumapper.queryTaskState(taskStu);
	}

	@Override
	public void acceptTask(TaskStu taskStu) {
		taskStumapper.acceptTask(taskStu);
	}

	@Override
	public void finishTask(TaskStu taskStu) {
		System.out.println(taskStu);
		taskStumapper.finishTask(taskStu);
	}

}
