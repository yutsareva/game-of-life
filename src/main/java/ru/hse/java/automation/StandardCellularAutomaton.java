package ru.hse.java.automation;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import ru.hse.java.settings.AutomationRules;
import ru.hse.java.settings.Settings;

public class StandardCellularAutomaton extends CellularAutomaton {

  private final Field field;
  private int iterationsLeft;
  private boolean gameStarted;
  private final AutomationRules automationRules;

  public StandardCellularAutomaton(Settings settings) {
    field = new Field(settings.getHeight(), settings.getWidth());
    var initialAliveCells = settings.getInitialAliveCells();

    for (var cell : initialAliveCells) {
      var x = cell.getLeft();
      var y = cell.getRight();
      if (x >= settings.getHeight() || y >= settings.getWidth()) {
        System.out.println(
            "Warning! You have an alive cell outside the bounds of the Field. "
                + "Coordinates: (" + x + ", " + y + ")");
        continue;
      }
      field.reviveCell(x, y);
    }
    iterationsLeft = settings.getIterationCount();
    gameStarted = false;
    automationRules = settings.getAutomationRules();
  }

  @Override
  public Field getNextIteration() {
    if (gameFinished()) {
      throw new RuntimeException("Game finished. Can not build new iteration.");
    }
    if (iterationsLeft > 0) {
      iterationsLeft--;
    }

    if (!gameStarted) {
      gameStarted = true;
      return field;
    }

    List<Pair<Integer, Integer>> cellsToDie = new ArrayList<>();
    List<Pair<Integer, Integer>> cellsToRevive = new ArrayList<>();

    for (int i = 0; i < field.getHeight(); i++) {
      for (int j = 0; j < field.getWidth(); j++) {
        var aliveNeighbourCount = field.getAliveNeighbourCount(i, j);

        if (field.isAlive(i, j) && automationRules.getAliveNeighborsToDie()
            .contains(aliveNeighbourCount)) {
          cellsToDie.add(new ImmutablePair<>(i, j));
        }

        if (automationRules.getAliveNeighborsToRevive().contains(aliveNeighbourCount)) {
          cellsToRevive.add(new ImmutablePair<>(i, j));
        }
      }
    }

    for (var cell : cellsToDie) {
      field.killCell(cell.getLeft(), cell.getRight());
    }
    for (var cell : cellsToRevive) {
      field.reviveCell(cell.getLeft(), cell.getRight());
    }

    return field;
  }

  public void setIterationsLeft(int new_iterations_left) {
    iterationsLeft = new_iterations_left;
  }

  @Override
  public boolean gameFinished() {
    return iterationsLeft == 0;
  }
}
