package com.qas.ws.pages;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

import java.text.MessageFormat;
import java.util.List;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class OrdersPage extends WebDriverBaseTestPage<WebDriverTestPage> implements Locators.OrderPageLocators {

	@FindBy(locator = ORDER_LOC)
	private List<Order> orders;

	@FindBy(locator = CREATE_BTN_LOC)
	private QAFWebElement createNewBtn;

	public List<Order> getOrders() {
		return orders;
	}

	public Order getOrderByNameOrId(String nameOrId) {
		return new Order(MessageFormat
				.format(getBundle().getString(ORDER_BY_NAME_OR_ID_LOC_FORMAT).replaceFirst("\\{", "'{'"), nameOrId));
	}

	public QAFWebElement getCreateNewBtn() {
		return createNewBtn;
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		driver.get("/");
	}

	@QAFTestStep(description = "Navigate to Orders Page")
	public void launchPage() {
		super.launchPage(null);
	}

	public class Order extends QAFWebComponent {

		@FindBy(locator = ORDER_ID_LOC)
		private QAFWebElement orderId;

		@FindBy(locator = CLIENT_NAME_LOC)
		private QAFWebElement clientName;

		@FindBy(locator = ORDER_AMOUNT_LOC)
		private QAFWebElement amount;

		@FindBy(locator = VIEW_BTN_LOC)
		private QAFWebElement viewBtn;

		@FindBy(locator = EDIT_BTN_LOC)
		private QAFWebElement editBtn;

		@FindBy(locator = DELETE_BTN_LOC)
		private QAFWebElement deleteBtn;

		public Order(String locator) {
			super(locator);
		}

		public QAFWebElement getOrderId() {
			return orderId;
		}

		public QAFWebElement getClientName() {
			return clientName;
		}

		public QAFWebElement getAmount() {
			return amount;
		}

		public QAFWebElement getViewBtn() {
			return viewBtn;
		}

		public QAFWebElement getEditBtn() {
			return editBtn;
		}

		public QAFWebElement getDeleteBtn() {
			return deleteBtn;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj instanceof String) {
				return obj.toString().equalsIgnoreCase(clientName.getText());
			}
			return super.equals(obj);
		}
	}
}
