package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nextPage = By.xpath("//a[@id='pnnext']");
    private By results = By.xpath("//div[@class='g']");

    public ResultPage nextPage() {
        driver.findElement(nextPage).click();
        return new ResultPage(driver);
    }

    public int calcListSize() {
        List<WebElement> List = driver.findElements(results);
        return List.size();
    }

}
