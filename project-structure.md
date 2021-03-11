## Project Structure

### class CommandLineInterface
Отправная точка взаимодействия пользователя с программой. Использует внешние библиотеки для распарсивания поступившей команды от пользователя и передачи управления соответствующим классам.

Поддерживает комманды:
1. `run --speed [1 (ms)] --size [“10,10”] --iters_count [100] --snapshot [true] --snapshot_step [10] --snapshot_file [“output.txt”]` Запуск симуляции с текущими параметрами и входными данными.
2. `initialize “input.txt”` Проинициализировать изначальное состояние поля координатами живых клеток из файла. Все предыдущие координаты клеток удаляются.
3. `set_rules “input.txt”` Изменить правила.
4. `set_params --speed [1] --size [“10,10”] --iters_count [100]` Зафиксировать значения параметров для всех будущих итераций.
5. `reset_params` Восстанавливает дефолтные значения параметров запуска.
6. `params` Вывести на экран текущие значения параметров.
7. `dot 2 5` Добавить живую клетку с данными координатами.
8. `figure --type [“type”] 6 12` Добавить фигуру.

#### class

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
