## Project Structure

### interface Settings
Хранит начальную конфигурацию живых клеток, размеры поля,  время между итерациями автомата, цвет клеток.

Публичные методы:
* getFieldSize
* getAliveCellColor
* getIterationTimeInterval

#### class StandartSettings implements Settings
Стандартные настройки.

#### class SettingsFromFile implements Settings
В конструкторе принимает путь к файлу с настройками игры.

---

### class Cell
Хранит координаты и состояние клетки.

Публичные методы:
* getState
* setState

---

### class Field
Хранит игровое поле, состоящее из объектов Cell.

Публичные методы:
* getCell

---

### interface Rules
Определяет правила, по которым клетка на следующей итерации оживает или умирает.


Публичные методы:
* updateFieldConfiguration(Field)
* gameFinished(Field) -> bool


#### class StandartRules implements Rules
Классические правила игры "Жизнь".

#### class RulesFromFile implements Rules
В конструкторе принимает путь к файлу с правилами автомата.

---

### class Runner
Принимает Rules, Field, Display.
```java
while(!rules.gameFinished(field)) {
  rules.updateFieldConfiguration(field)
  display.display(field)
}
```
