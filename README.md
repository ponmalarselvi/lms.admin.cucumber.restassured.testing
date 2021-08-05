# lms.admin.cucumber.restassured.testing

Don't forget to give this project a ⭐

Learn how to creat test automation for a REST API using Cucumber6 and Rest-Assured. It tests the API: [lms-admin-rest-service](https://github.com/ponmalarselvi/lms-admin-rest-service).

**Required software:**

* [Install JDK 11 & Apache Maven 3.6](https://anote.dev/install-jdk-11-apache-maven-3-6/)
* [Eclipse](https://www.guru99.com/install-eclipse-java.html)
* [Allure](https://docs.qameta.io/allure/#_installing_a_commandline)
* Clone/download the backend API [lms-admin-rest-service](https://github.com/ponmalarselvi/lms-admin-rest-service)


**Allure Installation:**
* Download the latest version as zip archive from [Maven Central](https://repo1.maven.org/maven2/io/qameta/allure/allure-commandline/).
  (this project used [allure-commandline-2.14.0](https://repo1.maven.org/maven2/io/qameta/allure/allure-commandline/2.14.0/allure-commandline-2.14.0.zip)

* Unpack the archive to allure-commandline directory.

* Navigate to bin directory.

* Use allure.bat for Windows or allure for other Unix platforms.

* Add allure to **system PATH**

**Running the backend API:**

Please, before executing any tests, run the backend API. After cloning this project:

Navigate to the project folder using the Terminal / Command prompt
Execute the following: mvn spring-boot:run
Wait until you see something like this: Application has started! Happy tests!
The API is ready and listen to all requests on http://localhost:8080

**How to execute the tests:**
You can open each test class on src\test\java and execute all of them

**Libraries:**
* [Rest-Assured](https://rest-assured.io/) library to test REST APIs
* [cucumber](https://docs.cucumber.io/) Testing framework
* [Allure-reports](https://docs.qameta.io/allure/)

Thanks for visiting. Enjoy Coding...
