package thucHanh;//[Thực hành] Tương tác với Text box và Button

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
    public class ThucHanhTTTextboxVaButton {
        public static void main(String[] args) {
            //Khởi tạo browser với Chrome
            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();

            driver.get("https://demoqa.com/text-box");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Nhập name và email
            String input_Name = "//input[@placeholder='%s']";
            String xpath = String.format(input_Name, "Full Name");
            String xpath1 = String.format(input_Name, "name@example.com");
            driver.findElement(By.xpath(xpath)).sendKeys("Duc2");
            driver.findElement(By.xpath(xpath1)).sendKeys("duc2@gmail.com");

            //Nhập textarea
            String input_TextArea = "//textarea[@id='%s']";
            String xpath2 = String.format(input_TextArea, "currentAddress");
            System.out.println("Xpath of Current Address is " + xpath2);
            String xpath3 = String.format(input_TextArea, "permanentAddress");
            driver.findElement(By.xpath(xpath2)).sendKeys("Duc");
            driver.findElement(By.xpath(xpath3)).sendKeys("duc@gmail.com");

            //Cuộn trang xuống

            //Click submit
            driver.findElement(By.xpath("//button[@id='submit']")).click();
        }
    }

