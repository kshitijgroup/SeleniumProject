package SeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.util.Log4jThread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted {
    
    @Test
    public void testDropDownSorted() {
        
        Logger log = Logger.getLogger(Log4jThread.class);
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PropertyConfigurator.configure("../SeleniumProject/src/main/syslogs/log4j.properties");
        driver.get("https://www.twoplugs.com/");
        log.info("Browser launched");
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement industry = driver.findElement(By.name("category_id"));
        Select indDrpDwn = new Select(industry);
        
        List<WebElement> options = indDrpDwn.getOptions();
        
        ArrayList<String> origList = new ArrayList<String>();
        ArrayList<String> tempList = new ArrayList<String>();

        for(WebElement option : options){
            origList.add(option.getText());
            tempList.add(option.getText());
        }

        log.info("Original List: " +origList);
        log.info("Temp List before sorting: " +tempList);

        log.info("*********************************************");

        Collections.sort(tempList);

        log.info("Original List: " +origList);
        log.info("Temp List after sorting: " +tempList);

        if(origList.equals(tempList)){
            log.info("Drop down list items are sorted");
        }
        else{
            log.info("Drop down list items are unsorted");
        }

        driver.quit();
    } 
}
