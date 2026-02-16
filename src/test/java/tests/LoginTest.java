package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ReportUtils;



@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Epic("Módulo de Autenticación")
@Feature("Login de Usuarios")
public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    @Step("Configuración del navegador e inicio de la aplicación")
    public void setUp() {
        // Aquí deberías inicializar tu WebDriver y abrir la página de login
        // Por ejemplo:
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Validar el acceso exitoso con credenciales estándar")
    @Step("INGRESANDO CON USUARIO ESTÁNDAR")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Ingreso con usuario estándar de SauceDemo")
    @Description("Este test verifica que un usuario con privilegios estándar pueda ingresar correctamente al catálogo de productos.")
    @Owner("Didier Marin (Tiko)")
    @Link(name = "Web SauceDemo", url = "https://www.saucedemo.com/")
    @Issue("QA-123") // Ejemplo de un ID de ticket de bug o tarea
    @TmsLink("TMS-456") // Ejemplo de un ID en un gestor de pruebas
    public void testValidLogin() {
        // Aquí deberías llamar al método de login con credenciales válidas
        loginPage.login ("standard_user", "secret_sauce");
    }

    @AfterMethod
    @Step("Cierre del navegador")
    public void tearDown() {
        // Aquí deberías cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
    }
//
    @AfterSuite  //
    public void setupReport() {
        // Se ejecuta UNA sola vez cuando terminaron TODOS los tests de la suite
        ReportUtils.createEnvironmentFile();
    }

}
