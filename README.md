[![GitHub stars](https://img.shields.io/github/stars/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Star&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/stargazers/)
[![GitHub forks](https://img.shields.io/github/forks/ngoanh2n/selenide-junit5-allure-example.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/ngoanh2n/selenide-junit5-allure-example/network/members/)

**Table of Contents**
<!-- TOC -->
* [Frameworks](#frameworks)
* [Structure](#structure)
* [Usages](#usages)
  * [Configurations](#configurations)
  * [Test Execution](#test-execution)
    * [Browser](#browser)
    * [Filter](#filter)
  * [Allure Report](#allure-report)
    * [Overview](#overview)
    * [Categories](#categories)
    * [Behaviors](#behaviors)
<!-- TOC -->

# Example of Selenide, JUnit5, Allure

## Frameworks
> **Gradle**: <em>8.6 - Build Tool</em><br>
> **Selenide**: <em>7.2.1 - WebDriver</em><br>
> **JUnit5**: <em>5.10.2 - Testing Framework</em><br>
> **Allure**: <em>2.25.0 - Report Framework</em><br>

## Structure
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
│   ├── java/com/github/ngoanh2n/example
│   │   ├── common
│   │   │   ├── AbstractPage.java
│   │   │   └── AbstractTest.java
│   │   ├── models
│   │   │   └── Account.java
│   │   ├── pages
│   │   │   ├── shared
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

## Usages

### Configurations
You can change values for your case.

> [log4j.properties](src/test/resources/log4j.properties)
>> Configuring log4j involves assigning the Level, defining Appender, and specifying Layout objects in a configuration file.

> [selenide.properties](src/test/resources/selenide.properties)
>> Settings can be set either via system property or programmatically.

> [junit-platform.properties](src/test/resources/junit-platform.properties)
>> If a properties file with this name is present in the root of the classpath, it will be used as a source for configuration parameters.<br>
>> If multiple files are present, only the first one detected in the classpath will be used.

> [allure.properties](src/test/resources/allure.properties)
>> For configuring all Allure properties by passing classpath.

> [categories.json](src/test/resources/categories.json)
>> For defining categories to group tests. Below is a sample category.
>>> ```json
>>> {
>>>   "name": "{Category name}",
>>>   "matchedStatuses": "{One or more statuses of tests}",
>>>   "traceRegex": "{Exception name}",
>>>   "messageRegex": "{The content or description of Exeception}"
>>> }
>>> ```
>>
>> Define a category by the following:
>>> - `matchedStatuses`: The status of test, one in `skipped`, `passed`, `broken`, `failed`, `unknown`
>>> - `traceRegex`: Find the exception caused status to the test
>>> - `messageRegex`: Get content or description shortly or fully
>>> - `name`: Set category name based on above keys

### Test Execution

#### Browser
Use JVM System Property `selenide.browser` to pass expected browser.<br>
Giving values can be: [`chrome`, `edge`, `firefox`, `safari`, `ie`].
```shell
gradlew test -Dselenide.browser=firefox
```
<em>`Note`: If run safari, you must enable the `Allow Remote Automation` option in Safari's Develop menu to control Safari via WebDriver.</em>

#### Filter
You can filter tests by using option `--tests`. <br>
Giving values can be [`TestPackage`, `TestClass`, `TestMethod`].
```shell
gradlew test -Dselenide.browser=firefox --tests ExampleTest.passedTest
```

_Refer to [Test Filtering](https://docs.gradle.org/current/userguide/java_testing.html#test_filtering) for more information._

### Allure Report
Add task `allureReport` to your test command. <br>
It generates from `build/allure-results` to `build/allure/allureReport`.
```shell
gradlew test -Dselenide.browser=firefox --tests ExampleTest.passedTest allureReport
```

<em>`Note`: If your test command contains task `allureReport`, when tests finished you can see below message in terminal likes.</em>
> Task: `allureReport` <br>
> Report successfully generated to `selenide-junit5-allure-example/build/allure/allureReport` <br>

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