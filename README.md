# hps-groovy-spock
[![Build Status](https://travis-ci.org/hiptest/hps-groovy-spock.svg?branch=master)](https://travis-ci.org/hiptest/hps-groovy-spock)

Hiptest publisher samples with Groovy/Spock

In this repository you'll find tests generated in Groovy/Spock format from [Hiptest](https://hiptest.net), using [Hiptest publisher](https://github.com/hiptest/hiptest-publisher).

The goals are:

 * to show how tests are exported in Groovy/Spock.
 * to check exports work out of the box (well, with implemented actionwords)

System under test
------------------

The SUT is a (not that much) simple coffee machine. You start it, you ask for a coffee and you get it, sometimes. But most of times you have to add water or beans, empty the grounds. You have an automatic expresso machine at work or at home? So you know how it goes :-)

Update tests
-------------


To update the tests:

    hiptest-publisher -c groovy-spock.conf --only=tests

The tests are generated in [``src/test/groovy/``](https://github.com/hiptest/hps-groovy-spock/blob/master/src/test/groovy/)

Run tests
---------


To build the project and run the tests, use the following command:

    mvn clean test

The SUT implementation can be seen in [``src/main/groovy/CoffeeMachine.groovy``](https://github.com/hiptest/hps-groovy-spock/blob/master/src/main/groovy/CoffeeMachine.groovy)

The test report is generated in ```target/surefire-reports/```
