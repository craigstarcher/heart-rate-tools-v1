package com.techelevator.application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.techelevator.Age;
import com.techelevator.Alarm;
import com.techelevator.HeartRateAlarm;
import com.techelevator.HeartRateStopwatch;
import com.techelevator.HeartRateTimer;
import com.techelevator.HrZone;
import com.techelevator.MaxHr;
import com.techelevator.tools.ConsoleService;
import com.techelevator.tools.Menu;

public class HeartRateApplicationCLI {

	private static final String MAIN_MENU_OPTION_MAX_HR = "Max Heart Rate Calculator";
	private static final String MAIN_MENU_OPTION_HR_ZONES = "Heart Rate Zones Calculator";
	private static final String MAIN_MENU_OPTION_ALARM = "Alarm Clock";
	private static final String MAIN_MENU_OPTION_STOPWATCH = "Interval Stopwatch";
	private static final String MAIN_MENU_OPTION_TIMER = "Interval Timer";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_MAX_HR, MAIN_MENU_OPTION_HR_ZONES,
			MAIN_MENU_OPTION_ALARM, MAIN_MENU_OPTION_STOPWATCH, MAIN_MENU_OPTION_TIMER, MAIN_MENU_OPTION_EXIT, "" };

	private Menu menu;

	
	public HeartRateApplicationCLI(){}
	public HeartRateApplicationCLI(Menu menu) {
		this.menu = menu;

	}
	
	public void run() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		HrZone hrZone = new HrZone();
		Alarm alarm = new Alarm();
		Age age = new Age();
		HeartRateStopwatch heartRateStopwatch = new HeartRateStopwatch();
		HeartRateTimer heartRateTimer = new HeartRateTimer();
		HeartRateAlarm heartRateAlarm = new HeartRateAlarm();
		ConsoleService console = new ConsoleService();
		MaxHr maxHr = new MaxHr();

		String input = "";
		
		console.title("|==========| Heart Rate Training ToolS |==========|");

		while (true) {
			console.mainMenu("Main Menu");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
// Max HR			
			if (choice.equals(MAIN_MENU_OPTION_MAX_HR)) {
				console.subMenu(MAIN_MENU_OPTION_MAX_HR);
				maxHr.printMaxHr(scanner, age);
			}
// HR Zones			
			else if (choice.equals(MAIN_MENU_OPTION_HR_ZONES)) {
				console.subMenu(MAIN_MENU_OPTION_HR_ZONES);
				hrZone.printZones(scanner, age, maxHr);
			}
// Alarm
			else if (choice.equals(MAIN_MENU_OPTION_ALARM)) {
				console.subMenu(MAIN_MENU_OPTION_ALARM);
				heartRateAlarm.alarm(scanner, alarm, input);
			}
// Stopwatch
			else if (choice.equals(MAIN_MENU_OPTION_STOPWATCH)) {
				console.subMenu(MAIN_MENU_OPTION_STOPWATCH);
				heartRateStopwatch.stopwatch(scanner, hrZone, age, maxHr);
			}
// Timer
			else if (choice.equals(MAIN_MENU_OPTION_TIMER)) {
				console.subMenu(MAIN_MENU_OPTION_TIMER);
				 heartRateTimer.timer(scanner, hrZone, age, maxHr);
			}
// Exit
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}

		}
		scanner.close();
	}

	public static void main(String[] args) throws FileNotFoundException {

		Menu menu = new Menu(System.in, System.out);
		HeartRateApplicationCLI cli = new HeartRateApplicationCLI(menu);
		cli.run();
	}
}
