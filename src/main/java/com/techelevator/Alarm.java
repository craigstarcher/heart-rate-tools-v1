package com.techelevator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Alarm extends Clock {

	public Alarm() {
	}

	public Alarm(int hour, int minute, String isAm) {
		super(hour, minute, isAm);
	}

// methods	
	public int targetAlarmHr(int age) {
		if (age < 21) {
			return 100;
		} else if (age > 20 && age < 30) {
			return 95;
		} else if (age < 31 && age < 40) {
			return 90;
		} else if (age < 41 && age < 50) {
			return 85;
		} else if (age < 51 && age < 60) {
			return 60;
		} else if (age < 61 && age < 70) {
			return 65;
		} else
			return 75;
	}

	public String alarmInputs(Scanner scanner, String input, Alarm alarm, String alarmTimeString) {
		// alarm
		// hour
		System.out.print("\nWhat hour would you like to set your alarm? ");
		input = scanner.nextLine();

		alarm.setHour(alarm.setHr(input, scanner));

		// minute
		System.out.print("\nWhat minute would you like to set your alarm? ");
		input = scanner.nextLine();

		alarm.setMinute(alarm.setMin(input, scanner));

		// AM or PM
		System.out.print("\nSet alarm for am or pm? ");
		input = scanner.nextLine();

		alarm.setIsAm(alarm.setAm(input, scanner).toUpperCase());

		return alarmTimeString = alarm.getHour() + ":" + alarm.getMinute() + " " + alarm.getIsAm();
	}

	public boolean alarmActivate(Alarm alarm, String alarmTimeString) {
		if (alarmTimeString.equals(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm a")))) {
			System.out.println("\n*ding*\nRise and Shine!\n");

			int counter = 10;

			while (counter >= 0) {
				System.out.println(counter);
				counter--;
			}
		}
		return true;
	}

	public boolean alarmDeactivate(Scanner scanner, int targetHr, boolean alarmOn) {
		int actualHr;

		while (alarmOn) {
			System.out.println("\n~Vibrate~");
			System.out.print("What is your heart rate? ");
			actualHr = Integer.parseInt(scanner.nextLine());
			if (actualHr >= targetHr) {
				System.out.println("\n*ding*\nGood Job!\nGreat start to a new day.");
				break;
			}
		}
		return false;
	}

}
