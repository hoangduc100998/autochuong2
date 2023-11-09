package bTap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class HoanThienDKBT {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/forms");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Kích chuyển hướng vào trang form
        driver.findElement(By.xpath("//span[normalize-space()='Practice Form']")).click();

        // bắt đầu điền
        String InputData = "//input[@id='%s']";
        String Xpath1 = String.format(InputData , "firstName");
        String Xpath2 = String.format(InputData , "lastName");
        String Xpath3 = String.format(InputData , "userEmail");
        String Xpath4= String.format(InputData , "userNumber");
        String Xpath5= String.format(InputData , "dateOfBirthInput");
        String Xpath6= String.format(InputData , "subjectsInput");
        String Xpath7= String.format(InputData , "react-select-3-input");
        String Xpath8= String.format(InputData , "react-select-4-input");

        driver.findElement(By.xpath(Xpath1)).click();
        driver.findElement(By.xpath(Xpath1)).sendKeys("Hoang Duc");

        driver.findElement(By.xpath(Xpath2)).click();
        driver.findElement(By.xpath(Xpath2)).sendKeys("Duong");

        driver.findElement(By.xpath(Xpath3)).click();
        driver.findElement(By.xpath(Xpath3)).sendKeys("hoangduc@gmail.com");

        driver.findElement(By.xpath(Xpath4)).click();
        driver.findElement(By.xpath(Xpath4)).sendKeys("0923242935");

        driver.findElement(By.xpath(Xpath5)).click();
        driver.findElement(By.xpath(Xpath5)).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.xpath(Xpath5)).sendKeys("20 Nov 1998");
        driver.findElement(By.xpath(Xpath5)).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(Xpath6)).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.xpath(Xpath6)).sendKeys("Chemistry");
        driver.findElement(By.xpath(Xpath6)).sendKeys(Keys.ENTER);

        //Dòng lệnh cho cuộn trang xuống
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        //8. Chọn tích vào ô Sport
        String ChooseOption  = "//label[@for='%s']";
        String Gender_Male = String.format(ChooseOption , "gender-radio-1");
        String Sport = String.format(ChooseOption , "hobbies-checkbox-1");
        driver.findElement(By.xpath(Gender_Male)).click();
        driver.findElement(By.xpath(Sport)).click();
        //Tải ảnh lên
        //Tải ảnh lên
        //Tải ảnh lên
        //Tải ảnh lên
        //Tải ảnh lên
        //Tải ảnh lên

        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(System.getProperty("user.dir") + "/src/duc1.jpeg");

        //Select State and City
        String inputselect = "//input[@id='%s']";
        //Select State
        driver.findElement(By.xpath("//div[@id='state']"));
        String xpathSelectState = String.format(inputselect,"react-select-3-input");
        WebElement SelectState = driver.findElement(By.xpath(xpathSelectState));
        SelectState.sendKeys("Uttar");
        SelectState.sendKeys(Keys.ENTER);
        //Select City
        driver.findElement(By.xpath("//div[@id='city']"));
        String xpathSelectCity = String.format(inputselect,"react-select-4-input");
        WebElement SelectCity = driver.findElement(By.xpath(xpathSelectCity));
        SelectCity.sendKeys("Agra");
        SelectCity.sendKeys(Keys.ENTER);
        //Submid
        driver.findElement(By.xpath("//form[@id='userForm']")).submit();
    }
}
