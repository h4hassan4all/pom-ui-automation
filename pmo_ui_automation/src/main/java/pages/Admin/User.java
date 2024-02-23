package pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.Map;

public class User {

    WebDriver driver;

    public User(WebDriver driver) {

        this.driver = driver;
    }

    ////////////////////////////////////////////// User Tab Locator  ///////////////////////////////////////////////
    private By currentUsersTab = By.xpath("//section/aside/div/div/div[1]/ul/li/ul/li[1]/ul/li[5]/ul/li[1]/span/div");

    ///////////////////////////////////////////// User Tab Locator Function ////////////////////////////////////////
    public WebElement currentUsersTab() {
        return driver.findElement(currentUsersTab);
    }

    ////////////////////////////////////////////// Pending User Tab Locator  ///////////////////////////////////////////////
    private By pendingUsersTab = By.xpath("//section/aside/div/div/div[1]/ul/li/ul/li[1]/ul/li[5]/ul/li[2]");

    ///////////////////////////////////////////// User Tab Locator Function ////////////////////////////////////////
    public WebElement pendingUsersTab() {
        return driver.findElement(pendingUsersTab);
    }

    ///////////////////////////////////////////// Current Users Page Locators //////////////////////////////////////
    private By remainingLicenses = By.xpath("//div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]");

    private By addNewUserBtn = By.xpath("//section/div/main/div[2]/div/div[1]/div[2]/button");
    private By addUserFormLabel = By.xpath("//div[1]/h4");
    private By firstNameField = By.id("user-modal-form_firstName");
    private By lastNameField = By.id("user-modal-form_lastName");
    private By accessTypeDropDown = By.id("user-modal-form_accessType");
    private By emailField = By.id("user-modal-form_email");

    // Country Flag Field
    private By addUserFormSaveBtn = By.xpath("//div/div[2]/div/div[2]/div/div[2]/button");
    private By phoneNumberField = By.xpath("//*[@id='user-modal-form']/div[6]/div/div[2]/div/div/div/input");


    ///////////////////////////////////////// Current Users Page Locators Functions /////////////////////////////////

    public WebElement remainingLicenses(){
        return driver.findElement(remainingLicenses);
    }
    public WebElement addNewUserBtn() {
        return driver.findElement(addNewUserBtn);
    }

    public WebElement addUserFormLabel() {
        return driver.findElement(addUserFormLabel);
    }

    ///////////////////////////////////////////// Current Users Table Locators ////////////////////////////////////////

    private By addedUserFullName = By.xpath("//table/tbody/tr[2]/td[1]/span");
    private By addedUserEmail = By.xpath("//table/tbody/tr[2]/td[1]/span/small");
    private By addedUserStatus = By.xpath("//table/tbody/tr[2]/td[4]/span/span[2]");

    private By updatedUserFullName = By.xpath("//table/tbody/tr[2]/td[1]/span");
    private By updatedUserPhoneNumber = By.xpath("//table/tbody/tr[2]/td[3]");
    private By updatedUserStatus = By.xpath("//table/tbody/tr[2]/td[4]/span/span[2]");


    private By activeUsersColumnLabel = By.xpath("//div[contains(text(),'Active')]");
    private By actionsBtn = By.xpath("//tr[2]//div[1]/span[1]//*[name()='svg']");
    private By editOption = By.xpath("//div[normalize-space()='Edit']");
    private By editUserFormLabel = By.xpath("//h4[normalize-space()='Edit User']");
    private By editUserFormUpdateBtn = By.xpath("//span[normalize-space()='Update']");

    private By revokeOption = By.xpath("//span[@class='ant-dropdown-menu-title-content']//div[contains(text(),'Revoke')]");
    private By revokeLicenceBtn = By.xpath("//span[normalize-space()='Revoke License']");

    private By revokedUsersColumnLabel = By.xpath("//div[contains(text(),'Revoked')]");
    private By grantAccessOption = By.xpath("//div[normalize-space()='Grant Access']");
    private By grantAccessBtn = By.xpath("//span[contains(text(),'Grant Access')]");

    ///////////////////////////////////////////// Current User (New) Locators //////////////////////////////

    private By grantaccessUser = By.xpath("//*/div[1]//div[2]//tr[2]/td[5]/div/span[2]");
    private By revokeaccessUser = By.xpath("//*/div[1]//div[2]//tr[3]/td[5]/div/span[1]");

    private By pendingOption = By.xpath("//div[@class='ant-tabs-tab ant-tabs-tab-active']");


    ///////////////////////////////////////////// Current Users Table Locators Functions //////////////////////////////

    public WebElement addedUserFullName() {
        return driver.findElement(addedUserFullName);
    }
    public WebElement addedUserEmail() {
        return driver.findElement(addedUserEmail);
    }
    public WebElement addedUserStatus() {
        return driver.findElement(addedUserStatus);
    }

    public WebElement updatedUserFullName() {
        return driver.findElement(updatedUserFullName);
    }
    public WebElement updatedUserStatus() {
        return driver.findElement(updatedUserStatus);
    }

    public WebElement updatedUserPhoneNumber() {
        return driver.findElement(updatedUserPhoneNumber);
    }


    public WebElement activeUsersColumnLabel() {
        return driver.findElement(activeUsersColumnLabel);
    }
    public WebElement actionsBtn(){
        return driver.findElement(actionsBtn);
    }
    public WebElement editOption(){
        return driver.findElement(editOption);
    }
    public WebElement editUserFormLabel() {

        return driver.findElement(editUserFormLabel);

    }
    public WebElement revokeOption(){
        return driver.findElement(revokeOption);
    }
    public WebElement revokeLicenceBtn() {
        return driver.findElement(revokeLicenceBtn);
    }

    public WebElement revokedUsersColumnLabel() {
        return driver.findElement(revokedUsersColumnLabel);

    }
    public WebElement grantAccessOption() {
        return driver.findElement(grantAccessOption);
    }
    public WebElement grantAccessBtn() {
        return driver.findElement(grantAccessBtn);
    }


    ////////////////////////////////////////////// Current Users Crud Functions /////////////////////////////////////////////////////


    public void addUser(String firstName, String lastName, String accessType, String email, String country) {
        driver.findElement(this.firstNameField).sendKeys(firstName);
        driver.findElement(this.lastNameField).sendKeys(lastName);
        driver.findElement(this.emailField).sendKeys(email);
        driver.findElement(this.accessTypeDropDown).sendKeys(accessType);
        driver.findElement(this.accessTypeDropDown).sendKeys(Keys.ENTER);
        driver.findElement(this.addUserFormSaveBtn).click();

    }
    public Map verifyAddedUserDetails() {

        Map<String, String> map = new LinkedHashMap();
        String[] str = addedUserFullName().getText().split(" ");
        String addedUserFirstName = str[0];

        map.put("Name", addedUserFirstName);
        map.put("Email", addedUserEmail().getText());
        map.put("Status", addedUserStatus().getText());
        return map;

    }

    public void editUser(String firstName, String lastName, String accessType, String phoneNumber){
        driver.findElement(this.firstNameField).sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        driver.findElement(this.firstNameField) .sendKeys(firstName);
        driver.findElement(this.lastNameField).sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        driver.findElement(this.lastNameField).sendKeys(lastName);
        driver.findElement(this.accessTypeDropDown).sendKeys(accessType);
        driver.findElement(this.accessTypeDropDown).sendKeys(Keys.ENTER);
//        driver.findElement(this.phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(this.editUserFormUpdateBtn).click();
    }

    public Map verifyUpdatedUserDetails() {

        Map<String, String> map = new LinkedHashMap();
        String[] str = updatedUserFullName().getText().split(" ");
        String updatedUserFullName = str[0];
        map.put("Name", updatedUserFullName);
        map.put("Phone", updatedUserPhoneNumber().getText());
        map.put("Status", updatedUserStatus().getText());
        return map;

    }

   ////////////////////////////User tab Functions ///////////////////////////////
    public WebElement grantaccessUser () {return driver.findElement(grantaccessUser);}

    public WebElement revokeaccessUser () {return driver.findElement(revokeaccessUser);}

    public WebElement pendingOption () {return driver.findElement(pendingOption);}

}