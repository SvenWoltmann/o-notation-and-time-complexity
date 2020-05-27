package eu.happycoders.o.simple;

import java.util.LinkedList;

/**
 * Simple demo for measuring a constant-time problem - <em>O(1)</em>:
 *
 * <p>
 * Inserting elements at the beginning of a linked list.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class ConstantTimeSimpleDemo {

  public static void main(String[] args) {
    for (int n = 32; n <= 8_388_608; n *= 2) {
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        list.add(i);
      }

      long time = System.nanoTime();
      list.add(0, 1);
      time = System.nanoTime() - time;

      System.out.printf("n = %d -> time = %d ns%n", n, time);
    }
  }

}
