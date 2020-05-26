package eu.happycoders.o;

import eu.happycoders.o.problem.*;
import eu.happycoders.o.utils.*;

import java.util.*;

/**
 * Demonstrates the complexity classes O(1), O(n), O(n²), O(log n), O(n log n).
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class TimeComplexityDemo {

  private static final int WARM_UPS = 3;
  private static final int ITERATIONS = 5;

  private static final Map<String, Scorecard> SCORECARDS = new HashMap<>();

  private static final Problem[] PROBLEMS = {
        new ConstantTime(),
        new LinearTime(),
        new QuadraticTime(),
        new LogarithmicTime(),
        new QuasiLinearTime()
  };

  public static void main(String[] args) {
    for (int i = 1; i <= WARM_UPS; i++) {
      System.out.printf("%n===== Warm up %d of %d =====%n", i, WARM_UPS);
      for (Problem problem : PROBLEMS) {
        runTests(problem, i, WARM_UPS, true);
      }
    }

    for (int i = 1; i <= ITERATIONS; i++) {
      System.out.printf("%n===== Iteration %d of %d =====%n", i, ITERATIONS);
      for (Problem problem : PROBLEMS) {
        runTests(problem, i, ITERATIONS, false);
      }

      System.out.printf("%n===== Results after iteration %d of %d =====%n",
            i, ITERATIONS);
      for (Problem problem : PROBLEMS) {
        printResults(problem, i);
      }
    }

    BlackHole.ensureExistence();
  }

  private static void runTests(Problem problem, int iteration,
                               int maxIterations, boolean warmingUp) {
    System.out.printf("%n--- %s (%s %d of %d) ---%n",
          problem.getClass().getSimpleName(),
          warmingUp ? "warming up" : "measuring", iteration, maxIterations);

    for (int n = problem.getMinN(); n <= problem.getMaxN(); n *= 2) {
      long time = problem.solve(n);
      System.out.printf(Locale.US, "%s: n = %,11d --> time = %,13d ns%n",
            problem.getClass().getSimpleName(), n, time);
      if (!warmingUp) {
        scorecard(problem, n, true).add(time);
      }
    }
  }

  private static Scorecard scorecard(Problem problem, int size,
                                     boolean create) {
    String key = String.format(Locale.US, "%s, n = %,11d",
          problem.getClass().getSimpleName(), size);
    return create
          ? SCORECARDS.computeIfAbsent(key, Scorecard::new)
          : SCORECARDS.get(key);
  }

  private static void printResults(Problem problem, int iteration) {
    System.out.printf("%n--- %s (results %d of %d) ---%n",
          problem.getClass().getSimpleName(), iteration, ITERATIONS);

    for (int n = problem.getMinN(); n <= problem.getMaxN(); n *= 2) {
      scorecard(problem, n, false).printResult();
    }
  }

}
