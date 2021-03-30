package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class WebApi {    // webapi is all setup in that class
   public WebDriver driver=null;
    //String url="https://www.amazon.com/";
    @Parameters({"OS","browserName","url"})
    @BeforeMethod
    public void setUp(String OS,String browserName,String  url) {
        getLocalDriver(OS, browserName);
// Set Browser Driver (driverSyntax, driverPath)
// System.setProperty("webdriver.chrome.driver","./BrowserDriver/mac/chromedriver");
// Reference variable of Browser Driver
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);

    }
    public WebDriver getLocalDriver(String OS, String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "./BrowserDriver/mac/chromedriver");
            } else if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "./BrowserDriver/windows/chromedriver.exe");
            }
            driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--disable-notifications");
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "./BrowserDriver/mac/chromedriver");
            } else if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "./BrowserDriver/windows/chromedriver.exe");
            }
            driver=new ChromeDriver(options);
        } else  if (browserName.equalsIgnoreCase("firefox")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "./BrowserDriver/mac/geckodriver");
            } else if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "./BrowserDriver/windows/geckodriver.exe");
            }
            driver=new FirefoxDriver();
        } else  if (browserName.equalsIgnoreCase("ie")) {
            if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.ie.driver", "./BrowserDriver/windows/IEDriverServer.exe");
            }
            driver= new InternetExplorerDriver();
        }  else  if (browserName.equalsIgnoreCase("safari")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.safari.driver", "./BrowserDriver/mac/safari");
            }
            driver=new SafariDriver();
        }

        return driver;
    }



    @AfterMethod


        public void tearDown () {
            driver.close();

        }

        public void waitFor ( int seconds) throws InterruptedException {
            // Wait 5 seconds
            Thread.sleep(1000 * seconds);
        }


}
