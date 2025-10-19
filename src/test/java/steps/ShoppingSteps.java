package steps;

import io.cucumber.java.en.*;
import pages.*;
import support.Config;

public class ShoppingSteps {


    private final HomePage home = new HomePage();
    private final SearchResultsPage results = new SearchResultsPage();
    private final CartPage cart = new CartPage();
    private final RegisterationPage regPage = new RegisterationPage();
    private final SignInPage signIn = new SignInPage();
    private final ProductPage product = new ProductPage();
    private String addedProductName;

    @Given("user navigates to prestashop")
    public void userNavigatesToPresta() {

        home.openHomePage(Config.getProp("baseUrl"));
    }

    @When("user creates a new account with {string}, {string}, {string}, {string},and {string}")
    public void userCreatesAccountWithGivenData(String firstName,String lastName,String email,String password,String birthdate) {

        home.switchIFrameByName("framelive");
        home.clickSignInButton();
        signIn.navigateToAccountRegistration();
        regPage.userEnterPersonalData(firstName,lastName,email,password,birthdate);
        regPage.clickOnRegister();

    }

    @When("user searches for {string}")
    public void userSearchesForItem(String itemName) {
        home.searchForItem(itemName);
    }

    @When("user selects the first search result and asserts it has an image")
    public void userSelectsFirstResultAndAssertsImage() {
        results.openFirstResult();
        product.assertSelectedItemHasImage();
    }

    @When("user adds the product to the cart")
    public void userAddProductToCart() {
        product.addProductToCart();
        addedProductName = product.userSaveAddedItemName();
        product.cancelAdditionPopUp();


    }

    @When("user navigates to the cart")
    public void userNavigateToCart(){
        cart.openCart();
    }

    @Then("Added product is found in cart")
    public void userVerifiesTheProductIsInTheCart() {
        cart.assertAddedProductIsInCart(addedProductName);
    }
}
