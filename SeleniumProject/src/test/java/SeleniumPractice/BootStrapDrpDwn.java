package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDrpDwn {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://www.hdfcbank.com/");
        Thread.sleep(2000);
        // driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//div[@class='cookie-container ng-scope']//a[text()='OK']")).click();
        // Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='drp1']//a[@class='btn-primary dropdown-toggle btn-block']")).click();
        Thread.sleep(2000);
        
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));

        System.out.println("Total options available in first dropdown: " +options.size());
        try{
            for(WebElement option : options){
                if(option.getText().equalsIgnoreCase("Accounts")){
                    System.out.println("MATCH FOUND");
                    option.click();
                    break;
                }
            }
        }  
        catch(Exception e){
            System.out.print(e.getStackTrace());
        } 
        //driver.quit();
    }
}
