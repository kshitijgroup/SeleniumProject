package SeleniumPractice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
    
    public static void clickElementJS(WebElement element, WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void highlightElement(WebElement element, WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void takesScreenshot(WebDriver driver, String screenshotName) throws Exception{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File targ = new File("./screenshots/"+screenshotName+".png");
        FileUtils.copyFile(src, targ);
    }
}
