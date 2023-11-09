package thucHanh;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ThucHanhLocatorCoBan {
    public static void main(String[]args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang https://demoqa.com/text-box
        driver.get("https://demoqa.com/text-box/");

        //[Thực hành] Tìm kiếm phần tử theo XPath
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("HoangDuc");

        //[Thực hành] Tìm kiếm phần tử theo CSS
        driver.findElement(By.cssSelector("input[placeholder='name@example.com']")).sendKeys("hoangduc100498@gmail.com");

    }
}
