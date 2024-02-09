package vers2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameInput = By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input");
    private By passwordInput = By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/input");
    private By loginButton = By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input");
    private By errorElement = By.cssSelector(".error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://gb.ru/login");
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorVisible() {
        return !driver.findElements(errorElement).isEmpty();
    }
}
