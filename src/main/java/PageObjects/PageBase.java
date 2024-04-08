package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Primeramente creamos nuestra primera clase PageObject, que es qa.PageBase, porque compartiremos las diferentes cosas y crearemos funciones personalizadas o
espacios vacíos para usar con las clases de objetos de página. Comenzaremos con qa.PageBase, que estará centralizado y extendido desde las diferentes clases
de prueba, o desde las diferentes clases de Objeto de Página*/
public class PageBase {
    /*Aquí inicializaremos AppiumDriver y Page Factory como Selenium.
    Con Page Factory, inicializaremos el elemento porque usaremos anotaciones con los elementos en las clases de Objeto de página.
    Así que aquí agregaré Appium Driver y simplemente lo llamaré AppiumDriver.*/
    static AppiumDriver driver;
    public static final long WAIT = 10;

    /*Luego crearé un constructor public qa.PageBase()y, como sabemos, el constructor es de la misma clase, pero no es a void, por lo que el constructor
    se inicializará una vez que obtengamos un nuevo objeto de esta clase.*/
    public PageBase(AppiumDriver appiumDriver) {

       /* AppiumFieldDecorator es el método que se encarga de recopilar todos los elementos que tienen anotaciones, como @Android, @AndroidFindBy o @iOSFindBy.
        Con AppiumFieldDecorator, debemos agregar un controlador aquí, y con qa.PageBase, también debemos pasar un controlador que se usará en nuestros casos de prueba, por lo que
        pasaremos AppiumDriver appiumDrivery this al archivo AppiumFieldDecorator, this significa que estamos usando esta clase y se refiere a todas las clases de PageObject que usan qa.PageBase.
        Después de eso, necesitamos obtener el valor del controlador Appium del que tenemos en qa.PageBase.
        Entonces, esta es la idea principal, estamos inicializando el controlador Appium y luego, cuando creamos la primera PageObjectclase, simplemente la extenderemos desde qa.PageBase.*/
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

        // Para comenzar, simplemente crearemos uno para waitForVisibility(), esperando a que el elemento sea visible.
    public void waitFordVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT); //driver llama a appium y WAIT es el tiempo que le dimos a la clase
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //Entonces, después de llamar a esta función clear, debemos pasar el elemento que queremos borrar y esperar a que el elemento esté visible durante 10 segundos, y luego podemos borrar el elemento después de eso.
    public void clear(MobileElement element) {
        waitFordVisibility(element);
        element.clear();
    }

    public void click(MobileElement element) {
        waitFordVisibility(element);
        element.click();
    }

    public void sendText(MobileElement element, String text) {
        waitFordVisibility(element);
        element.sendKeys(text);
    }
    //Continuamos y agregamos el último public void getAttribute()si queremos obtener el atributo de un elemento en la aplicación.
    //Esta función no será public voidporque devolverá el atributo como una cadena, por lo que debe ser `public String getAttribute.
    public String getAttribute(MobileElement element, String attribute) {
        waitFordVisibility(element);
        return element.getAttribute(attribute);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
