package hw2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class Tests {
    WebDriver chromeDriver;
    Actions actions;

    @BeforeEach
    public void openWebPage() throws InterruptedException {
        chromeDriver = new ChromeDriver();
        actions = new Actions(chromeDriver);
        chromeDriver.get("https://6pm.com");
        Thread.sleep(3000);
        chromeDriver.manage().window().maximize();
        System.out.println("PreTest");
    }

    @AfterEach
    public void quitDriver(){
        chromeDriver.quit();
    }

    @Test
    @Tag("Bags")
    public void test1() throws InterruptedException {
        WebElements.navigateToCategory(chromeDriver,actions,"Bags","All Bags","Luggage");

        Thread.sleep(5000);
        List<WebElement> products = chromeDriver.findElements(Selectors.SELECTOR_PRODUCTS_LIST);
        Thread.sleep(5000);

        for (WebElement product : products) {//ԽՆԴԻՐ ՈՒՆԵՄ ԷՍՏԵՂ ՄԵՆԱԿ ՄԻ ՏԱՐՐԻ ՎՐԱՅՈՎԱ ԱՆՑՆՈՒՄ
            String productName = product.findElement(Selectors.SELECTOR_PRODUCT_NAME).getText();
            String productPrice = product.findElement(Selectors.SELECTOR_PRODUCT_PRICE).getText();
            System.out.println(productName + " costs " + productPrice);
        }
//2-րդ պունկտի համար ցանկալի կլինի, որ գրեք մեթոդ, որին կփոխանցեք թաբի ու կատեգորիայի,
// ինչպես նաև քլիք արվող տարբերակի անունը, ու ինքը կաշխատի ցանկացած վալիդ կոմբինացիայի համար։

        Random random = new Random();
        int randomNumber = random.nextInt(products.size());
        products.get(randomNumber).click();
        Thread.sleep(5000);

        WebElement selectedProductName = chromeDriver.findElement(Selectors.SELECTOR_PRODUCT_NAME2);
        WebElement selecteddProductPrice = chromeDriver.findElement(Selectors.SELECTOR_PRODUCT_PRICE2);
        System.out.println("Selected product name : " + selectedProductName.getText() + " price : " + selecteddProductPrice.getText());
        Thread.sleep(2000);

        WebElement addButton = chromeDriver.findElement(Selectors.SELECTOR_ADD_BUTTON);
        addButton.click();

        Thread.sleep(2000);

        WebElement removeButton = chromeDriver.findElement(Selectors.SELECTOR_REMOVE_BUTTON);
        removeButton.click();

        Thread.sleep(3000);

        WebElement signIn = chromeDriver.findElement(Selectors.SELECTOR_SIGN_IN);
        System.out.println("Sign in: " + signIn.getDomProperty("href"));
        chromeDriver.quit();
    }

    @Test
    @Tag("Clothing")
    public void test2() throws InterruptedException {

      //hover կանի Clothing-ի վրա, հետո կընտրի Men's-ի T-Shirt-ը ու քլիք կանի
        WebElements.navigateToCategory(chromeDriver, actions, "Clothing", "Men's", "T-Shirts");
        Thread.sleep(5000);

        WebElement colorTab = chromeDriver.findElement(Selectors.SELECTOR_COLOR_TAB);

        colorTab.click();
        WebElements.filterMenClothesBasedOnColor(chromeDriver, "brown");
        System.out.println("passed");
        Thread.sleep(5000);


        WebElement countOfFilteredItems = chromeDriver.findElement(Selectors.COUNT_OF_SPECIAL_COLOR_TSHIRTS);
        String expectedText = countOfFilteredItems.getText().replaceAll("[^0-9]", "");
        int expectedCount = Integer.parseInt(expectedText);
        System.out.println("Expected count: " + expectedCount);

        Thread.sleep(5000);
        WebElement countOfFilteredItems2 = chromeDriver.findElement(Selectors.COUNT_OF_SPECIAL_COLORS_TSHIRTS2);
        String realText = countOfFilteredItems2.getText().replaceAll("[^0-9]", "");
        int actualCount = Integer.parseInt(realText);
        System.out.println("Real count: " + actualCount);

        Assertions.assertEquals(expectedCount,actualCount,"The filtered items result counts don't equals");

        Thread.sleep(5000);
        WebElement removeFilter = chromeDriver.findElement(Selectors.SELECTOR_REMOVE_FILTER);
        removeFilter.click();
        Thread.sleep(8000);

        List<WebElement> allFilters = chromeDriver.findElements(By.xpath("//*[@id='searchSelectedFilters']//a"));
        allFilters.stream().forEach(element -> System.out.println(element.getText()));
        boolean isBrownRemoved = allFilters.stream().noneMatch(e -> e.getText().equals("Brown"));
        Assertions.assertTrue(isBrownRemoved, "Brown filter is still available.");

        WebElement brownFilterUnselected = chromeDriver.findElement(By.xpath("//a[contains(@href, 'men-brown-t-shirts')]/parent::li[@class='']"));
        Assertions.assertFalse(brownFilterUnselected.isSelected(), "Brown filter is still selected.");
        System.out.println("Done");
    }
}
