import com.example.coffeemachine.CoffeeMachine

class Actionwords {
  def sut
  def handleBeans = false
  def handleWater = false
  def handleGrounds = false

  Actionwords() {
    sut = CoffeeMachine.newInstance()
  }

  def iStartTheCoffeeMachineUsingLanguageLang(lang) {  // TODO: Implement action: "Start the coffee machine using language ${lang}"
    sut.start(lang)
  }

  def iShutdownTheCoffeeMachine() {  // TODO: Implement action: "Shutdown coffee machine"
    sut.stop()
  }

  def messageMessageShouldBeDisplayed(message) {  // TODO: Implement result: "Displayed message is \"${message}\""
    return sut.message() == message
  }

  def coffeeShouldBeServed() {  // TODO: Implement result: "Coffee is served :)"
    return sut.coffeeServed
  }

  def coffeeShouldNotBeServed() {  // TODO: Implement result: "No coffee is served :("
    return !sut.coffeeServed
  }

  def iTakeACoffee() {  // TODO: Implement action: "Take a coffee"
    sut.takeCoffee()
    if (handleGrounds) {
      iEmptyTheCoffeeGrounds()
    }

    if (handleWater) {
      iFillTheWaterTank()
    }

    if (handleBeans) {
      iFillTheBeansTank()
    }
  }

  def iEmptyTheCoffeeGrounds() {  // TODO: Implement action: "Empty coffee grounds"
    sut.emptyGrounds()
  }

  def iFillTheBeansTank() {  // TODO: Implement action: "Fill beans"
    sut.fillBeans()
  }

  def iFillTheWaterTank() {  // TODO: Implement action: "Fill water tank"
    sut.fillTank()
  }

  def iTakeCoffeeNumberCoffees(coffeeNumber) {
    while (coffeeNumber > 0) {
      iTakeACoffee()
      coffeeNumber -= 1
    }
  }

  def theCoffeeMachineIsStarted() {
    iStartTheCoffeeMachineUsingLanguageLang("en")
  }

  def iHandleEverythingExceptTheWaterTank() {
    iHandleCoffeeGrounds()
    iHandleBeans()
  }

  def iHandleWaterTank() {
    handleWater = true
  }

  def iHandleBeans() {
    handleBeans = true
  }

  def iHandleCoffeeGrounds() {
    handleGrounds = true
  }

  def iHandleEverythingExceptTheBeans() {
    iHandleWaterTank()
    iHandleCoffeeGrounds()
  }

  def iHandleEverythingExceptTheGrounds() {
    iHandleWaterTank()
    iHandleBeans()
  }

  def displayedMessageIs(freeText) {
    messageMessageShouldBeDisplayed(freeText)
  }

  def iSwitchToSettingsMode() {
    sut.showSettings()
  }

  def settingsShouldBe(datatable) {
    def settings = [:]
    datatable.split("\n").each {
      def values = it.split("\\|")
      settings.put(values[1].replaceAll(' ', ''), values[2].trim())
    }

    return settings == sut.getSettings()
  }
}
