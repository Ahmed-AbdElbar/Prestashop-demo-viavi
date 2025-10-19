In this repo I used Cucumber for BDD and Selenium (Java) with JUnit as the test runner, and used the Page Object Model for organizing the website’s pages to centralize any changeable locators.
I added one feature file with the requested scenario (a simple flow to register and add an item to the cart and validate it has been added).
I also used the Allure library to generate reports alongside Cucumber reports (for different preferences).
GitHub Actions is also used to run all tests in the repo and then uploads the Cucumber reports as ZIP artifacts to be downloaded.
Here are example reports: 
note that I created a hook to capture a screenshot after each step to save evidence of failure/sucess

1-cucumber report for local run
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/2c8a22f0-8946-4e61-a604-e00f5e83c7ab" />


2-allure report for local run
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/2ac82d67-93bf-44ae-9cce-2d444a2413d9" />

3-cucmber report for github actions run (cloud)
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/3c70ccb2-cc44-408c-a15e-76ecc71139e9" />


4-allure report for github actions run (cloud)
this one was a little bit tricky because of the static loading of the JSON files that contain data for allure to populate so i had to use page deployment on github
and to open allure report I should use the highlighted link in the screenshot below
<img width="1918" height="996" alt="image" src="https://github.com/user-attachments/assets/e1fb0202-d45a-4983-8662-7fdd5da6b380" />


and this is how the report looks
<img width="1918" height="996" alt="image" src="https://github.com/user-attachments/assets/61a2ca8e-8c2f-472d-89c5-7cf1daac096a" />




