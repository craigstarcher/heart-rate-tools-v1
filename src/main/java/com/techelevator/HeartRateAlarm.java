package com.techelevator;

import java.util.Scanner;

public class HeartRateAlarm {

	public void alarm(Scanner scanner, Alarm alarm, String input) {
		Age a = new Age();

		String alarmTimeString = "";
		boolean alarmOn = false;

		a.ageRequest(scanner);

		int targetHr = alarm.targetAlarmHr(a.getAge());

		alarmTimeString = alarm.alarmInputs(scanner, input, alarm, alarmTimeString);
		System.out.println("\n" + alarmTimeString);

		alarmOn = alarm.alarmActivate(alarm, alarmTimeString);

		if (alarmOn) {
			System.out.println("\nGo!");
			System.out.println("Lets get that heart rate up to " + targetHr + " bpm.");
		}

		alarmOn = alarm.alarmDeactivate(scanner, targetHr, alarmOn);
	}

}
