package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatedPopUp {
    
    @Test
    public void authenticationPopUp() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Syntax: http://user:password@url
        Thread.sleep(3000);
        driver.quit();
    }
}
