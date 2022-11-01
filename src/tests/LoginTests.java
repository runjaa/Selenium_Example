package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    public String invalidUsername = "user_989";
    public String expectedError = "Epic sadface: Username and password do not match any user in this service";
    public String invalidPassword = "000000";
    public String lockedUserError = "Epic sadface: Sorry, this user has been locked out.";
    public String lockedUser = "locked_out_user";


    @Test
    public void loginWithValidUser(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.baseURL();
        loginPage.login(validUsername, validPassword);
        homePage.verifyLogin("PRODUCTS");}

    @Test

    public void loginWithInvalidUsername(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.baseURL();
        loginPage.login(invalidUsername, validPassword);
        loginPage.verifyInvalidLogin(expectedError);}

    @Test

    public void loginWithInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.baseURL();
        loginPage.login(validUsername, invalidPassword);
        loginPage.verifyInvalidLogin(expectedError);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test

    public void loginWithLockedUser(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.baseURL();
        loginPage.login(lockedUser, validPassword);
        loginPage.verifyInvalidLogin(lockedUserError);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    
    public void verifySucessfullLogout(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.baseURL();
        loginPage.login(validUsername, validPassword);
        homePage.clickOnHamburgerButton();
        homePage.clickOnLogoutButton();
        loginPage.verifySucessfullLogout();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
           
    

