import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Autocomplete {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement address = driver.findElement(By.id("autocomplete"));
        address.sendKeys("1555 Park Blvd, Palo Alto, CA");
        Thread.sleep(1000);

        WebElement autocompleteresults = driver.findElement(By.className("pac-item"));
        autocompleteresults.click();

        driver.quit();
    }
}
