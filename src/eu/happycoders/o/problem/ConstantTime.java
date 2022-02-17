package eu.happycoders.o.problem;

import java.util.LinkedList;

/**
 * Implementation of a constant-time problem - <em>O(1)</em>:
 *
 * <p>Inserting elements at the beginning of a linked list.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class ConstantTime implements Problem {

  @Override
  public long solve(int n) {
    LinkedList list = createLinkedList(n);

    // Clean up the heap, so that doesn't happen in parallel while measuring
    // our operations (we can't guarantee it, but we can try...)
    System.gc();

    long time = System.nanoTime();

    // Add 1,000 elements (otherwise the time will be too short to measure)
    for (int i = 0; i < 1_000; i++) {
      list.add(0, i);
    }

    return System.nanoTime() - time;
  }

  private LinkedList<Integer> createLinkedList(int n) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }
    return list;
  }

  @Override
  public int getMaxN() {
    // Otherwise the preparation (creation of the linked list) takes too long
    return 2 << 22;
  }
}
