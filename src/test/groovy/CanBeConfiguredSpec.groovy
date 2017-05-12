import spock.lang.*

class CanBeConfiguredSpec extends Specification {
  def actionwords = Actionwords.newInstance()



  def "Display settings"() {
    // Tags: priority:1


    given:
    actionwords.theCoffeeMachineIsStarted()
    when:
    actionwords.iSwitchToSettingsMode()
    then:
    actionwords.displayedMessageIs("Settings:\n - 1: water hardness\n - 2: grinder")
  }
  def "Default settings"() {
    // Tags: priority:0


    given:
    actionwords.theCoffeeMachineIsStarted()
    when:
    actionwords.iSwitchToSettingsMode()
    then:
    actionwords.settingsShouldBe("| water hardness | 2      |\n| grinder        | medium |")
  }
}