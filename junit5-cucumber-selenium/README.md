# Cucumber - Selenium - Java - Junit5


## Reasons behind the chosen tests
* To check some “advanced search” and “search in” filters are working properly, and the results are related to the “
searched word” and the filters.
* To check some default options work properly  such as “Article “ in the “search in” filter of advanced search


## Conf & Instalation

* macOs Catalina(10.15.7)
* IntelliJ (version:2019.3.1)
* Languange: java (version:17 JDK)
* Maven project
* InteliJ plugins: Gherkin - Cucumber for java
* NodeJS (14)
* Local Chromedriver version: 100.0.4896.60

## Before the start

* Import changes for Maven project
* Go to File - Project structure - SDKs and choose Java 17
* Open IntelliJ and clone this project
* Make sure you are in the pom.xml directory
* Open the terminal and run the script:

```

mvn clean install

```


## Start

* On the terminal run the script:

```
mvn test -Dcucumber.filter.tags="testname"
-->
mvn test -Dcucumber.filter.tags="@search-wikipedia"
mvn test -Dcucumber.filter.tags="@advanced-search-wikipedia"


```



## Reasons behind the chosen framework and pattern(s)

* Maven helps to download dependencies in java projects, you do not have to download any jar file. Just add  the versions of the jar files in the pom.xml to execute your tests.
* Cucumber supports Behaviour-Driven Development (BDD) Approach, and in my opinion, it provides to read test steps easily for everyone such as product owner, business analyst.
* In my opinion, TestNG is a bit more complex to create the BaseConfig Class, and generally, cucumber use Junit framework.


## Next possible steps for improvements
* Test report can be added
* Page object model can be improved


