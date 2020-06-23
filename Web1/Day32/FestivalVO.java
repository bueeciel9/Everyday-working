package vo;

public class FestivalVO {
	
	private int festival_pk;	//���� ������ȣ (PK)
	private String festival_name;	//�����̸�
	private String date;	//��
	private String area;	//����
	private String adress;	//���ּ�
	private String url;	//��������Ʈ�ּ�
	private String season;	//����
	
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
