package hw2;

import org.openqa.selenium.By;

public class Selectors {

    //first problem selectors
//    public static final By SELECTOR_BAGS_TAB = By.xpath("(//a[text()='Bags'])[1]");
//    public static final By SELECTOR_LUGGAGE = By.xpath("//a[text()='Luggage']");
    public static final By SELECTOR_PRODUCTS_LIST = By.xpath("//div[@id='products']/article");
    public static final By SELECTOR_PRODUCT_NAME = By.xpath(".//dt[text()='Product Name']/following-sibling::dd[1]");
    public static final By SELECTOR_PRODUCT_PRICE = By.xpath(".//dt[text()='Price']//following-sibling::dd/span[1]");
    public static final By SELECTOR_PRODUCT_NAME2 = By.xpath("//*[@id='productRecap']//h1//span[2]");
    public static final By SELECTOR_PRODUCT_PRICE2 = By.xpath("//span[contains(@aria-label,'$')]/span[1]");
    public static final By SELECTOR_ADD_BUTTON = By.xpath("//button[@id='add-to-cart-button']");
    public static final By SELECTOR_REMOVE_BUTTON = By.xpath("//button[@aria-label='Remove Item']");
    public static final By SELECTOR_SIGN_IN = By.xpath("(//a[contains(text(), 'Sign In')]) [2]");

    //second problem selectors
//    public static final By SELECTOR_CLOTHING_TAB = By.xpath("(//a[text()='Clothing'])[1]");
//    public static final By SELECTOR_MENS_TSHIRT = By.xpath("(//a[text()='T-Shirts'])[1]");
    public static final By SELECTOR_COLOR_TAB = By.xpath("//*[@id='colorFacet']");
    public static final By SELECTOR_BROWN = By.xpath("//a[contains(@href, 'men-brown-t-shirts')]");
    public static final By COUNT_OF_SPECIAL_COLOR_TSHIRTS = By.xpath("//a[contains(@href,'-t-shirts')]//span[contains(@aria-label,'products available')]");
    public static final By COUNT_OF_SPECIAL_COLORS_TSHIRTS2 = By.xpath("//span[contains(text(), 'items found')]");
    public static final By SELECTOR_REMOVE_FILTER = By.xpath("//*[@aria-label='Remove Brown filter']");

}
