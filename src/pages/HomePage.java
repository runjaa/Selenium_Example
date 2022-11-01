package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By headerTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By hamburgerButtonBy = By.xpath("//*[@id='react-burger-menu-btn']");
    By logoutButtonBy = By.xpath("//*[@id='logout_sidebar_link']");
    By logoutVerificationField = By.xpath("//*[@id='login_credentials']/h4");
    By shoopingCart = By.xpath("//*[@id='shopping_cart_container']/a");
    By allItemsButton = By.xpath("//*[@id='inventory_sidebar_link']");
    String expectedHref = "https://saucelabs.com/";
    By aboutButton = By.xpath("//*[@id='about_sidebar_link']");
    By numberOfItemsBy = By.xpath("//*[@class='inventory_item']");
    By AboutButton = By.xpath("//*[@id='about_sidebar_link']");
    By sortDropdownBy = By.xpath("//select[@class='product_sort_container']");
    By productsTitlesBy = By.xpath("//div[@class='inventory_item_name']");
    By shoppingCartBadgeBy = By.xpath("//*[@id='shopping_cart_container']/a/span");
    By addToCartButtonBy = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    By removeButtonBy = By.xpath("//*[@id='remove-sauce-labs-backpack']");



    public HomePage verifyLogin (String expectedText){
        String pageTitle = readText(headerTitleBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }

    public HomePage clickOnHamburgerButton (){
        click(hamburgerButtonBy);
        return this;
    }

    public HomePage clickOnLogoutButton (){
        click(logoutButtonBy);
        return this;
    }

    public HomePage clickOnShoopingCartButton(){
        click(shoopingCart);
        return this;
    }

    public HomePage clickOnAllItemsButton(){
        click(allItemsButton);
        return this;
    }

    public HomePage verifyAllItemsPage(String expectedText) {
        String pageTitle = readText(headerTitleBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }

    public HomePage verifyAboutLink(){
        String actualHref = readHref(aboutButton);
        assertEquals(expectedHref, actualHref);
        return this;
    }

    public HomePage validateNumberOfProducts(int numberOfAllItems){
        int actualNumberOFProducts = locateElements(numberOfItemsBy).size();
        assertIntegerEquals(numberOfAllItems, actualNumberOFProducts);
        return this;
    }

    public HomePage selectSortOptionByValue(String value){
        selectDropdownOptionByValue(sortDropdownBy, value);
        return this;
    }

    public HomePage validateFirstProductName(String expectName){
        String firstProductTittle = readTextFromIndexElement(productsTitlesBy, 0);
        assertStringEquals(firstProductTittle, expectName);
        return this;
    }

    public HomePage clickAddToCartButton(){
        click(addToCartButtonBy);
        return this;
    }

    public HomePage verifyAddToCart (String expectedText){
        String removeButton = readText(removeButtonBy);
        assertStringEquals(removeButton, expectedText);
        return this;
    }

}
