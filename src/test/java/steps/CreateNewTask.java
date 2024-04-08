package steps;

import PageObjects.CreateTaskPage;
import PageObjects.PageBase;
import PageObjects.TacksListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTask extends TestBase {

    CreateTaskPage createTaskPage;
    TacksListPage tacksListPage;
    PageBase pageBase;

    @Given("Click en agregar")
    public void clickEnAgregar() throws MalformedURLException {
        Android_setUp();
        tacksListPage = new TacksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        tacksListPage.clickAddTaskBtn();
    }

    @Given("Agregar un nombre")
    public void agregarUnNombre() {
        createTaskPage.enterTaskName("Esto es una prueba");
    }

    @Given("Agregar una descripcion")
    public void agregarUnaDescripcion() {
        createTaskPage.enterTaskDesc("QA testing");
    }

    @When("Click en guardar")
    public void clickEnGuardar() {
        createTaskPage.clickSaveBtn();
    }

    @Then("Tarea agregada exitosamente")
    public void tareaAgregadaExitosamente() {
        driver.hideKeyboard();
        pageBase.tearDown();
    }
}
