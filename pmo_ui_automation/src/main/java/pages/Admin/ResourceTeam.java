package pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

import java.util.List;


public class ResourceTeam {
    WebDriver driver;
    private By addNewTeamBtn = By.xpath("//span[normalize-space()='New Resource Team']");
    private By teamNameField = By.id("resource-form_teamName");
    private By teamDescriptionField = By.id("resource-form_description");
    private By resourceManagerField = By.id("resource-form_resourceManager");
    private By teamLeadField = By.id("resource-form_teamLead");
    private By saveTeamBtn = By.xpath("//span[normalize-space()='Save']");
    private By updateTeamIcon = By.xpath("//tbody/tr[2]/td[6]/div[1]");
    private By updateTeamBtn = By.xpath("//span[normalize-space()='Update']");
    private By teamRow = By.xpath("//table[1]/tbody[1]/tr[2]/td[3]");
    private By addResourceBtn = By.cssSelector("button[data-i='add-resource-btn']");
    private By selectResource = By.xpath("((//div[@class='rc-virtual-list-holder-inner'][1])[1]/div)[1]");
    private By selectQADesignation = By.cssSelector("div[title='QA'] div[class='ant-select-item-option-content']");
    private By resourceNameField = By.cssSelector("input[id='resourceName']");
    private By designationField = By.id("designation");
    private By teamCapacityField = By.id("teamCapacity");
    private By saveResourceBtn = By.xpath("//span[normalize-space()='Save']");
    private By addResourceSuccessMessege = By.className("ant-notification-notice-message");
    private By updateResourceBtn = By.xpath("((//tbody/tr)[2]/td)[8]/div/div[2]");
    private By dailyCapacityArrow = By.xpath("(//span[@class='ant-select-arrow'])[3]");
    private By dailyCapacityField = By.cssSelector("div[class='ant-select ant-select-in-form-item ant-select-status-success ant-select-single ant-select-show-arrow'] div[class='ant-select-selector']");
    private By select100 = By.xpath("//div[contains(text(),'100%')]");
    private By plannedVacationTimeField = By.xpath("//div[@class='ant-picker-input ant-picker-input-active']");
    private By vacationDate = By.cssSelector("td[title]");
    private By deleteResourceBtn = By.xpath("//tbody/tr[2]/td[8]/div/div[1]");
    private By deleteConfirmationText = By.xpath("//h5[normalize-space()='Are you sure you want to remove this resource?']");
    private By confirmDelete = By.xpath("//span[normalize-space()='OK']");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By addResourceWithNewTabSuccessMessage = By.xpath("(//div[@class='ant-notification-notice-message'])[2]");
    private By createdTeamName = By.xpath("//tbody/tr[2]/td[1]");
    private By phoneNoTableField = By.xpath("((//tbody/tr)[2]/td)[3]/div");

    public ResourceTeam(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addNewResourceTeamBtn() {
        return driver.findElement(addNewTeamBtn);
    }


    public WebElement phoneNoTableField() {
        return driver.findElement(phoneNoTableField);
    }

    public WebElement createdTeamName() {
        return driver.findElement(createdTeamName);
    }

    public void addNewTeam(String teamName, String teamDescription) {
        driver.findElement(this.teamNameField).sendKeys(teamName);
        driver.findElement(this.teamDescriptionField).sendKeys(teamDescription);
        driver.findElement(resourceManagerField).click();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
//        driver.findElement(teamLeadField).click();
//        new Actions(driver).sendKeys(Keys.ENTER).perform();
        driver.findElement(saveTeamBtn).click();
    }

    public WebElement updateResourceTeamBtn() {
        return driver.findElement(updateTeamIcon);
    }

    public WebElement teamLeadField() {
        return driver.findElement(teamNameField);
    }

    public void updateTeam(String teamName, String teamDescription) {
        driver.findElement(this.teamNameField).clear();
        driver.findElement(this.teamNameField).sendKeys(teamName);
        driver.findElement(this.teamDescriptionField).clear();
        driver.findElement(this.teamDescriptionField).sendKeys(teamDescription);
        driver.findElement(updateTeamBtn).click();
    }

    public WebElement goToTeamSetup() {
        return driver.findElement(teamRow);
    }

    public WebElement addResourceBtn() {
        return driver.findElement(addResourceBtn);
    }

    public void addResource() {
        driver.findElement(resourceNameField).click();
        driver.findElement(selectResource).click();
        driver.findElement(designationField).click();
        driver.findElement(selectQADesignation).click();
        driver.findElement(teamCapacityField).click();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        driver.findElement(saveResourceBtn).click();
    }

    public void addResourceWithNewTab(String firstName, String lastName, String email) {
        driver.findElement(By.xpath("//span[normalize-space()='New']")).click();
        driver.findElement(By.id("email")).sendKeys(email + "@yopmail.com");
        driver.findElement(this.firstNameField).sendKeys(firstName);
        driver.findElement(this.lastNameField).sendKeys(lastName);
        driver.findElement(designationField).click();
        driver.findElement(selectQADesignation).click();
        driver.findElement(teamCapacityField).click();
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        driver.findElement(saveResourceBtn).click();
    }

    public WebElement resourceNameField() {
        return driver.findElement(resourceNameField);
    }

    public WebElement addResourceSuccessMessage() {
        return driver.findElement(addResourceSuccessMessege);
    }

    public WebElement updateResourceBtn() {
        return driver.findElement(updateResourceBtn);
    }

    public WebElement dailyCapacityArrow() {
        return driver.findElement(dailyCapacityArrow);
    }

    public void updateTeamResource() throws InterruptedException {
        driver.findElement(dailyCapacityField).click();
        driver.findElement(select100).click();
        driver.findElement(plannedVacationTimeField).click();

        List<WebElement> dateElements = driver.findElements(vacationDate);
        int randomIndex = Utils.getRandomNumber(10, dateElements.size());
        WebElement randomDateElement = dateElements.get(randomIndex);
        randomDateElement.click();
        Thread.sleep(3000);
        randomDateElement.click();
        driver.findElement(saveResourceBtn).click();

    }

    public void deleteResourceBtn() {
        driver.findElement(deleteResourceBtn).click();
    }

    public WebElement deleteConfirmationText() {
        return driver.findElement(deleteConfirmationText);
    }

    public void confirmDelete() {
        driver.findElement(confirmDelete).click();
    }

    public WebElement addResourceWithNewTabSuccessMessage() {
        return driver.findElement(addResourceWithNewTabSuccessMessage);
    }
}