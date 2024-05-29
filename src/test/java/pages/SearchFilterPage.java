package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchFilterPage {
    private WebDriver driver;

    private By filterDelivery = By.xpath("//div[@class='ui-search-filter-dl'][2]//button");
    
    private By listFreeDelivery = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']//child::li//span[text()='Envío gratis']");
    
    private By detailProducto = By.xpath("//li[@class='ui-search-layout__item shops__layout-item ui-search-layout__stack'][1]//a[1]");

    private By btn = By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[2]/button[2]");

    private By titleFilterPage = By.xpath("//aside[1]//h1");

    private By search = By.xpath("//input[@id='cb1-edit']");


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
            System.out.println("DENTRO DEL BUCLE ====> "+deli.getText());
            delivery = (deli.getText().contains("Envío gratis")) ? true : false;
            System.out.println("Respuesta variable delivery =====> " + delivery);
        }
        return delivery;
    }

    public void clickDetailProduct(){
        driver.findElement(detailProducto).click();
    }

    public void clickLaterBtn(){
        driver.findElement(btn).click();
    }
    
    public String getTitleFilter(){
        System.out.println("TITULO DEL FILTRO ==> " + driver.findElement(titleFilterPage).getText().toString());
        return driver.findElement(titleFilterPage).getText().toString();
    }

    public String getTitleInputSearch(){ 
        String inputTitle = driver.findElement(search).getAttribute("value");
        char firstLetter = driver.findElement(search).getAttribute("value").charAt(0);
        char capitalFirstLetter = Character.toUpperCase(firstLetter);
        System.out.println("TITULO DEL INPUT ==> " + driver.findElement(search).getAttribute("value"));
        return driver.findElement(search).getAttribute("value").replace(inputTitle.charAt(0), capitalFirstLetter);
    }
    
}
