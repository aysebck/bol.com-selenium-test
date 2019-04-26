package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    private static String rootUrl = "https://www.bol.com";
    private String url;

    public BaseTest(String url) {
        this.url = url;
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(rootUrl + url);
    }

    @AfterEach
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
