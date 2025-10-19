package pages;

import org.openqa.selenium.By;

public class RegisterationPage extends BasePage{
    public static final By firstNameField = By.id("field-firstname");
    public static final By lastNameField = By.id("field-lastname");
    public static final By emailField = By.id("field-email");
    public static final By passwordField = By.id("field-password");
    public static final By birthDateField = By.id("field-birthday");
    public static final By tosCheckBox = By.xpath("//input[@name='psgdpr' and @type='checkbox']");
    public static final By customerPrivacyCheckBox = By.xpath("//input[@name='customer_privacy' and @type='checkbox']");
    public static final By saveCustomer = By.xpath("//button[@data-link-action='save-customer']");

    public void userEnterPersonalData(String firstName, String lastName, String email, String password, String birthdate) {
        type(firstNameField,firstName);
        type(lastNameField,lastName);
        type(emailField,email);
        type(passwordField,password);
        type(birthDateField,birthdate);
        clickOnCheckBox(tosCheckBox);
        clickOnCheckBox(customerPrivacyCheckBox);

    }

    public void clickOnRegister() {
        click(saveCustomer);
    }
}
