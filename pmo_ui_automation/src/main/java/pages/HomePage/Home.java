package pages.HomePage;

import org.openqa.selenium.*;

public class Home {
    private WebDriver driver;
    private By userRole = By.xpath("//header/div/div[2]/div[2]/div/div/div/span");
    private  By adminTab = By.xpath("//div[contains(text(),'Admin')]");
    private By projectManagerTab = By.xpath("//*[@id='root']/div/section/section/aside/div/div/div[1]/ul/li/ul/li[2]");
    private By resourceManagerTab = By.xpath("//*[@id='root']/div/section/section/aside/div/div/div[1]/ul/li/ul/li[3]");

    // Admin Menu Locators
    private By cadenceTab = By.xpath("//aside/div/div/div[1]/ul/li/ul/li[1]/ul/li[1]/span/div");
    private By projectMetricsTab = By.xpath("//aside/div/div/div[1]/ul/li/ul/li[1]/ul/li[2]/span/div");
    private By resourceTeamTab = By.xpath("//aside/div/div/div[1]/ul/li/ul/li[1]/ul/li[4]/span/div");
    private By userTab = By.xpath("(//div[contains(text(),'User')])[1]");
    private By billingTab = By.xpath("//aside/div/div/div[1]/ul/li/ul/li[1]/ul/li[6]/span/div");

    // Resource Manager Menu Locators
    private By rmDashboardTab = By.xpath("//li[3]//ul[1]//li[1]");

    public Home(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement userRole(){
        return driver.findElement(userRole);
    }
    public WebElement adminTab(){
        return driver.findElement(adminTab);
    }

    // Admin Menu Locators Functions
        public WebElement cadenceTab(){
            return driver.findElement(cadenceTab);
        }
        public WebElement projectMetricsTab(){
            return driver.findElement(projectMetricsTab);
        }
        public WebElement resourceTeamTab(){
            return driver.findElement(resourceTeamTab);
        }
        public WebElement userTab(){
            return driver.findElement(userTab);
        }
        public WebElement billingTab(){
            return driver.findElement(billingTab);
        }
        public WebElement projectManagerTab(){
        return driver.findElement(projectManagerTab);
    }
        public WebElement resourceManagerTab(){
        return driver.findElement(resourceManagerTab);
    }
        // Resource Manager Locators Functions
        public  WebElement rmDashboardTab (){return driver.findElement(rmDashboardTab);}
}
