package com.apex.selenium.steps;

import com.apex.selenium.domain.Checkout;
import com.apex.selenium.domain.OrderSummary;
import com.apex.selenium.domain.PuppyHomePage;
import com.apex.selenium.utils.BrowserFactory;
import com.sun.tools.javac.comp.Check;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.TableRow;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.PageFactory.initElements;

public class StepDefinition {
    WebDriver webDriver;
    PuppyHomePage puppyHomePage;
    OrderSummary orderSummary;
    Checkout checkout;

    @Given("A web page {string}")
    public void a_web_page(String pageUrl) {
        webDriver = BrowserFactory.getDriver();
        webDriver.get(pageUrl);
    }

    @Given("I look for details for dog {int}")
    public void iLookForDetailsForDog(int dogNo) throws Throwable {
        Thread.sleep(2000);
        puppyHomePage =  PageFactory.initElements(webDriver, PuppyHomePage.class);
        puppyHomePage.lookForPetDetails(dogNo);
    }

    @And("adopt the pet")
    public void adoptThePet() {
        puppyHomePage.adopt();
    }

    @When("shopping cart appear complete te adoption")
    public void shoppingCartAppearCompleteTeAdoption() {
        orderSummary = PageFactory.initElements(webDriver, OrderSummary.class);
        orderSummary.completeAdoption();
    }


    @And("complete the adoption form with following data$")
    public void completeTheAdoptionFormWithFollowingData(DataTable dt) {
        Map<String, String> data;
        data = dt.asMap(String.class, String.class);

        checkout = PageFactory.initElements(webDriver, Checkout.class);
        checkout.completeCheckout(data.get("name"), data.get("address"), data.get("mail"), data.get("paymentType"));
    }

    @Then("I verify the adoption on home page")
    public void iVerifyTheAdoptionOnHomePage() {
        Assert.assertEquals("Thank you for adopting a puppy!", puppyHomePage.getNoticeMessage());
    }

    @And("I want to add one more puppy")
    public void iWantToAddOneMorePuppy() {
        orderSummary = PageFactory.initElements(webDriver, OrderSummary.class);
        orderSummary.addAnotherPuppy();
    }
}
