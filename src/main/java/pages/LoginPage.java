package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private WebDriver driver;
  // se cambia el localizador para que falle y hacer el debug , quitamos una letra , la e
  @FindBy(id = "user-name")
  private WebElement usernameInput;

  @FindBy(id = "password")
  private WebElement passwordInput;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  //@FindBy(css = ".error-message-container")
  //private WebElement errorContainer;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this); // Inicializa los @FindBy
  }

  public void login(String user, String pass) {
    usernameInput.sendKeys(user);
    passwordInput.sendKeys(pass);
    loginButton.click();
  }
}
