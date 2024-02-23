package pages.Admin;

import com.fasterxml.jackson.databind.deser.Deserializers;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;


public class Billing {


    WebDriver driver;

    public Billing(WebDriver driver){
        this.driver = driver;
    }
    ////////////////////////////////////////////// Billing Tab Locator  ///////////////////////////////////////////////

    private By billingTab = By.xpath("//aside/div/div/div[1]/ul/li/ul/li[1]/ul/li[6]/span/div");

    ///////////////////////////////////////////// Billing Tab Locator Function ////////////////////////////////////////

    public WebElement billingTab() {
        return driver.findElement(billingTab);
    }

    ///////////////////////////////////////////// Billing Page Locators //////////////////////////////////////////////

    private By billingPageTitle = By.xpath("//main/div[1]/div[1]/div/div/div[1]/div[1]/div[1]/span");
    private By totalLicenses = By.xpath("//main/div[1]/div[1]/div/div/div[4]/div[1]/div[2]");
    private By packageName = By.xpath("//main/div[2]/div/div[3]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]");
    private By upgradePackageBtn = By.xpath("//main/div[2]/div/div[1]/div[2]/button/span");
    private By packagesPageLabel = By.xpath("//*[@id=\"packages\"]/div[2]/div[1]/h4");
    private By licensesInputField = By.xpath("//*[@id=\"packages\"]/div[2]/div[1]/input");
    private By standardPackageBtn = By.xpath("//*[@id=\"packages\"]/div[3]/div[1]/div/div/button");
    private By premiumPackageBtn = By.xpath("//*[@id=\"packages\"]/div[3]/div[2]/div/div/button");
    private By goldPackageBtn = By.xpath("//*[@id=\"packages\"]/div[3]/div[3]/div/div/button");


    ////////////////////////////////////////////// Card Details Page Locators ////////////////////////////////////////




    ///////////////////////////////////////////// Billing Page Locators Functions ////////////////////////////////////

    public WebElement billingPageTitle (){
        return driver.findElement(billingPageTitle);
    }

    public WebElement totalLicenses(){
        return driver.findElement(totalLicenses);
    }

    public WebElement packageName(){
        return driver.findElement(packageName);
    }

    public WebElement upgradePackageBtn(){
        return driver.findElement(upgradePackageBtn);
    }

    public WebElement packagesPageLabel(){
        return driver.findElement(packagesPageLabel);
    }


    ////////////////////////////////////////////// Billing Page Functions /////////////////////////////////////////////

    public String currentPackage(String packageName){
        if (packageName.equalsIgnoreCase("free")){
            String newPackage = Utils.getRandomPackage();
            return newPackage;
        }
         return packageName().getText();
    }

    public void upgradePackage(String currentPackage, String licenses) throws InterruptedException {
        if(currentPackage.equalsIgnoreCase("Standard"))
              standardPackage(licenses);
        if(currentPackage.equalsIgnoreCase("Premium"))
                premiumPackage(licenses);
        if(currentPackage.equalsIgnoreCase("Gold"))
                 goldPackage(licenses);
        return;

    }

    public void standardPackage(String licenses) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(this.licensesInputField).sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        driver.findElement(this.licensesInputField).sendKeys(licenses);
        driver.findElement(this.standardPackageBtn).click();
        cardDetails();
    }

    public void premiumPackage(String licenses) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(this.licensesInputField).sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        driver.findElement(this.licensesInputField).sendKeys(licenses);
        driver.findElement(this.premiumPackageBtn).click();
        cardDetails();
    }

    public void goldPackage(String licenses) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(this.licensesInputField).sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        driver.findElement(this.licensesInputField).sendKeys(licenses);
        driver.findElement(this.goldPackageBtn).click();
        cardDetails();
    }


    ////////////////////////////////////////////// Card Details Page Functions ////////////////////////////////////////

    public void cardDetails(){

    }



}
