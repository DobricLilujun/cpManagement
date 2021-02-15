package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebEventListener extends AbstractWebDriverEventListener {
	 
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("打开前url: '" + url + "'");
    }
 
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("打开url:'" + url + "'");
    }
 
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("试图单击对象: " + element.toString());
    }
 
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("单击对象: " + element.toString());
    }
 
    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Error occurred: " + error);
    }
}
