package com.techelevator.tools;

public class ConsoleService {
	
	public void title(String name) {
		System.out.println();
		System.out.println("|=================================================|");
		System.out.println("|<<<<<<<<<<| ========================= |>>>>>>>>>>|");
		System.out.println(name);
		System.out.println("|<<<<<<<<<<| ========================= |>>>>>>>>>>|");
		System.out.println("|=================================================|");
		System.out.println();
	}
	
	public void mainMenu(String name) {
		System.out.println("\n|><|><|><|<>| " + name + " |<>|><|><|><|");
	}
	
	public void subMenu(String name) {
		System.out.println("\n--------  " + name + "  --------");
	}
	
}
