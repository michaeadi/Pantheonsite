package PageObjects;

import org.openqa.selenium.By;

public class Pageobjects {
    public static String pageURL = "https://dev-bsa-dev-test.pantheonsite.io/#/";
    public static By navMenu = By.xpath("//*[@id=\"navigation\"]//div[2]/div");
    public static By navLogo = By.xpath("//*[@id=\"navigation-header\"]");
    public static By menuCTA = By.xpath("//*[@id=\"navigation\"]//div[2]/div/a");
    public static By companyMenu = By.xpath("//*[@id=\"navigation-menu\"]/ul/li[3]/a");
    public static By companySection = By.xpath("//*[@id=\"culture\"]/div");
    public static By careerMenu = By.xpath("//*[@id=\"navigation-menu\"]/ul/li[4]/a");
    public static By careerSection = By.xpath("//*[@id=\"openings\"]/div");
    public static By experienceMenu = By.xpath("//*[@id=\"navigation-menu\"]/ul/li[2]/a");
    public static By experienceSection = By.xpath("//*[@id=\"hero\"]/div");
    public static By serviceMenu = By.className("navigation-menu__submenu-item");
    public static By serviceList = By.className("navigation-menu__submenu-link");
    public static By subLabels = By.className("navigation-menu__submenu-label");
    public static By subMenu = By.className("navigation-menu__submenu");
    public static By twitterLink = By.xpath("/html/body/footer/div/div[2]/div/a[1]");
    public static By linkedinLink = By.xpath("/html/body/footer/div/div[2]/div/a[2]");
    public static By instagramLink = By.xpath("/html/body/footer/div/div[2]/div/a[3]");

}
