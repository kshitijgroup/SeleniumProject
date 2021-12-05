package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {
    
    @Test
    public void handleCheckbox(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        
        List<WebElement> days = driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
        System.out.println(days.size());

        // for(int i=0;i<days.size();i++){
        //     days.get(i).click();
        // }

        // for(WebElement ele : days){
        //     if(ele.getAttribute("id").equals("sunday") || ele.getAttribute("id").equals("tuesday")){
        //         ele.click();
        //     }
        // }

        /* Select last 2 checkboxes 
        for(int j=days.size()-2;j<days.size();j++){
            days.get(j).click();
        }
        */

        // Select first 3 checkboxes
        for(int j=0;j<days.size();j++){
            if(j<3){
                days.get(j).click();
            }
        }
      

        
    }
}
