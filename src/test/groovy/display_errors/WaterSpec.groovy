import spock.lang.*

class WaterSpec extends Specification {
  def actionwords = Actionwords.newInstance()


  def setup() {
    given:
    actionwords.theCoffeeMachineIsStarted()
    actionwords.iHandleEverythingExceptTheWaterTank()}


  def "Message \"Fill water tank\" is displayed after 50 coffees are taken"() {
    // Tags: priority:0


    when:
    actionwords.iTakeCoffeeNumberCoffees(50)
    then:
    actionwords.messageMessageShouldBeDisplayed("Fill tank")
  }
  def "It is possible to take 10 coffees after the message \"Fill water tank\" is displayed"() {
    // Tags: priority:2


    when:
    actionwords.iTakeCoffeeNumberCoffees(60)
    then:
    actionwords.coffeeShouldBeServed()
    when:
    actionwords.iTakeACoffee()
    then:
    actionwords.coffeeShouldNotBeServed()
  }
  def "When the water tank is filled, the message disappears"() {
    // Tags: priority:0


    when:
    actionwords.iTakeCoffeeNumberCoffees(55)
    actionwords.iFillTheWaterTank()
    then:
    actionwords.messageMessageShouldBeDisplayed("Ready")
  }
}