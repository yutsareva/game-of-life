package ru.hse.java;

import ru.hse.java.automation.CellularAutomaton;
import ru.hse.java.automation.StandardCellularAutomaton;
import ru.hse.java.settings.Settings;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Runner {

  private Settings settings;
  private final Display display;

  public Runner(Settings settings, Display display) {
    this.settings = settings;
    this.display = display;
  }

  public void run() throws InterruptedException {
    CellularAutomaton automation = new StandardCellularAutomaton(settings);
    while (true) {
      for (int i = 0; i < settings.getIterationCount() || settings.getIterationCount() < 0; i++) {
        display.display(automation.getNextIteration(), true);
        TimeUnit.MILLISECONDS.sleep(settings.getIterationTimeInterval().toMillis());
      }
      Scanner scanner = new Scanner(System.in);
      while (true) {
        System.out.println(
            "Do you want to continue(C), start from begin(S) or finish(F)? C/S/F (default=[F])");
        String input_from_user = scanner.next();
        System.out.println();
        if (input_from_user.equalsIgnoreCase("S")) {
          automation = new StandardCellularAutomaton(settings);
          break;
        } else if (input_from_user.equalsIgnoreCase("C")) {
          automation.setIterationsLeft(settings.getIterationCount());
          break;
        } else if (input_from_user.equalsIgnoreCase("F")) {
          return;
        }
      }
    }
  }
}
