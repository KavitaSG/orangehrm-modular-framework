# OrangeHRM Modular Framework (POM + Singleton + ExtentReports)

## What you get
- Maven project (Java 11)
- Singleton WebDriver (DriverSingleton)
- Page Object Model (LoginPage, DashboardPage)
- ExtentReports configured
- JSON-driven test data (test-data/users.json)
- TestNG suite (testng.xml)

## How to run in IntelliJ
1. Open project (File > Open) and select this folder.
2. Ensure Project SDK is Java 11+.
3. In Maven tool window, click Refresh to download dependencies.
4. Run `testng.xml` (right-click > Run) or run `mvn test` from terminal.

## Notes
- Default runs Chrome in headless mode (change testng.xml parameter headless to false to see browser).
- Reports: `target/extent-report/index.html`
- Screenshots on failure: `target/screenshots/`
