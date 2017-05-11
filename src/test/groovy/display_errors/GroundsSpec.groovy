import spock.lang.*

class GroundsSpec extends Specification {
  def actionwords = Actionwords.newInstance()


  def setup() {
    given:
    actionwords.theCoffeeMachineIsStarted()
    actionwords.iHandleEverythingExceptTheGrounds()}


  def "Message \"Empty grounds\" is displayed after 30 coffees are taken"() {
    // Tags: priority:0
    when:
    actionwords.iTakeCoffeeNumberCoffees(30)
    then:
    actionwords.messageMessageShouldBeDisplayed("Empty grounds")
  }
  def "When the grounds are emptied, message is removed"() {
    // Tags: priority:1
    when:
    actionwords.iTakeCoffeeNumberCoffees(30)
    actionwords.iEmptyTheCoffeeGrounds()
    then:
    actionwords.messageMessageShouldBeDisplayed("Ready")
  }}