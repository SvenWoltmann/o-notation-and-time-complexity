package eu.happycoders.o.simple;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple demo for measuring a quasi-linear-time problem - <em>O(n log n)</em>:
 *
 * <p>Sorting an array with Quicksort.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class QuasiLinearTimeSimpleDemo {

  public static void main(String[] args) {
    // Dual-Pivot Quicksort used in Arrays.sort() switches to Insertion Sort
    // for arrays with fewer than 44 elements --> start at 64 and not at 32!
    for (int n = 64; n <= 67_108_864; n *= 2) {
      int[] array = createRandomArrayOfSize(n);

      long time = System.nanoTime();
      Arrays.sort(array);
      time = System.nanoTime() - time;

      System.out.printf("n = %d -> time = %d ns%n", n, time);
    }
  }

  private static int[] createRandomArrayOfSize(int n) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = random.nextInt();
    }
    return array;
  }
}
