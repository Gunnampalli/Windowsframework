package Base;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Properties;

public class BaseSetup {
    public static Properties prop;
    public FileInputStream fis;
    public static WindowsDriver  driver;
   public static Screen screen ;
    public BaseSetup()
    {
        prop = new Properties();
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\ConfigFiles\\config.properties");
            prop.load(fis);
            System.out.println("Properties file is loaded");
        } catch (IOException e) {
            System.out.println("Config properties file is not found");
            e.printStackTrace();
        }
    }
    public void initialize() {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("app","C:\\Users\\venkateswara.G\\Downloads\\WinClient\\WinClient.exe");
        try {
             driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            Thread.sleep(6000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    public boolean isElementPresent(By locator, long waitTime) {
        boolean bflag = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (driver.findElement(locator).isDisplayed() || driver.findElement(locator).isEnabled()) {
                bflag = true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element." + locator + " was not not found in time " + waitTime + "seconds" + "-NosuchElementException");
            Assert.fail("locator is not present");
        } catch (TimeoutException e) {
            System.out.println("Element." + locator + " was not not found in time " + waitTime + "seconds" + "-TimeoutException");
            Assert.fail("locator is not present");
        } catch (Exception e) {
            System.out.println("Element." + locator + " was not not found in time" + e);
            Assert.fail("locator is not present");
        }
        return bflag;
    }
    public boolean isElementEnabled(By locator, long waitTime) {
        boolean bflag = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if ( driver.findElement(locator).isEnabled()) {
                bflag = true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element." + locator + " was not not found in time " + waitTime + "seconds" + "-NosuchElementException");
            Assert.fail("locator is not present");
        } catch (TimeoutException e) {
            System.out.println("Element." + locator + " was not not found in time " + waitTime + "seconds" + "-TimeoutException");
            Assert.fail("locator is not present");
        } catch (Exception e) {
            System.out.println("Element." + locator + " was not not found in time" + e);
            Assert.fail("locator is not present");
        }
        return bflag;
    }
    public void clearData(By locator,long waitTime)
    {
        try {
            if (isElementPresent(locator, waitTime)) {
                WebElement ele = driver.findElement(locator);
                ele.clear();
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element" + " is not visble to click.." + "- StaleElementReferenceException");
        } catch (NoSuchElementException e) {
            System.out.println("Element" + " is not visble to click.." + "-NosuchElementException");
        } catch (Exception e) {
            System.out.println("unable to click.." + e);
        }
    }
    public void click(By locator, long waitTime) {
        try {
            if (isElementPresent(locator, waitTime)) {
                WebElement ele = driver.findElement(locator);
                ele.click();
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element" + " is not visble to click.." + "- StaleElementReferenceException");
        } catch (NoSuchElementException e) {
            System.out.println("Element" + " is not visble to click.." + "-NosuchElementException");
        } catch (Exception e) {
            System.out.println("unable to click.." + e);
        }
    }

    public void sendkeys(By locator, long waitTime, String msg) {
        try {
            if (isElementPresent(locator, waitTime)) {
                WebElement ele = driver.findElement(locator);
                ele.sendKeys(msg);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element" + " is not visble to click.." + "-NosuchElementException");
        } catch (Exception e) {
            System.out.println("unable to click.." + e);
        }
    }

}
