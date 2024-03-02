[![GitHub stars](https://img.shields.io/github/stars/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Star&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Watch&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/watchers/)
[![GitHub forks](https://img.shields.io/github/forks/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/network/members/)

**Table of Contents**
<!-- TOC -->
* [Example of Selenide, JUnit5, Allure](#example-of-selenide-junit5-allure)
  * [Framework](#framework)
  * [Project Structure](#project-structure)
  * [How To Use](#how-to-use)
    * [Clone Repository](#clone-repository)
    * [Configuration Files](#configuration-files)
    * [Run Tests With Gradle](#run-tests-with-gradle)
      * [Perform On Browsers](#perform-on-browsers)
      * [Filter Tests](#filter-tests)
    * [Allure Report](#allure-report)
      * [Overview](#overview)
      * [Categories](#categories)
      * [Behaviors](#behaviors)
<!-- TOC -->

# Example of Selenide, JUnit5, Allure

## Framework
> **Gradle**: <em>8.6 - Build Tool</em> <br>
> **Selenide**: <em>7.2.0 - WebDriver</em> <br>
> **Allure**: <em>2.25.0 - Report Framework</em> <br>
> **JUnit5 - Jupiter**: <em>5.10.2 - Testing Framework</em> <br>

## Project Structure
```
├── gradle
│   ├── config
│   │   ├── allure.gradle
│   │   ├── compilation.gradle
│   │   ├── dependencies.gradle
│   │   └── test.gradle
│   ├── wrapper
│   │   ├── gradle-wrapper.jar
│   │   └── gradle-wrapper.properties
│   ├── helpers.gradle
│   └── versions.gradle
├── images
│   └── **/*.png
├── src/test
│   ├── java/com/github/ngoanh2n/sjae
│   │   ├── common
│   │   │   ├── AbstractPage.java
│   │   │   └── AbstractTest.java
│   │   ├── models
│   │   │   └── Account.java
│   │   ├── pages
│   │   │   ├── layouts
│   │   │   │   └── Header.java
│   │   │   ├── LoginPage.java
│   │   │   └── PortalPage.java
│   │   └── scripts
│   │       └── ExampleTest.java
│   └── resources
│       ├── account.yml
│       ├── allure.properties
│       ├── categories.json
│       ├── junit-platform.properties
│       ├── log4j.properties
│       └── selenide.properties
├── .gitignore
├── README.md
├── build.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle
```

## How To Use
### Clone Repository
> `$ git clone https://github.com/ngoanh2n/selenide-junit5-allure-example.git`

### Configuration Files
You can change values for your case.

1. [log4j.properties](src/test/resources/log4j.properties) <br>
    > Configuring log4j involves assigning the Level, defining Appender, and specifying Layout objects in a configuration file.
2. [selenide.properties](src/test/resources/selenide.properties) <br>
    > Configuration settings for Selenide default browser. Settings can be set either via system property or programmatically.
3. [junit-platform.properties](src/test/resources/junit-platform.properties) <br>
    > If a properties file with this name is present in the root of the classpath, it will be used as a source for configuration parameters. If multiple files are present, only the first one detected in the classpath will be used.
4. [allure.properties](src/test/resources/allure.properties) <br>
    > Configuring all Allure properties by passing classpath.
5. [categories.json](src/test/resources/categories.json) for Allure Report <br>
    > Define categories to group tests. <br>
    >> ```json
    >> {
    >>   "name": "{Category name}",
    >>   "matchedStatuses": "{One or more statuses of tests}",
    >>   "traceRegex": "{Exception name}",
    >>   "messageRegex": "{The content or description of Exeception}"
    >> }
    >> ```
    >
    > Define a category by the following: <br>
    >> - `matchedStatuses` -> The status of test, one in `skipped`, `passed`, `broken`, `failed`, `unknown` <br>
    >> - `traceRegex` -> Find the exception caused status to the test <br>
    >> - `messageRegex` -> Get content or description shortly or fully <br>
    >> - `name` -> Set category name based on above keys <br>

### Run Tests With Gradle
> `./gradlew test` <br>

#### Perform On Browsers
> `./gradlew test -Dselenide.browser=firefox allureReport`

Browser can be:
- chrome
- edge
- firefox
- safari
- ie

<em>`Note`: If run safari, you must enable the `Allow Remote Automation` option in Safari's Develop menu to control Safari via WebDriver.</em>

#### Filter Tests
You can filter tests by using option `--tests`. <br>
Giving values can be `TestPackage`, `TestClass`, `TestMethod`.
> `./gradlew test -Dselenide.browser=firefox --tests ExampleTest.passedTest`

### Allure Report
Add task `allureReport` to your test command. <br>
It generates report from `selenide-junit5-allure-example/build/allure-results` folder.
> `./gradlew test -Dselenide.browser=firefox --tests ExampleTest.passedTest allureReport`

<em>`Note`: If your test command contains task `allureReport`, when tests finished you can see below message in terminal likes.</em>
> Task: `allureReport` <br>
> Report successfully generated to `selenide-junit5-allure-example/build/reports/allure-report` <br>

Open your browser with above path by Firefox <br>
<em>`Note`: If you see Allure report is displayed likes below image.</em>
![](images/allure-loading-firefox.png?raw=true)
<em>Then you have to do by the following:.</em>
- Go to `about:config` in new tab 
- Search for `security.fileuri.strict_origin_policy`
- Finally, change value to `false`, and refresh tab `Allure Report`

<em>Otherwise, you can see below.</em>

#### Overview
![](images/allure-report-overview.png?raw=true)

#### Categories
![](images/allure-report-categories.png?raw=true)

#### Behaviors
![](images/allure-report-behaviors.png?raw=true)