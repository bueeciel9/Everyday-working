package ctaProject;

public class GeoLocation {

	private double latitude;
	private double longitude;

	// default constructor
	public GeoLocation() {
		super();
		latitude = 0;
		longitude = 0;
	}

	// constructor with parameters
	public GeoLocation(double ltd, double lnt) {
		super();
		this.latitude = ltd;
		this.longitude = lnt;
	}

	// getters
	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	// setters
	public void setLatitude(double ltd) {
		this.latitude = ltd;
	}

	public void setLongitude(double lnt) {
		this.longitude = lnt;
	}

	// calculate distance of location
	public double calcDistance(GeoLocation geolocation) {
		double distance = Math.sqrt(Math.pow(geolocation.getLatitude() - this.latitude, 2)
				+ Math.pow(geolocation.getLongitude() - this.longitude, 2));
		return distance;
	}

	// calculate distance between current location and specific location
	public double calcDistance(double ltd, double lnt) {
		double distance = Math.sqrt(Math.pow(ltd - this.latitude, 2) + Math.pow(lnt - this.longitude, 2));
		return distance;
	}

	// equals method
	public boolean equals(double ltd, double lnt) {
		boolean check = false;
		if (this.latitude == ltd && this.longitude == lnt) {
			check = true;
		}
		return check;
	}

	public boolean equals(GeoLocation geolocation) {
		boolean check = false;
		if (this.getLatitude() == geolocation.getLatitude() && this.getLongitude() == geolocation.getLongitude()) {
			check = true;
		}
		return check;
	}

	// toString method
	public String toString() {
		return "Latitude is : " + latitude + " Longitude is :  " + longitude;
	}
}
