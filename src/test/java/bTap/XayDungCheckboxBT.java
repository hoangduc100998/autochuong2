package bTap;//[Bài tập] Xây dựng kịch bản kiểm thử cho checkbox

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XayDungCheckboxBT {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Mở trang web ni lên
        driver.get("https://demoqa.com/elements");
        //2. Chọn Check Box
        driver.findElement(By.xpath("//ul[@class='menu-list']//following-sibling::li[@id='item-1']")).click();

        //3. Click [+] Để mở hết option ra
        driver.findElement(By.xpath("//button[@title='Expand all']")).click();

        //4. Chọn cái Commands
        driver.findElement(By.xpath("//input[@id='tree-node-commands']//following::span[@class='rct-checkbox' and position()=1]")).click();
        Thread.sleep(2000);
        //5. Chọn Angular
        driver.findElement(By.xpath("//input[@id='tree-node-angular']//following::span[@class='rct-checkbox' and position()=1]")).click();
        Thread.sleep(2000);
        //6. Cuộn xuống
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        //7. Chọn Private
        driver.findElement(By.xpath("//input[@id='tree-node-private']//following::span[@class='rct-checkbox' and position()=1]")).click();
        Thread.sleep(2000);
        //8. Chọn Excel File.doc
        driver.findElement(By.xpath("//input[@id='tree-node-excelFile']//following::span[@class='rct-checkbox' and position()=1]")).click();
        Thread.sleep(2000);
        //9. Click - để đóng hết lại
        driver.findElement(By.xpath("//button[@title='Collapse all']")).click();
    }
}

