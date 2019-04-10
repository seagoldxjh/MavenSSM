package com.xjh.service;

import com.xjh.entity.Admin;

public interface AdminService {
	public Admin queryAdminByAdmno(int admNo);
	public int addAdmin(Admin admin);
	public void updatePersonByAdmno(Admin admin);
	public Boolean checkLogin(Admin admin);	
}
