package com.Santiii.Santiagoo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa. selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BaseTest;





public class TestDespegar {
	WebDriver driver=null;
	WebDriverWait wait=null;
	@BeforeMethod
	public void InicioTest(ITestContext context) {
		String navegadorTestSuite=context.getCurrentXmlTest().getParameter("Navegador");
		String navegador= navegadorTestSuite !=null ? navegadorTestSuite : "CHROME";
		System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://despegar.com.ar");
		driver.manage().window().maximize();
		wait = new WebDriverWait (driver, 5);
	
	}	
	
	@DataProvider(name = "DataProviderDespegar")
	public Object [] [] dpMethod(){
		return new Object[] [] {{"Cordoba"}, {"Mendoza"}, {"La Rioja"}};
	}
	
	@Test(dataProvider = "DataProviderDespegar", description = "Agregar destino")
	public void ValidarBusquedaDespegar(String DataProviderDespegar) throws Exception {
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.header-products-container>ul>li>a[title='Alojamientos']")));
			WebElement alojamiento = driver.findElement(By.cssSelector("div.header-products-container>ul>li>a[title='Alojamientos']"));
			alojamiento.click();
			
			//seleccionar destino
			System.out.println("Cargando el destino");
		    WebElement destinoInput = driver.findElement(By.cssSelector(".sbox5-box-places-ovr input"));
		    destinoInput.click();
		    destinoInput.sendKeys(DataProviderDespegar);
		    Thread.sleep(1000);
		    destinoInput.sendKeys(Keys.CONTROL);
		    Thread.sleep(1000);
		    WebElement primerDestino = driver.findElement(By.cssSelector(".ac-container .item-text"));
		    primerDestino.click();
		    WebElement destinoOpcionInput = driver.findElement(By.cssSelector(".sbox5-box-container .input-container input"));
		    destinoOpcionInput.click();
	
			
			//seleccionar fechas 
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1")));
		    WebElement fecha= driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1"));
			fecha.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today")));
			WebElement salida = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today"));
			salida.click();
			
			wait.until(ExpectedConditions.elementToBeClickable (By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-selected+div")));
			WebElement vuelta = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-selected+div"));
			vuelta.click();
			
			//seleccionar pasajeros
			WebElement personas = driver.findElement(By.cssSelector("div.sbox5-3-double-input"));
			wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("div.sbox5-3-double-input")));
			personas.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right")));
			
			WebElement cantPersonas = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right"));
			cantPersonas.click();	
			
			WebElement cantNiños = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right"));
			cantNiños.click();	
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(3) select")));
			WebElement menores = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(3) select"));
			menores.click();
			
			System.out.println("Clickeando edad minima");
			WebElement edadmin = menores.findElement(By.cssSelector(".select-option[value='4']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector(".select-option[value='4']")));
			edadmin.click();
			
			
			WebElement aplicar = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened .stepper__room__footer>a:nth-child(1)"));
			aplicar.click();
			Assert.assertTrue(menores.isDisplayed());
			
			WebElement buscar = driver.findElement(By.cssSelector("div.sbox5-box-container div.sbox5-box-content button"));
			wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("div.sbox5-box-container div.sbox5-box-content button")));
			buscar.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results-cluster-container:nth-child(1) em.btn-text")));
			WebElement elejir = driver.findElement(By.cssSelector("div.results-cluster-container:nth-child(1) em.btn-text"));
			Assert.assertTrue(elejir.isDisplayed());
			
			WebElement busqueda = driver.findElement(By.cssSelector("div.sbox-wrapper"));
			System.out.println("Cuadro de busqueda  "+busqueda.isDisplayed());
			
	}
	
	@AfterMethod
	public void cerrar() {
		driver.close();
	}
}
