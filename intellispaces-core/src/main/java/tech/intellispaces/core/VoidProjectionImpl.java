package tech.intellispaces.core;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class VoidProjectionImpl implements Projection {

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
    return false;
  }

  @Override
  public boolean isVoid() {
    return true;
  }

  @Override
  public FocusedProjection asFocused() {
    throw UnexpectedExceptions.withMessage("Attempt to cast void projection to focused projection");
  }

  @Override
  public FuzzyProjection asFuzzy() {
    throw UnexpectedExceptions.withMessage("Attempt to cast void projection to fuzzy projection");
  }
}
