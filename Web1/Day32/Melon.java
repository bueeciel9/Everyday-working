package crawling;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Melon {

	private WebDriver driver;
	private WebElement element;
	private String url;

	// properties
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:/chromedriver.exe";

	public Melon() {
		url = "https://www.melon.com/";
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// Driver Setup
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		url = "https://www.melon.com/";
	}

	public static void main(String[] args) {
		new Melon().operate();
	}

	public void operate() {
		try {
			searchSong();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
			driver.quit();
		}
	}

	public void searchSong() {

		Scanner sc = new Scanner(System.in);
		try {
			driver.get(url);
//		"ui-autocomplete-input" //검색 버튼
			element = driver.findElement(By.className("ui-autocomplete-input"));
			System.out.println("노래제목");
//		입력받은 문자열을 검색창에 입력
			element.sendKeys(sc.nextLine()); // 이까지 하면 작성
//		검색 영역에서 엔터
			element.sendKeys(Keys.RETURN); // 이게 enter 키!
			Thread.sleep(1000);

			// section_no_data
			element = driver.findElement(By.className("section_no_data"));
			System.out.println("검색된 결과가 없습니다.");

		} catch (Exception e) {
			// 검색된 결과가 있다면 오는 영역
//			songTypeOne : 곡명으로 검색
			element = driver.findElement(By.id("frm_searchSong"));

			// 번호, 제목, 아티스트 리스트 3개 필요
			List<WebElement> numList = element.findElements(By.className("no"));
			List<WebElement> titleList = element.findElements(By.className("fc_gray"));
			List<WebElement> artistList = element.findElements(By.id("artistName"));

			for (int i = 0; i < numList.size(); i++) {
				System.out.println(numList.get(i).getText() + ". " + titleList.get(i).getText() + ", 아티스트 : "
						+ artistList.get(i).getText());
			}

			// 아티스트 찾기 :List에 넣기 내일까지 해오기~

			System.out.println("곡 번호 :");
			int num = sc.nextInt();

			// 엔터 상쇄
			sc.nextLine();

			List<WebElement> detailList = element.findElements(By.className("btn_icon_detail"));
			detailList.get(num - 1).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				;
			}

			try {
				driver.findElement(By.className("button_more")).click();
				element = driver.findElement(By.className("lyric"));
				System.out.println(element.getText());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					;
				}
			} catch (org.openqa.selenium.NoSuchElementException e1) {
				System.out.println("This lyric needs adult authorization");
			}

			// 가사 찾기(lyric)

		}
	}
}
