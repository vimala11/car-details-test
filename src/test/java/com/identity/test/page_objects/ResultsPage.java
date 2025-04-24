package com.identity.test.page_objects;

import com.identity.test.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class ResultsPage extends BasePage {

    public Map<String,String> getResults() throws InterruptedException {
        Map<String, String> output = new HashMap<>();
        String locator = "//div[3]/div[1]/div/span/div[2]/dl[%d]";

        WebElement chkElement = BasePage.driver.findElement(By.xpath("//a[text()='Skip, with limited data']"));
        chkElement.click();
        driver.switchTo().defaultContent();
        for (int i = 1; i < 5; i++) {
            WebElement element = BasePage.driver.findElement(By.xpath(String.format(locator, i)));
            output.put(element.findElement(By.tagName("dt")).getText().toUpperCase(), element.findElement(By.tagName("dd")).getText().toUpperCase());
        } return output;
    }
}
