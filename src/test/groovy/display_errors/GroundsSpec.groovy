import spock.lang.*

class GroundsSpec extends Specification {
  def actionwords = Actionwords.newInstance()


  def setup() {
    given:
    actionwords.theCoffeeMachineIsStarted()
    actionwords.iHandleEverythingExceptTheGrounds()}


  def "When the grounds are emptied, message is removed"() {
    // Tags: priority:medium
    given:
    actionwords.iTakeCoffeeNumberCoffees(30)
    when:
    actionwords.iEmptyTheCoffeeGrounds()
    then:
    actionwords.messageMessageShouldBeDisplayed("Ready")
  }
  def "Message \"Empty grounds\" is displayed after 30 coffees are taken"() {
    // Tags: priority:high
    when:
    actionwords.iTakeCoffeeNumberCoffees(30)
    then:
    actionwords.messageMessageShouldBeDisplayed("Empty grounds")
  }}