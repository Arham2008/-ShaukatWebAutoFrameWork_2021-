package homepagetest;


import common.WebApi;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class HomePageTest extends WebApi {
    HomePage frontPage;
//Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns.
// In Page Factory, testers use @FindBy annotation.
// The initElements method is used to initialize web elements
//The @FindBy annotation is the essence of the Page Factory approach.
// It is used to locate web elements using different locators strategies.
// Additionally, it helps in quickly locating the web elements using one search criteria.
// Before declaring the WebElement, we pass its attribute and the corresponding value
    @BeforeMethod
    public void getInit(){
        frontPage= PageFactory.initElements(driver,HomePage.class);
    }
    @Test
    public void testSearchBox(){
        frontPage.checkSearchBox();
        frontPage.verifySearchProductFan("\"fan\"");//pass
    }
    @Test
     public void testHamburger(){
        frontPage.checkHamburger();
        frontPage.verifyHamburger("Best Sellers in Freezers");

     }
     @Test @Ignore
     public void testClothes(){
        frontPage.checkClothes();
         frontPage.verifyClothes("Featured categories");
    }
    @Test
    public void testFresh(){
        frontPage.checkFresh();
        frontPage.verifyFresh("Beverages");
    }
    @Test
    public void testPharmacy(){
        frontPage.checkAmazonPharmacy();
        frontPage.verifyPharmacy("Choose your way\n" + "to pay");
    }
}
