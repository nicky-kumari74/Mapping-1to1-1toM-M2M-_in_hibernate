package com.ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
@Entity
public class Employee {
	@Id
	private int eid;
	private String name;
	@ManyToMany
	@JoinTable(name="emp_proj",joinColumns= {@JoinColumn(name="eid")},inverseJoinColumns= {
			@JoinColumn(name="pid")})
	private List<Projects> projects;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String name, List<Projects> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	
}
