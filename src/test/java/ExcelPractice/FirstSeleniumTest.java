package ExcelPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
	
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "/Users/kshitijchaudhary/Desktop/Sel/chromedriver");
	
	WebDriver driver = new ChromeDriver();
	driver.get("http://stackoverflow.com/");
	
}
}
