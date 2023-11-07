import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ToiUuLocatorBT {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang de bai yeu cau
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Login website
        String DYNAMIC_INPUT_VALUE_FORM = "//input[@placeholder='%s']";
        String userNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM,"Username");
        driver.findElement(By.xpath(userNameXpath)).sendKeys("Admin");
        String userPassword = String.format(DYNAMIC_INPUT_VALUE_FORM,"Password");
        driver.findElement(By.xpath(userPassword)).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Personal Details']")).click();


        //Employee Full Name
        String firstNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM,"First Name");
        WebElement inputFirstName = driver.findElement(By.xpath(firstNameXpath));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inputFirstName));

        inputFirstName.sendKeys(" ");
        inputFirstName.click();
        Thread.sleep(2000);
        inputFirstName.sendKeys(Keys.CONTROL, "a",Keys.DELETE);
        //inputFirstName.sendKeys(Keys.DELETE);
        inputFirstName.sendKeys("Hanh");

        //Input use Javascript
//        WebElement inputFirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].value = '';", inputFirstName);
//        jse.executeScript("document.getElementsByClassName('firstName').value='Hanh';");
    }
}





//
//        //Login
//        String DYNAMIC_INPUT = "//input[@placeholder='%s']";
//        //Input id
//        String usernameXpath = String.format(DYNAMIC_INPUT,"Username");
//        System.out.println("Xpath of Current Address is " + usernameXpath);
//        driver.findElement(By.xpath(usernameXpath)).sendKeys("Admin");
//        //Input password
//        String passwordXpath = String.format(DYNAMIC_INPUT,"Password");
//        System.out.println("Xpath of Permanent Address is " + passwordXpath);
//        driver.findElement(By.xpath(passwordXpath)).sendKeys("admin123");
//
//        //Click button login
//        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
