package thucHanh;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class ToiUuLocator01 {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang de bai yeu cau
        driver.get("https://demoqa.com/text-box");


        String DYNAMIC_NHAP = "//input[@placeholder='%s']";
        //1. Nhập Full Name - Trong " " là id
        String fullNameXpath = String.format(DYNAMIC_NHAP,"Full Name");
        System.out.println("Xpath of Current Address is " + fullNameXpath);
        driver.findElement(By.xpath(fullNameXpath)).sendKeys("Hoang Duc");
        //2. Nhập Email
        String emailXpath = String.format(DYNAMIC_NHAP,"name@example.com");
        System.out.println("Xpath of Current Address is " + emailXpath);
        driver.findElement(By.xpath(emailXpath)).sendKeys("hoangduc100498@gmail.com");


        //Chỗ nào khác nhau thì ghi %s
        String DYNAMIC_INPUT = "//textarea[@id='%s']";
        //3. Nhập Current Address
        String currentAddressXpath = String.format(DYNAMIC_INPUT,"currentAddress");
        System.out.println("Xpath of Current Address is " + currentAddressXpath);
        driver.findElement(By.xpath(currentAddressXpath)).sendKeys("abc");
        //4. Permanent Address
        String permanentAddressXpath = String.format(DYNAMIC_INPUT,"permanentAddress");
        System.out.println("Xpath of Permanent Address is " + permanentAddressXpath);
        driver.findElement(By.xpath(permanentAddressXpath)).sendKeys("abcde");
    }
}
