package Tests;

import Base.BaseTest;
import Pages.WebTablesPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest {

    @BeforeMethod
    public void setUpPage(){

        driver.get("https://demoqa.com/webtables");

        webTablesPage = new WebTablesPage();



    }

    @Test(priority = 10)
    public void addDataFromExcelFile(){
        Assert.assertTrue(webTablesPage.getAddDataButton().isDisplayed());

        for(int i=1; i<excelReader.getLastRow("InputData"); i++){

            webTablesPage.clickOnAddDataButton();
            wait.until(ExpectedConditions.elementToBeClickable(webTablesPage.getSubmitButton()));
            Assert.assertTrue(webTablesPage.getSubmitButton().isDisplayed());

            String firstName = excelReader.getStringData("InputData", i, 0);
            String lastName = excelReader.getStringData("InputData", i, 1);
            String email = excelReader.getStringData("InputData", i, 2);
            String age = excelReader.getStringData("InputData", i, 3);
            String salary = excelReader.getStringData("InputData", i, 4);
            String department = excelReader.getStringData("InputData", i, 5);

            webTablesPage.inputFirstName(firstName);
            webTablesPage.inputLastName(lastName);
            webTablesPage.inputUserEmail(email);
            webTablesPage.inputAge(age);
            webTablesPage.inputSalary(salary);
            webTablesPage.inputDepartment(department);

            webTablesPage.clickOnSubmitButton();

            if(webTablesPage.isNextButtonEnabled()){
                wait.until(ExpectedConditions.visibilityOf(webTablesPage.getNextButton()));
                scrollElementIntoView(webTablesPage.getNextButton());
                webTablesPage.clickOnNextButton();
            }

            Assert.assertTrue(webTablesPage.findCellByText(firstName).isDisplayed());
            Assert.assertTrue(webTablesPage.findCellByText(lastName).isDisplayed());
            Assert.assertTrue(webTablesPage.findCellByText(email).isDisplayed());
            Assert.assertTrue(webTablesPage.findCellByText(age).isDisplayed());
            Assert.assertTrue(webTablesPage.findCellByText(salary).isDisplayed());
            Assert.assertTrue(webTablesPage.findCellByText(department).isDisplayed());

        }
    }
}
