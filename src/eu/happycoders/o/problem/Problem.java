package eu.happycoders.o.problem;

/**
 * Interface for problem implementations.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public interface Problem {

  int DEFAULT_MIN_N = 2 << 4;
  int DEFAULT_MAX_N = 2 << 28;

  long solve(int n);

  default int getMinN() {
    return DEFAULT_MIN_N;
  }

  default int getMaxN() {
    return DEFAULT_MAX_N;
  }

}
