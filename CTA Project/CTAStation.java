package ctaProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.*;

public class CTAStation extends GeoLocation {

	private String name;
	private double latitude;
	private double longitude;
	private String location;
	private boolean wheelchair;
	String[] lines = { "red", "green", "blue", "brown", "purple", "pink", "orange", "yellow" };
	private int[] colorIdx; // "red", "green", "blue", "brown", "purple", "pink", "orange", "yellow"
	protected static ArrayList<CTAStation> Stations = new ArrayList<CTAStation>();

	// default constructor
	public CTAStation() {
		super();
		name = "";
		latitude = 0;
		longitude = 0;
		location = "";
		wheelchair = false;
		int[] tempIdx = { -1, -1, -1, -1, -1, -1, -1, -1 };
		colorIdx = tempIdx;
	}

	// constructor
	public CTAStation(String name, double latitude, double longitude, String location, boolean wheelchair,
			int[] colorIdx) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.location = location;
		this.wheelchair = wheelchair;
		this.colorIdx = colorIdx; // int[] colorIdx ={redIdx, greenIdx, blueIdx, brownIdx, purpleIdx, pinkIdx,
									// orangeIdx, yellowIdx};
	}
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isWheelchair() {
		return wheelchair;
	}

	public void setWheelchair(boolean wheelchair) {
		this.wheelchair = wheelchair;
	}

	public int[] getColorIdx() {
		return colorIdx;
	}

	public void setColorIdx(int[] colorIdx) {
		this.colorIdx = colorIdx;
	}

	//Reading file
	public void ReadFile() throws FileNotFoundException {
		String path = "C:\\java_lab\\Project\\src\\CTAStation.txt";

		try {
			String station;
			int[] line = new int[8];
			String[] arrayInfo = null;
			Scanner in = new Scanner(new FileReader(path));

			while (in.hasNextLine()) {
				station = in.nextLine();
				arrayInfo = station.split(",");

				for (int i = 5; i < 13; i++) {
					line[i - 5] = Integer.parseInt(arrayInfo[i]);
					arrayInfo[i] = null;
				}
			}
			String name = arrayInfo[0];
			int index = searchStation(name);
			double latitude = Double.parseDouble(arrayInfo[1]);
			double longitude = Double.parseDouble(arrayInfo[2]);
			String location = arrayInfo[3];
			boolean wheelchair = Boolean.parseBoolean(arrayInfo[4]);
			CTAStation Station = new CTAStation(name, latitude, longitude, location, wheelchair, line);
			if (index == -1) {
				Stations.set(Stations.size() + 1, Station);
			} else
				Stations.set(index, Station);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	//Save file
	public void OutPutFile() {
		try {
			File file = new File("CTAStations.txt");
			file.delete();
			file.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(file, true));
			for (CTAStation S : Stations) {
				out.println(S.getName() + "\t" + S.getLatitude() + "\t" + S.getLongitude() + "\t" + S.getLocation()
						+ "\t" + S.isWheelchair() + "\t" + S.colorIdx[0] + "\t" + S.colorIdx[1] + "\t" + S.colorIdx[2]
						+ "\t" + S.colorIdx[3] + "\t" + S.colorIdx[4] + "\t" + S.colorIdx[5] + "\t" + S.colorIdx[6]
						+ "\t" + S.colorIdx[7]);
			}
			out.close();
		} catch (IOException e) {
		}
	}
	//Adding stations into ArrayList
	public void addStation() {

		int[] colorIdx = { -1, -1, -1, -1, -1, -1, -1, -1 };

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the station's name: ");
		String name = scan.nextLine();
		System.out.println("Enter the station's latitude: ");
		double latitude = scan.nextDouble();
		System.out.println("Enter the station's longitude: ");
		double longitude = scan.nextDouble();
		System.out.println("Enter the station's location: ");
		String location = scan.next();
		System.out.println("Enter the station's acceptance of wheelchair. \n true: 1, false : -1");

		int s = scan.nextInt();
		if (s == 1) {
			wheelchair = true;
		} else
			wheelchair = false;

		try {
			for (int i = 0; i < 8; i++) {
				System.out.println("Enter the station's " + lines[i] + " lines index : ");
				colorIdx[i] = scan.nextInt();
			}
		} catch (InputMismatchException e) {
			for (int i = 0; i < 8; i++) {
				System.out.println("Enter the station's " + lines[i] + " lines index : ");
				colorIdx[i] = scan.nextInt();
			}
		}

		CTAStation ctastation = new CTAStation(name, latitude, longitude, location, wheelchair, colorIdx);
		Stations.add(ctastation);
		System.out.println("The station " + name + " is successfully added ");

	}
	//Delete station from ArrayList
	public void deleteStation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the station you want to delete : ");
		String name = scan.nextLine();
		try {
			Stations.remove(searchStation(name));
		} catch (ArrayIndexOutOfBoundsException e) {
			;
		}
		System.out.println("The station " + name + " is removed from the list.");
	}
	//Searching station by name
	public int searchStation(String name) {
		for (int i = 0; i < Stations.size(); i++) {
			if (Stations.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	// method overloading
	public CTAStation searchStation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the station you want to search");
		name = scan.nextLine();
		for (int i = 0; i < Stations.size(); i++) {
			if (Stations.get(i).getName().equals(name)) {
				return Stations.get(i);
			}
		}
		System.out.println("There is no station you entered. ");
		return null;
	}
	//Modify station using name
	public void modifyStation() {
		int[] colorIdx = { -1, -1, -1, -1, -1, -1, -1, -1 };

		Scanner scan = new Scanner(System.in);
		System.out.println("please input the station's name:");
		String name = scan.nextLine();

		System.out.println("please input the station's latitude:");
		double latitude = scan.nextDouble();
		System.out.println("please input the station's longitude:");
		double longitude = scan.nextDouble();
		System.out.println("Enter the station's location: ");
		String location = scan.next();
		System.out.println("Enter the station's acceptance of wheelchair. \n true: 1, false : -1");

		int s = scan.nextInt();
		if (s == 1) {
			wheelchair = true;
		} else
			wheelchair = false;

		try {
			for (int i = 0; i < 8; i++) {
				System.out.println("Enter the station's " + lines[i] + " lines index : ");
				colorIdx[i] = scan.nextInt();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			;
		}
		CTAStation newStation = new CTAStation(name, latitude, longitude, location, wheelchair, colorIdx);
		try {
			Stations.set(searchStation(name), newStation);
		} catch (ArrayIndexOutOfBoundsException e) {
			;
		}

		// stations.set(searchStation(name),newStation);
		System.out.println("Moficiation of the " + name + " station is successfully completed!!");
	}
	//calculate the distance and return the minimum distance of station
	public CTAStation nearStation() {
		CTAStation station = new CTAStation();
		double latitude = 0;
		double longitude = 0;
		double distance = 0;
		double minimum = 10000;
		String name = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your latitude");
		latitude = scan.nextDouble();
		System.out.println("Enter your longitude");
		longitude = scan.nextDouble();
		for (CTAStation s : Stations) {
			distance = Math.sqrt(Math.pow(latitude - s.latitude, 2) + Math.pow(longitude - s.longitude, 2));
			if (distance < minimum) {
				minimum = distance;
				name = s.name;
			}

		}
		try {
			station = Stations.get(searchStation(name));
		} catch (ArrayIndexOutOfBoundsException e) {
			;
		}
		return station;
	}

//	@override
	public String toString() {
		return " Station : " + this.name + "\n latitude : " + this.latitude + "\n longitude: " + this.longitude
				+ "\n Location : " + this.location + "\n wheelchair : " + this.wheelchair;
	}

}
