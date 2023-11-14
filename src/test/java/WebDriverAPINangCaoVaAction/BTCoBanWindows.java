//Thực hiện truy cập "https://test.warface.codegym.vn"
//Thực hiện mở 01 tab mới và truy cập trang "https://test.warface.codegym.vn/login"
//Thực hiện nhập thông tin tài khoản, mật khẩu để truy cập website
//Click đăng nhập
//Quay về tab đầu tiên và thực hiện refresh trang này. Sau đó đóng tab đăng nhập
//Thực hiện add 02 mặt hàng đầu tiên trong danh mục điện thoại
//Truy cập giỏ hàng và tiến hành kiểm tra các danh sách sản phẩm

package WebDriverAPINangCaoVaAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;

public class BTCoBanWindows {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.get("https://test.warface.codegym.vn");

        // 2. Thực hiện mở 01 tab mới
        driver.switchTo().newWindow(WindowType.TAB);
        String newWindowHandle = driver.getWindowHandle();
        driver.get("https://test.warface.codegym.vn/login");

        // 3. Đăng nhập
        driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("admin@codegym.vn");
        driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("123123");
        driver.findElement(By.xpath("//button")).click();

        // 4. Quay về tab đầu tiên và thực hiện refresh trang này. Sau đó đóng tab đăng nhập
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        driver.navigate().refresh();
        driver.switchTo().window(newWindowHandle);
        driver.close();

        // 5. Quay lại tab đầu tiên
        driver.switchTo().window(driver.getWindowHandles().iterator().next());

        // 6. Tìm và click vào danh mục "Điện thoại"
        WebElement dienThoaiCategory =
                driver.findElement(By.xpath("//a[contains(text(), 'Máy tính')]"));
        dienThoaiCategory.click();

        //7. Cuộn xuống
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,750)", "");

        // 8. Tìm và click vào 2 mặt hàng đầu tiên trong danh mục
        // Thêm sp 1
        driver.findElement(By.xpath("(//a[text()='Mua hàng'])[1]")).click();
        // Thêm sp 2
        //driver.findElement(By.xpath("(//a[text()='Mua hàng'])[2]")).click();
        //Thread.sleep(5000);

        // 9. Vào giỏ hàng
        //driver.findElement(By.xpath("(//a[contains(@href, 'cart')])[1]")).click();

        //10. Cuộn xuống
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,200)", "");

        //11. thoát
        Thread.sleep(5000);
        driver.quit();
    }
}
