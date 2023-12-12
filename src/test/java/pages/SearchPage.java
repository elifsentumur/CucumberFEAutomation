package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;



public class SearchPage extends BasePage {

    private By closeIconModal = By.cssSelector("[title=\"Kapat\"]");
    private By acceptButtonCookie = By.id("onetrust-accept-btn-handler");

    private By searchField = By.cssSelector("[data-testid=\"suggestion\"]");

    private By searchIcon = By.cssSelector("[data-testid=\"search-icon\"]");

    private By modalText = By.id("homepage-popup-header");

    private By categoriFieldText = By.cssSelector("[class=\"fltr-item-text chckd ctgry\"]");

    private By femaleImg = By.cssSelector("[alt=\"Female\"]");
    private By pageText = By.cssSelector("#search-app > div > div.srch-rslt-cntnt > div.srch-prdcts-cntnr.srch-prdcts-cntnr-V2 > div.srch-rslt-title > div.srch-ttl-cntnr-wrppr > div > h1");
    private By dropdownOneFieldText = By.cssSelector("#sfx-discovery-search-suggestions > div > div.GiHHlveY > div.o79ToC0s > div > a:nth-child(1) > span.HjZKa1gK > b");
    private By dropdownOneFieldFullText = By.cssSelector("#sfx-discovery-search-suggestions > div > div.GiHHlveY > div.o79ToC0s > div > a:nth-child(1) > span.HjZKa1gK ");

    private By dropDownSuggestionTextFieild = By.cssSelector("[class=\"CpbuLat\"]");

    private By pastSearchText = By.cssSelector("[data-testid=\"search-history-list\"] h2");
    private By pastSearchTextName = By.cssSelector("[data-testid=\"search-history-list\"] a");

    private By failPageText = By.cssSelector("div.bigtypography  a  h1");

    //    private By searchText = By.cssSelector(":contains('^ %& (ujıffff96')");
    private By popularSearchField = By.cssSelector("[data-testid=\"populer-aramalar-list\"] h2");
    private By popularTextOne = By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div[2]/div[2]/div/a[1]/div/span");
    private By categoriesFieldText = By.cssSelector("#sfx-discovery-search-suggestions > div > div.GiHHlveY > div:nth-child(3) > div > a:nth-child(1) > div > span");
    private By categoriesTitleText = By.cssSelector("#sfx-discovery-search-suggestions > div > div.GiHHlveY > div:nth-child(3) > h2");
    private By recomendedText = By.cssSelector("[class=\"selected-order\"]");

    private By clearText = By.cssSelector("#sfx-discovery-search-suggestions > div > div.GiHHlveY > div.FOMz4mgT > div.TXOkMOCO > button");
    private By recomendedTextField = By.cssSelector("#sfx-discovery-search-suggestions > div > div.GiHHlveY > div.u07YbQBK > h2");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickCloseModal() {
        waitForClickability(closeIconModal);
    }

    public void clickAcceptButtonCookie() {
        waitForClickability(acceptButtonCookie);
    }

    public void sendKeySearchField(String text) throws InterruptedException {
        waitForSendKeys(searchField, text);
        Thread.sleep(2000);
        waitForSendKeysEnter(searchField);
    }

    public void clickSearchIcon() {
        waitForClickability(searchIcon);
    }

    public void waitModalText() {
        waitForVisibility(modalText);
    }

    public void assertCategoriFieldTest(String text) {
        waitForValueToBe(categoriFieldText, text);
    }

    public void clickFemaleImg() {
        waitForClickability(femaleImg);
    }

    public void assertPageFieldTest(String text) {
        waitForValueToBe(pageText, text);
    }

    public void viewDropdownText(String text) {
        waitForValueToBe(dropdownOneFieldText, text);
    }

    public void viewSeesSuggestion(String text) {
        waitForValueToBe(dropDownSuggestionTextFieild, text);
    }

    public void viewExampleSuggestions(String txt1, String txt2, String txt3, String txt4, String txt5, String txt6, String txt7) {
        waitAssertMultipleText(dropDownSuggestionTextFieild, txt1, txt2, txt3, txt4, txt5, txt6, txt7);
    }

    public void sendKeySearchFieldText(String text) throws InterruptedException {
        waitForSendKeys(searchField, text);
        Thread.sleep(2000);
    }

    public void searchPastTextAndTitle(String txt1, String txt2) {
        waitForValueToBe(pastSearchText, txt1);
        waitForValueToBe(pastSearchTextName, txt2);
    }

    public void checkedPage(String text) {
        waitForValueToBe(failPageText, text);
    }


    public void checkPopularTextField(String txt1) {
        waitForValueToBe(popularSearchField, txt1);
    }

    public void ClickPopularTextOne() {
        waitForVisibility(popularTextOne);
        waitForClickability(popularTextOne);
        System.out.println("popularTextOne elemente tıkla = " + popularTextOne);
    }

    public void CheckedPopularText() {
        String popularText = waitGetText(popularTextOne);
        waitForValueToBe(pageText, popularText);
    }

    public void ClickCategoriesFieldText() {

        waitForClickability(categoriesFieldText);
    }

    public void chechkedCategoriesText(String text) {
        waitForValueToBe(categoriesTitleText, text);
    }

    public void categoriesPageText() {
        String text = waitGetText(categoriesFieldText);
        waitForValueToBe(pageText, text);
    }

    public void chechkedRecommendedText(String text) {
        waitForValueToBe(recomendedText, text);
    }

    public void CheckedNowUrl(String text) {
        String urlText = waitGetCurrentUrl();
        Assert.assertEquals(urlText, text);
    }

    public void searchListChecked(String text1, String text2) {
        waitForValueToBe(dropdownOneFieldText, text1);
        waitForValueToBe(dropdownOneFieldFullText, text2);
    }

    public void isPresentTextChecked() {
        isElementPresent(recomendedTextField);
    }

    public void clickPastSearch() {
        waitForClickability(clearText);
    }

    public void isNotElement() {
        isElementNotPresent(pastSearchTextName);
    }
}
