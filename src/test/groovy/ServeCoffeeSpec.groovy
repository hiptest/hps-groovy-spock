import spock.lang.*

class ServeCoffeeSpec extends Specification {
  def actionwords = Actionwords.newInstance()



  def "Simple use"() {
    // Tags: priority:high

    // Well, sometimes, you just get a coffee.
    given:
    actionwords.theCoffeeMachineIsStarted()
    when:
    actionwords.iTakeACoffee()
    then:
    actionwords.coffeeShouldBeServed()
  }}