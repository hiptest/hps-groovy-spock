class CoffeeMachine {
  Boolean started = false;
  Boolean coffeeServed = false;
  Boolean settingsDisplayed = false;

  Integer tankContent;
  Integer beansContent;
  Integer groundsContent;

  String lang;
  String waterHardness = "2";
  String grinder = "medium";

  CoffeeMachine() {
    fillTank();
    fillBeans();
    emptyGrounds();
  }

  def start(lang) {
    started = true;
    this.lang = lang ?: "en";
  }

  def stop() {
    started = false;
  }

  def fillTank() {
    tankContent = 60;
  }

  def fillBeans() {
    beansContent = 40;
  }

  def emptyGrounds() {
    groundsContent = 0;
  }

  def showSettings() {
    settingsDisplayed = true;
  }

  def hideSettings() {
    settingsDisplayed = false;
  }

  def getSettings() {
    [waterhardness: waterHardness, grinder: grinder];
  }

  def i18n(key) {
    def messages = [
      en: [
        tank: 'Fill tank',
        beans: 'Fill beans',
        grounds: "Empty grounds",
        ready: "Ready",
        settings: "Settings:\n - 1: water hardness\n - 2: grinder"
      ],
      fr: [
        tank: 'Remplir reservoir',
        beans: 'Ajouter grains',
        grounds: "Vider marc",
        ready: "Pret",
        settings: "Configurer:\n - 1: durete de l'eau\n - 2: mouture"
      ],
    ]

    println lang
    println key
    return messages[lang][key];
  }

  String message() {
    if(!started) return "";

    if (settingsDisplayed) return i18n("settings");
    if (tankContent <= 10) return i18n("tank");
    if (beansContent < 3) return i18n("beans");
    if (groundsContent >= 30) return i18n("grounds");
    return i18n("ready");
  }

  public void takeCoffee() {
    if (tankContent == 0 || beansContent == 0) {
      coffeeServed = false;
    } else {
      coffeeServed = true;
      tankContent -= 1;
      beansContent -= 1;
      groundsContent += 1;
    }
  }
}

