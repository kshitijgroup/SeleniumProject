package SeleniumPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {
    
    @Test
    public void handleBrowserWindows() {
        
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //getWindowHandle()
        String windowId = driver.getWindowHandle(); // This will return ID of single browser window.
        System.out.println(windowId);

        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        // getWindowHandles()
        Set<String> windowIds = driver.getWindowHandles(); // return IDs of multiple browser windows

        //****** First Method - Iterator
    /*  Iterator<String> itr = windowIds.iterator();
        String parentWindowId = itr.next();
        String childWindowId = itr.next();

        System.out.println("Parent Window ID is: " +parentWindowId);
        System.out.println("Child Window ID is: " +childWindowId);
    */

        //******Second Method - List/ArrayList
    /*    List<String> windowIdsList = new ArrayList<String>(windowIds);
        String parentWindowId = windowIdsList.get(0);
        String childWindowId = windowIdsList.get(1);

        System.out.println(parentWindowId);
        System.out.println(childWindowId);

        //How to use Window Ids for switching between windows
        driver.switchTo().window(parentWindowId);
        System.out.println("Parent window title: " +driver.getTitle()); // Expected Title: OrangeHRM

        driver.switchTo().window(childWindowId);
        System.out.println("Child window title: " +driver.getTitle());  // Expected Title: OrangeHRM HR Software | Free HR Software | HRMS | HRIS
    */

        //******For Each loop
    /*  for(String winId : windowIds){
            String title =  driver.switchTo().window(winId).getTitle();
            System.out.println(title);
            driver.close();
        }
        
    */
        
        for(String winId : windowIds){
            String title =  driver.switchTo().window(winId).getTitle();
            if(title.contains("HRMS")||title.contains("OrangeHRM")){
                driver.close();
            }
        }
    }
}
