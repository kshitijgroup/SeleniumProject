package SeleniumPractice;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
    
    @Test
    public void datePicker(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.redbus.in");

        String date = "10";
        String month = "Mar";
        String year = "2022";

        driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
        
        while(true){
            String monthyear = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']//td[@class='monthTitle']")).getText();
            String arr[] = monthyear.split(" ");
            String mn = arr[0];
            String yr = arr[1];

            if(month.equalsIgnoreCase(mn) && year.equalsIgnoreCase(yr)){
                break;
            }
            else{
                driver.findElement(By.xpath("//td[@class='next']")).click();
            }
        }

        List<WebElement> dates = driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']//table/tbody//tr//td"));
        for(WebElement dt : dates){
            if(date.equals(dt.getText())){
                dt.click();
                break;
            }
        }

    }
}
