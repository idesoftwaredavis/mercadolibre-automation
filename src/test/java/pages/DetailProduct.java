package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase que identifica elementos del título de producto y el botón 'Comprar Ahora' sea vísible
 */
public class DetailProduct {
    
    private By titleDetailProduct = By.xpath("//div[@class='ui-pdp-header']//h1");
    
    private WebDriver driver;

    public DetailProduct(WebDriver driver){
        this.driver = driver;
    }

    public Boolean getTitleDetailProduct(){
        return driver.findElement(titleDetailProduct).isDisplayed();
    }

}
