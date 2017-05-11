import spock.lang.*

class SupportInternationalisationSpec extends Specification {
  def actionwords = Actionwords.newInstance()



  def "No messages are displayed when machine is shut down"() {
    // Tags: priority:medium
    given:
    actionwords.theCoffeeMachineIsStarted()
    when:
    actionwords.iShutdownTheCoffeeMachine()
    then:
    actionwords.messageMessageShouldBeDisplayed("")
  }
  def "Messages are based on language"() {
    // Tags: priority:medium

    // Well, sometimes, you just get a coffee.
    when:
    actionwords.iStartTheCoffeeMachineUsingLanguageLang(language)
    then:
    actionwords.messageMessageShouldBeDisplayed(readyMessage)

    where:
    language | readyMessage
    "en" | "Ready"
    "fr" | "Pret"
  }
}
