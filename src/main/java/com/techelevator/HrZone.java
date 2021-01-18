package com.techelevator;

import java.util.Scanner;

public class HrZone {

	private String[] zoneArray;
	private int targetHrMin;
	private int targetHrMax;

	public HrZone() {
	}

	public HrZone(String[] zoneArray, int targetHrMin, int targetHrMax) {
		this.zoneArray = zoneArray;
		this.targetHrMin = targetHrMin;
		this.targetHrMax = targetHrMax;
	}

	public int getTargetHrMin() {
		return targetHrMin;
	}

	public void setTargetHrMin(int targetHrMin) {
		this.targetHrMin = targetHrMin;
	}

	public int getTargetHrMax() {
		return targetHrMax;
	}

	public void setTargetHrMax(int targetHrMax) {
		this.targetHrMax = targetHrMax;
	}

	public String[] getZoneArray(MaxHr maxHr) {
		zoneArray = new String[] {
				"\nZone 1:  " + (int) (maxHr.getMaxHr() * 0.5) + " - " + (int) (maxHr.getMaxHr() * 0.6)
						+ " bpm : Recovery (Improve health and recover)",
				"Zone 2: " + (int) (maxHr.getMaxHr() * 0.6) + " - " + (int) (maxHr.getMaxHr() * 0.7)
						+ " bpm : Endurance (Improve basic endurance and fat burning)",
				"Zone 3: " + (int) (maxHr.getMaxHr() * 0.7) + " - " + (int) (maxHr.getMaxHr() * 0.8)
						+ " bpm : Aerobic (Improve aerobic fitness)",
				"Zone 4: " + (int) (maxHr.getMaxHr() * 0.8) + " - " + (int) (maxHr.getMaxHr() * 0.9)
						+ " bpm : Anaerobic (Improve max performance)",
				"Zone 5: " + (int) (maxHr.getMaxHr() * 0.9) + " - " + maxHr.getMaxHr()
						+ " bpm : Max Effort (Develop max performance and speed)" };
		return zoneArray;
	}

	public void printZones(Scanner scanner, Age age, MaxHr maxHr) {
		maxHr.runMaxHr(scanner, age);
		for (int i = 0; i < getZoneArray(maxHr).length; i++) {
			System.out.println(getZoneArray(maxHr)[i]);
		}
	}

	public String zoneSelection(Scanner scanner, Age age, MaxHr maxHr) {
		printZones(scanner, age, maxHr);
		System.out.print("\nEnter your zone number: ");
		String zoneInput = scanner.nextLine();
		setTargetHrMin(targetHrMinimum(zoneInput, maxHr));
		setTargetHrMax(targetHrMaximum(zoneInput, maxHr));
		System.out.println(selectedHrRange(zoneInput, maxHr));
		return zoneInput;
	}

	public int targetHrMinimum(String zoneInput, MaxHr maxHr) {
		double targetHrMin = 0;

		if (zoneInput.contains("1")) {
			targetHrMin = maxHr.getMaxHr() * 0.5;
		} else if (zoneInput.contains("2")) {
			targetHrMin = maxHr.getMaxHr() * 0.6;
		} else if (zoneInput.contains("3")) {
			targetHrMin = maxHr.getMaxHr() * 0.7;
		} else if (zoneInput.contains("4")) {
			targetHrMin = maxHr.getMaxHr() * 0.8;
		} else {
			targetHrMin = maxHr.getMaxHr() * 0.9;
		}
		return (int) targetHrMin;
	}

	public int targetHrMaximum(String zoneInput, MaxHr maxHr) {
		double targetHrMax = 0;

		if (zoneInput.contains("1")) {
			targetHrMax = maxHr.getMaxHr() * 0.6;
		} else if (zoneInput.contains("2")) {
			targetHrMax = maxHr.getMaxHr() * 0.7;
		} else if (zoneInput.contains("3")) {
			targetHrMax = maxHr.getMaxHr() * 0.8;
		} else if (zoneInput.contains("4")) {
			targetHrMax = maxHr.getMaxHr() * 0.9;
		} else {
			targetHrMax = maxHr.getMaxHr();
		}
		return (int) targetHrMax;
	}

	public String selectedHrRange(String zoneInput, MaxHr maxHr) {
		double min = targetHrMinimum(zoneInput, maxHr);
		double max = targetHrMaximum(zoneInput, maxHr);

		setTargetHrMin((int) min);
		setTargetHrMax((int) max);

		return "\nYour heart rate should be " + (int) min + " - " + (int) max + " bpm";
	}

}
