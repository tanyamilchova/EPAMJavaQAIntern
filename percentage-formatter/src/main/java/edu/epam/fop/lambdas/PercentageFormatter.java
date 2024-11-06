package edu.epam.fop.lambdas;

import java.util.Locale;
import java.util.function.DoubleFunction;

public interface PercentageFormatter {
  DoubleFunction<String> INSTANCE = doubleNumber -> {
    double percentage = Math.round(doubleNumber * 1000.0) / 10.0;
    return (percentage == (long) percentage
            ? String.format(Locale.US, "%d", (long) percentage)
            : String.format(Locale.US, "%.1f", percentage))
            + " %";
  };
}
