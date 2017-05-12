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
  def "Messages are based on language"() {
    // Well, sometimes, you just get a coffee.

    // Tags: priority:1


    when:
    actionwords.iStartTheCoffeeMachineUsingLanguageLang(language)
    then:
    actionwords.messageMessageShouldBeDisplayed(readyMessage)

    where:
    language | readyMessage | hiptestUid
    "en" | "Ready" | "uid:"
    "fr" | "Pret" | "uid:"
  }
}