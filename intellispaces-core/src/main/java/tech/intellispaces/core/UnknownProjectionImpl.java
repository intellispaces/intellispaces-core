package tech.intellispaces.core;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class UnknownProjectionImpl implements Projection {

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
    return false;
  }

  @Override
  public boolean isUnknown() {
    return true;
  }

  @Override
  public boolean isVoid() {
    return false;
  }

  @Override
  public FocusedProjection asFocused() {
    throw UnexpectedExceptions.withMessage("Attempt to cast unknown projection to focused projection");
  }

  @Override
  public FuzzyProjection asFuzzy() {
    throw UnexpectedExceptions.withMessage("Attempt to cast unknown projection to fuzzy projection");
  }
}
