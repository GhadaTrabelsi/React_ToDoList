package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class TodoListPage {
	
	public TodoListPage todolistPage;

	/* Retrieve Element */

	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	public static WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	public static WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public static  WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	public static WebElement addTaskPage; 
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
	public static WebElement alertMsg;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Tâches']")
	public static WebElement taskIcon;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[1]")
	public static WebElement taskName;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[2]")
	public static WebElement taskDescr;
	
	@FindBy(how = How.XPATH, using ="//body[1]/div[1]/div[1]/div[1]")
	public static WebElement localStorage;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Déconnexion']")
	public static WebElement deconnexionIcon;
	
	@FindBy(how = How.XPATH, using = "//div[@class='badge badge-success']")
	public static WebElement statusComp;
	@FindBy(how = How.XPATH, using = "//div[@class='badge badge-danger']")
	public static WebElement statusNonComp;
	
	@FindBy(how = How.XPATH, using = "(//a[normalize-space()='Supprimer'])")
	public static WebElement deleteBtn;
	
	public TodoListPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	

	
	
	
	
	
}
