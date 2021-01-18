package com.techelevator;

import java.util.Scanner;

public class MaxHr {

	private int maxHr;

	public int getMaxHr() {
		return maxHr;
	}

	public void setMaxHr(int maxHr) {
		this.maxHr = maxHr;
	}

	public int runMaxHr(Scanner scanner, Age age) {
		age.ageRequest(scanner);
		setMaxHr(maxHrCalc(age.getAge()));
		return getMaxHr();
	}

	public int maxHrCalc(int age) {
		int maxHr = 220 - age;
		return maxHr;
	}

	public void printMaxHr(Scanner scanner, Age age) {
		runMaxHr(scanner, age);
		System.out.println("\nYour max heart rate is " + getMaxHr() + " bpm.");
	}

}
