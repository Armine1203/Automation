package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElements {
    //1

    public static void navigateToCategory(WebDriver driver, String tabName, String category, String option) throws InterruptedException {
        Actions actions = new Actions(driver);

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

}
