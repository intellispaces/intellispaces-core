package tech.intellispaces.core;

public interface Projection {

  boolean isFocused();

  boolean isFuzzy();

  boolean isLikely();

  boolean isUnknown();

  boolean isVoid();

  FocusedProjection asFocused();

  FuzzyProjection asFuzzy();
}
