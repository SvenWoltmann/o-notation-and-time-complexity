package eu.happycoders.o.simple;

import java.util.Arrays;

/**
 * Simple demo for measuring a logarithmic-time problem - <em>O(log n)</em>:
 *
 * <p>
 * Finding an element within a sorted array using binary search.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class LogarithmicTimeSimpleDemo {

  public static void main(String[] args) {
    for (int n = 32; n <= 536_870_912; n *= 2) {
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = i;
      }

      long time = System.nanoTime();
      Arrays.binarySearch(array, 0);
      time = System.nanoTime() - time;

      System.out.printf("n = %d -> time = %d ns%n", n, time);
    }
  }

}
