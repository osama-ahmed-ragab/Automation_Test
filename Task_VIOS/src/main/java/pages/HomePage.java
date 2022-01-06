package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputField = By.xpath("//*[@name = 'q']");
    private By searchButton = By.xpath("//*[@name = 'btnK']");


    public ResultPage setText() {
        driver.findElement(inputField).sendKeys("Vodafone" + Keys.ENTER);
//        driver.findElement(searchButton).click();
        return new ResultPage(driver);
    }


    private void clickLink(String LintText) {
        driver.findElement(By.linkText(LintText)).click();
    }
}
