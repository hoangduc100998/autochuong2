import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class XDinhPhanTuWebBT {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang de bai yeu cau
        driver.get("https://rise.fairsketch.com/team_members/view/1/general");

        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        //locator
        String DYNAMIC_INPUT = "//input[@id='%s']";
        //1. Nhap Fist Name
        String firstname = String.format(DYNAMIC_INPUT, "first_name");
        WebElement inputFirstname = driver.findElement(By.xpath(firstname));
        inputFirstname.sendKeys(Keys.COMMAND, "a");
        inputFirstname.sendKeys(Keys.DELETE);
        inputFirstname.sendKeys("Hoang Duc");

        //2. Last name
        String lastname = String.format(DYNAMIC_INPUT, "last_name");
        WebElement inputlastname = driver.findElement(By.xpath(lastname));
        inputlastname.sendKeys(Keys.COMMAND, "a");
        inputlastname.sendKeys(Keys.DELETE);
        inputlastname.sendKeys("Duong");

        //3. Mailing address
        String textArea_INPUT = "//textarea[@id='%s']";

        String mailingadress = String.format(textArea_INPUT, "address");
        WebElement inputMailing = driver.findElement(By.xpath(mailingadress));
        inputMailing.sendKeys(Keys.COMMAND, "a");
        inputMailing.sendKeys(Keys.DELETE);
        inputMailing.sendKeys("hoangduc100498@gmail.com");

        //4. Alternative address
        String alternativeaddress = String.format(textArea_INPUT, "alternative_address");
        WebElement inputAlternative = driver.findElement(By.xpath(alternativeaddress));
        inputAlternative.sendKeys(Keys.COMMAND, "a");
        inputAlternative.sendKeys(Keys.DELETE);
        inputAlternative.sendKeys("sdzduc@gmail.com");

        //5. Phone
        String phone = String.format(DYNAMIC_INPUT, "phone");
        WebElement inputphone = driver.findElement(By.xpath(phone));
        inputphone.sendKeys(Keys.COMMAND, "a");
        inputphone.sendKeys(Keys.DELETE);
        inputphone.sendKeys("0923242935");

        //6. Alternative phone
        String alternativephone = String.format(DYNAMIC_INPUT, "alternative_phone");
        WebElement inputAlternativephone = driver.findElement(By.xpath(alternativephone));
        inputAlternativephone.sendKeys(Keys.COMMAND, "a");
        inputAlternativephone.sendKeys(Keys.DELETE);
        inputAlternativephone.sendKeys("0774450762");

        //7. SKype
        String skype = String.format(DYNAMIC_INPUT, "skype");
        WebElement inputskype = driver.findElement(By.xpath(skype));
        inputskype.sendKeys(Keys.COMMAND, "a");
        inputskype.sendKeys(Keys.DELETE);
        inputskype.sendKeys("duc123");

        //8. Date of Birth
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='dob']"));
        //Press Ctrl-A
        String s = Keys.chord(Keys.COMMAND, "a");
        datePicker.sendKeys(s);
        //Fill Date
        datePicker.sendKeys("10 Oct 1998");
        //Nhấn enter để xác nhận cái ngày mình mới nhập là ok
        datePicker.sendKeys(Keys.ENTER);

        //9. SSN
        String ssn = String.format(DYNAMIC_INPUT, "ssn");
        WebElement inputssn = driver.findElement(By.xpath(ssn));
        inputssn.sendKeys(Keys.COMMAND, "a");
        inputssn.sendKeys(Keys.DELETE);
        inputssn.sendKeys("duc123");

        //10. Gioi Tinh - Dùng cái AND để tìm rồi chọn
        driver.findElement(By.xpath("//input[@name='gender' and @id = 'gender_other']")).click();

        //11. Save
        driver.findElement(By.xpath
                ("//form[@id='general-info-form']//button[@type='submit'][normalize-space()='Save']")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(By.xpath("//form[@id='general-info-form']//button[@type='submit'][normalize-space()='Save']\")).click()")));

        //11. Mo sang trang Social Links
        driver.findElement(By.xpath("//a[normalize-space()='Social Links']")).click();

        //12. facebook
        String facebook = String.format(DYNAMIC_INPUT, "facebook");
        WebElement inputfacebook = driver.findElement(By.xpath(facebook));
        inputfacebook.sendKeys(Keys.COMMAND, "a");
        inputfacebook.sendKeys(Keys.DELETE);
        inputfacebook.sendKeys("https://www.facebook.com/Seraphina.khaly");
    }
}
