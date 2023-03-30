package testng;

import PageObjects.Pageobjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class PantheonsiteDesktop {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Pageobjects.pageURL);
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @AfterMethod
    public void endMethod(){
        driver.quit();
    }
    @Test(priority = 1)
    public void menuListTest() {
        // Locate the header element on the page
        WebElement navBar = driver.findElement(Pageobjects.navMenu);
        //Click and hold the header
        actions.clickAndHold(navBar);
        // Get the text content of the header element
        String headerText = navBar.getText();
        // Check if the header contains the expected menu text
        assert headerText.contains("SERVICES");
        assert headerText.contains("Open Submenu");
        assert headerText.contains("EXPERIENCE");
        assert headerText.contains("COMPANY");
        assert headerText.contains("CAREERS");
        assert headerText.contains("CONTACT US");
    }
    @Test(priority = 2)
    public void menuLogoTest() {
        // Locate the header element on the page
        WebElement navBar = driver.findElement(Pageobjects.navMenu);
        // Locate the logo element on the page
        WebElement navLogo = driver.findElement(Pageobjects.navLogo);
        // Retrieve the X-coordinate of the logo element
        int logoX = navLogo.getLocation().getX();

        // Retrieve the X-coordinate of the header element
        int headerX = navBar.getLocation().getX();

        // Assert that the logo is on the left side of the header
        Assert.assertTrue(logoX < headerX, "Logo is not on the left side of the header");
    }
    @Test(priority = 3)
    public void menuCTATest() {
        // Locate the header element on the page
        WebElement navBar = driver.findElement(Pageobjects.navMenu);
        // Locate the CTA element on the page
        WebElement menuCTA = driver.findElement(Pageobjects.menuCTA);
        // Get the location and size of the CTA element
        Point ctaLocation = menuCTA.getLocation();
        Dimension ctaSize = menuCTA.getSize();

        // Calculate the rightmost coordinate of the CTA element
        int ctaRight = ctaLocation.getX() + ctaSize.getWidth();

        // Calculate the rightmost coordinate of the header element
        int headerRight = navBar.getLocation().getX() + navBar.getSize().getWidth();

        // Assert that the CTA is on the right side of the header
        Assert.assertTrue(ctaRight <= headerRight, "CTA is not on the right side of the header");
    }
    @Test(priority = 4)
    public void menuCTAColorTest() {
        // Locate the CTA element on the page
        WebElement menuCTA = driver.findElement(Pageobjects.menuCTA);
        // Move the mouse pointer to the button to simulate a hover
        actions.moveToElement(menuCTA).perform();

        // Get the background color of the button
        String backgroundColor = menuCTA.getCssValue("background-color");

        // Assert that the background color has changed
        Assert.assertNotEquals("#252525", backgroundColor);
    }

    @Test(priority = 4)
    public void headerColorTest() {
        // Locate the header element on the page
        WebElement navBar = driver.findElement(Pageobjects.navMenu);
        // Move the mouse pointer to the button to simulate a hover
        actions.moveToElement(navBar).perform();

        // Get the background color of the button
        String backgroundColor = navBar.getCssValue("background-color");

        // Assert that the background color has changed
        Assert.assertNotEquals("#252525", backgroundColor);
    }
    @Test(priority = 5)
    public void contactUsCTATest() {
        // Locate the CTA element on the page
        WebElement menuCTA = driver.findElement(Pageobjects.menuCTA);
        // Move the mouse pointer to the button to click
        actions.click(menuCTA).perform();

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("contact-us"));

        // Assert that the page has reloaded
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("contact-us")) {
            System.out.println("Page redirects to contact us page successfully");
        } else {
            System.out.println("Page does not redirect user to contact us page, the test failed");
        }

    }
    @Test(priority = 6)
    public void logoReloadTest() {
        // Locate the logo element on the page
        WebElement navLogo = driver.findElement(Pageobjects.navLogo);
        // Move the mouse pointer to the logo to click
        actions.click(navLogo).perform();

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("pantheonsite.io"));

        // Assert that the page has reloaded
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("pantheonsite.io")) {
            System.out.println("Page reloads successfully");
        } else {
            System.out.println("Page reload failed");
        }

    }
    @Test(priority = 7)
    public void companyMenuTest() {
        // Locate the Company Menu element on the page
        WebElement companyMenuLink = driver.findElement(Pageobjects.companyMenu);
        // Move the mouse pointer to the Menu to click
        actions.click(companyMenuLink).perform();
        // Locate the Company section on the page
        WebElement companySection = driver.findElement(Pageobjects.companySection);

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(companySection));

        // Assert that the page has reloaded
        if (companySection.isDisplayed()) {
            System.out.println("Page redirects to Company page successfully");
        } else {
            System.out.println("Page does not redirect user to Company page, the test failed");
        }

    }
    @Test(priority = 8)
    public void careerMenuTest() {
        // Locate the Career Menu element on the page
        WebElement careerMenuLink = driver.findElement(Pageobjects.careerMenu);
        // Move the mouse pointer to the button to simulate a hover
        actions.click(careerMenuLink).perform();
        // Locate the career section on the page
        WebElement careerSection = driver.findElement(Pageobjects.careerSection);

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(careerSection));

        // Assert that the page has reloaded
        if (careerSection.isDisplayed()) {
            System.out.println("Page redirects to Career page successfully");
        } else {
            System.out.println("Page does not redirect user to Career page, the test failed");
        }

    }
    @Test(priority = 9)
    public void experienceMenuTest() {
        // Locate the Career Menu element on the page
        WebElement careerMenuLink = driver.findElement(Pageobjects.careerMenu);
        // Move the mouse pointer to the button to simulate a hover
        actions.click(careerMenuLink).perform();
        // Locate the Experience Menu element on the page
        WebElement experienceMenuLink = driver.findElement(Pageobjects.experienceMenu);
        // Move the mouse pointer to the button to simulate a hover
        actions.click(experienceMenuLink).perform();
        // Locate the Experience section on the page
        WebElement experienceSection = driver.findElement(Pageobjects.experienceSection);

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(experienceSection));

        // Assert that the page has reloaded
        if (experienceSection.isDisplayed()) {
            System.out.println("Page redirects to Expereince page successfully");
        } else {
            System.out.println("Page does not redirect user to Experience page, the test failed");
        }

    }
    @Test(priority = 10)
    public void subMenuListTest() {
        WebElement submenu = driver.findElement(Pageobjects.subMenu);

        // Assert that the submenu element is displayed
        assert submenu.isDisplayed();

        // Find all the submenu items within the submenu element
        List<WebElement> submenuItems = submenu.findElements(Pageobjects.serviceMenu);

        // Assert that the number of submenu items is 6
        assert submenuItems.size() == 6;
        // Loop through each submenu item and assert that it contains the expected link text and URL
        for (WebElement item : submenuItems) {
            WebElement link = item.findElement(Pageobjects.serviceList);
            String expectedText = link.findElement(Pageobjects.subLabels).getText();
            String expectedUrl = "#"; // Replace with the expected URL for each submenu item
            assert link.getAttribute("href").equals(expectedUrl);
            assert link.getText().equals(expectedText);
        }
    }
    @Test(priority = 11)
    public void TwitterLinkTest() {
        // Locate the Twitter Link element on the page
        WebElement twitterLink = driver.findElement(Pageobjects.twitterLink);
        // Move the mouse pointer to the logo to click
        actions.click(twitterLink).perform();

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("twitter"));

        // Assert that the page has reloaded
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("twitter")) {
            System.out.println("Twitter Page reloads successfully");
        } else {
            System.out.println("Twitter Page reload failed");
        }

    }
    @Test(priority = 12)
    public void LinkedinLinkTest() {
        // Locate the Linkedin Link element on the page
        WebElement linkedinLink = driver.findElement(Pageobjects.linkedinLink);
        // Move the mouse pointer to the link to click
        actions.click(linkedinLink).perform();

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("linkedin"));

        // Assert that the page has reloaded
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("linkedin")) {
            System.out.println("Linkedin Page reloads successfully");
        } else {
            System.out.println("Linkedin Page reload failed");
        }

    }
    @Test(priority = 13)
    public void InstagramLinkTest() {
        // Locate the Instagram Link element on the page
        WebElement instagramLink = driver.findElement(Pageobjects.instagramLink);
        // Move the mouse pointer to the link to click
        actions.click(instagramLink).perform();

        // Wait for the page to reload
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("instagram"));

        // Assert that the page has reloaded
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("instagram")) {
            System.out.println("Instagram Page reloads successfully");
        } else {
            System.out.println("Instagram Page reload failed");
        }

    }
}
