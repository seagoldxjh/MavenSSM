package com.xjh.service;

import java.util.List;

import com.xjh.entity.Student;

public interface StudentService {
	public Student queryStudentByStuno(int stuNo);
	public List<Student> queryAllStudent();
	public int addStudent(Student student);
	public void deleteStudent(int stuNo);
	public void updatePersonByStuno(Student student);
	public void deleteBatch(List<Integer> stuNos);
	public Boolean checkLogin(Student student);
}
