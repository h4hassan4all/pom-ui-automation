package testComponents.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.Admin.Billing;
import pages.Admin.Cadence;
import pages.Admin.ResourceTeam;
import pages.Auth.Login;
import pages.HomePage.Home;
import pages.Admin.User;
import pages.ProjectManager.ProjectConflicts;
import pages.ResourceManager.Dashboard;
import utils.*;


import java.io.IOException;
import java.time.Duration;

public class Base {

    public static WebDriver driver;

    // Page Objects
    public Login login;
    public Home home;
    public Cadence cadence;
    public ResourceTeam resourceTeam;
    public User user;
    public Billing billing;
    public Dashboard resourceManagerDashboard;

    public ProjectConflicts projectConflicts;


    private By notification = By.xpath("//div[contains(@class,'ant-notification-notice-message')]");


    public WebDriver setUp() {
        String browserName = System.getProperty("browser", Utils.getElementFromPropertiesFile("browser", "global"));

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();

            // options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080", "--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("firefox");
            // Handle Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("edge safari");
            // Handle Edge
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        return driver;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
        return source;
    }

    public void login() {
        login = new Login(driver);
        waitForWebElement(login.companyNameField(), Duration.ofSeconds(20));
        login.companyNameField().sendKeys(Utils.getElementFromPropertiesFile("company", "global"));
        waitForWebElement(login.emailField(), Duration.ofSeconds(20));
        login.emailField().sendKeys(Utils.getElementFromPropertiesFile("email", "global"));
        waitForWebElement(login.passwordField(), Duration.ofSeconds(20));
        login.passwordField().sendKeys(Utils.getElementFromPropertiesFile("password", "global"));
        waitForWebElement(login.signInBtn(), Duration.ofSeconds(20));
        login.signInBtn().click();
    }


    @BeforeSuite(alwaysRun = true)
    public void launchApplication() {
        driver = setUp();
        driver.get(Utils.getElementFromPropertiesFile("url", "global"));
        login();
    }

    @BeforeClass
    public void initializePageObjects() {
//        login = new Login(driver);
        home = new Home(driver);
        cadence = new Cadence(driver);
        resourceTeam = new ResourceTeam(driver);
        user = new User(driver);
        billing = new Billing(driver);
        resourceManagerDashboard = new Dashboard(driver);
        projectConflicts = new ProjectConflicts(driver);
    }

    public void waitForElement(By findBy, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElement(WebElement findBy, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public WebElement notification() {
        return driver.findElement(notification);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
