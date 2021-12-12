package SeleniumPractice;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.util.Log4jThread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptTest {
    
    @Test
    public void javaScriptTestCases() throws Exception{

        Logger log = Logger.getLogger(Log4jThread.class);
        PropertyConfigurator.configure("../SeleniumProject/src/main/syslogs/log4j.properties");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        
        WebElement register = driver.findElement(By.linkText("Register"));

        JavaScriptUtility.clickElementJS(register, driver);
        log.info("Clicked on Register link");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

        JavaScriptUtility.highlightElement(logo, driver);
        log.info("Highlighted on Company logo");

        JavaScriptUtility.takesScreenshot(driver, "JStestscreenshot");
        log.info("Screenshot capture and saved");

        Thread.sleep(4000);
        driver.quit();
    }
}
