# WebpageUI-Sample-JUnit-Selenium

Small and simple framework for Webpage UI (or end to end tests) based on Selenium WebDriver + JUnit 4.12

Next features available:

- Test cases could be grouped into test suites (given sample contains 2 suits)
	- Service Suite (could be used as checker that everything works OK, before running other test suites)
	- Base Test Suite (here should be placed Ui tests scenarios)
	
For running tests

1. Install IDE (Eclipse IDE was used, but should also work with others (e.g. IntellijIDea))
2. Verify that java installed (print in the terminal java -version or java --version)
3. Install JUnit 4.12 + Selenium
4. Execute the tests (Run Full Tests suite as JUnit test in the IDE)
