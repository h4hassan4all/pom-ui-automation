package pages.ProjectManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import static utils.Utils.getRandomString;


public class ProjectConflicts {
    WebDriver driver;

    public ProjectConflicts(WebDriver driver) {

        this.driver = driver;
    }

    private By confProjectManagerTab = By.xpath("//div[contains(text(),'Project Manager')]");

    private By confConflictTab = By.xpath("/html/body/div/div/section/section/aside/div/div/div[1]/ul/li/ul/li[2]/ul/li[4]");

    private By confCreateConflictButton = By.xpath("//span[normalize-space()='Open a new Conflict']");

    private By confProjectName = By.id("conflict_projectId");

    private By confProjectNameField = By.xpath("//form/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/span[1]/input");


    private By confProjectNameDropdownValue = By.xpath("//form/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div");

    private By confConflictName = By.id("conflict_conflictName");

    private By confConflictDescription = By.id("conflict_description");

    private By confSuggestedResolution = By.id("conflict_suggestedResolution");

    private By confImpactedTeam = By.xpath("//div[@class='ant-select-selection-overflow'][1]");

    private By confImpactedTeamValue = By.xpath("//form/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div");

    private By confImpactedMember = By.xpath("//*[@id='conflict']/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/div");

    private By confImpactedMemberValue = By.xpath("//form/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/div");

    private By confSeverity = By.xpath("//form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/div/div[1]/span[1]/input");

    private By confSeverityValue = By.xpath("//form/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div");


    private By confCreateConflict = By.xpath("//span[normalize-space()='Create Conflict']");

    private By confCreatedUsers = By.xpath("//main/div/div/div/div[3]/div[2]/div/div/div[1]/div/div/div/div/div/table/tbody/tr[2]");
    private By confCreatedUser1 = By.xpath("//tbody/tr[2]/td[3]");


    ///////////////////////////////////////////// ProjectManagerTab ////////////////////////////////////////
    public WebElement confProjectManagerTab() {
        return driver.findElement(confProjectManagerTab);
    }

    public WebElement confConflictTab() {
        return driver.findElement(confConflictTab);
    }

    public WebElement confCreateConflictButton() {
        return driver.findElement(confCreateConflictButton);
    }

    public WebElement confProjectName() {
        return driver.findElement(confProjectName);
    }

    public WebElement confProjectNameField() {
        return driver.findElement(confProjectNameField);
    }

    public WebElement confProjectNameDropdownValue() {
        return driver.findElement(confProjectNameDropdownValue);
    }

    public WebElement confConflictName() {
        return driver.findElement(confConflictName);
    }

    public WebElement confConflictDescription() {
        return driver.findElement(confConflictDescription);
    }

    public WebElement confSuggestedResolution() {
        return driver.findElement(confSuggestedResolution);
    }

    public WebElement confImpactedTeam() {
        return driver.findElement(confImpactedTeam);
    }

    public WebElement confImpactedTeamValue() {
        return driver.findElement(confImpactedTeamValue);
    }

    public WebElement confImpactedMember() {
        return driver.findElement(confImpactedMember);
    }

    public WebElement confSeverity() {
        return driver.findElement(confSeverity);
    }

    public WebElement confSeverityValue() {
        return driver.findElement(confSeverityValue);
    }

    public WebElement confImpactedMemberValue() {
        return driver.findElement(confImpactedMemberValue);
    }

    public WebElement confCreateConflict() {
        return driver.findElement(confCreateConflict);
    }
    public WebElement confCreatedUser1() {
        return driver.findElement(confCreatedUser1);
    }

    public WebElement confCreatedUsers() {
        return driver.findElement(confCreatedUsers);
    }

    public WebElement confDescriptionFn() throws InterruptedException {

        driver.findElement(confConflictDescription).sendKeys(getRandomString(35));
        return null;
    }

    public WebElement conflictNameFn() throws InterruptedException {

        driver.findElement(confConflictName).sendKeys(getRandomString(35));
        return null;
    }
    public WebElement confSuggestedResolutionFn() throws InterruptedException {

        driver.findElement(confSuggestedResolution).sendKeys(getRandomString(35));
        return null;
    }
}

