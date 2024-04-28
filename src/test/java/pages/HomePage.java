package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class HomePage{
    private WebDriver driver;

    String categoryAux="//li[@class='nav-menu-list'][text()='%s']";
    private By category = By.xpath(categoryAux);

    String subCategoryAux = "//li[@class='nav-categs-departments'][normalize-space()='%s']";
    private By subCategories = By.xpath(subCategoryAux);
    
    private By searchButton = By.xpath("//input[@id='cb1-edit']");

    private By linkSite = By.xpath("//li[@class='ml-site-mlc']");
    
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

     //Selección de categoría
    public void selectCategory(String textCategory){
        categoryAux = String.format(categoryAux,textCategory);
        driver.findElement(category).click();
    }

     //Selección de subcategoría
    public void SelectSubCategory(String textSubCategory){
        subCategoryAux = String.format(subCategoryAux, textSubCategory);
        driver.findElement(subCategories).click();
    }

}
