## Project Structure

### class CommandLineInterface
Отправная точка взаимодействия пользователя с программой. Использует внешние библиотеки для распарсивания поступившей команды от пользователя и передачи управления соответствующим классам.

Поддерживает комманды:
1. `run --speed 400 --size 10 10 --iters_count 100 --snapshot --snapshot_step 10 --snapshot_folder “path/to/folder/” --color "white"` Запуск симуляции с текущими параметрами и входными данными.
2. `initialize --file “input.json”` Проинициализировать изначальное состояние поля координатами живых клеток из файла. Все предыдущие координаты клеток удаляются.
3. `set_rules --revive 1,2,3 --die 4,5` Изменить правила.
4. `set_params --speed 1 --size 10 10 --iters_count 100 --color "white"` Зафиксировать значения параметров для всех будущих итераций.
5. `get_params` Вывести на экран текущие значения параметров.
6. `add_dot --place 2 5` Добавить живую клетку с данными координатами.
7. `remove_dot --place 2 5` Удалить живую клетку с данными координатами.
8. `add_figure --type blinker --place 6 12` Добавить фигуру.
9. `show_start` Показать стартовое состояние автомата.
10. `reset` Восстанавливает дефолтные значения параметров запуска, правил, очищает начальную конфигурацию.
11. `show_board --file "input.json"` Выводит на экран доску из файла.
12. `clear` Очищает доску.
 
---

### interface Command
Интерфейс команды.

Публичный метод:
* Run

#### class RunCommand implements Command
Запускает симуляцию. Предполагается, что на момент запуска этой команды, начальная конфигурация была проверена другими командами и валидна на данный момент. `RunCommand` инициализирует начальное состояние автомата и запускает класс `Runner`.

#### class InitializeCommand implements Command
Инициализирует изначальное состояние автомата координатами и параметрами из файла.

#### class SetRulesCommand implements Command
Меняет правила на новые. Записывает новые правила в `current_configuration.json`.

#### class SetParamsCommand implements Command
Перманентно меняет значение параметров запуска. Записывает их в `current_configuration.json`.

#### class GetParamsCommand implements Command
Выводит на экран значения параметров. Читает из `current_configuration.json`.

#### class AddDotCommand implements Command
Добавляет живую клетку. Проверяет, что такой клетки еще нет и добавляет ее в `current_configuration.json`. 

#### class RemoveDotCommand implements Command
Удаляет живую клетку. Проверяет, есть ли такая живая клетка и удаляет ее из `current_configuration.json`.

#### class AddFigureCommand implements Command
Добавляет фигуру с координатами верхней левой клетки. Аналогично `AddDotCommand`, но с поправками на фигуру.

#### class ShowStartCommand implements Command
Выводит на экран стартовую конфигурацию живых клеток.

#### class ResetCommand implements Command
Возвращает дефолтные значения симуляции. Копирует `default_configuration.json` в `current_configuration.json`.

#### class ShowBoardCommand implements Command
Получает на вход доску из файла и выводит ее в консоль.

#### class ClearCommand implements Command
Очищает доску.

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


### class Field
Хранит игровое поле: состояние каждой клетки. Предположительно строки будут храниться в BitSet.

Публичные методы:
* getCell
* setCell

---

### interface CellularAutomaton
Определяет правила, по которым клетка на следующей итерации оживает или умирает.


Публичные методы:
* updateFieldConfiguration(Field)
* gameFinished(Field) -> bool


#### class StandartCellularAutomaton implements CellularAutomaton
Классические правила игры "Жизнь".

#### class CellularAutomatonFromFile implements CellularAutomaton
В конструкторе принимает путь к файлу с правилами автомата.

---

### interface Reader
Интерфейс чтения входных данных.

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
Принимает CellularAutomaton, Field, Display.
```java
while(!automation.gameFinished(field) && !automation.isTerminated()) {
  automation.updateFieldConfiguration(field)
  display.display(field)
}
```
