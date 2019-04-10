package com.xjh.mapper;

import com.xjh.entity.Admin;

public interface AdminMapper {
	public Admin queryAdminByAdmno(int admNo);
	public void updatePersonByAdmno(Admin admin);
	public int checkLogin(Admin admin);
	public void addAdmin(Admin admin);
}
