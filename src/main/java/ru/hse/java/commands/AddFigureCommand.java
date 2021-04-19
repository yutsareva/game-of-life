package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.List;
import java.util.Map;

@Parameters(
    commandNames = {"add_figure"},
    commandDescription = "Add new figure."
)
public class AddFigureCommand implements Command {

  private static final Map<String, int[][]> FIGURES = (Map<String, int[][]>) java.util.Map
      .ofEntries(java.util.Map.entry("block", new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 1}}),
          java.util.Map.entry("beehive", new int[][]{{0, 1}, {0, 2}, {1, 0}, {1, 3}, {2, 1}, {2, 2}}),
          java.util.Map.entry("loaf", new int[][]{{0, 1}, {0, 2}, {1, 0}, {1, 3}, {2, 1}, {2, 3}, {3, 2}}),
          java.util.Map.entry("boat", new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}}),
          java.util.Map.entry("tub", new int[][]{{0, 1}, {1, 0}, {1, 2}, {2, 1}}),
          java.util.Map.entry("blinker", new int[][]{{1, 0}, {1, 1}, {1, 2}}),
          java.util.Map.entry("toad", new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 1}, {1, 2}}),
          java.util.Map.entry("beacon", new int[][]{{0, 0}, {0, 1}, {1, 0}, {2, 3}, {3, 2}, {3, 3}}),
          java.util.Map.entry("pulsar", new int[][]{
              {1, 3}, {1, 4}, {1, 5}, {1, 9}, {1, 10}, {1, 11}, {3, 6}, {4, 6}, {5, 6}, {3, 8},
              {4, 8}, {5, 8}, {3, 13}, {4, 13}, {5, 13}, {6, 9}, {6, 10}, {6, 11}, {8, 9}, {8, 10},
              {8, 11}, {9, 13}, {10, 13}, {11, 13}, {3, 1}, {4, 1}, {5, 1}, {9, 1}, {10, 1},
              {11, 1}, {6, 3}, {6, 4}, {6, 5}, {8, 3}, {8, 4}, {8, 5}, {13, 3}, {13, 4}, {13, 5},
              {9, 6}, {10, 6}, {11, 6}, {9, 8}, {10, 8}, {11, 8}, {13, 9}, {13, 10}, {13, 11}
          }),
          java.util.Map.entry("pentadecathlon", new int[][]{
              {3, 4}, {4, 4}, {6, 4}, {7, 4}, {8, 4}, {9, 4}, {11, 4}, {12, 4}, {5, 3}, {5, 5},
              {10, 3}, {10, 5}}),
          java.util.Map.entry("glider", new int[][]{{0, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}}),
          java.util.Map.entry("lw_spaceship",
              new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 0}, {1, 4}, {2, 4}, {3, 0}, {3, 3}}),
          java.util.Map.entry("mw_spaceship",
              new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 0}, {1, 5}, {2, 5}, {3, 0},
                  {3, 4}, {4, 2}}),
          java.util.Map.entry("hw_spaceship",
              new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {1, 0}, {1, 6}, {2, 6},
                  {3, 0}, {3, 5}, {4, 2}, {4, 3}}));

  @Parameter(
      names = "--place",
      description = "Add alive cells figure by coordinates of top left corner.",
      required = true
  )
  private List<Integer> coordinates;

  @Parameter(
      names = "--type",
      description = "Figure type.",
      required = true
  )
  private String type;

  @Override
  public void run() {
    System.out.println("AddFigureCommand");
  }

  @Override
  public boolean check_flags() {
    if (coordinates.size() != 2) {
      System.out.println("'--place' should be an array of size 2.");
      return false;
    }

    // Implement later I guess...

    return true;
  }
}
