package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsAttributeValue {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		
		System.out.println(email.getAttribute("value"));
		email.clear();
		email.sendKeys("kshitijchaudhary@gmail.com");
		Thread.sleep(2000);
		System.out.println(email.getAttribute("value"));

	}

}
