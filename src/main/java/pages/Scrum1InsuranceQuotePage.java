package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.WebActions;

public class Scrum1InsuranceQuotePage {
    private final Page page;
    private final Locator VEHICLE_NUMBER_EDITBOX;
    private final Locator MOBILE_NUMBER_EDITBOX;
    private final Locator GET_QUOTE_BUTTON;

    public Scrum1InsuranceQuotePage(Page page) {
        this.page = page;
        this.VEHICLE_NUMBER_EDITBOX = resolveInput(new String[]{"Vehicle Number", "Vehicle No.", "Vehicle No", "Enter vehicle number"}, new String[]{"Vehicle Number", "Vehicle No.", "Vehicle No", "Enter vehicle number"});
        this.MOBILE_NUMBER_EDITBOX = resolveInput(new String[]{"Mobile Number", "Mobile No.", "Mobile No", "Enter mobile number"}, new String[]{"Mobile Number", "Mobile No.", "Mobile No", "Enter mobile number"});
        this.GET_QUOTE_BUTTON = resolveButton("Get Quote", "Get Quote Now", "Proceed to Quote");
    }

    public void navigateToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            this.page.navigate(url);
            return;
        }
        this.page.navigate(WebActions.getProperty(url));
    }

    public void enterVehicleNumber(String vehicleNumber) {
        this.VEHICLE_NUMBER_EDITBOX.fill(vehicleNumber);
    }

    public void enterMobileNumber(String mobileNumber) {
        this.MOBILE_NUMBER_EDITBOX.fill(mobileNumber);
    }

    public void clickGetQuote() {
        this.GET_QUOTE_BUTTON.click();
    }

    public boolean verifyGetQuoteButtonEnabled() {
        return this.GET_QUOTE_BUTTON.isEnabled();
    }

    public boolean verifyQuoteFlowStarted() {
        String currentUrl = this.page.url().toLowerCase();
        if (currentUrl.contains("quote") || currentUrl.contains("otp")) {
            return true;
        }
        return this.page.getByText("Quote Details").isVisible()
                || this.page.getByText("OTP").isVisible()
                || this.page.getByText("Verify OTP").isVisible()
                || this.page.getByText("Your Quote").isVisible();
    }

    private Locator resolveInput(String[] labels, String[] placeholders) {
        for (String label : labels) {
            Locator candidate = this.page.getByLabel(label);
            if (candidate.count() > 0) {
                return candidate;
            }
        }

        for (String placeholder : placeholders) {
            Locator candidate = this.page.getByPlaceholder(placeholder);
            if (candidate.count() > 0) {
                return candidate;
            }
        }

        return this.page.getByLabel(labels[0]);
    }

    private Locator resolveButton(String... buttonNames) {
        for (String buttonName : buttonNames) {
            Locator roleButton = this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonName));
            if (roleButton.count() > 0) {
                return roleButton;
            }

            Locator textButton = this.page.getByText(buttonName, new Page.GetByTextOptions().setExact(true));
            if (textButton.count() > 0) {
                return textButton;
            }
        }

        return this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonNames[0]));
    }
}
