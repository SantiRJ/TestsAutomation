package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Despegarhomepage {

	@FindBy (css="div.header-products-container>ul>li>a[title='Alojamientos']")
    	WebElement alojamiento;
		private WebDriver Driver = null;

public Despegarhomepage (WebDriver Driver) {
this.Driver=Driver;
PageFactory.initElements(Driver,this);
}
public boolean alojamientoEsVisible() {
return alojamiento.isDisplayed();

 }

 public DespegarBusquedaPage seleccionAlojamiento() { 
alojamiento.click(); 
return new DespegarBusquedaPage (this.Driver);
}

}
