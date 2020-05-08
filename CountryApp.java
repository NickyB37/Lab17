import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountryApp {
	private static FileHelper<Country> helper = new FileHelper<>("players.txt", new CountryLineConverter());

	public static void main(String[] args) {
		Path path1 = Paths.get("myfile.txt");

		Scanner scnr = new Scanner(System.in);
		System.out.println("Available commands:");
		System.out.println(" list");
		System.out.println(" add ");
		System.out.println(" quit");
		
		
		
		while (true) {
			System.out.println("What would you like to do? ");
			String command = scnr.nextLine();

			if (command.equals("quit")) {
				break;
			} else if (command.equals("list")) {
				List<Country> Thing = convertStringsToObjects();
				System.out.println(Thing);
			} else if (command.startsWith("add ")) {
				helper.append(new Country("Lebron", 23));
				helper.append(new Country("Mike", 23));
				List<Country>countries = helper.readAll();
				for(Country p : countries) {
					System.out.println(p);
				}
				String country = command.substring(4);
				writeToFile(country);
			} else {
				System.out.println("Invalid command.");
			}

			if (Files.notExists(path1)) {
				try {
					Files.createFile(path1);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

			List<Country> lines = new ArrayList<>();
			lines.add(new Country("U.S.A", 328000000));
			lines.add(new Country("China", 1393000000));
			lines.add(new Country("Mexico", 126000000));
			for (Country x : lines) {
				writeToFile(x);
			}

			try {

				List<String> formattedDemoObjects = Files.readAllLines(path1);
				convertStringsToObjects(formattedDemoObjects);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static List<Country> convertStringsToObjects(List<String> listOfStrings) {

		List<Country> returnList = new ArrayList<>();

		for (String s : listOfStrings) {

			String[] arr = s.split(",");
			returnList.add(new Country(arr[0], arr[1]));

		}

		return returnList;
	}

	public static void writeToFile(Country kev) {

		List<String> Country = Collections.singletonList(kev.toString());

		try {
			Files.write(path1, Country, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to write to file.");
		}

	}
}
