package eu.happycoders.o.utils;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A scorecard to print the fastest and median times measured for a specific algorithm and problem
 * size.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class Scorecard {

  private final String name;
  private final ArrayList<Long> times = new ArrayList<>();

  private long fastest = Long.MAX_VALUE;

  public Scorecard(String name) {
    this.name = name;
  }

  /**
   * Adds a time to the scorecard.
   *
   * @param time the time
   */
  public void add(long time) {
    times.add(time);
    if (time < fastest) {
      fastest = time;
    }
  }

  /** Prints the fastest and median times. */
  public void printResult() {
    System.out.printf(
        Locale.US, "%s -> fastest: %,13d ns, median: %,13d ns%n", name, fastest, getMedian());
  }

  private long getMedian() {
    int len = times.size();
    long[] array = new long[len];
    for (int i = 0; i < len; i++) {
      array[i] = times.get(i);
    }
    return ArrayUtils.median(array);
  }
}
