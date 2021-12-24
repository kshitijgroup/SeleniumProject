package RealTime_Scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_WDW_US {
    
    @Test
    public void waltDisneyScenarioUS() throws Exception{
    
    String cookieAcceptBtn = "//button[@id='onetrust-accept-btn-handler']";
    String hotel_ticket = "//fieldset[@class='holiday']//label[@for='package']";
    String day = "//select[@id='day']";
    String month = "//select[@id='month']";
    String nights = "//select[@id='nights']";
    String adults = "//select[@id='adults']";
    String children = "//select[@id='children']";
    String child1age = "//select[@id='age1']";
    String package_category = "//select[@id='package-category']";
    String searchHotelsButton = "//input[@type='submit']";

    //Initialize Webdriver instance
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    try{
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.disneyholidays.com/walt-disney-world/");
        
        //Click on Accept Cookie button
        driver.findElement(By.xpath(cookieAcceptBtn)).click();

        //Select Hotel+Ticket option
        driver.findElement(By.xpath(hotel_ticket)).click();

        //Select Departing date
        WebElement date = driver.findElement(By.xpath(day));
        selectDropDownValue(driver, date, "10");

        //Select Departing Month
        WebElement monthYear = driver.findElement(By.xpath(month));
        selectDropDownValue(driver, monthYear, "February 2022");
        
        //Select number of nights to stay
        WebElement nightsToStay = driver.findElement(By.xpath(nights));
        selectDropDownValue(driver, nightsToStay, "3");

        //Select number of adults in the party
        WebElement adultsCount = driver.findElement(By.xpath(adults));
        selectDropDownValue(driver, adultsCount, "3");
        
        //Select number of Children in the party
        WebElement childrenCount = driver.findElement(By.xpath(children));
        selectDropDownValue(driver, childrenCount, "1");
        
        //Select Age of Child 1 in the party
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement chi1Age = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(child1age)));
        selectDropDownValue(driver, chi1Age, "3");

        //Select Package Category
        WebElement packageCat = driver.findElement(By.xpath(package_category));
        selectDropDownValue(driver, packageCat, "Disney's Deluxe Villas");

        //Click on Search Hotels button
        driver.findElement(By.xpath(searchHotelsButton)).click();
        
        Thread.sleep(10000);
        Assert.assertEquals("Select Your Disney Hotel | Walt Disney World® Official Site", driver.getTitle());
    } catch(Exception e){
        e.printStackTrace();
    } finally{
        Thread.sleep(3000);
        driver.quit();
    }
    
    }

    public static void selectDropDownValue(WebDriver driver, WebElement ele, String value){
        Select sel = new Select(ele);
        sel.selectByVisibleText(value);
    }
}
