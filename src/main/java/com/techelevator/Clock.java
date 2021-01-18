package com.techelevator;

import java.util.Scanner;

public class Clock {
	private int hour;
	private int minute;
	private String isAm;

	public Clock(int hour, int minute, String isAm) {
		this.hour = hour;
		this.minute = minute;
		this.isAm = isAm;
	}

	public Clock() {
	}

// getters & setters	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getIsAm() {
		return isAm;
	}

	public void setIsAm(String isAm) {
		this.isAm = isAm;
	}

// methods
	public int setHr(String input, Scanner scanner) {
		hour = Integer.parseInt(input);
		while (hour < 1 || hour > 12) {
			System.out.println();
			System.out.print("Invalid hour entry. Please try again.");
			hour = Integer.parseInt(scanner.nextLine());

			if (hour > 0 && hour < 13) {
				break;
			}
		}
		return hour;
	}

	public int setMin(String input, Scanner scanner) {
		minute = Integer.parseInt(input);
		while (minute < 0 || minute > 59) {
			System.out.println();
			System.out.print("Invalid minute entry. Please try again.");
			minute = Integer.parseInt(scanner.nextLine());

			if (minute >= 0 && minute < 60) {
				break;
			}
		}
		return minute;
	}

	public String setAm(String input, Scanner scanner) {
		while (!input.toUpperCase().contains("AM") && !input.toUpperCase().contains("PM")) {
			System.out.println("\nInvalid AM or PM entry. Please try again.");
			input = scanner.nextLine();

			if (input.toUpperCase().contains("AM") || input.toUpperCase().contains("PM")) {
				break;
			}
		}

		if (input.toUpperCase().contains("AM")) {
			isAm = "AM";
		} else
			isAm = "PM";
		return isAm;
	}
}
