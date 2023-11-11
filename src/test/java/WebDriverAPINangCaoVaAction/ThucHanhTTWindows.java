package WebDriverAPINangCaoVaAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.Set;

public class ThucHanhTTWindows {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Login link web
        driver.get("https://demoqa.com/alertsWindows");
        // Click "Browser Windows"
        String browserWinXPath = "//span[text()='Browser Windows']";
        WebElement browserWinEle = driver.findElement(By.xpath(browserWinXPath));
        browserWinEle.click();

        // 1. New tab button
        WebElement newTabEle = driver.findElement(By.id("tabButton"));
        newTabEle.click();

        Set<String> windowList = driver.getWindowHandles();
        System.out.println(MessageFormat.format("The total windows: {0}", windowList.size()));


        // Get current windows
        String currentWin = driver.getWindowHandle();
        System.out.println("Current window: " + currentWin);

        // Switch qua cửa sổ mới
        for (String win : windowList) {
            if (!win.equals(currentWin)){
                driver.switchTo().window(win);
            }
        }

        System.out.println("New window: " + driver.getWindowHandle());
        WebElement textWindow2Ele = driver.findElement(By.id("sampleHeading"));
        String textValue = textWindow2Ele.getText();
        if (textValue.equals("This is a sample page"))
            System.out.println("Verify the window text : successfully - " + textValue);

        // Back về trang chủ tại bước 2 (Sử dụng phương thức get window đầu tiên và switchTo)
        driver.switchTo().window(currentWin);
    }
}
