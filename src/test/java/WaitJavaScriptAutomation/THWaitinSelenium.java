package WaitJavaScriptAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
//import static JavaScript.DemoFluentWait.driver;
import static java.time.Duration.ofSeconds;

public class THWaitinSelenium {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.get("https://demoqa.com/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //2. Truy cập "https://demoqa.com/". Kiểm tra title của page có chính xác không,
        // và wait cho tới khi page xong để kiểm tra [Forms] đã hiện hay chưa

        // Wait for the logo shown
        String logoXPath = "//img[@src='/images/Toolsqa.jpg']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoXPath)));

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");

        //3. Click [Forms]. Lưu ý cần kiểm tra xem đối tượng đã ready để click chưa
        String formXPath = "//h5[text()='Forms']";
        WebElement formEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(formXPath)));
        formEle.click();

        //4. Click [Practice Form]. Lưu ý cần kiểm tra xem đối tượng đã ready để click chưa
        String practiceFormXPath = "//span[text()='Practice Form']";
        WebElement practiceEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(practiceFormXPath)));
        practiceEle.click();
        //driver.quit();
    }
}
