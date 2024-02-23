package pages.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class Login {

    private WebDriver driver;
    private By companyNameField = By.cssSelector("input[data-i='company-name']");
    private By emailField = By.id("login-form_email");
    private By passwordField = By.id("login-form_password");
    private By signInBtn = By.cssSelector("button[type='submit']");

    public Login(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement companyNameField(){
        return driver.findElement(companyNameField);
    }
    public WebElement emailField(){
        return driver.findElement(emailField);
    }
    public WebElement passwordField(){
        return driver.findElement(passwordField);
    }
    public WebElement signInBtn(){
        return driver.findElement(signInBtn);
    }
}
