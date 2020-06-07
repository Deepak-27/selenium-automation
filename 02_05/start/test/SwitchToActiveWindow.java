import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTabWindow = driver.findElement(By.id("new-tab-button"));
        newTabWindow.click();

        String originalhandle = driver.getWindowHandle();

        for(String handle1: driver.getWindowHandles()){
            driver.switchTo().window(handle1);
        }

        driver.switchTo().window(originalhandle);
        Thread.sleep(5000);
        driver.quit();
    }
}
