//Lấy thông tin dữ liệu hiển thị trên alert và in ra ngoài màn hình console.
package WebDriverAPINangCaoVaAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.MessageFormat;
import java.util.Set;
import static java.time.Duration.ofSeconds;
public class ThucHanhTTAlert {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.get("https://demoqa.com/alertsWindows");

        //Cuon xuong
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");

        // Click "Alerts" tại thanh menu bar
        String alertXPath = "//span[text()='Alerts']";
        WebElement alertWinEle = driver.findElement(By.xpath(alertXPath));
        alertWinEle.click();

        // Thực hiện mở từng alert bằng cách click vào [Click me]
        WebElement alertEle = driver.findElement(By.id("alertButton"));
        alertEle.click();

        // Lấy thông tin dữ liệu hiển thị trên alert và in ra ngoài màn hình console.
        // Switch to Alert
        Alert alert = driver.switchTo().alert();
        String alertText  = alert.getText();
        System.out.println("Text : " + alertText);
        Thread.sleep(1000);
        alert.accept();

        // 2. On button click, alert will appear after 5 seconds
        WebElement alert1Ele = driver.findElement(By.id("timerAlertButton"));
        alert1Ele.click();
        Thread.sleep(5000);
        // Switch to Alert
        Alert alert1 = driver.switchTo().alert();
        String alert1Text  = alert1.getText();
        System.out.println("Text : " + alert1Text);
        Thread.sleep(5000);
        alert1.accept();

        // 3. On button click, confirm box will appear
        WebElement alert2Ele = driver.findElement(By.id("confirmButton"));
        alert2Ele.click();
        // Switch to Alert
        Alert alert2 = driver.switchTo().alert();
        String alert2Text  = alert2.getText();
        System.out.println("Text : " + alert2Text);
        Thread.sleep(3000);
        alert2.accept();

        // 4. On button click, prompt box will appear
        WebElement alert4Ele = driver.findElement(By.id("promtButton"));
        alert4Ele.click();
        // Switch to Alert
        Alert alert4 = driver.switchTo().alert();
        String alert4Text  = alert4.getText();
        System.out.println("Text : " + alert4Text);
        alert4.sendKeys("Automation Test - 2023");
        alert4.accept();
        WebElement alertTextRes = driver.findElement(By.id("promptResult"));
        Thread.sleep(500);
        System.out.println("Your text: " + alertTextRes.getText());

        driver.quit();
    }
}
