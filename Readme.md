# Ebay Web Automation
This project contains web automation built using Selenium with the Java programming language, integrated with Cucumber to define BDD steps in test cases. The project has been developed using Maven as the build tool.

## Features
The scenario in this web automation consists of 2 features:
1. Access product after apply multiple filters via category page.
2. Access product via search page.

## Prerequisites
- Java
- Selenium
- Cucumber
- Chromedriver
- Editor Intellij
- Git

## How to Run?
1. Clone the repository or unzipped the file.
```
git clone git@github.com:OlviLora/herokuapp_automation.git
```
2. Go to the repository automation and open in the Editor.
3. Add Dependency defined in pom.xml file by running script below to load all the dependency in local.
```
add script to run maven
```
4. **Update the location on the chromedriver** → open file src/test/java/step_definitions/base/BaseSteps.java → update function setDriver()
   ```System.setProperty("web-driver.chrome.driver", "<chromedriver location on local>");```
5. **Run the scenario** → Right click the each file and select Run file name.
6. **Test Automation is running** It will open the chrome browser automatically and run each steps on the scenario.
