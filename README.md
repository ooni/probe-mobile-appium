###### POC Appium mobile E2E tests for Android and iOS

Requirements: Details about install of appium and pre requirements are found here:
https://www.swtestacademy.com/appium-tutorial/ 

This Project will be build in gradle with appium java/cucumber , using POM and BDD with Pagefactory for Android and iOS.
Test are working in parallel execution and device configuration (desired capabilities) are found in configuration.yaml file
Feature files (Test steps ) are gherkin type and can be found in /OONI/src/test/resources/features folder

NOTE: for ios execution add ipa file to app folder and change path or run simulator and run program through xcode.


TODO : 
1. Add element IDs for both platforms as current id user are full xpath.
2. Add test reports (Allure) .
3. Add additional validation to existing tests.
4. Add project to CI pipeline






