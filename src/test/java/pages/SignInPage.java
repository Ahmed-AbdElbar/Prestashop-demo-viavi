package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {
    public static final By createAccountLink = By.xpath("//a[@data-link-action='display-register-form']");
    public SignInPage( ) {
        super();
    }
    public void navigateToAccountRegistration(){
        click(createAccountLink);
    }


}
