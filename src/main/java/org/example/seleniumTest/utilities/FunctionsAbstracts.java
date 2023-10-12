package org.example.seleniumTest.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FunctionsAbstracts {

    public WebDriver driver;
    public WebDriverWait wait;
    public FunctionsAbstracts(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    public WebElement visibilityElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> visibilityElements(List<WebElement> elements){
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public Boolean invisibilityElement(WebElement element){
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement clickableElement(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKey(WebElement element, String text){
        visibilityElement(element).clear();
        visibilityElement(element).sendKeys(text);
    }

    public void clickElement(WebElement element){
        clickableElement(element).click();
    }

    public void selectText(WebElement element, String text){
        Select selection = new Select(visibilityElement(element));
        selection.selectByVisibleText(text);
    }

    public void toGo(String url){
        driver.get(url);
    }

//    screenshot
    public void getScreenshot(String testClassName) throws IOException {
        TakesScreenshot ts =  (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+testClassName+".pgn");
        FileUtils.copyFile(source,file);

    }

}
