package eu.happycoders.o.simple;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple demo for measuring a quadratic-time problem - <em>O(n²)</em>:
 *
 * <p>
 * Sorting an array with Insertion Sort.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class QuadraticTimeSimpleDemo {

  public static void main(String[] args) {
    for (int n = 32; n <= 262_144; n *= 2) {
      ThreadLocalRandom random = ThreadLocalRandom.current();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = random.nextInt();
      }

      long time = System.nanoTime();
      insertionSort(array);
      time = System.nanoTime() - time;

      System.out.printf("n = %d -> time = %d ns%n", n, time);
    }
  }

  private static void insertionSort(int[] elements) {
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

}
