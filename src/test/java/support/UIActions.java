package support;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIActions extends BrowserActions {
    public UIActions(WebDriver driver) {
        super(driver);
    }
    public void search(By searchBox, String q){
        type(searchBox, q);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }
    public void click(By by){
        isVisible(by).click();
    }
    public void clickOnCheckBox(By by){
        driver.findElement(by).sendKeys(Keys.SPACE);
    }
    public void clickWithoutCheckingVisibility(By by){
        driver.findElement(by).click();
    }
    public void type(By by, CharSequence text){
        WebElement e = isVisible(by); e.clear(); e.sendKeys(text);
    }
    public String getText(By by){
        return isVisible(by).getText();

    }
}
