package eu.happycoders.o.simple;

/**
 * Simple demo for measuring a linear-time problem - <em>O(n)</em>:
 *
 * <p>
 * Summing up all elements of an array.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class LinearTimeSimpleDemo {

  public static void main(String[] args) {
    for (int n = 32; n <= 536_870_912; n *= 2) {
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = i;
      }

      long sum = 0;

      long time = System.nanoTime();
      for (int i = 0; i < n; i++) {
        sum += array[i];
      }
      time = System.nanoTime() - time;

      System.out.printf("n = %d -> time = %d ns%n", n, time);
    }
  }

}
