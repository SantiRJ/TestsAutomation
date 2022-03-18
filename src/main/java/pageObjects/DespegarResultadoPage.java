package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarResultadoPage {

	@FindBy(css="div.sbox5-only-mobile")WebElement searchforAloj;
	private WebDriver driver =null;

	public DespegarResultadoPage(WebDriver driver) {
	    this.driver=driver;
	    PageFactory.initElements(driver,this);
	    WebDriverWait wait = new WebDriverWait (driver,5);		
	}	
	public boolean cuadroBusqueda() {	
	     return this.searchforAloj.isDisplayed();	
	}	
	}

