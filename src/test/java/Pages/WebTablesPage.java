package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addDataButton;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy (className = "rt-td")
    public List<WebElement> cells;

    @FindBy(css = ".-next > button")
    public WebElement nextButton;


    //-----------------------------------------------------

    public WebElement getAddDataButton(){
        return addDataButton;
    }

    public void clickOnAddDataButton(){
        getAddDataButton().click();
    }

    public WebElement getSubmitButton(){
        return submitButton;
    }

    public void clickOnSubmitButton(){
        getSubmitButton().click();
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getUserEmailField() {
        return userEmailField;
    }

    public WebElement getAgeField() {
        return ageField;
    }

    public WebElement getSalaryField() {
        return salaryField;
    }

    public WebElement getDepartmentField() {
        return departmentField;
    }

    public void inputFirstName(String s){
        getFirstNameField().clear();
        getFirstNameField().sendKeys(s);
    }

    public void inputLastName(String s){
        getLastNameField().clear();
        getLastNameField().sendKeys(s);
    }

    public void inputUserEmail(String s){
        getUserEmailField().clear();
        getUserEmailField().sendKeys(s);
    }

    public void inputAge(String s){
        getAgeField().clear();
        getAgeField().sendKeys(s);
    }

    public void inputSalary(String s){
        getSalaryField().clear();
        getSalaryField().sendKeys(s);
    }

    public void inputDepartment(String s){
        getDepartmentField().clear();
        getDepartmentField().sendKeys(s);
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public List<WebElement> getCells(){
        return cells;
    }

    public WebElement findCellByText(String s) {
        try{
            return driver.findElement(By.xpath("//div[text()='"+s+"']"));
        }catch (Exception e) {
            return null;
        }
    }

    public void clickOnNextButton(){
        getNextButton().click();
    }

    public boolean isNextButtonEnabled(){
        try{
            driver.findElement(By.cssSelector(".-next > button[disabled]"));
            return false;
        }catch (Exception e){
            return true;
        }
    }
}
