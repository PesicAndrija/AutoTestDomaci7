package Base;

import Pages.WebTablesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseTest {

    public static WebDriver driver;
    public ExcelReader excelReader;
    public WebTablesPage webTablesPage;
    public WebDriverWait wait;
    public JavascriptExecutor jse;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        excelReader = new ExcelReader("TestData.xlsx");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public List<WebElement> getElementsByText(String s){
        return driver.findElements(By.xpath("//div[contains(text(), '"+s+"')]"));
    }

    public void scrollElementIntoView(WebElement we){
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", we);
    }
}
