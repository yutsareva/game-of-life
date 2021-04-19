//package ru.hse.java.settings;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.apache.commons.lang3.tuple.Pair;
//
//public class StandartSettings extends Settings {
//
//  final private int fieldSize = 5;
//  final private int iterationCount = 20;
//  final private Duration iterationTimeInterval = Duration.ofSeconds(1);
//  // TODO: support several standard configurations
//  private static List<Pair<Integer, Integer>> initialAliveCells = Collections.unmodifiableList(
//      Arrays.asList(
//          new ImmutablePair<>(1, 2),
//          new ImmutablePair<>(2, 2),
//          new ImmutablePair<>(3, 2)
//      )
//  );
//
//  @Override
//  public Integer getHeight() {
//    return fieldSize;
//  }
//
//  @Override
//  public Integer getWidth() {
//    return fieldSize;
//  }
//
//  @Override
//  public Duration getIterationTimeInterval() {
//    return iterationTimeInterval;
//  }
//
//  @Override
//  public List<Pair<Integer, Integer>> getInitialAliveCells() {
//    return initialAliveCells;
//  }
//
//  @Override
//  public int getIterationCount() {
//    return iterationCount;
//  }
//
//}
