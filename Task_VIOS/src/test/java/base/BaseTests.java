package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected JavascriptExecutor js;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser)  throws Exception{

        if(browser.equalsIgnoreCase("firefox")) {
        System.setProperty("webdriver.gecko.driver", "reso/geckodriver.exe");
        driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "reso/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "reso/msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.get("https://www.google.com/");
        homePage = new HomePage(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void wait5(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

}
