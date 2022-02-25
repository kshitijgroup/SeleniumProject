package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJQueryDrpDwn {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.id("justAnInputBox")).click();
        // selectMultipleChoice(driver, "choice 1");
        // selectMultipleChoice(driver, "choice 1", "choice 2 2", "choice 6 2", "choice
        // 6 2 3");
        selectMultipleChoice(driver, "ALL");
        Thread.sleep(4000);
        //driver.quit();
    }

    public static void selectMultipleChoice(WebDriver driver, String... value) {

        List<WebElement> li = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']//input"));

        if (!value[0].equalsIgnoreCase("all")) {
            for (WebElement ele : li) {
                String text = ele.getText();
                for (String val : value) {
                    if (text.equalsIgnoreCase(val)) {
                        ele.click();
                        break;
                    }
                }
            }
        } else {
            try {
                for (WebElement ele : li) {
                    ele.click();
                }
            } catch (Exception e) {
            }
        }

    }
}
