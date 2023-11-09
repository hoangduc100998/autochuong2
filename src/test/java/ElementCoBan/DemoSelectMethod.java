//Select: Áp dụng cho các list (nếu support)
package ElementCoBan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class DemoSelectMethod {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/select-menu");


        //Handle Old Style Select Menu dropdown
        WebElement itemStyleDropdown=driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(itemStyleDropdown);
        select.selectByVisibleText("Green");

        //Clear value of Old Style Select Menu
        select.deselectAll();
    }
}
