import spock.lang.*

class BadUsageSpec extends Specification {
  def actionwords = Actionwords.newInstance()



  def "Full grounds does not block coffee"() {
    // You keep getting coffee even if the "Empty grounds" message is displayed. That said it's not a fantastic idea, you'll get ground everywhere when you'll decide to empty it.

    // Tags: priority:2


    given:
    actionwords.theCoffeeMachineIsStarted()
    actionwords.iHandleEverythingExceptTheGrounds()
    when:
    actionwords.iTakeCoffeeNumberCoffees(50)
    then:
    actionwords.messageMessageShouldBeDisplayed("Empty grounds")
    actionwords.coffeeShouldBeServed()
  }
}