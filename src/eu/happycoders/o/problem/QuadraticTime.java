package eu.happycoders.o.problem;

import eu.happycoders.o.utils.*;

/**
 * Implementation of a quadratic-time problem - <em>O(n²)</em>:
 *
 * <p>
 * Sorting an array with Insertion Sort.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class QuadraticTime implements Problem {

  @Override
  public long solve(int n) {
    int[] array = ArrayUtils.createRandomArray(n);

    // Clean up the heap, so that doesn't happen in parallel while measuring
    // our operations (we can't guarantee it, but we can try...)
    System.gc();

    long time = System.nanoTime();
    insertionSort(array);
    time = System.nanoTime() - time;

    // So that the whole operation doesn't get optimized away by HotSpot
    BlackHole.consume(array[0]);
    BlackHole.consume(array[n - 1]);

    return time;
  }

  private void insertionSort(int[] elements) {
    for (int i = 1; i < elements.length; i++) {
      int elementToSort = elements[i];
      int j = i;
      while (j > 0 && elementToSort < elements[j - 1]) {
        elements[j] = elements[j - 1];
        j--;
      }
      elements[j] = elementToSort;
    }
  }

  @Override
  public int getMaxN() {
    // Otherwise the operation will take too long
    return 2 << 16;
  }

}
