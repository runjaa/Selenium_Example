package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String cartVerification = "YOUR CART";
    String AllItemsVerification = "PRODUCTS";
    String expectedProductNameZASort = "Test.allTheThings() T-Shirt (Red)";
    String expectedProductNameAZSort = "Sauce Labs Backpack";
    int numberOfAllItems = 6;
    String removeButton = "REMOVE";

    @Test
    public void VerifyCartEntry(){
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.baseURL();
    loginPage.login(standardUsername, password);
    homePage.clickOnShoopingCartButton();
    }

    @Test
    public void VerifyCartToAllItems(){
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.baseURL();
    loginPage.login(standardUsername, password);
    homePage.clickOnShoopingCartButton();
    homePage.clickOnHamburgerButton();
    homePage.clickOnAllItemsButton();
    homePage.verifyAllItemsPage(AllItemsVerification);
    }

    @Test
    public void VerifyAboutLink(){
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.baseURL();
    loginPage.login(standardUsername, password);
    homePage.clickOnHamburgerButton();
    homePage.verifyAboutLink();
    }

    @Test
    public void checkNumberOfItemsOnHomePage(){

    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.baseURL();
    loginPage.login(standardUsername, password);
    homePage.validateNumberOfProducts(numberOfAllItems);
    }

    @Test
    public void checkSortFromZtoA(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.baseURL();
        loginPage.login(standardUsername, password);
        homePage.selectSortOptionByValue("za");
        homePage.validateFirstProductName(expectedProductNameZASort);
    }

    @Test
    public void checkSortFromAtoZ(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.baseURL();
        loginPage.login(standardUsername, password);
        homePage.selectSortOptionByValue("az");
        homePage.validateFirstProductName(expectedProductNameAZSort);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void VerifyRemoveButtonVisibility(){
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.baseURL();
    loginPage.login(standardUsername, password);
    homePage.clickAddToCartButton();
    homePage.verifyAddToCart(removeButton);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    }


}
