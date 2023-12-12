package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import utils.BasePage;
import utils.DriverFactory;

public class Search_Steps extends BasePage {

    SearchPage searchPage;

    public Search_Steps() {
        super(DriverFactory.getDriver());
        this.searchPage = new SearchPage(driver);
    }

    @Given("the user is on Trendyol homepage")
    public void theUserIsOnTrendyolHomepage() throws InterruptedException {
        driver.get("https://www.trendyol.com");
        Thread.sleep(10000);
    }

    @And("the user is click modal")
    public void theUserIsClickModal() throws InterruptedException {
        Thread.sleep(4000);
        searchPage.waitModalText();
        Thread.sleep(5000);
        searchPage.clickCloseModal();
    }

    @When("the user is click accept for cookie")
    public void theUserIsClickAcceptForCookie() {
        searchPage.clickAcceptButtonCookie();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String text) throws InterruptedException {
        searchPage.sendKeySearchField(text);
    }

    @And("the user is click search icon")
    public void theUserIsClickSearchIcon() {
        searchPage.clickSearchIcon();
    }

    @Then("the search function should work correctly text {string}")
    public void theSearchFunctionShouldWorkCorrectlyText(String text) {
        searchPage.assertCategoriFieldTest(text);
    }

    @When("the user is click on the Female")
    public void theUserIsClickOnTheFemale() {
        searchPage.clickFemaleImg();
    }

    @Then("the search function should work correctly text {string} in the page")
    public void theSearchFunctionShouldWorkCorrectlyTextInThePage(String text) {
        searchPage.assertPageFieldTest(text);
    }

    @Then("Listing the word {string} in the list")
    public void listingTheWordInTheList(String text) throws InterruptedException {
        Thread.sleep(2000);
        searchPage.viewDropdownText(text);
    }

    @Then("sees suggestion texts {string}")
    public void seesSuggestionTexts(String text) {
        searchPage.viewSeesSuggestion(text);
    }

    @Then("sees examples texts {string},{string},{string},{string},{string},{string},{string}")
    public void seesExamplesTexts(String txt1, String txt2, String txt3, String txt4, String txt5, String txt6, String txt7) {
        searchPage.viewExampleSuggestions(txt1, txt2, txt3, txt4, txt5, txt6, txt7);
    }

    @When("the user only searches for {string}")
    public void theUserOnlySearchesFor(String text) throws InterruptedException {
        searchPage.sendKeySearchFieldText(text);
    }

    @Then("the user is seen {string} and {string}")
    public void theUserIsSeenAnd(String txt1, String txt2) {
        searchPage.searchPastTextAndTitle(txt1, txt2);
    }

    @Then("seen {string} page")
    public void seenPage(String text) {
        searchPage.checkedPage(text);
    }


    @Then("the search function should work text {string} in the page")
    public void theSearchFunctionShouldWorkTextInThePage(String txt1) {
//        searchPage.checkedFailPageAndText(txt1);
    }

    @Then("the user is seen popular search {string}")
    public void theUserIsSeenPopularSearch(String txt1) {
        searchPage.checkPopularTextField(txt1);
    }

    @When("the user click on the one popular text")
    public void theUserClickOnTheOnePopularText() {
        searchPage.ClickPopularTextOne();
    }

    @Then("the search function should work correctly text in the page")
    public void theSearchFunctionShouldWorkCorrectlyTextInThePage() {
        searchPage.CheckedPopularText();
    }

    @When("the user click on the one categories field text")
    public void theUserClickOnTheOneCategoriesFieldText() {
        searchPage.ClickCategoriesFieldText();
    }

    @Then("the user is seen categories field search {string}")
    public void theUserIsSeenCategoriesFieldSearch(String text) {
        searchPage.chechkedCategoriesText(text);
    }

    @Then("the search Categories text should work correctly text in the page")
    public void theSearchCategoriesTextShouldWorkCorrectlyTextInThePage() {
        searchPage.categoriesPageText();
    }

    @When("recommended sort check text {string}")
    public void recommendedSortCheckText(String text) {
        searchPage.chechkedRecommendedText(text);
    }

    @Then("page is checked {string} url")
    public void pageIsCheckedUrl(String text) {
        searchPage.CheckedNowUrl(text);
    }

    @Then("Listing the word {string} and full text {string} in the list")
    public void listingTheWordAndFullTextInTheList(String text1, String text2) {
        searchPage.searchListChecked(text1, text2);
    }

    @Then("category suggestions for search appear")
    public void categorySuggestionsForSearchAppear() {
        searchPage.isPresentTextChecked();
    }

    @And("Click on the past search field")
    public void clickOnThePastSearchField() {
        searchPage.clickPastSearch();
    }

    @Then("Text field should not seen")
    public void textFieldShouldNotSeen() {
        searchPage.isNotElement();
    }

}
