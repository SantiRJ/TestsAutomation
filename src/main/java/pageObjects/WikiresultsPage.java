package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiresultsPage{

	@FindBy(id="firstHeading") WebElement titulo;

	private WebDriver Driver = null;

	public WikiresultsPage (WebDriver driver) { 
		this.Driver = driver; 
		PageFactory.initElements (driver, this);
	
	}
	
	public boolean tituloEsVisible() { 
		return this.titulo.isDisplayed();
			
	}

}