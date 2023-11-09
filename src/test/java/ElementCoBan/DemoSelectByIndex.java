//selectByIndex(int index): chọn giá trị ở vị trí index cho dropdown, list
package ElementCoBan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class DemoSelectByIndex {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select an option by its index (e.g., index 2, which is the third option)
        select.selectByIndex(4);

        // Close the browser
        //driver.quit();
    }
}

