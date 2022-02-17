package eu.happycoders.o.problem;

import eu.happycoders.o.utils.ArrayUtils;
import eu.happycoders.o.utils.BlackHole;

/**
 * Implementation of a linear-time problem - <em>O(n)</em>:
 *
 * <p>Summing up all elements of an array.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class LinearTime implements Problem {

  @Override
  public long solve(int n) {
    int[] array = ArrayUtils.createSortedArray(n);

    long sum = 0;

    // Clean up the heap, so that doesn't happen in parallel while measuring
    // our operations (we can't guarantee it, but we can try...)
    System.gc();

    long time = System.nanoTime();
    for (int i = 0; i < n; i++) {
      sum += array[i];
    }
    time = System.nanoTime() - time;

    // So that the whole operation doesn't get optimized away
    BlackHole.consume(sum);

    return time;
  }
}
