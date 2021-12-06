package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrames2 {
    
    @Test
    public void innerFramesTest() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

        driver.switchTo().frame("iframeResult");
        driver.switchTo().frame(0);

        String text = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(text);

        driver.switchTo().parentFrame();
        String parText = driver.findElement(By.xpath("//p[contains(text(),'You can use the height')]")).getText();
        System.out.println(parText);

        driver.quit();
    }
}
