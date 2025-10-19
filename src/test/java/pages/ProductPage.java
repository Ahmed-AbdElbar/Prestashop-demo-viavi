package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductPage extends BasePage{

    public static final By addProductBtn = By.xpath("//div[@class='add']");
    public static final By cancelPopUpIcon = By.xpath("//*[text()='close']");
    public static final By itemName = By.xpath("//*[@class='h6 product-name']");
    public static final By productImage= By.xpath("(//div[@class='product-cover']//img)[1]");


    public ProductPage( ) {
        super();
    }
    public void addProductToCart()  {

        click(addProductBtn);
    }

    public void cancelAdditionPopUp() {
        click(cancelPopUpIcon);

    }

    public String userSaveAddedItemName() {
        return getText(itemName);

    }

    public void assertSelectedItemHasImage() {
        Assertions.assertTrue(isImageIsRendered(productImage));
    }
}
