//25. getAllSelectedOptions():
// Phương thức này trả về danh sách tất cả các tùy chọn đã chọn được liên kết với thẻ Chọn.
package ElementCoBan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.List;


public class DemoGetAllSelectedOptions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("cars"));


        // Create a Select object
        Select select = new Select(dropdownElement);


        // Select multiple options in the dropdown (assuming it's a multi-select)
        select.selectByValue("volvo");
        select.selectByValue("audi");


        // Retrieve all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();


        // Print the selected options
        for (WebElement option : selectedOptions) {
            System.out.println("Selected Option: " + option.getText());
        }


        // Close the browser
        //driver.quit();
    }


}

