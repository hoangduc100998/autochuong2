package thucHanh;//[Thực hành] Tương tác với các phần tử Radio Box

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ThucHanhTTVoiRadioBox {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement labelYes = driver.findElement(By.xpath("//label[text()='Yes']"));
        WebElement labelImpressive = driver.findElement(By.xpath("//label[text()='Impressive']"));
        String radiobutton = "//input[@id = '%s']";
        //Find locator Yes radio button
        String xpathYes = String.format(radiobutton,"yesRadio");
        WebElement YesRadioButton = driver.findElement(By.xpath(xpathYes));
        //Find locator Impressive radio button
        String xpathImpressive = String.format(radiobutton,"impressiveRadio");
        WebElement ImpressiveRadioButton = driver.findElement(By.xpath(xpathImpressive));
        //Find locator No radio button
        String xpathNo = String.format(radiobutton,"noRadio");
        WebElement NoRadioButton = driver.findElement(By.xpath(xpathNo));
        //Check Yes ? If not > checked
        if (!ImpressiveRadioButton.isSelected()){
            labelImpressive.click();}
        //Check element is selected or not?
        boolean isYeschecked = YesRadioButton.isSelected();
        boolean isImpressivechecked = ImpressiveRadioButton.isSelected();
        boolean isNochecked = NoRadioButton.isSelected();
        System.out.println("Yes button - Checked: " + isYeschecked);
        System.out.println("Impressive button - Checked: " + isImpressivechecked);
        System.out.println("No button - Checked: " + isNochecked);
    }
}
