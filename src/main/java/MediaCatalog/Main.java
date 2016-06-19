package mediacatalog;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import mediacatalog.cli.Action;

public class Main {
	
	public static void main(String[] args) // remove throws !!!! handle it
			throws IllegalAccessException,IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try (Scanner scanner = new Scanner(System.in)) {
			String command;
			while (!(command = scanner.nextLine()).equals("quit")) {
				String params[] = command.split(" "); // check command for null or validate parametrs in action
				Action action = new Action();
				try {
					new JCommander(action, params);
					action.execute();
				} catch (ParameterException exception) {
					System.out.println("Invalid command syntax: " + exception.getMessage());
				}				
			}
		}		
	}

}
