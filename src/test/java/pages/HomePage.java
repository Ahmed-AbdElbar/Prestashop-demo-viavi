package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final By signInButton = By.xpath("(//a[@title='Log in to your customer account'])[1]");
    private static final By searchBar    = By.xpath("//input[@aria-label='Search']");

    public HomePage() { super(); }

    public void openHomePage(String baseUrl){ openUrl(baseUrl); }
    public void clickSignInButton(){ click(signInButton); }
    public void searchForItem(String term){ search(searchBar, term); }
}
