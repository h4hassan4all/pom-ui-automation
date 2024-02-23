package pages.ResourceManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard {
    WebDriver driver;
    private By newResourceTeamBtn = By.xpath("//span[normalize-space()='New Resource Team']");
    private By teamNameField = By.xpath("//input[@id='resource-form_teamName']");
    private By teamDescriptionField = By.xpath("//input[@id='resource-form_description']");
    private By resourceManagerField = By.id("resource-form_resourceManager");
    private By teamLeadField = By.id("resource-form_teamLead");
    private By saveTeamBtn = By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-block']");
    private By resourceTeamTitle = By.xpath("//h4[@class='ant-typography']");
    private By addResourceSuccessMessege = By.className("ant-notification-notice-message");
    private By teamName = By.xpath("//tbody/tr[2]/td[1]");
    private By updateTeamBtn = By.xpath("//tbody/tr[2]/td[6]/div[1]//*[name()='svg']");
    private By resourceTeamEditTitle = By.xpath("//h4[normalize-space()='Edit Resource Team']");
    private By updateFormBtn = By.xpath("//span[normalize-space()='Update']");
    private By teamIcon = By.xpath("//table[1]/tbody[1]/tr[2]/td[3]");
    private By addResourceBtn = By.xpath("//span[normalize-space()='Add Resource']");
    private By addResourceFormLabel = By.xpath("//h4[normalize-space()='Add Resource']");
    private By resourceName = By.xpath("//div[@class='ant-select-item-option-content']");
    private By resourceNameField = By.cssSelector("input[id='resourceName']");
    private By designationTitle = By.xpath("//input[@id='designation']");
    private By designationName = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Backend']");
    private By dailyCapacityTitle = By.id("teamCapacity");
    private By dailyCapacity50 = By.xpath("//div[contains(text(),'50%')]");
    private By saveBtn = By.xpath("//button[@class='ant-btn ant-btn-primary']");
    private By resourceNameAssertion = By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[1]");
    private By deleteActionBtn = By.xpath("//tbody/tr[2]/td[8]/div[1]/div[1]");
    private By confirmDeletion = By.xpath("//span[normalize-space()='OK']");
    private By topRowResource = By.xpath("//table/tbody/tr[2]/td[1]");
    private By teamResourcesTable = By.className("ant-table-tbody");
    private By radioButtonForNewTab = By.xpath("//label[2]/span[1]");
    private By emailTitle = By.xpath("//input[@id='email']");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By selectDesignation = By.cssSelector("div[title='QA'] div[class='ant-select-item-option-content']");
    private By newTabCapacity = By.xpath("//input[@id='teamCapacity']");
    private By newTab50 =  By.xpath("//div[contains(text(),'50%')]");

    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addResourceSuccessMessage() {
        return driver.findElement(addResourceSuccessMessege);
    }

    public WebElement addResourceTeamBtn() {
        return driver.findElement(newResourceTeamBtn);
    }

    public WebElement teamName() {
        return driver.findElement(teamName);
    }

    public void addNewTeam(String teamName, String teamDescription) {
        driver.findElement(this.teamNameField).sendKeys(teamName);
        driver.findElement(this.teamDescriptionField).sendKeys(teamDescription);
        driver.findElement(resourceManagerField).click();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        driver.findElement(teamLeadField).click();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        driver.findElement(saveTeamBtn).click();
    }
    public WebElement resourceTeamTitle()
    {
        return driver.findElement(resourceTeamTitle);
    }
    public WebElement updateResourceTeamBtn() {
        return driver.findElement(updateTeamBtn);
    }
    public WebElement resourceTeamEditTitle()
    {
        return driver.findElement(resourceTeamEditTitle);
    }
    public WebElement teamLeadField() {
        return driver.findElement(teamNameField);
    }
    public void updateTeam(String teamName, String teamDescription) throws InterruptedException {
        driver.findElement(this.teamNameField).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        driver.findElement(this.teamNameField).sendKeys(teamName);
        driver.findElement(this.teamDescriptionField).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        driver.findElement(this.teamDescriptionField).sendKeys(teamDescription);
        driver.findElement(updateFormBtn).click();
    }
    public WebElement teamIcon() {
        return driver.findElement(teamIcon);
    }
    public WebElement adResourceBtn() {
        return driver.findElement(addResourceBtn);
    }
    public WebElement addResourceFormLabel()
    {
        return driver.findElement(addResourceFormLabel);
    }
    public WebElement resourceNameField() {
        return driver.findElement(resourceNameField);
    }
    public WebElement selectExistingResource(){
        return driver.findElement(resourceName);
    }
    public void addResource() {
        driver.findElement(resourceName).click();
        driver.findElement(designationTitle).click();
        driver.findElement(designationName).click();
        driver.findElement(dailyCapacityTitle).click();
        driver.findElement(dailyCapacity50).click();
        //new Actions(driver).sendKeys(Keys.ENTER).perform();
        driver.findElement(saveBtn).click();
    }
    public WebElement resourceNameAssertion()
    {
        return driver.findElement(resourceNameAssertion);
    }
    public WebElement deleteActionBtn() {
        return driver.findElement(deleteActionBtn);
    }

    public WebElement confirmDeletion(){ return driver.findElement(confirmDeletion); }
    public WebElement topRowResource()
    {
        return driver.findElement(topRowResource);
    }
    public List<WebElement> teamResourcesList(){
        WebElement baseTable = driver.findElement(teamResourcesTable);
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        return tableRows;
    }
    public WebElement radioButtonForNewTab()
    {
        return driver.findElement(radioButtonForNewTab);
    }
    public WebElement emailTitle()
    {
        return driver.findElement(emailTitle);
    }
    public void addNewResourceInTeam(String firstName, String lastName, String email)
    {
        driver.findElement(By.xpath("//span[normalize-space()='New']")).click();
        driver.findElement(By.id("email")).sendKeys(email + "@yopmail.com");
        driver.findElement(this.firstNameField).sendKeys(firstName);
        driver.findElement(this.lastNameField).sendKeys(lastName);
        driver.findElement(designationTitle).click();
        driver.findElement(selectDesignation).click();
        driver.findElement(newTabCapacity).click();
        driver.findElement(newTab50).click();
        //new Actions(driver).sendKeys(Keys.ENTER).perform();
        driver.findElement(saveBtn).click();
    }
}
