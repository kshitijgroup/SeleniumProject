package SeleniumPractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
    
    @Test
    public void handleBrokenLinks() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int brokenlink=0;
        for(WebElement ele : links){
            String link = ele.getAttribute("href");

            if(link.isEmpty() || link=="null"){
                System.out.println("URL is empty");
                continue;
            }

            URL url = new URL(link);
            try{
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                if(conn.getResponseCode()>=400){
                    System.out.println(url +" is a broken link with Response code " +conn.getResponseCode());
                    brokenlink++;
                }
                else{
                    System.out.println(url +" is a valid link with Response code " +conn.getResponseCode());
                }
            }
            catch(Exception e){}          
        }
        System.out.println("Total broken links are: " +brokenlink);
        driver.quit();
        }
        
    }