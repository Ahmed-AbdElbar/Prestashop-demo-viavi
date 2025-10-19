package pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {


    public static final By firstItemLinkAndImage = By.xpath("(//section[@id='products']//img)[1]");

    public SearchResultsPage( ) { super(); }

    public void openFirstResult(){
        clickWithoutCheckingVisibility(firstItemLinkAndImage);
    }

}
