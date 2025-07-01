package tech.intellispaces.core;

import java.util.List;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

public class FuzzyProjectionImpl implements FuzzyProjection {
  private final LikelyProjection mostLikelyProjection;
  private final List<LikelyProjection> likelyProjection;
  private final Reflection collectiveTarget;

  FuzzyProjectionImpl(
      LikelyProjection mostLikelyProjection,
      List<LikelyProjection> likelyProjection,
      Reflection collectiveTarget
  ) {
    this.mostLikelyProjection = mostLikelyProjection;
    this.likelyProjection = likelyProjection;
    this.collectiveTarget = collectiveTarget;
  }

  @Override
  public LikelyProjection mostLikelyProjection() {
    return mostLikelyProjection;
  }

  @Override
  public List<LikelyProjection> likelyProjection() {
    return likelyProjection;
  }

  @Override
  public Reflection collectiveTarget() {
    return collectiveTarget;
  }

  @Override
  public boolean isFocused() {
    return false;
  }

  @Override
  public boolean isFuzzy() {
    return true;
  }

  @Override
  public boolean isLikely() {
    return false;
  }

  @Override
  public boolean isUnknown() {
    return false;
  }

  @Override
  public boolean isVoid() {
    return false;
  }

  @Override
  public FocusedProjection asFocused() {
    throw UnexpectedExceptions.withMessage("Attempt to case fuzzy projection to focused projection");
  }

  @Override
  public FuzzyProjection asFuzzy() {
    return this;
  }
}
