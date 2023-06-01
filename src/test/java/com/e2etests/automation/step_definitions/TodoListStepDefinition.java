package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.TodoListPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TodoListStepDefinition {

	public TodoListPage todolistPage;
	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public Validations validation;

	public TodoListStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		validation = new Validations();
		todolistPage = new TodoListPage();
	}

	@Given("I am on the Todo List application")
	public void iAmOnTheTodoListApplication() {
		utils.get(configFileReader.getProperties("home.url"));
	}

	@When("I leave one or more fields empty")
	public void iLeaveOneOrMoreFieldsEmpty() {
		utils.clearField(TodoListPage.email);
		utils.clearField(TodoListPage.password);
	}

	@Then("the buttons for the forms should be disabled")
	public void theButtonsForTheFormsShouldBeDisabled() {

		validation.checkElementDisabled(TodoListPage.submitBtn);
		utils.checkElementPresent(TodoListPage.addTaskPage);

	}
	@When("I enter incorrect login credentials {string} and {string}")
	public void iEnterIncorrectLoginCredentialsAnd(String email, String password) {
		utils.writeText(TodoListPage.email, email);
		utils.writeText(TodoListPage.password, email);
		utils.click(TodoListPage.submitBtn);
		
	  
	}

	
	@Then("a red message should appear to alert me {string}")
	public void aRedMessageShouldAppearToAlertMe(String alert) {
		utils.assertEquals(TodoListPage.alertMsg, alert);

	}



	@When("I log in")
	public void iLogIn() {
	    utils.writeText(TodoListPage.email,configFileReader.getProperties("email"));
	    utils.writeText(TodoListPage.password,configFileReader.getProperties("password"));
utils.click(TodoListPage.submitBtn);

	}

	@Then("the {string} and {string} links should be visible")
	public void theAndLinksShouldBeVisible(String string, String string2) {
		validation.isElementDisplayed(TodoListPage.deconnexionIcon);
		validation.isElementDisplayed(TodoListPage.taskIcon);
		System.out.println("visible");

	}

	@When("I add a task")
	public void iAddATask() {
		utils.writeText(TodoListPage.email, configFileReader.getProperties("email"));
		utils.writeText(TodoListPage.password, configFileReader.getProperties("password"));
		utils.click(TodoListPage.submitBtn);

		utils.writeText(TodoListPage.taskName, configFileReader.getProperties("taskName"));
		utils.writeText(TodoListPage.taskDescr, configFileReader.getProperties("taskDescr"));
		utils.click(TodoListPage.addTaskPage);

	}

	@Then("the task should be added to the local storage")
	public void theTaskShouldBeAddedToTheLocalStorage() {
		validation.assertTrue(TodoListPage.localStorage, configFileReader.getProperties("taskName"));

	}

	@When("I modify the status of a task")
	public void iModifyTheStatusOfATask() {
		utils.click(TodoListPage.statusNonComp);
	}

	@Then("the task status should be updated {string} in the local storage")
	public void theTaskStatusShouldBeUpdatedInTheLocalStorage(String status) {
		utils.assertEquals(TodoListPage.statusComp, status);

	}

	@When("I delete a task")
	public void iDeleteATask() throws InterruptedException {

		utils.click(TodoListPage.deleteBtn);
	}

	@Then("the task should be removed from the local storage")
	public void theTaskShouldBeRemovedFromTheLocalStorage() {

		validation.assertFalse(TodoListPage.localStorage, configFileReader.getProperties("taskName"));

	}




}
