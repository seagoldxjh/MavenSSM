package com.xjh.controller;

import com.xjh.entity.Student;
import com.xjh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("register")
	@ResponseBody
	public String register(Student student) {
		int flag = studentService.addStudent(student);
		if(flag == 400) {
			return "此学号已存在,请检查学号是否输入正确!";
		}
		return "注册成功，请到登录页进行登陆!";
	}
	
	@RequestMapping("changePwd")
	@ResponseBody
	public String changePwd(@RequestParam("stuNo") Integer stuNo,
			@RequestParam("pwd") String pwd,
			@RequestParam("pwd2") String pwd2){
		System.out.println(stuNo);
		if(pwd!=null && pwd.equals(pwd2)) {
			Student student = studentService.queryStudentByStuno(stuNo);
			if(student!=null) {
				student.setPassWord(pwd);
				studentService.updatePersonByStuno(student);
				return "密码修改成功";
			}
		}
		return "两次输入密码不一致或学号输入错误,请重新输入!";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam("stuNo") Integer stuNo,
			@RequestParam("passWord") String passWord,
			HttpSession session) {
		Student student = new Student(stuNo, null, passWord);
		Boolean checkLogin = studentService.checkLogin(student);
		if (checkLogin) {
			session.setAttribute("loginStuNo", stuNo.toString());
			return "select";
		}
		return "index";
	}
	
	@RequestMapping("test")
	@ResponseBody
	public String logi() {
		return "index4s2";
	}
}
