In this repo I used Cucumber for BDD and Selenium (Java) with JUnit as the test runner, and used the Page Object Model for organizing the website’s pages to centralize any changeable locators.
I added one feature file with the requested scenario (a simple flow to register and add an item to the cart and validate it has been added).
I also used the Allure library to generate reports alongside Cucumber reports (for different preferences).
GitHub Actions is also used to run all tests in the repo and then uploads the Cucumber and Allure reports as ZIP artifacts to be downloaded.
Here are example reports: 
note that I created a hook to capture a screenshot after each step to save evidence of failure/sucess

1-cucumber report for local run
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/248ec50b-0693-49ff-8dd3-1b5fcda90419" />

2-allure report for local run
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/2ac82d67-93bf-44ae-9cce-2d444a2413d9" />

3-cucmber report for github actions run (cloud)
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/c01c4ec8-7ebf-4ec8-a348-e34cb84136c3" />

4-allure report for github actions run (cloud)

