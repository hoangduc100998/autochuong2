//Thực hiện truy cập "https://demo.guru99.com/test/delete_customer.php"
//Nhập thông tin cho Customer ID "Vincent"
// Click [Submit] button
//Thực hiện kiểm tra xem thông báo trả ra là "Do you really want to delete this Customer?"
//Thực hiện action Cancel
//Click đăng nhập
//Thực hiện lặp lại bước 2,3,4
//Thực hiện action OK
//Kiểm tra thông tin hiển thị có là "Customer Successfully Delete!"
package WebDriverAPINangCaoVaAction;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.time.Duration.ofSeconds;

public class BTCoBanAlerts {
    public static void main(String[] args) throws InterruptedException, AWTException {
        //1. Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        //2. Nhập thông tin cho Customer ID "Vincent"
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("admin@codegym.vn");

        //3. Click [Submit] button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //4. Thực hiện kiểm tra xem thông báo trả ra là "Do you really want to delete this Customer?"
        Alert alert1 = driver.switchTo().alert();
        String alertText  = alert1.getText();
        System.out.println("Text : " + alertText);
        Thread.sleep(1000);
        //5. Thực hiện action Cancel
        alert1.dismiss();

        //6. Click đăng nhập (Bấm f5 trên bàn phím cho nó đẳng cấp)

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).keyDown("r")
                .keyUp(Keys.COMMAND).keyUp(Keys.SHIFT).perform();

        Thread.sleep(1000);

//        Robot robot = new Robot();
//        // press key Ctrl+Shift+r
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.delay(100);
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.delay(100);
//        robot.keyPress(KeyEvent.VK_R);
//        // Refresh key Ctrl+Shift+r
//        robot.delay(100);
//        robot.keyRelease(KeyEvent.VK_R);
//        robot.delay(100);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.delay(100);
//        robot.keyRelease(KeyEvent.VK_CONTROL);

        //6. Click đăng nhập - f5 lai trang
        //driver.navigate().refresh();

        //7. Thực hiện lặp lại bước 2,3,4
        //Nhập thông tin cho Customer ID "Vincent"
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("bai2");
        //Click [Submit] button
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //Thực hiện kiểm tra xem thông báo trả ra là "Do you really want to delete this Customer?"
        Alert alert2 = driver.switchTo().alert();
        String alertText2  = alert2.getText();
        System.out.println("Text : " + alertText2);
        Thread.sleep(1000);
        //Thực hiện action OK
        alert2.accept();

        Alert alert3 = driver.switchTo().alert();
        alert3.accept();

        //Thoat
        driver.quit();
    }
}
