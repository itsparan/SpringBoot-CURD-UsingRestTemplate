package com.rest.rstmp.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Student {

	private int student_id;

	private String student_name;

	private String sex;

	private int age;

	private Date birth_date;

	private Date entry_date;

	public Student() {

	}

	public Student(String student_name, String sex, int age, Date birth_date, Date entry_date) {
		// super();
		this.student_name = student_name;
		this.sex = sex;
		this.age = age;
		this.birth_date = birth_date;
		this.entry_date = entry_date;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

//generate to string
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", sex=" + sex + ", age=" + age
				+ ", birth_date=" + birth_date + ", entry_date=" + entry_date + "]";
	}

}
