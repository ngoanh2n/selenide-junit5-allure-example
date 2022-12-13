[![GitHub stars](https://img.shields.io/github/stars/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Star&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Watch&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/watchers/)
[![GitHub forks](https://img.shields.io/github/forks/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/network/members/)

[![License: MIT](https://img.shields.io/badge/License-MIT-blueviolet.svg)](https://opensource.org/licenses/MIT)
[![badge-jdk](https://img.shields.io/badge/jdk-8-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Build Status](https://travis-ci.org/ngoanh2n/selenide-junit5-allure-example.svg?branch=master)](https://travis-ci.org/ngoanh2n/selenide-junit5-allure-example)

# Selenide, JUnit5, Allure Example

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [**Frameworks/Libraries**](#frameworkslibraries)
- [**Project Structure**](#project-structure)
- [**How To Use**](#how-to-use)
  - [**Clone Repository**](#clone-repository)
  - [**Configuration Files**](#configuration-files)
  - [**Run Tests With Gradle**](#run-tests-with-gradle)
    - [**Perform On Browsers**](#perform-on-browsers)
    - [**Filter Tests**](#filter-tests)
  - [**Allure Report**](#allure-report)
    - [**Overview**](#overview)
    - [**Categories**](#categories)
    - [**Behaviors**](#behaviors)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## **Libraries & Tools**
> **Gradle**: <em>6.9.3 - Build Tool</em><br/>
> **Selenide**: <em>6.10.2 - WebDriver</em><br/>
> **Allure**: <em>2.20.1 - Test Report</em><br/>
> **Appium**: <em>8.3.0 - WebDriver for Mobile</em><br/>
> **JUnit5 - Platform**: <em>1.9.1 - Testing Launcher</em><br/>
> **JUnit5 - Jupiter**: <em>5.9.1 - Testing Framework</em><br/>
> **JUnit5 - Vintage**: <em>5.9.1 - Test Engine</em><br/>

## **Project Structure**
```
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── images
│   └── **/*.png
├── src/test
│   ├── java/com/github/ngoanh2n/sjae
│   │   ├── common
│   │   │   ├── BasePage.java
│   │   │   └── BaseTest.java
│   │   ├── pages
│   │   │   ├── layouts
│   │   │   │   └── Header.java
│   │   │   ├── LoginPage.java
│   │   │   └── PortalPage.java
│   │   └── scripts
│   │       └── ExampleTest.java
│   └── resources
│       ├── allure.properties
│       ├── categories.json
│       ├── junit-platform.properties
│       ├── log4j.properties
│       └── selenide.properties
├── .gitignore
├── .travis.yml
├── LICENSE
├── README.md
├── build.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle
```

## **How To Use**
### **Clone Repository**
> `$ git clone https://github.com/ngoanh2n/selenide-junit5-allure-example.git`

### **Configuration Files**
You can change values for your case.

1. [log4j.properties](src/test/resources/log4j.properties)<br/>
    > Configuring log4j involves assigning the Level, defining Appender, and specifying Layout objects in a configuration file.
2. [selenide.properties](src/test/resources/selenide.properties)<br/>
    > Configuration settings for Selenide default browser. Settings can be set either via system property or programmatically.
3. [junit-platform.properties](src/test/resources/junit-platform.properties)<br/>
    > If a properties file with this name is present in the root of the classpath, it will be used as a source for configuration parameters. If multiple files are present, only the first one detected in the classpath will be used.
4. [allure.properties](src/test/resources/allure.properties)<br/>
    > Configuring all Allure properties by passing classpath.
5. [categories.json](src/test/resources/categories.json) for Allure Report<br/>
    > Defining categories to group tests.<br/>
    > **Category structure:**<br/>
    > ```json
    > {
    >   "name": "{Category name}",
    >   "matchedStatuses": "{One or more statuses of tests}",
    >   "traceRegex": "{Exception name}",
    >   "messageRegex": "{The content or description of Exeception}"
    > }
    > ```
    > **Define a category by the following:**<br/>
    > - `matchedStatuses` -> The status of test, one in `skipped`, `passed`, `broken`, `failed`, `unknown`<br/>
    > - `traceRegex` -> Find the exception caused status to the test<br/>
    > - `messageRegex` -> Get content or description shortly or fully<br/>
    > - `name` -> Set category name based on above keys<br/>

### **Run Tests With Gradle**
> `./gradlew clean test allureReport`<br/>

Task `allureReport`: Build report from `selenide-junit5-allure-example/build/allure-results` folder

#### **Perform On Browsers**
- chrome
- edge
- firefox
- ie
- safari

> If run safari, you must enable the 'Allow Remote Automation' option in Safari's Develop menu to control Safari via WebDriver.

Able to select browser by passing system property `selenide.browser`<br/>
> `./gradlew clean test -Dselenide.browser=firefox allureReport`

#### **Filter Tests**
You can filter tests by using option `--tests`<br/>
Giving values can be `TestPackage`, `TestClass`, `TestMethod`
> `./gradlew clean test -Dselenide.browser=firefox --tests ExampleTest.passedTest allureReport`

### **Allure Report**
<em>`Note`: If your test command contains task `allureReport`, when tests finished you can see below message in terminal likes.</em>
> **> Task :allureReport**<br/>
> Report successfully generated to /Users/ngoanh2n/Desktop/Work/guides-test-automation/`selenide-junit5-allure-example/build/reports/allure-report`<br/>

Open your browser with above path by Firefox<br/>
<em>`Note`: If you see Allure report is displayed likes below image.</em>
![](images/allure-loading-firefox.png?raw=true)
<em>Then you have to do by the following:.</em>
- Go to `about:config` in new tab 
- Search for `security.fileuri.strict_origin_policy`
- Finally, change value to `false`, and refresh tab `Allure Report`

<em>Otherwise, you can see below.</em>

#### **Overview**
![](images/allure-report-overview.png?raw=true)

#### **Categories**
![](images/allure-report-categories.png?raw=true)

#### **Behaviors**
![](images/allure-report-behaviors.png?raw=true)