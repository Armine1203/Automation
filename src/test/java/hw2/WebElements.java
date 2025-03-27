package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElements {
    //1

    public static void navigateToCategory(WebDriver driver, Actions actions, String tabName, String category, String option) throws InterruptedException {
        WebElement tab = driver.findElement(By.xpath(String.format("(//a[text()=\"%s\"])[1]", tabName)));
        actions.moveToElement(tab).perform();
        Thread.sleep(4000);

        WebElement categoryElement = driver.findElement(By.xpath(String.format("//a[text()=\"%s\"]", category)));
        actions.moveToElement(categoryElement).perform();
        Thread.sleep(4000);

        WebElement optionElement = driver.findElement(By.xpath(String.format("//a[text()=\"%s\"]", option)));
        optionElement.click();
        Thread.sleep(4000);
    }

    //2

       public static void filterMenClothesBasedOnColor(WebDriver driver, String color) throws InterruptedException {
        WebElement colorElement = driver.findElement(By.xpath("//a[contains(@href, 'men-" + color.toLowerCase() + "-t-shirts')]"));
        colorElement.click();
       }

//    public static void main(String[] args) {
//        // Set up the WebDriver (assuming you're using ChromeDriver)
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        WebDriver chromeDriver = new ChromeDriver();
//
//        // Navigate to the page
//        chromeDriver.get("your-web-page-url");
//
//        // Select the color tab (optional, if needed)
//        WebElement colorTab = chromeDriver.findElement(SELECTOR_COLOR_TAB);
//
//        // Example for selecting and checking "brown"
//        WebElement colorBrown = selectColor(chromeDriver, "brown");
//        System.out.println("Brown color selected: " + isColorSelected(chromeDriver, "brown"));
//
//        // Close the browser
//        chromeDriver.quit();
//    }

}
