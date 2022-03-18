package com.Santiii.Santiagoo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BaseTest;
import pageObjects.DespegarBusquedaPage;
import pageObjects.DespegarResultadoPage;
import pageObjects.Despegarhomepage;
public class TestDespegar extends BaseTest {
	WebDriver driver=null;
	
	@BeforeMethod (alwaysRun=true)
	public void InicioTest(ITestContext context) {
		String navegador=context.getCurrentXmlTest().getParameter("Navegador");
		String browser= navegador !=null ? navegador : "CHROME";
		driver = super.iniciarDriver(driver, browser);
		super.goToMainPage(driver, "https://www.despegar.com.ar/");
	}		
	
		
	@Test( description = "Validar Busqueda")
	public void ValidarBusquedaDespegar() throws Exception {	
			Despegarhomepage inicio = new Despegarhomepage(driver);
			Assert.assertTrue(inicio.alojamientoEsVisible(), "Es Visible"); 
			DespegarBusquedaPage busqueda = inicio.seleccionAlojamiento(); 
			Assert.assertTrue(busqueda.destinoEsVisible(), "Es Visible");
			busqueda.ElegirDestino("Mendoza");
			busqueda.elegirFecha();
			busqueda.elegirPasajeros();
			DespegarResultadoPage resultados=busqueda.buscarAlojamiento(); 
			Assert.assertTrue (resultados.cuadroBusqueda(), "es visible"); 
	}
	
	@AfterMethod (alwaysRun=true)
	public void cerrar() {
		driver.close();
	}
}
