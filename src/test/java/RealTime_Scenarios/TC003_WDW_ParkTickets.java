package RealTime_Scenarios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_WDW_ParkTickets {

    ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    ExtentTest logger;

    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "LocalHost");
        extent.setSystemInfo("Environment", "Automation Testing");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
        htmlReporter.config().setReportName("Name of the Report Comes here");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @Test
    public void buyParkTickets() throws Exception {

        logger = extent.createTest("TC003_WDW_ParkTickets");
        // Define Xpaths
        String parksTickets = "//li[@class='parks item flyout']//a[text()='Parks & Tickets']";
        String buyParkTickets = "//li[@class='parks item flyout']//descendant::div//a[text()='Buy Park Tickets']";
        String childCountIncrement = "//div[@class='children small-12 medium-6']//div[@class='selector small-12 medium-12']//descendant::a[@class='plus']";
        String numOfDays = "//label[@for='four-day']";
        String calendarDate = "//table[@class='ui-datepicker-calendar']/tbody/tr/td//a[text()='14']";
        String parkHopperTicket = "//label[@for='hopper']";
        String parkHopperPrice = "//label[@for='hopper']//div[@class='total']//span";
        String submitBtn = "//input[@type='submit']";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {

            // Launch browser
            driver.get("https://www.disneyholidays.com/walt-disney-world/");

            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

            WebElement parksTicketsLink = driver.findElement(By.xpath(parksTickets));
            Actions act = new Actions(driver);
            act.moveToElement(parksTicketsLink).build().perform();

            WebElement buyParksTicketsLink = driver.findElement(By.xpath(buyParkTickets));
            Thread.sleep(1000);
            buyParksTicketsLink.click();

            // Add 3 Children
            WebElement childCount = driver.findElement(By.xpath(childCountIncrement));
            for (int i = 0; i < 3; i++) {
                childCount.click();
                Thread.sleep(1000);
            }

            WebElement numOfDaysBtn = driver.findElement(By.xpath(numOfDays));
            numOfDaysBtn.click();

            WebElement calendarDateBtn = driver.findElement(By.xpath(calendarDate));
            calendarDateBtn.click();

            WebElement parkHopperLink = driver.findElement(By.xpath(parkHopperTicket));
            parkHopperLink.click();

            WebElement actualPrice = driver.findElement(By.xpath(parkHopperPrice));
            String actualTicketPrice = actualPrice.getText();
            System.out.println("ACTUAL PRICE IS: " + actualTicketPrice);
            Assert.assertEquals(actualTicketPrice, "2562.00");
            logger.log(Status.PASS, MarkupHelper.createLabel("buyParkTickets is passTest", ExtentColor.GREEN));
            
            WebElement submit = driver.findElement(By.xpath(submitBtn));
            submit.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }

    @AfterClass
    public static void endTest() {
        extent.flush();
    }
}
