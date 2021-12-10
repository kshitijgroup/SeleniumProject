package SeleniumPractice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {
    
    @Test
    public void captureScreenshot() throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //Full Page Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("./screenshots/fullpage.png");
        FileUtils.copyFile(src, target);

        //Page Section screenshot
        WebElement ele = driver.findElement(By.xpath("//div[@class='news-list-homepage']"));
        File src1 = ele.getScreenshotAs(OutputType.FILE);
        File target1 = new File("./screenshots/pagesection.png");
        FileUtils.copyFile(src1, target1);

        //WebElement screenshot
        WebElement img = driver.findElement(By.xpath("//div[@class='header-lower']"));
        File src2 = img.getScreenshotAs(OutputType.FILE);
        File target2 = new File("./screenshots/img.png");
        FileUtils.copyFile(src2, target2);

        driver.quit();
    }
}
