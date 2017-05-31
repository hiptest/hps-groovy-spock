import spock.lang.*

class SupportInternationalisationSpec extends Specification {
  def actionwords = Actionwords.newInstance()



  def "No messages are displayed when machine is shut down"() {
    // Tags: priority:1


    given:
    actionwords.theCoffeeMachineIsStarted()
    when:
    actionwords.iShutdownTheCoffeeMachine()
    then:
    actionwords.messageMessageShouldBeDisplayed("")
  }
  def messagesAreBasedOnLanguage(language, readyMessage) {
    // Well, sometimes, you just get a coffee.

    // Tags: priority:1


    actionwords.iStartTheCoffeeMachineUsingLanguageLang(language)
    actionwords.messageMessageShouldBeDisplayed(readyMessage)
  }

  def "Messages are based on language - English"() {
    expect:
    messagesAreBasedOnLanguage("en", "Ready")
  }

  def "Messages are based on language - French"() {
    expect:
    messagesAreBasedOnLanguage("fr", "Pret")
  }
}