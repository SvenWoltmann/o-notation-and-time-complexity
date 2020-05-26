package eu.happycoders.o.utils;

/**
 * BlackHole for consuming values to make sure operations are not optimized
 * away by HotSpot.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class BlackHole {

  private static long sum;

  public static void consume(long value) {
    sum += value;
  }

  public static void ensureExistence() {
    System.out.printf("%n(BlackHole's sum: %d)%n", sum);
  }

}
