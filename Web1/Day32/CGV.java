package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CGV {

	private WebDriver driver;
	private WebElement el;

	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:/chromedriver.exe";

	public static void main(String[] args) {

		CGV cgv = new CGV();

		// ����̹� ����
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// WebDriver
		// �ɼ��� �� ��
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		cgv.driver = new ChromeDriver(options);

		// �ɼ��� ���� ��
//		cgv.driver = new ChromeDriver();

		WebElement el;
		WebElement el2;

		String url = "http://www.cgv.co.kr/movies/";

		try {
			cgv.driver.get(url);
			el = cgv.driver.findElement(By.className("btn-more-fontbold"));
			el.click();// �̰� ����Ʈ Ÿ�� ���� �� ��ư Ŭ���� �ִ°Ŵ�. 
			Thread.sleep(1000);
			
			
//			class : sect-movie-chart
			el2 = cgv.driver.findElement(By.className("sect-movie-chart"));
			
			//ã�� �� ���� ���� �ܼ�, ã�� �� ������ ����!
			for(WebElement data : el2.findElements(By.className("title"))) {
				System.out.println(data.getText());
			}
//			class : title(�ݺ�)
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cgv.driver.close();
			cgv.driver.quit();
		}
		
	}
}
