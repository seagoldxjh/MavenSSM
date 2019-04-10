package com.xjh.mapper;

import java.util.List;

import com.xjh.entity.Student;

public interface StudentMapper {
	public Student queryStudentByStuno(int stuno);
	public List<Student> queryAllStudent();
	public void addStudent(Student student);
	public void deleteStudentBuStuno(int stuno);
	public void updatePersonByStuno(Student student);
	public int checkLogin(Student student);
}
