package search;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import search.WebEventListener;

public class reptile {
	
	public static String browserString = "D:\\360 浏览器\\360se6\\Application\\360se.exe";
	private ChromeOptions option ;
	public WebDriver br;
	public String urlString;
	public EventFiringWebDriver e_driver;
	
	
	reptile(String urlString) {
		this.urlString = urlString;
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		option.setBinary(browserString);
		br =  new ChromeDriver(option);
		try {
			startBrowser(br); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void startBrowser(WebDriver driver) throws Exception
    {
		int waitTime = 20;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		e_driver = new EventFiringWebDriver(driver);
		WebEventListener eventListener = new WebEventListener();
        e_driver.register(eventListener);
		e_driver.get(urlString);
		Dimension dimension = new Dimension(800, 600);
		e_driver.manage().window().setSize(dimension);
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        System.out.println(tabs.size());
//        e_driver.switchTo().window(tabs.get(0));
//        Thread.sleep(5000);
//        System.out.println("有标签页："+tabs.size()+"被检测到！");
        
//	    driver.quit();
	  }
	 
	 //通过爬虫导出数据
	 public void export_ecologie_data() throws Exception
	 {
		 System.out.print("我正在导出数据内容");
	 }
	 
	 public static void main(String[] args) throws Exception 
    { 
		 // 对浏览器驱动
		 reptile reptile =new reptile("http://www.cnblogs.com/tankxiao");
    } 
}
	 

