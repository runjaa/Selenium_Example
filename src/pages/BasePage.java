package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    
    public void click (By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }

    public void writeText (By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText (By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public String readTextFromIndexElement(By elementBy, int index){
        waitVisibility(elementBy);
        return driver.findElements(elementBy).get(index).getText();
    }
    
    public void assertEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public void assertStringEquals (String string, String expectedText){
        Assert.assertEquals(string,expectedText);
    }

    public void assertElementVisible(By elementBy){
        boolean isVisible = driver.findElement(elementBy).isDisplayed();
        Assert.assertTrue(isVisible);
    }

    public String readHref(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute("href");
    }

    public int countItems(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void assertIntegerEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }
    
    public List<WebElement> locateElements(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }

    public void selectDropdownOptionByValue(By elementBy, String value){
        waitVisibility(elementBy);
        Select select = new Select(driver.findElement(elementBy));
        select.selectByValue(value);
    }

    
    
}
