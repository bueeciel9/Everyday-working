package ctaProject;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

import ctaProject.CTARoute;
import ctaProject.CTAStation;
import ctaProject.GeoLocation;

public class Application {
	public static void main(String[] args) throws FileNotFoundException {

		int choice = 0;
		CTARoute route = new CTARoute();

		route.ReadFile();
		route.setLine();

		System.out.println(" Welcome to the CTA ");
		System.out.println("select the service what you want");

		while (choice != 7) {
			System.out.println("1.add a station \n" + "2. modify a station \n" + "3. delete a station \n"
					+ "4. search a station\n" + "5. find the nearest station\n" + "6. generate a route\n" + "7. exit");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();

			switch (choice) {

			case 1:
				route.addStation();
				break;
			case 2:
				route.modifyStation();
				break;
			case 3:
				route.deleteStation();
				break;
			case 4:
				route.searchStation();
				break;
			case 5:
				route.nearStation();
				break;

			case 6:
//				route.generateRout();
				break;
			case 7:
				System.out.println("Program is ended.");
				break;
			default:
				System.out.println("Wrong number!");

			}

		}

	}
}
