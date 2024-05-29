package runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DetailProduct;
import pages.HomePage;
import pages.SearchFilterPage;

public class SearchTest extends AbstractTest {
    
    String actual = "";
    String expected = "";


    
    @Test
    public void SearchFilterTest() throws InterruptedException{
        HomePage home = new HomePage(driver);
        SearchFilterPage search = new SearchFilterPage(driver);
        home.initPage("https://www.mercadolibre.com"); 
        home.searchProduct("ps5 ofertas cyber day");
        // Assertion 1 : Validar búsqueda de artículos
        Assert.assertEquals(search.getTitleFilter(),search.getTitleInputSearch(), "No se ha encontrado coincidencias");
    }


    @Test
    public void DisplayCategoryDetailTest() {
        HomePage home = new HomePage(driver);
        home.initPage("https://www.mercadolibre.com");
        home.selectCategory("Categorías");
        home.SelectSubCategory("Vehículos");

        Assert.assertTrue(home.carouselIsDisplayed(), "No se ha encontrado la categoria respectiva");
    }

    @Test
    public void SwitchFreeDerliveryTest(){
        HomePage home = new HomePage(driver);
        SearchFilterPage search = new SearchFilterPage(driver);
        home.initPage("https://www.mercadolibre.com");
        home.searchProduct("ps5 ofertas cyber day");
        search.selectDeliverySwitch();

        Assert.assertTrue(search.deliveryDetected(),"El switch no funciona o el listado no ha devuelto el filtro respectivo");
    }

    @Test
    public void DetailProductTest(){
        HomePage home = new HomePage(driver);
        SearchFilterPage search = new SearchFilterPage(driver);
        DetailProduct detail = new DetailProduct(driver);

        home.initPage("https://www.mercadolibre.com");
        home.searchProduct("ps5 ofertas cyber day");
        search.clickDetailProduct();
        
        Assert.assertTrue(detail.getTitleDetailProduct(),"No se ha redirigido a la página del detalle de producto");
    }

}
