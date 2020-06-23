package vo;

public class FestivalVO {
	
	private int festival_pk;	//축제 고유번호 (PK)
	private String festival_name;	//축제이름
	private String date;	//월
	private String area;	//지역
	private String adress;	//상세주소
	private String url;	//축제사이트주소
	private String season;	//계절
	
	public FestivalVO() {}

	public FestivalVO(int festival_pk, String festival_name, String date, String area, String adress, String url,
			String season) {
		super();
		this.festival_pk = festival_pk;
		this.festival_name = festival_name;
		this.date = date;
		this.area = area;
		this.adress = adress;
		this.url = url;
		this.season = season;
	}

	public int getFestival_pk() {
		return festival_pk;
	}

	public String getFestival_name() {
		return festival_name;
	}

	public String getDate() {
		return date;
	}

	public String getArea() {
		return area;
	}

	public String getAdress() {
		return adress;
	}

	public String getUrl() {
		return url;
	}

	public String getSeason() {
		return season;
	}

	public void setFestival_pk(int festival_pk) {
		this.festival_pk = festival_pk;
	}

	public void setFestival_name(String festival_name) {
		this.festival_name = festival_name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setSeason(String season) {
		this.season = season;
	}
	
	
	
}
