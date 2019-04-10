package com.xjh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjh.entity.Admin;
import com.xjh.entity.Student;
import com.xjh.mapper.AdminMapper;
import com.xjh.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin queryAdminByAdmno(int admNo) {
		return adminMapper.queryAdminByAdmno(admNo);
	}

	@Override
	public int addAdmin(Admin admin) {
		Admin isAdmin = adminMapper.queryAdminByAdmno(admin.getAdmNo());
		if(isAdmin != null) {
			return 400;
		}else {
			adminMapper.addAdmin(admin);
		}
		return 200;
	}

	@Override
	public void updatePersonByAdmno(Admin admin) {
		adminMapper.updatePersonByAdmno(admin);
	}

	@Override
	public Boolean checkLogin(Admin admin) {
		Boolean flag = false;
		int checkLogin = adminMapper.checkLogin(admin);
		if(checkLogin == 1) {
			flag = true;
		}
		return flag;
	}

	

}
