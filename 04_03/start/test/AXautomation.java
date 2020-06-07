

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AXautomation {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub


        // Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //	   System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        //	   WebDriver driver = new FirefoxDriver(); // launch FF


        //enter url
        driver.get("https://www.audatex.in/bre");

        // driver.findElement(By.id("usernamereg-firstName")).sendKeys("Tommy");



        //handle drop down
//	Select select = new Select(driver.findElement(By.id("usernamereg-month")));
//	select.selectByVisibleText("January");


        driver.findElement(By.id("ssousername")).sendKeys("abhatt");
        driver.findElement(By.id("password")).sendKeys("abhatt");
        driver.findElement(By.name("submit")).click();

    //    Thread.sleep(5000);
    //    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       WebDriverWait wait = new WebDriverWait(driver, 10);

    //  driver.findElement(By.id("tbitem_new_case")).click();
        WebElement newCase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbitem_new_case")));
        newCase.click();
                driver.manage().window().maximize();
        driver.findElement(By.name("root.task.basicClaimData.vehicle.vehicleIdentification.VIN")).sendKeys("WAUZKJ4G1JY000958");
        driver.findElement(By.name("root.task.basicClaimData.vehicle.vehicleAdmin.plateNumber")).sendKeys("DL3ClB4561");
        driver.findElement(By.id("PreIntakeForm_submitButton")).click();

        // Page scroll down
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,100)");

        // Loss date calendar
        driver.findElement(By.xpath("//span[@id='BREForm_root.task.basicClaimData.accidentData.accidentDateTime']//img[@class='ui-datepicker-trigger']")).click();


        // Month from calendar
        Select selectmonth = new Select(driver.findElement(By.cssSelector(".ui-datepicker-month")));
        selectmonth.selectByVisibleText("Jan");

        // Year from calendar
        Select selectyear = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
        selectyear.selectByVisibleText("2018");

        driver.findElement(By.xpath("//tr[1]//td[3]//a[1]")).click();
        driver.findElement(By.xpath("//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")).click();

        // driver.findElement(By.className("ui-state-default ui-state-active")).click();
        //  driver.findElement(By.cssSelector("body.body:nth-child(5) div.ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all:nth-child(92) table.ui-datepicker-calendar tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) > a.ui-state-default.ui-state-hover")).click();

        // Insurance Company Drop Down
        Select selectinscomp = new Select(driver.findElement(By.xpath("//select[@id='BREForm_root.task.basicClaimData.policyData.insuranceCompany.companyName']")));
        selectinscomp.selectByVisibleText("Bharti Axa General Insurance Co. Ltd.");

        //  driver.findElement(By.className("ui-datepicker-trigger")).click();

        // Next button Policy Data
        driver.findElement(By.xpath("//input[@id='nextButtonPlaceHolder']")).click();

        // Vehicle Identification
        // not required   driver.findElement(By.xpath("//input[@id='BREForm_root.task.basicClaimData.vehicle.vehicleIdentification.VINQuery-VIN']")).sendKeys("WAUZKJ4G1JY000958");
        driver.findElement(By.xpath("//input[@id='BREForm_root.task.basicClaimData.vehicle.vehicleIdentification.VINQuery-VINQueryButton']")).click();

        Thread.sleep(5000);


        driver.findElement(By.xpath("//a[@id='toDoListItem_Labor rates']")).click();

        //Labor Rates
        driver.findElement(By.xpath("//input[@id='BREForm_root.task.classInput.rate1.value']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@id='BREForm_root.task.classInput.ratePaint1.value']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@id='nextButtonPlaceHolder']")).click();


        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Start Qapter
        driver.findElement(By.xpath("//input[@id='BREForm_root.task.damageCapture.webpadButton']")).click();
        Thread.sleep(10000);

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        // Perform the actions on new window

        //  driver.findElement(By.xpath("//span[@id='navigation-adjustment']")).click();

        Thread.sleep(6000);

        List<WebElement> eleList = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='0_0_30000016']//*[local-name()='path' and contains(@class,'fp x80 xab')]"));

        for(WebElement ele: eleList)
        {
            String text = null;
            ele.getAttribute("d");

            System.out.println(text);
        }


        Thread.sleep(10000);
        driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

        // In Qapter Graphics
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  driver.findElement(By.xpath("/*[name()='svg']/*[name()='g']")).click();

        //   WebElement svgObj = driver.findElement(By.xpath("//*[name()='g' and @id='0_0_30000016']//*[name()='path' and contains(@class,'fp x80 xab')]"));
        //   Actions actionBuilder = new Actions(driver);
        //   actionBuilder.click(svgObj).build().perform();


    }

}

