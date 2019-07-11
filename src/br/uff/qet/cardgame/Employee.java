package br.uff.qet.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private List<Artifact> artifacts;
	
	public Employee(String name) {
		this.name = name;
		artifacts = new ArrayList<Artifact>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Artifact> getArtifacts() {
		return artifacts;
	}

	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}

	public boolean equals(Employee anotherEmployee) {
		return (this.getName().equals(anotherEmployee.getName()));
	}
}
