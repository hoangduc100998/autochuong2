//Thực hiện xác định từng frame, truy cập và lấy thông tin frame đó (text hiển thị)
package WebDriverAPINangCaoVaAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;

public class ThucHanhTTFrame {
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

        // Click "Frame"
        String browserWinXPath = "//span[normalize-space()='Frames']";
        WebElement browserWinEle = driver.findElement(By.xpath(browserWinXPath));
        browserWinEle.click();

        //Thực hiện xác định từng frame, truy cập và lấy thông tin frame đó (text hiển thị)
        // Thuc hien tim kiem frame va verify
        String frameXPath = "//iframe[@id='frame1']";
        String frameID = "frame1";
        WebElement frameElement = driver.findElement(By.id(frameID));

        //region Frame verification
        String expFrameWidth= "500px";
        String actFrameWidth = frameElement.getAttribute("width");
        if(expFrameWidth.equals(actFrameWidth)){
            System.out.println(String.format("The width of frame: %s", actFrameWidth));
        } else {
            System.out.println(String.format("The width of frame is not same: actual: %s, expected: %s", actFrameWidth, expFrameWidth));
        }
        //endregion

        // Access to this frame
        driver.switchTo().frame(frameElement);
        String sampleHeadingID = "sampleHeading";
        WebElement sampleHeading = driver.findElement(By.id(sampleHeadingID));
        String actHeadingText = sampleHeading.getText();
        System.out.println("Current text: " + actHeadingText);

//region Frame verification
        String expHeadingText = "This is a sample page";
        if(actHeadingText.equals(expHeadingText)){
            System.out.println(String.format("The frame text:  %s", actHeadingText));
        } else {
            System.out.println(String.format("The frame text is not same: actual: %s, expected: %s", actHeadingText, expHeadingText));
        }
//endregion

        // Back to page contents
        driver.switchTo().defaultContent();

        //thoat
        driver.quit();
    }
}
