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
//		"ui-autocomplete-input" //�˻� ��ư
			element = driver.findElement(By.className("ui-autocomplete-input"));
			System.out.println("�뷡����");
//		�Է¹��� ���ڿ��� �˻�â�� �Է�
			element.sendKeys(sc.nextLine()); // �̱��� �ϸ� �ۼ�
//		�˻� �������� ����
			element.sendKeys(Keys.RETURN); // �̰� enter Ű!
			Thread.sleep(1000);

			// section_no_data
			element = driver.findElement(By.className("section_no_data"));
			System.out.println("�˻��� ����� �����ϴ�.");

		} catch (Exception e) {
			// �˻��� ����� �ִٸ� ���� ����
//			songTypeOne : ������� �˻�
			element = driver.findElement(By.id("frm_searchSong"));

			// ��ȣ, ����, ��Ƽ��Ʈ ����Ʈ 3�� �ʿ�
			List<WebElement> numList = element.findElements(By.className("no"));
			List<WebElement> titleList = element.findElements(By.className("fc_gray"));
			List<WebElement> artistList = element.findElements(By.id("artistName"));

			for (int i = 0; i < numList.size(); i++) {
				System.out.println(numList.get(i).getText() + ". " + titleList.get(i).getText() + ", ��Ƽ��Ʈ : "
						+ artistList.get(i).getText());
			}

			// ��Ƽ��Ʈ ã�� :List�� �ֱ� ���ϱ��� �ؿ���~

			System.out.println("�� ��ȣ :");
			int num = sc.nextInt();

			// ���� ���
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

			// ���� ã��(lyric)

		}
	}
}
