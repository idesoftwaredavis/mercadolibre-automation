package runner;

import org.testng.annotations.Test;

import pages.HomePage;

public class SearchTest extends AbstractTest {
    
    @Test
    public void pruebaEjemplo() throws InterruptedException{
        
        HomePage home = new HomePage(driver);

        home.goToPage("https://www.mercadolibre.com");

        home.selectCountry();
        
        home.searchProduct("iPhone 15 pro");
            
    }
}
