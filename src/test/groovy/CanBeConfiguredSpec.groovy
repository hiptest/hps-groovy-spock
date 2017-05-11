import spock.lang.*

class CanBeConfiguredSpec extends Specification {
  def actionwords = Actionwords.newInstance()



  def "Default settings"() {
    // Tags: priority:high
    given:
    actionwords.theCoffeeMachineIsStarted()
    when:
    actionwords.iSwitchToSettingsMode()
    then:
    actionwords.settingsShouldBe("| water hardness | 2      |\n| grinder        | medium |")
  }
  def "Display settings"() {
    // Tags: priority:medium
    given:
    actionwords.theCoffeeMachineIsStarted()
    when:
    actionwords.iSwitchToSettingsMode()
    then:
    actionwords.displayedMessageIs("Settings:\n - 1: water hardness\n - 2: grinder")
  }}