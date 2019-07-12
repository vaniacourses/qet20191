package br.uff.qet.cardgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Util {
	
	public static void initializeLevels(Map<Level, MaturityLevel> mpsbr) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./resources/levels.info"));
			while (br.ready()) {
				String linha = br.readLine();
				String[] levels = linha.split("\\|", -1);
				Level level = Level.valueOf(levels[0].trim());
				MaturityLevel mLevel = new MaturityLevel(level);
				for (int i = 1; i < levels.length; i++) {
					Process process = new Process(levels[i].trim());
					initializeProcess(process);
					mLevel.getProcess().put(levels[i].trim(), process);
				}
				mpsbr.put(level, mLevel);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public static void initializeProcess(Process process) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./resources/process.info"));
			while (br.ready()) {
				String linha = br.readLine();
				String[] employees = linha.split("\\|", -1);
				Process newProcess = new Process(employees[0].trim());
				if (!process.equals(newProcess))
					continue;
				for (int i = 1; i < employees.length; i++) {
					Employee employee = new Employee(employees[i].trim());
					initializeEmployees(employee);
					process.getEmployees().put(employees[i].trim(), employee);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initializeEmployees(Employee employee) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./resources/artifacts.info"));
			while (br.ready()) {
				String linha = br.readLine();
				String[] artifacts = linha.split("\\|", -1);
				Employee newEmployee = new Employee(artifacts[0].trim());
				if (!employee.equals(newEmployee))
					continue;
				for (int i = 1; i < artifacts.length; i++) {
					Artifact artifact = new Artifact(artifacts[i].trim());
					employee.getArtifacts().add(artifact);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
