package br.uff.qet.cardgame;

import java.util.HashMap;
import java.util.Map;

public class Process {
	
	private String name;
	private Map<String, Employee> employees;
	
	public Process(String name) {
		this.name = name; 
		employees = new HashMap<String, Employee>();
	}

	public String getName() {
		return name; 
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<String, Employee> employees) {
		this.employees = employees;
	}
	
	public boolean equals(Process another) {
		return (this.getName().equals(another.getName()));
		
	}

}
