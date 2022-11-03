package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SearchStepDefinitions {
    WebDriver driver=new ChromeDriver();

    public static SearchStepDefinitions createSearchStepDefinitions() {
        return new SearchStepDefinitions();
    }


    @Given("^I access (.*)$")
    public void accessUrl(String url) {
            driver.navigate().to(url);

    }


    @Given ("^I click on the first checkbox$")
    public void clickFirstCheckbox(){
            driver.findElement(By.id("checkBoxOption1")).click();
    }



    @Then("I check that the checkbox is checked")
    public void iCheckThatTheCheckboxIsChecked() {
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isEnabled());
    }

    @Then("I check that the checkbox is unchecked")
    public void iCheckThatTheCheckboxIsUnchecked() {
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isDisplayed());
    }

    @When("I accept cookies")
    public void iAcceptCookies() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
    }

    @Then("I click on Sign in button")
    public void clickOnSignIn() {
        WebElement signInButton= driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]"));

        WebElement signInButton2= driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]"));
        signInButton2.click();

    }


    @Then("I insert the email")
    public void insertEmail() throws IOException {

        String path="/Users/rabirzu/IdeaProjects/assessment/selenium-ex/src/test/resources/properties/credential.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(path));

        driver.findElement(By.xpath("//*[contains(@name,'identifier')]")).sendKeys(appProps.get("userName").toString());
    }

    @Then("I click on Next")
    public void clickOnNext() {
        driver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
    }
}
