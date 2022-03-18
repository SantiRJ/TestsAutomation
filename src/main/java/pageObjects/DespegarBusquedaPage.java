package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarBusquedaPage {
	
	@FindBy(css=".sbox5-box-places-ovr input") 
	WebElement destinoInput;
	@FindBy(css=".ac-container .item-text") 
	WebElement primerDestino;
	@FindBy(css=".sbox5-box-container .input-container input")
	WebElement destinoOpcionInput;
	@FindBy(css="div#searchbox-sbox-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1")  
	WebElement fecha;
	@FindBy(css="div.sbox5-floating-tooltip-opened div.calendar-container div.-today") 
	WebElement salida;
	@FindBy(css="div#searchbox-sbox-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input2")
	WebElement clickVuelta;
	@FindBy(css="div.sbox5-floating-tooltip-opened div.calendar-container div.-selected+div") 
	WebElement vuelta;
	@FindBy(css="div.sbox5-floating-tooltip-opened div.calendar-footer em.btn-text")
	WebElement aplicarD;
	@FindBy(css="div.sbox5-3-double-input") 
	WebElement personas;
	@FindBy(css="div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right")
	WebElement cantPersonas;
	@FindBy(css="div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right") 
	WebElement cantNiños;
	@FindBy(css="div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(3) select")
	WebElement menores;
	@FindBy(css=".select-option[value='15']") 
	WebElement edadMin;
	@FindBy(css="div.sbox5-floating-tooltip-opened .stepper__room__footer>a:nth-child(1)") 
	WebElement aplicar;
	@FindBy(css="div.sbox5-box-container div.sbox5-box-content button") 
	WebElement buscar;
	@FindBy(css="div.sbox5-floating-tooltip-opened")
	WebElement listaPasajeros;
	
	private WebDriverWait wait = null;
	private WebDriver driver = null;
	JavascriptExecutor js = null;  

	public DespegarBusquedaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait (driver,5);
		js = (JavascriptExecutor) driver;
	}
	
	public boolean destinoEsVisible () {
		return destinoInput.isDisplayed(); 
	}


	public void ElegirDestino (String busqueda) throws InterruptedException{
	
			wait.until(ExpectedConditions.elementToBeClickable(destinoInput)); 
			destinoInput.click();
			Thread.sleep(2000);
			destinoInput.sendKeys(busqueda);
			Thread.sleep(500);
			destinoInput.sendKeys(Keys.CONTROL);
			wait.until(ExpectedConditions.elementToBeClickable(primerDestino));
			destinoInput.sendKeys(Keys.ENTER);
	}
		
	public void elegirFecha () {			
			wait.until(ExpectedConditions.elementToBeClickable (fecha));
			fecha.click();
			wait.until(ExpectedConditions.elementToBeClickable(salida));
			salida.click();
			clickVuelta.click();
			wait.until(ExpectedConditions.elementToBeClickable(vuelta));
			vuelta.click();
			js.executeScript("window.scrollBy(0,300)");
			aplicarD.click();			
		}
	
	public void elegirPasajeros () {
			personas.click();
			wait.until(ExpectedConditions.elementToBeClickable(cantPersonas));
			cantPersonas.click();			
			wait.until(ExpectedConditions.elementToBeClickable (cantNiños));
			cantNiños.click();
			menores.click();
			wait.until(ExpectedConditions.elementToBeClickable(edadMin));
			edadMin.click();
			aplicar.click();		
		}

	public DespegarResultadoPage buscarAlojamiento () {
		buscar.click();
		return new DespegarResultadoPage(this.driver);
	}
}



