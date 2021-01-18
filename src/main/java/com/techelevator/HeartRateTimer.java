package com.techelevator;

import java.util.Scanner;

public class HeartRateTimer {

	public void timer(Scanner scanner, HrZone hrZone, Age age, MaxHr maxHr) {
		intro();
		hrZone.zoneSelection(scanner, age, maxHr);
		timerRun(scanner, hrZone);
		System.out.println("\nGood job!");
	}

	public void intro() {
		System.out.println("The timer will run only while your heart ");
		System.out.println("rate is within the zone you selected.");
		System.out.println(">>> Select \"0\" to stop your timer. <<<");
	}

	public void timerRun(Scanner scanner, HrZone hrZone) {
		int counter = 0;

		while (true) {
			System.out.println("\nWhat is your heart rate?");
			int actualHr = Integer.parseInt(scanner.nextLine());

			if (actualHr == 0) {
				break;
			}

			if (actualHr >= hrZone.getTargetHrMin() && actualHr <= hrZone.getTargetHrMax()) {
				counter++;
			} else if (actualHr > hrZone.getTargetHrMax()) {
				counter++;
				System.out.println("\nPull back into the zone.");
			} else
				System.out.println("\nLets get that heart rate up.");

			System.out.println(counter + " seconds");
		}
	}
}
