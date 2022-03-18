package pageObjects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class BaseTest {
	public static void goToMainPage (WebDriver driver, String url) { 
		driver.get(url);
	}
	
	public static WebDriver iniciarDriver(WebDriver driver, String browserName) {
		switch(browserName) {
			case "CHROME": { 
				System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe"); 
				System.out.println("Abro browser de chrome");
				driver = new ChromeDriver();
				break;	
			}	
			case "EDGE": {
				System.setProperty("webdriver.edge.driver", "C:\\driver\\edgedriver.exe"); 
				System.out.println("Abro browser Edge");
				break;
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
}
