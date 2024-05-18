package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage{
    private WebDriver driver;

    String categoryAux="//ul[@class='nav-menu-list']/li[@class='nav-menu-item'][1]";
    private By category = By.xpath(categoryAux);

    String subCategoryAux = "";
    private By subCategories = By.xpath("//ul[@class='nav-categs-departments']//li[normalize-space()='Supermercado']");
    
    private By searchButton = By.xpath("//input[@id='cb1-edit']");

    private By linkSite = By.xpath("//li[@class='ml-site-mlc']");

    private By laterBtn = By.xpath("//div[@class='onboarding-cp']//button[2]");

    
    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public void goToPage(String url){
        driver.get(url);
    }

    public void selectCountry(){
         driver.findElement(linkSite).click();
    }

    //Busqueda en el menú de la parte superior
    public void searchProduct(String textInput){
        driver.findElement(searchButton).clear();
        driver.findElement(searchButton).sendKeys(textInput);
        driver.findElement(searchButton).sendKeys(Keys.ENTER);
    }

    // Click on "Mas tarde" information
    public void clickMoreLater(){
        driver.findElement(laterBtn).click();
    }

     //Selección de categoría
    public void selectCategory(String textCategory){
        //categoryAux = String.format(categoryAux,textCategory);
        driver.findElement(category).click();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(category)).perform();
    }


     //Selección de subcategoría
    public void SelectSubCategory(String textSubCategory){
        
        
        driver.findElement(subCategories).click();

        // WebElement elementToHover= driver.findElement(subCategories);
        // List<WebElement> elementos = elementToHover.findElements(By.tagName("li"));
        // WebElement elemento = elementos.get(1);

        // elemento.click();

    }


    

}
