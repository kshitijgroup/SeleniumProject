package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * HandleMultipleDroDwn
 */
public class HandleMultipleDroDwn {

    // public static void main(String[] args) throws InterruptedException {

    @Test
    public void multipleDrpDwn() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.orangehrm.com/contact-sales/");

        WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
        selectFromDrpDwn(country, "India");
        WebElement emp = driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
        selectFromDrpDwn(emp, "16 - 20");
        Thread.sleep(2000);
        driver.quit();
    }

    public static void selectFromDrpDwn(WebElement ele, String value){

        Select sel = new Select(ele);
        List<WebElement> options = sel.getOptions();
        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase(value)){
                option.click();
            }
        }
    }
    
    // }
}