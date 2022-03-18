package com.Santiii.Santiagoo;
import org.openqa.selenium. WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseTest;
import pageObjects.WikiHomePage;
import pageObjects.WikiresultsPage;

import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod;
public class wikinewtest extends BaseTest{
   	WebDriver driver=null;	
	@BeforeMethod (alwaysRun=true)
	public void InicioTest() {
	 driver = BaseTest.iniciarDriver(driver, "CHROME"); 
	BaseTest.goToMainPage(driver, "https://www.wikipedia.org/");	
    }
	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
public void ValidarBusquedaWikipedia () throws Exception {
	WikiHomePage homePage = new WikiHomePage (driver);

	Assert.assertTrue (homePage. searchInputEsVisible(), "El input no esta visible"); 
	WikiresultsPage resultspage = homePage.searchText("Selenium");	
	Assert.assertTrue ( resultspage.tituloEsVisible(), "El titulo no esta visible"); 
	}	
	@AfterMethod (alwaysRun=true)
	public void Fintest() { 
	driver.close();
	}	
}