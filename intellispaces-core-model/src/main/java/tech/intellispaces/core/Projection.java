package tech.intellispaces.core;

public interface Projection {

  boolean isFocused();

  boolean isLikely();

  boolean isUnknown();

  boolean isVoid();

  FocusedProjection asFocused();

  FuzzyProjection asFuzzy();
}
