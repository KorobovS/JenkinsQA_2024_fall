package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.page.HomePage;
import school.redrover.page.ViewPage;
import school.redrover.runner.BaseTest;

import java.util.List;

public class NewViewDashboardTest extends BaseTest {

    private static final String PROJECT_NAME = "New Freestyle Project";
    private static final String LIST_VIEW = "ListView";
    private static final String MY_VIEW = "MyView";

    @Test
    public void testAddNewMyView() {
        new HomePage(getDriver())
                .createFreestyleProject(PROJECT_NAME)
                .clickCreateNewViewButton()
                .typeNameIntoInputField(MY_VIEW)
                .selectViewType(MY_VIEW)
                .clickCreateButton();

        List<WebElement> listOfViews = getDriver().findElements(By.xpath("//div[@class = 'tabBar']//a"));
        Assert.assertTrue(listOfViews.stream().anyMatch(item -> MY_VIEW.equals(item.getText())));
    }

    @Test
    public void testAddNewListView() {
        new HomePage(getDriver())
                .createFreestyleProject(PROJECT_NAME)
                .clickCreateNewViewButton()
                .typeNameIntoInputField(LIST_VIEW)
                .selectViewType(LIST_VIEW)
                .clickCreateButton()
                .clickOkButton();

        List<WebElement> listOfViews = getDriver().findElements(By.xpath("//div[@class = 'tabBar']//a"));
        Assert.assertTrue(listOfViews.stream().anyMatch(item -> LIST_VIEW.equals(item.getText())));
    }

    @Test (dependsOnMethods = "testAddNewMyView")
    public void testDeleteMyView() {
        new ViewPage(getDriver())
                .selectViewTypeToDelete(MY_VIEW)
                .deleteView()
                .clickYesInPopUp();

        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'tabBar']")));
        List<WebElement> listOfViews = getDriver().findElements(By.xpath("//div[@class = 'tabBar']//a"));

        Assert.assertTrue(listOfViews.stream().anyMatch(item -> !MY_VIEW.equals(item.getText())));
    }
    @Test (dependsOnMethods = "testAddNewListView")
    public void testDeleteListView() {
        new ViewPage(getDriver())
                .selectViewTypeToDelete(LIST_VIEW)
                .deleteView()
                .clickYesInPopUp();

        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'tabBar']")));
        List<WebElement> listOfViews = getDriver().findElements(By.xpath("//div[@class = 'tabBar']//a"));

        Assert.assertTrue(listOfViews.stream().anyMatch(item -> !LIST_VIEW.equals(item.getText())));
    }

}
