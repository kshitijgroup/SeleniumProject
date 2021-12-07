package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
    
    @Test
    public void getDataWebtable() throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://testautomationpractice.blogspot.com/?");

        //Print total number of rows
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Total rows are: " +(rows-1));

        //Print total number of columnns
        int columns = driver.findElements(By.xpath("//table[@name='BookTable']//tr/th")).size();
        System.out.println("Total Columns are: " +columns);

        //Retrieve all column values
        for(int row=2;row<=rows;row++) {
            for(int col=1;col<=columns;col++){
                String text = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]/td["+col+"]")).getText();
                System.out.print(text + " | ");
            }
            System.out.println();
        }
        driver.quit();
    }
}
