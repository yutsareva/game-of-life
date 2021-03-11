## Project Structure

### class CommandLineInterface
Отправная точка взаимодействия пользователя с программой. Использует внешние библиотеки для распарсивания поступившей команды от пользователя и передачи управления соответствующим классам.

Поддерживает комманды:
1. `run --speed [1 (ms)] --size [“10,10”] --iters_count [100] --snapshot [true] --snapshot_step [10] --snapshot_file [“output.txt”]` Запуск симуляции с текущими параметрами и входными данными.
2. `initialize “input.txt”` Проинициализировать изначальное состояние поля координатами живых клеток из файла. Все предыдущие координаты клеток удаляются.
3. `set_rules “input.txt”` Изменить правила.
4. `set_params --speed [1] --size [“10,10”] --iters_count [100]` Зафиксировать значения параметров для всех будущих итераций.
5. `reset_params` Восстанавливает дефолтные значения параметров запуска.
6. `get_params` Вывести на экран текущие значения параметров.
7. `add_dot 2 5` Добавить живую клетку с данными координатами.
8. `remove_dot 2 5` Удалить живую клетку с данными координатами.
9. `add_figure --type [“type”] 6 12` Добавить фигуру.
10. `show_start` Показать стартовое состояние автомата.
 
---

### interface Command
Интерфейс команды.

Публичный метод:
* Run

#### class RunCommand implements Command
Запускает симуляцию.

#### class InitializeCommand implements Command
Инициализирует изначальное состояние автомата координатами из файла.

#### class SetRulesCommand implements Command
Меняет правила на данные в файле.

#### class SetParamsCommand implements Command
Перманентно меняет значение параметров запуска.

#### class ResetParamsCommand implements Command
Возвращает дефолтные значения параметров запуска.

#### class GetParamsCommand implements Command
Выводит на экран значения параметров.

#### class AddDotCommand implements Command
Добавляет живую клетку.

#### class RemoveDotCommand implements Command
Удаляет живую клетку.

#### class AddFigureCommand implements Command
Добавляет фигуру с координатами верхней левой клетки.

#### class ShowStartCommand implements Command
Выводит на экран стартовую конфигурацию живых клеток.

---

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
