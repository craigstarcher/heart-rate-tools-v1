package com.techelevator;

import java.util.Scanner;

public class Age {

	private int age;

	public Age() {
	}

	public Age(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void ageRequest(Scanner scanner) {
		if (getAge() == 0) {
			System.out.print("\nWhat's your age? ");
			setAge(Integer.parseInt(scanner.nextLine()));
		}
	}
}
