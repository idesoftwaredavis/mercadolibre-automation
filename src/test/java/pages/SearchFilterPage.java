package pages;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchFilterPage {
    private WebDriver driver;

    private By filterDelivery = By.xpath("//input[@id='shipping_highlighted_fulfillment']");
    
    private By listFreeDelivery = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']//child::li//span[text()='Envío gratis']");
    
    private By detailProducto = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']//child::li[1]//img");

    public SearchFilterPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectDeliverySwitch(){
        driver.findElement(filterDelivery).click();
    }

    public Boolean deliveryDetected(){
        Boolean delivery = true;
        List<WebElement> listDeliverys = driver.findElements(listFreeDelivery);

        for(WebElement deli : listDeliverys){
            delivery = (deli.getText() == "Envío gratis") ? delivery : false;
        }
        return delivery;
    }

    public void clickDetailProduct(){
        driver.findElement(detailProducto).click();
    }
    
    
}
