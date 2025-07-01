package tech.intellispaces.core;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class FocusedProjectionImpl implements FocusedProjection {
  private final Object target;

  FocusedProjectionImpl(Object target) {
    this.target = target;
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
    return true;
  }

  @Override
  public boolean isFuzzy() {
    return false;
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
    return this;
  }

  @Override
  public FuzzyProjection asFuzzy() {
    throw UnexpectedExceptions.withMessage("Attempt to case focused projection to fuzzy projection");
  }
}
