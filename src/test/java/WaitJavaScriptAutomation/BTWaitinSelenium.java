package WaitJavaScriptAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
public class BTWaitinSelenium {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.get("https://rise.fairsketch.com/events");

        JavascriptExecutor javaScripts = (JavascriptExecutor) driver;

//        //1. Toi uu
//        String DYNAMIC_INPUT_PLACEHOLDER_FORM = "//input[@placeholder='%s']";
//                //id
//        String idXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "Email");
//        WebElement idNameEle = driver.findElement(By.xpath(idXPath));
//        javaScripts.executeScript("arguments[0].value = 'admin@demo.com';", idNameEle);
//        //String text = (String) javaScripts.executeScript("return arguments[0].value;", idNameEle);
//        //System.out.println("Email: " + text);
//                //pass
//        String passXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "Password");
//        WebElement passNameEle = driver.findElement(By.xpath(passXPath));
//        javaScripts.executeScript("arguments[0].value = 'admin@demo.com';", passNameEle);
//        //String text2 = (String) javaScripts.executeScript("return arguments[0].value;", passNameEle);
//        //System.out.println("Password: " + text2);

        //2. Click to Sign in
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        //3. Kiểm tra trạng thái đăng nhập thành công hay không
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String formXPath  ="//h1[text()='Event calendar']";
        WebElement formEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(formXPath)));
        formEle.click();

        //4. Truy cập [Events] menu
        String practiceFormXPath ="//span[normalize-space()='Events']";
        WebElement practiceEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(practiceFormXPath)));
        practiceEle.click();
    }
}
