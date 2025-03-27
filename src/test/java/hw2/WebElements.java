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
    public static void filterMenClothes(WebElement tabs, WebElement checkbox) throws InterruptedException {
        tabs.click();
        Thread.sleep(3000);
        checkbox.click();
    }

}
