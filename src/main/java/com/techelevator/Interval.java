package com.techelevator;

import java.util.Scanner;

public class Interval {

	private int intervalCount;
	private int intervalLength;

	public int getIntervalCount() {
		return intervalCount;
	}

	public void setIntervalCount(int intervalCount) {
		this.intervalCount = intervalCount;
	}

	public int getIntervalLength() {
		return intervalLength;
	}

	public void setIntervalLength(int intervalLength) {
		this.intervalLength = intervalLength;
	}

	public void intervalPrep(Scanner scanner, HrZone hrZone, Age age, MaxHr maxHr) {
		age.ageRequest(scanner);

		hrZone.zoneSelection(scanner, age, maxHr);

		System.out.println("\nHow many intervals?");
		setIntervalCount(Integer.parseInt(scanner.nextLine()));

		System.out.println("\nHow many seconds will your intervals be?");
		setIntervalLength(Integer.parseInt(scanner.nextLine()));
	}

}
