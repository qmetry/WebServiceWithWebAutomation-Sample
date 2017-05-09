package com.qas.ws.steps;

import static com.qmetry.qaf.automation.util.Validator.assertThat;

import org.hamcrest.Matchers;
import com.qas.ws.pages.OrdersPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class StepsLibrary {

	@QAFTestStep(description = "Order Entry for {0} should be present on Orders Page")
	public void assertOrderExist(String nameOrId) {
		if (nameOrId.contains("/")) {
			nameOrId = getOrderId(nameOrId);
		}
		assertThat("Name or Id", nameOrId, Matchers.notNullValue());
		OrdersPage ordersPage = new OrdersPage();
		ordersPage.launchPage();
		ordersPage.getOrderByNameOrId(nameOrId).assertPresent();
	}

	@QAFTestStep(description = "Order Entry for {0} should not be present on Orders Page")
	public void assertOrderNotExist(String nameOrId) {
		if (nameOrId.contains("/")) {
			nameOrId = getOrderId(nameOrId);
		}
		assertThat("Name or Id", nameOrId, Matchers.notNullValue());
		OrdersPage ordersPage = new OrdersPage();
		ordersPage.launchPage();
		ordersPage.getOrderByNameOrId(nameOrId).assertNotPresent();
	}

	public String getOrderId(String location) {
		return location.substring(location.lastIndexOf("/") + 1, location.lastIndexOf("."));
	}
}
