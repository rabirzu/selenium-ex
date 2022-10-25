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
import org.openqa.selenium.chrome.ChromeDriver;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;

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
}
