package JavaPracticePrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example5 {
    
    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		driver.get("https://www.onlinegdb.com/");
		//Capturing the webelement
		
		//Select sel = new Select(program);
		List<WebElement> li = driver.findElements(By.xpath("xpath of element"));
		for(WebElement ele : li){
		    System.out.print(ele.getText());
		}

        //SQL
        //Update Employee Set firstname='Laxman' where salary = (select Max(Salary) from SalaryTable where firstname='Ram');


    }
}
