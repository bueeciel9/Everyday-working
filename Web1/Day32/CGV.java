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

		// 드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// WebDriver
		// 옵션을 줄 때
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		cgv.driver = new ChromeDriver(options);

		// 옵션이 없을 때
//		cgv.driver = new ChromeDriver();

		WebElement el;
		WebElement el2;

		String url = "http://www.cgv.co.kr/movies/";

		try {
			cgv.driver.get(url);
			el = cgv.driver.findElement(By.className("btn-more-fontbold"));
			el.click();// 이게 사이트 타고 들어가서 이 버튼 클릭해 주는거다. 
			Thread.sleep(1000);
			
			
//			class : sect-movie-chart
			el2 = cgv.driver.findElement(By.className("sect-movie-chart"));
			
			//찾을 게 없을 때는 단수, 찾을 게 있으면 복수!
			for(WebElement data : el2.findElements(By.className("title"))) {
				System.out.println(data.getText());
			}
//			class : title(반복)
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cgv.driver.close();
			cgv.driver.quit();
		}
		
	}
}
