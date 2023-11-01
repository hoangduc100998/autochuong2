import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaiTap {
    public static void main(String[]args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang https://demoqa.com/text-box
        driver.get("https://demoqa.com/automation-practice-form");

        //[BaiTap] Theo ID:
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("HoangDuc");
        //[BaiTap] Theo placeholder:
        driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Duong");


        //email
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hoangduc100498@gmail.com");
        //phone
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("0923242935");

        //phone
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));

        //click Choose File
        driver.findElement(By.linkText("uploadPicture")).click();
    }
}
