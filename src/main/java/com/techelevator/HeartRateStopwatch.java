package com.techelevator;

import java.util.Scanner;

public class HeartRateStopwatch {

	public void stopwatch(Scanner scanner, HrZone hrZone, Age age, MaxHr maxHr) {
		Interval prep = new Interval();

		prep.intervalPrep(scanner, hrZone, age, maxHr);
		intervals(prep.getIntervalCount(), prep.getIntervalLength(), scanner, hrZone);
		System.out.println("\nGood job!");
	}

	public void counter(int counter, Scanner scanner, HrZone hrZone) {
		while (counter > 0) {
			System.out.println("\nWhat is your heart rate?");
			int actualHr = Integer.parseInt(scanner.nextLine());
			if (actualHr >= hrZone.getTargetHrMin() && actualHr <= hrZone.getTargetHrMax()) {
				counter--;
			} else if (actualHr > hrZone.getTargetHrMax()) {
				counter--;
				System.out.println("\nPull back into the zone.");
			} else
				System.out.println("\nLets get that heart rate up.");
		}
	}

	public void intervals(int intervalCount, int intervalLength, Scanner scanner, HrZone hrZone) {
		System.out.println("\nLets get started!");

		while (intervalCount > 0) {
			int counter = intervalLength;
			counter(counter, scanner, hrZone);
			intervalCount--;

			if (intervalCount > 0) {
				System.out.println("\nGet ready for the next interval!");
				for (int i = 10; i >= 0; i--) {
					System.out.println(i);
				}
			} else
				break;
		}
	}
}
