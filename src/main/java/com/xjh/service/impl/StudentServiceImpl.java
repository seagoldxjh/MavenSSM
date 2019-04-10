package com.xjh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xjh.entity.Student;
import com.xjh.mapper.StudentMapper;
import com.xjh.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public Student queryStudentByStuno(int stuNo) {
		Student student = studentMapper.queryStudentByStuno(stuNo);
		return student;
	}

	@Override
	public int addStudent(Student student) {
		Student istudent = studentMapper.queryStudentByStuno(student.getStuNo());
		if(istudent != null) {
			return 400;
		}else {
			studentMapper.addStudent(student);
		}
		return 200;
	}

	@Override
	public List<Student> queryAllStudent() {
		List<Student> students = studentMapper.queryAllStudent();
		return students;
	}

	@Override
	public void deleteStudent(int stuNo) {
		studentMapper.deleteStudentBuStuno(stuNo);
	}

	@Override
	public void updatePersonByStuno(Student student) {
		studentMapper.updatePersonByStuno(student);
	}

	@Override
	public void deleteBatch(List<Integer> stuNos) {
		for (Integer stuNo : stuNos) {
			studentMapper.deleteStudentBuStuno(stuNo);
		}
	}

	@Override
	public Boolean checkLogin(Student student) {
		Boolean flag = false;
		int checkLogin = studentMapper.checkLogin(student);
		if(checkLogin == 1) {
			flag = true;
		}
		return flag;
	}

}
