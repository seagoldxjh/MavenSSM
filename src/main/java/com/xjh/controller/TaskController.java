package com.xjh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjh.entity.Task;
import com.xjh.entity.TaskStu;
import com.xjh.service.TaskService;
import com.xjh.service.TaskStuService;

@Controller
@RequestMapping("/")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private TaskStuService taskStuService;
	
	@RequestMapping("queryAllTask")
	@ResponseBody
	public List<Task> queryAllTask(){
		List<Task> tasks = new ArrayList<>();
		tasks = taskService.queryAllTask();
		return tasks;
	}
	
	@RequestMapping("queryTaskById")
	@ResponseBody
	public Task queryTaskById(@RequestParam("taskId") Integer taskId){
		return taskService.queryTaskById(taskId);
	}
	
	@RequestMapping("queryTaskStu")
	@ResponseBody
	public String queryTaskStu(@RequestParam("taskId") Integer taskId,HttpSession session) {
		String url = "index.jsp";
		String loginStuNo = (String) session.getAttribute("loginStuNo");
		System.out.println(loginStuNo);
		if(loginStuNo == null) {
			return url;
		}else {
			int flag = taskStuService.queryTaskStu(new TaskStu(taskId,Integer.parseInt(loginStuNo)));
			if(flag > 0) {
				url = "taskdetails.jsp?taskId="+taskId;
			}else {
				//向记录表增加记录
				taskStuService.insertTaskStu(new TaskStu(taskId, Integer.parseInt(loginStuNo), "你还未接受该任务!"));
				url = "taskdetails.jsp?taskId="+taskId;
			}
		}
		return url;
	}
	
	@RequestMapping("queryTaskState")
	@ResponseBody
	public String queryTaskState(@RequestParam("taskId") Integer taskId,HttpSession session) {
		String loginStuNo = (String) session.getAttribute("loginStuNo");
		return taskStuService.queryTaskState(new TaskStu(taskId,Integer.parseInt(loginStuNo)));
	}
	
	@RequestMapping("acceptTask")
	@ResponseBody
	public String acceptTask(@RequestParam("taskId") Integer taskId,HttpSession session) {
		String loginStuNo = (String) session.getAttribute("loginStuNo");
		TaskStu taskStu = new TaskStu(taskId,Integer.parseInt(loginStuNo),"任务进行中");
		taskStuService.acceptTask(taskStu);
		return taskStuService.queryTaskState(taskStu);
	}
	
	@RequestMapping("releaseTask")
	public String releaseTask(@RequestParam("taskTitle") String taskTitle,
							@RequestParam("taskStart") String taskStart,
							@RequestParam("taskEnd") String taskEnd,
							@RequestParam("taskDetails") String taskDetails,HttpSession session) throws ParseException {
		String admName = (String)session.getAttribute("admName");
		if(admName != null) {
			Task task = new Task();
			task.setTaskTitle(taskTitle);
			task.setTaskStart(StringToDate(taskStart));
			task.setTaskEnd(StringToDate(taskEnd));
			task.setTaskDetails(taskDetails);
			task.setTaskCreator(admName);
			System.out.println(task);
			taskService.releaseTask(task);
			return "release";
		}else {
			return "admin";
		}
	}
	
	public Date StringToDate(String date) throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.parse(date);
	}
}
