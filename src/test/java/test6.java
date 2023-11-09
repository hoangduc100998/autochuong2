import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class test6 {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("cars"));


        // Create a Select object
        Select select = new Select(dropdownElement);

        // Select an option by its index (e.g., index 2, which is the third option)
        select.selectByValue("volvo");
        //select.deselectByValue("volvo");

        // Close the browser
        //driver.quit();
    }
}
