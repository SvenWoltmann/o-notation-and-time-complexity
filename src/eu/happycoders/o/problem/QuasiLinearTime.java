package eu.happycoders.o.problem;

import eu.happycoders.o.utils.ArrayUtils;
import eu.happycoders.o.utils.BlackHole;

import java.util.Arrays;

/**
 * Implementation of a quasi-linear-time problem - <em>O(n log n)</em>:
 *
 * <p>Sorting an array with Quicksort.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class QuasiLinearTime implements Problem {

  @Override
  public long solve(int n) {
    int[] array = ArrayUtils.createRandomArray(n);

    // Clean up the heap, so that doesn't happen in parallel while measuring
    // our operations (we can't guarantee it, but we can try...)
    System.gc();

    long time = System.nanoTime();
    Arrays.sort(array);
    time = System.nanoTime() - time;

    // So that the whole operation doesn't get optimized away by HotSpot
    BlackHole.consume(array[0]);
    BlackHole.consume(array[n - 1]);

    return time;
  }

  @Override
  public int getMinN() {
    // Dual-Pivot Quicksort used in Arrays.sort() switches to Insertion Sort
    // for arrays with fewer than 44 elements --> start at 64 and not at 32!
    return 2 << 5;
  }

  @Override
  public int getMaxN() {
    // Otherwise the operation will take too long
    return 2 << 24;
  }
}
