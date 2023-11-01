import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.*;
import java.time.Duration;

public class ThucHanhLocatorNangCao {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");

        //1. first name
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Hoang Duc");
        //2. last name
        driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Duong");

        //3. email
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hoangduc100498@gmail.com");

        //4. Chọn cái giới tính
        //driver.findElement(By.xpath("//input[@name='gender' and @value='Male']/following-sibling::label")).click();
        String DYNAMIC_INPUT_NAME_VALUE_FORM = "//input[@name='%s' and @value='%s']/following-sibling::label";
        String maleXPath = String.format(DYNAMIC_INPUT_NAME_VALUE_FORM, "gender","Female");
        Boolean isSelected = driver.findElement(By.xpath(maleXPath)).isSelected();
        if (isSelected == false) {
            driver.findElement(By.xpath(maleXPath)).click();
        }

        //5. Nhập số điện thoại
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("0923242935");
        //6. Tự chọn ngày (Giống nhập tay - CMD + a cái ngày của họ xong nhập ngày mình vào)
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        //Press Ctrl-A
        String s = Keys.chord(Keys.COMMAND, "a");
        datePicker.sendKeys(s);
        //Fill Date
        datePicker.sendKeys("10 Oct 1998");
        //Nhấn enter để xác nhận cái ngày mình mới nhập là ok
        datePicker.sendKeys(Keys.ENTER);

        //7. Từ điền cái Subjects
        WebElement dropdown=driver.findElement
                (By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        //Cuộn xuống để tìm cái Subjects để tự nó điền chứ Subjects đang cấn 1 cái quảng cáo
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        dropdown.click();
        Thread.sleep(20);
        //Tự điền cái dòng Subjects
        WebElement dropdown1=driver.findElement(By.id("subjectsInput"));
        dropdown1.sendKeys("Chemistry");
        dropdown1.sendKeys(Keys.ENTER);

        //8. Chọn tích vào ô Sport
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
        //9. Chon anh
        //driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("D:\\Codegym\\Automation\\Course_Selenium_Java\\SeleniumMaven\\src\\test\\resource\\TestDataFile\\Timo.png");
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("\\Users\\hoangduc\\Documents\\C823L1 - AT101\\SeleniumMaven\\src\\main\\resources\\TestDataFile\\Timo.png");

        //label[@for="hobbies-checkbox-1"]
        //Tắt browser
        //driver.quit();
    }
}