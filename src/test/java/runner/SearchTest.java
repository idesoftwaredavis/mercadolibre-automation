package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchFilterPage;

public class SearchTest extends AbstractTest {
    
    String actual = "";
    String expected = "";
   
    
    @Test
    public void SearchFilterTest() throws InterruptedException{
        HomePage home = new HomePage(driver);
        SearchFilterPage search = new SearchFilterPage(driver);

        home.goToPage("https://www.mercadolibre.com");
        home.selectCountry();
        home.clickMoreLater(); 
        home.searchProduct("ps5");

        // Assertion 1 : Validar búsqueda de artículos
        Assert.assertEquals(search.getTitleFilter(),search.getTitleInputSearch());
    }


    @Test
    public void hovers() {
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");

        WebElement hoverable = driver.findElement(By.id("hover"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();

        Assert.assertEquals("hovered", driver.findElement(By.id("move-status")).getText());
    }

}
