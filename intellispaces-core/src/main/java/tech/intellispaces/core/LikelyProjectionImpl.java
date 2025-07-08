package tech.intellispaces.core;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class LikelyProjectionImpl implements LikelyProjection {
  private final double score;
  private final Object target;

  LikelyProjectionImpl(double score, Object target) {
    this.score = score;
    this.target = target;
  }

  @Override
  public double score() {
    return score;
  }

  @Override
  public Object target() {
    return target;
  }

  @Override
  public String targetAsString() {
    if (target instanceof String string) {
      return string;
    }
    throw UnexpectedExceptions.withMessage("Invalid projection target type");
  }

  @Override
  public boolean isFocused() {
    return false;
  }

  @Override
  public boolean isFuzzy() {
    return false;
  }

  @Override
  public boolean isLikely() {
    return true;
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
    return this;
  }

  @Override
  public FuzzyProjection asFuzzy() {
    throw UnexpectedExceptions.withMessage("Attempt to cast likely projection to fuzzy projection");
  }
}
