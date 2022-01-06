package ResultsPage;

import base.BaseTests;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.ResultPage;

import static org.testng.Assert.assertEquals;

public class SecondPageTest extends BaseTests {

    @Test
    public void searchtest() {
        ResultPage result = homePage.setText();
        result.nextPage();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        int secondPageResults = result.calcListSize();
        result.nextPage();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        int thirdPageResults = result.calcListSize();
        assertEquals(secondPageResults,thirdPageResults,"its not Equals");
    }
}
