package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Scrum1InsuranceQuotePage;

public class Scrum1InsuranceQuoteSteps {
    Scrum1InsuranceQuotePage scrum1InsuranceQuotePage = new Scrum1InsuranceQuotePage(DriverFactory.getPage());

    @Given("^user navigates to \"([^\"]*)\"$")
    public void navigateToUrl(String url) {
        scrum1InsuranceQuotePage.navigateToUrl(url);
    }

    @When("^user enters \"([^\"]*)\" vehicle number in Two Wheeler Insurance Quote page$")
    public void enterVehicleNumber(String vehicleNumber) {
        scrum1InsuranceQuotePage.enterVehicleNumber(vehicleNumber);
    }

    @When("^user enters \"([^\"]*)\" mobile number in Two Wheeler Insurance Quote page$")
    public void enterMobileNumber(String mobileNumber) {
        scrum1InsuranceQuotePage.enterMobileNumber(mobileNumber);
    }

    @Then("^verify Get Quote button is enabled in Two Wheeler Insurance Quote page$")
    public void verifyGetQuoteButtonEnabled() {
        Assert.assertTrue(scrum1InsuranceQuotePage.verifyGetQuoteButtonEnabled());
    }

    @When("^user clicks Get Quote button in Two Wheeler Insurance Quote page$")
    public void clickGetQuote() {
        scrum1InsuranceQuotePage.clickGetQuote();
    }

    @Then("^verify quote details page or OTP verification step is displayed in Two Wheeler Insurance Quote page$")
    public void verifyQuoteFlowStarted() {
        Assert.assertTrue(scrum1InsuranceQuotePage.verifyQuoteFlowStarted());
    }
}
