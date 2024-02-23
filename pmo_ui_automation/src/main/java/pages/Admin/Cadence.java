package pages.Admin;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Cadence {

    WebDriver driver;

    private By agileCadenceLabel =  By.xpath("//span[normalize-space()='Agile Cadence']");
    private By activateBtnAgile = By.cssSelector("button[data-i='agile-activate-btn']");

    private By sprintStartDate = By.cssSelector("#agile-cadence-form_sprintStartDate");
    private By sprintDuration = By.cssSelector("#agile-cadence-form_sprintDuration");
    private By sprintNumber = By.cssSelector("#agile-cadence-form_sprintName");

    private By cadenceLabel = By.cssSelector(".ant-menu-item.ant-menu-item-selected.ant-menu-item-only-child");
    private By sdlcActivateBtn =  By.xpath("//button[@data-i='sdlc-activate-btn']");
    private By sdlcFiscalYearStartDate =  By.xpath("//input[@id='sdlc-cadence-form_fiscalYearStartDate']");
    private By fiscalYear =  By.cssSelector("#sdlc-cadence-form_fiscalYearName");






    public WebElement cadenceLabel(){
        return driver.findElement(cadenceLabel);
    }


    public Cadence(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement activateBtnAgile(){
        return driver.findElement(activateBtnAgile);
    }
    public WebElement sdlcActivateBtn(){
        return driver.findElement(sdlcActivateBtn);
    }



    public WebElement agileCadenceLabel() {
        return driver.findElement(agileCadenceLabel);
    }


    public void addAgileCadence(String sprintStartDate, String sprintDuration, String sprintNumber){

        driver.findElement(this.sprintStartDate).sendKeys(sprintStartDate, Keys.ENTER);
        driver.findElement(this.sprintDuration).sendKeys(sprintDuration);
        driver.findElement(this.sprintNumber).sendKeys(sprintNumber);


    }
    public void addSdlcCadence(String fiscalYearStartDate, String fiscalYear){

        driver.findElement(this.sdlcFiscalYearStartDate) .sendKeys(fiscalYearStartDate, Keys.ENTER);
        driver.findElement(this.fiscalYear).sendKeys(fiscalYear);



    }












}
