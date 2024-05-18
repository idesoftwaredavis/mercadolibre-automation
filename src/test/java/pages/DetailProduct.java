package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase que identifica elementos del título de producto y el botón 'Comprar Ahora' sea vísible
 */
public class DetailProduct {
    
    private By titleDetailProduct = By.xpath("//div[@class='ui-pdp-header']//h1");
    
    private By buyButton = By.xpath("//div[@class='ui-pdp-actions__container']//child::button[1]");

    private WebDriver driver;

    public DetailProduct(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleDetailProduct(){
        return driver.findElement(titleDetailProduct).getText().toString();
    }

    public Boolean buyButtonDisplayed(){
        return driver.findElement(buyButton).isDisplayed();
    }

    

}
