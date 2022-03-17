package com.Santiii.Santiagoo;
import org.openqa.selenium. WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.WikiHomePage;
import pageObjects.WikiresultsPage;
import pageObjects.BaseTest;
import org.testng.annotations. AfterMethod; 
import org.testng.annotations. BeforeMethod;





public class wikinewtest extends BaseTest{
	
	WebDriver driver=null;
	
	@BeforeMethod
	public void InicioTest() {
	 driver = BaseTest.iniciarDriver("CHROME"); 
	BaseTest.goToMainPage (driver);
	
    }


	

	@Test (description = "Validar que las busquedas en Wikipedia funcionan")


public void ValidarBusquedaWikipedia () throws Exception {

	WebDriver driver = BaseTest.iniciarDriver("CHROME"); 
	BaseTest.goToMainPage (driver);
	driver.manage().window().maximize();
	WikiHomePage homePage = new WikiHomePage (driver);
	
	Assert.assertTrue (homePage. searchInputEsVisible(), "El input no esta visible"); 
		WikiresultsPage resultspage = homePage.searchText("Selenium");
	
	Assert.assertTrue ( resultspage.tituloEsVisible(), "El titulo no esta visible"); 
	driver.close();
 

	}
	
	@AfterMethod 
	public void Fintest() { 
	driver.close();
	}
	
	
	
}