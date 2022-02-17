package eu.happycoders.o.problem;

import eu.happycoders.o.utils.ArrayUtils;
import eu.happycoders.o.utils.BlackHole;

import java.util.Arrays;

/**
 * Implementation of a logarithmic-time problem - <em>O(log n)</em>:
 *
 * <p>Finding an element within a sorted array using binary search.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class LogarithmicTime implements Problem {

  @Override
  public long solve(int n) {
    int[] array = ArrayUtils.createSortedArray(n);
    long sum = 0;

    // Clean up the heap, so that doesn't happen in parallel while measuring
    // our operations (we can't guarantee it, but we can try...)
    System.gc();

    long time = System.nanoTime();

    // Run this 10_000 times, so we get useful results
    for (int i = 0; i < 10_000; i++) {
      // Search for the 0, to ensure we need the maximum number of steps
      int position = Arrays.binarySearch(array, 0);
      sum += position;
    }

    time = System.nanoTime() - time;

    // So that the operation doesn't get optimized away
    BlackHole.consume(sum);

    return time;
  }
}
