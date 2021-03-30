package homepage;

import base.WebApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;


import static homepage.HomePageWebElement.*;
public class HomePage extends WebApi {
// Action class:
    // Call all the related locators variable from WebElement class inside @FindBy
    // Create Action Methods based on your test cases
    // Create Assertion Methods based on verification needed in your test cases


    // Page object Design Pattern
    // using @FindBY with How
  @FindBy(how = How.ID,using = amazonSearchBox)
    public WebElement searchBox;
    @FindBy(how = How.XPATH,using = clickButton)
    public WebElement searchButton;
    @FindBy(how = How.XPATH,using = fanText)
    public WebElement fanClick;
    @FindBy(how =How.XPATH,using = hamburgerButton)
    public WebElement hamburger;
    @FindBy(how =How.XPATH,using =bestSellerButton )
    public WebElement bestSeller;
    @FindBy(how = How.XPATH,using =applianceButton )
    public WebElement applianceText;
    @FindBy(how = How.XPATH,using = freezerButton)
   public WebElement freezer;
    @FindBy(how = How.XPATH,using = freezerchose)
    public WebElement freezergood;


    //Action Method
    public void checkSearchBox(){
        // Enter product name in search webEdit field
        searchBox.sendKeys("fan");
        // Click on search button
        searchButton.click();
        fanClick.click();
    }
    public void checkHamburger(){
     hamburger.click();
     bestSeller.click();
     applianceText.click();
     freezer.click();
     freezergood.click();

    }

    public void verifySearchProductFan(String expectedText){
        // Expected Result
        // String expectedText="\"fan\"";
        // Actual Result
        String actualText=fanClick.getText();
        Assert.assertEquals(actualText,expectedText,"Product does not match");
    }
    public void verifyHamburger(String expectedText){
        String actualText=freezergood.getText();
        Assert.assertEquals(actualText,expectedText,"Test fail");


    }
      // using @FindBY with Locator type when public  second way
         @FindBy(xpath = hamburgerSwitch)
         public WebElement hamSwitch;
         @FindBy(css = clothes)
         public WebElement salwarKameez;
         @FindBy(xpath = mens)
         public WebElement suite;
         @FindBy(xpath = luggage)
         public WebElement trunk;
         @FindBy(xpath = best)
         public WebElement good;
         //==========================================================



       // action method
        public void   checkClothes(){
        hamSwitch.click();
        salwarKameez.click();
        suite.click();
        trunk.click();
        }
    public void verifyClothes(String expectedTest){
        String actualTest=good.getText();
        Assert.assertEquals(actualTest,expectedTest,"Test fail");

    }
   //==========================================================

    @FindBy(xpath = hamburgerIn)
    public  WebElement hamIn;
     @FindBy(css = amazonFresh)
     public WebElement fresh;
     @FindBy(css = beverage)
     public WebElement juice;
     @FindBy(xpath = drink)
     public WebElement orange;

     public void checkFresh(){
        hamIn.click();
        fresh.click();
        juice.click();
   }
    public void verifyFresh(String expectedTest) {
        String actualTest = orange.getText();
        Assert.assertEquals(actualTest, expectedTest, "Test fail");
     }
     //============================================================================
     // // using @FindBY with Locator type when private
    //    @FindBy(xpath = searchButtonWebElement1)
    //    private WebElement searchButton2;
    //
    //    // Getter and Setter
    //    public WebElement getSearchButton2() {
    //        return searchButton2;
    //    }
    //
    //    // Action Method
    //    public void checkSearchBox2() {
    //        getSearchButton2().sendKeys(productName);
    //    }
       @FindBy(xpath = hamburgerOut)
       private WebElement hamOut;
       @FindBy(xpath = pharmacy)
       private WebElement doze;
       @FindBy(xpath = pricing)
       private WebElement value;
       @FindBy(xpath = chooseWay)
       private WebElement way;

    // Getter and Setter
    public WebElement  getHamOut(){
        return hamOut;
    }
    public WebElement getDoze(){
        return doze;
    }
    public WebElement getValue(){
        return value;
    }
    public WebElement getWay(){
        return way;
    }

     public void checkAmazonPharmacy(){
        getHamOut().click();
        getDoze().click();
        getValue().click();
    }
    public void verifyPharmacy(String expectedText){
        String actualText=getWay().getText();
        Assert.assertEquals(actualText,expectedText,"Test fail");

    }

}
