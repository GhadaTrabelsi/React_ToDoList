@TodoList
Feature: Testing Todo List Web Site

  Background: 
    Given I am on the Todo List application

  Scenario: Verify buttons are disabled when all fields are not filled
    When I leave one or more fields empty
    Then the buttons for the forms should be disabled
    
    Scenario: Verify red message appears for incorrect login credentials
    When I enter incorrect login credentials "<username>" and "<password>"
    Then a red message should appear to alert me "Désolé, les identifiants sont incorrects."
Examples:
      | username    | password    |
      | test123       | test   |
      | test@test.com | test123 |

   Scenario: Verify "Tasks" and "Logout" links appear  when the user is logged in
    
    When I log in
    Then the "Tasks" and "Logout" links should be visible
  
  Scenario: Verify local storage is updated when adding, modifying, or deleting a task
    When I add a task
    Then the task should be added to the local storage
    When I modify the status of a task
    Then the task status should be updated "Complétée" in the local storage
    When I delete a task
    Then the task should be removed from the local storage
