package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement country = driver.findElement(By.id("input-country"));
		
		Select sel = new Select(country);
		sel.selectByIndex(8);
		Thread.sleep(1000);
		
		sel.selectByVisibleText("Denmark");
		Thread.sleep(1000);
		sel.selectByValue("10");
		Thread.sleep(1000);
		
		List<WebElement> li = sel.getOptions();
		for(WebElement ele : li) {
			if(ele.getText().equalsIgnoreCase("India")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.quit();

	}

}
