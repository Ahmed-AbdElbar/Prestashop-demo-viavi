package pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    public static final By cartIcon = By.xpath("//div[@class='blockcart cart-preview active']");
    public static final By latestProductAdded = By.xpath("//li[@class='cart-item'][last()]//a[@class='label']");



    public CartPage( ) { super(); }

    public void openCart(){
        click(cartIcon);
    }

    public void assertAddedProductIsInCart(String nameOfAddedItem){
        Assertions.assertEquals(nameOfAddedItem,getText(latestProductAdded));
    }
}
