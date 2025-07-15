package tech.intellispaces.core;

import java.util.List;

public final class Projections {

  public static FocusedProjection focused(Reflection target) {
    return new FocusedProjectionImpl(target);
  }

  public static FocusedProjection focused(Object target) {
    return new FocusedProjectionImpl(target);
  }

  public static FuzzyProjection fuzzy(double score, Reflection mostLikelyTarget) {
    var mostLikelyProjection = new LikelyProjectionImpl(score, mostLikelyTarget);
    return new FuzzyProjectionImpl(mostLikelyProjection, List.of(mostLikelyProjection), null);
  }

  public static FuzzyProjection fuzzy(double score, String mostLikelyTarget) {
    var mostLikelyProjection = new LikelyProjectionImpl(score, mostLikelyTarget);
    return new FuzzyProjectionImpl(mostLikelyProjection, List.of(mostLikelyProjection), null);
  }

  public static FuzzyProjection fuzzy(Reflection collectiveTarget) {
    return new FuzzyProjectionImpl(null, List.of(), collectiveTarget);
  }

  public static Projection unknown() {
    return UNKNOWN_PROJECTION;
  }

  public static Projection voidProjection() {
    return VOId_PROJECTION;
  }

  private final static Projection UNKNOWN_PROJECTION = new UnknownProjectionImpl();
  private final static Projection VOId_PROJECTION = new VoidProjectionImpl();
}
