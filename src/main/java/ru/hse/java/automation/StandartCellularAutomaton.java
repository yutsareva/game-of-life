package ru.hse.java.automation;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import ru.hse.java.settings.Settings;

public class StandartCellularAutomaton extends CellularAutomaton {

  private final Field field;
  private int iterationsLeft;
  private boolean gameStarted;

  public StandartCellularAutomaton(Settings settings) {
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
  }

  @Override
  public Field getNextIteration() {
    assert !gameFinished();  // TODO: Throw exception
    iterationsLeft--;
    if (!gameStarted) {
      gameStarted = true;
      return field;
    }

    List<Pair<Integer, Integer>> cellsToDie = new ArrayList<>();
    List<Pair<Integer, Integer>> cellsToRevive = new ArrayList<>();
    for (int i = 0; i < field.getHeight(); i++) {
      for (int j = 0; j < field.getWidth(); j++) {
        var aliveNeighbourCount = field.getAliveNeighbourCount(i, j);
        if (aliveNeighbourCount < 2 || aliveNeighbourCount > 3) {
          cellsToDie.add(new ImmutablePair<Integer, Integer>(i, j));
        }
        if (!field.isAlive(i, j) && aliveNeighbourCount == 3) {
          cellsToRevive.add(new ImmutablePair<Integer, Integer>(i, j));
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

  @Override
  public boolean gameFinished() {
    return iterationsLeft == 0;
  }
}
