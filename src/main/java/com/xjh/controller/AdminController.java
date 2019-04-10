package com.xjh.controller;

import com.xjh.entity.Admin;
import com.xjh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("registerAdmin")
    @ResponseBody
    public String register(Admin admin) {
        int flag = adminService.addAdmin(admin);
        if (flag == 400) {
            return "此学号已存在,请检查学号是否输入正确!";
        }
        return "注册成功，请到登录页进行登陆!";
    }

    @RequestMapping("changePwdAdmin")
    @ResponseBody
    public String changePwd(@RequestParam("admNo") Integer admNo,
                            @RequestParam("pwd") String pwd,
                            @RequestParam("pwd2") String pwd2) {
        System.out.println(admNo);
        if (pwd != null && pwd.equals(pwd2)) {
            Admin admin = adminService.queryAdminByAdmno(admNo);
            if (admin != null) {
                admin.setPassWord(pwd);
                adminService.updatePersonByAdmno(admin);
                return "密码修改成功";
            }
        }
        return "两次输入密码不一致或学号输入错误,请重新输入!";
    }

    @RequestMapping("loginAdmin")
    public String login(@RequestParam("admNo") Integer admNo,
                        @RequestParam("passWord") String passWord,
                        HttpSession session) {
        Admin admin = new Admin(admNo, null, passWord);
        Boolean checkLogin = adminService.checkLogin(admin);
        if (checkLogin) {
            String admName = adminService.queryAdminByAdmno(admNo).getAdmName();
            session.setAttribute("admName", admName);
            return "redirect:views/release.jsp";
        }
        return "admin";
    }
}
