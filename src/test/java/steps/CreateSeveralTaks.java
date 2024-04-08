package steps;

import PageObjects.CreateTaskPage;
import PageObjects.PageBase;
import PageObjects.TacksListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateSeveralTaks extends TestBase {
    CreateTaskPage createTaskPage;
    TacksListPage tacksListPage;
    PageBase pageBase;

    @Given("Click add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        tacksListPage = new TacksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tacksListPage.clickAddTaskBtn();
    }

    @Given("Enter {string} and {string}")
    public void enterAnd(String arg0, String arg1) {
        createTaskPage.enterTaskName(arg0);
        createTaskPage.enterTaskDesc(arg1);
        createTaskPage.clickSaveBtn();
    }

    @Then("Task Added Successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        pageBase.tearDown();
    }
}
