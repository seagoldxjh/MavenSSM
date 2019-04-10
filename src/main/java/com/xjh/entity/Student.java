package com.xjh.entity;

public class Student {
    private int stuNo;
    private String stuName;
    private String passWord;

    public Student() {
    }

    public Student(int stuNo, String stuName, String passWord) {
        super();
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.passWord = passWord;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        System.out.println(this.stuNo + this.stuName + this.passWord);
        return passWord;
    }
}
