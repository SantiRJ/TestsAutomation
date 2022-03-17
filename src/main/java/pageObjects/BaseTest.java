package pageObjects;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class BaseTest {


	public static void goToMainPage (WebDriver driver) { 
		driver.get("http://wikipedia.org");
		}
	
	
	public static WebDriver iniciarDriver (String browserName) {
    WebDriver driver = null;{
	switch (browserName) {
	
	case "CHROME": { System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe"); 
	System.out.println("Abro browser de chrome");
	driver = new ChromeDriver();
	break;
	
	}
	
	case "Edge": {
	System.setProperty("webdriver.edge.driver", "C:\\driver\\edgedriver.exe"); 
	System.out.println("Abro browser Edge");
	}



	}
    }
	return driver;

	}
}
	
	