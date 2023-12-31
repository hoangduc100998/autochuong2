import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class TestSelenium {
    public static void main(String[]args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang https://demoqa.com/text-box
        driver.get("https://demoqa.com/text-box/");

//        //1.Input information in Full Name by id
//        driver.findElement(By.xpath("//input[@placeholder=\"Full Name\"]")).sendKeys("Vincent");


//        //1.Input information in Full Name by cssSelector
//        driver.findElement(By.cssSelector("input[placeholder='Full Name']")).sendKeys("HoangDuc");

        //click Home
        //driver.findElement(By.linkText("Home")).click();

        driver.findElement(By.partialLinkText("me")).click();

//        //1.Input information in Full Name by id
//        driver.findElement(By.id("userName")).sendKeys("Vincent");
    }
}
