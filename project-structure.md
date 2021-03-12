## Project Structure

### class CommandLineInterface
Отправная точка взаимодействия пользователя с программой. Использует внешние библиотеки для распарсивания поступившей команды от пользователя и передачи управления соответствующим классам.

Поддерживает комманды:
1. `run --speed [1 (ms)] --size [“10,10”] --iters_count [100] --snapshot [true] --snapshot_step [10] --snapshot_file [“output.txt”] --color ["white"]` Запуск симуляции с текущими параметрами и входными данными.
2. `initialize “input.txt”` Проинициализировать изначальное состояние поля координатами живых клеток из файла. Все предыдущие координаты клеток удаляются.
3. `set_rules “input.txt”` Изменить правила.
4. `set_params --speed [1] --size [“10,10”] --iters_count [100] --color ["white"]` Зафиксировать значения параметров для всех будущих итераций.
5. `get_params` Вывести на экран текущие значения параметров.
6. `add_dot 2 5` Добавить живую клетку с данными координатами.
7. `remove_dot 2 5` Удалить живую клетку с данными координатами.
8. `add_figure --type [“type”] 6 12` Добавить фигуру.
9. `show_start` Показать стартовое состояние автомата.
10. `reset` Восстанавливает дефолтные значения параметров запуска, правил, очищает начальную конфигурацию.
 
---

### interface Command
Интерфейс команды.

Публичный метод:
* Run

#### class RunCommand implements Command
Запускает симуляцию. Предполагается, что на момент запуска этой команды, начальная конфигурация была проверена другими командами и валидна на данный момент. `RunCommand` инициализирует начальное состояние автомата и запускает класс `Runner`.

#### class InitializeCommand implements Command
Инициализирует изначальное состояние автомата координатами из файла. Проверяет корректность формата и данных, и копирует координаты в `initial_configuration.txt`.

#### class SetRulesCommand implements Command
Меняет правила на данные в файле. Проверяет корректность правил, и копирует их в `rules.txt` (есть еще неизменяемый файл `default_rules.txt` с начальными правилами GoL).

#### class SetParamsCommand implements Command
Перманентно меняет значение параметров запуска. Записывает их в `parameters.txt`.

#### class GetParamsCommand implements Command
Выводит на экран значения параметров. Читает из `parameters.txt`.

#### class AddDotCommand implements Command
Добавляет живую клетку. Проверяет, что такой клетки еще нет и добавляет ее в `initial_configuration.txt`. 

#### class RemoveDotCommand implements Command
Удаляет живую клетку. Проверяет, есть ли такая живая клетка и удаляет ее из `initial_configuration.txt`.

#### class AddFigureCommand implements Command
Добавляет фигуру с координатами верхней левой клетки. Аналогично `AddDotCommand`, но с поправками на фигуру.

#### class ShowStartCommand implements Command
Выводит на экран стартовую конфигурацию живых клеток.

#### class ResetCommand implements Command
Возвращает дефолтные значения симуляции. Копирует `default_rules.txt` в `rules.txt`, копирует `default_params.txt` в `params.txt`, очищает файл `initial_configuration.txt`.

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

### interface Reader
Интерфейс чтения входных данных.

Публичные методы:
* readFieldSize
* readNCells
* readCells(nCells) -> List<Cell>
* readCell -> Cell 


#### class ConsoleReader implements Reader


#### class FileReader implements Reader
В конструкторе принимает путь к файлу с начальными координатами всех живых клеток.

---

### interface Display
Отображение состояния игры "Жизнь" в консоли / запись состояний в файл.

Публичные методы:
* display(field)

#### class ConsoleDisplay implements Display
Отображение состояний в консоли.

#### class FileDisplay implements Display
В конструкторе принимает путь к snapshot_file файлу.

---

### class Runner
Принимает Rules, Field, Display.
```java
while(!rules.gameFinished(field)) {
  rules.updateFieldConfiguration(field)
  display.display(field)
}
```
