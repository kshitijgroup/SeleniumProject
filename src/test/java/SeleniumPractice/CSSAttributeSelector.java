package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSAttributeSelector {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
		
		System.out.println(driver.findElements(By.cssSelector("input[placeholder]")).size());
		System.out.println(driver.findElements(By.cssSelector("input[placeholder='First Name']")).size());
		System.out.println(driver.findElements(By.cssSelector("input[placeholder~='answer']")).size());
		System.out.println(driver.findElements(By.cssSelector("input[placeholder*='tion']")).size());
		System.out.println(driver.findElements(By.cssSelector("p[class|='my']")).size());
		System.out.println(driver.findElements(By.cssSelector("p[class^='my']")).size());
		System.out.println(driver.findElements(By.cssSelector("p[class$='ass']")).size());
				
		

	}

}
