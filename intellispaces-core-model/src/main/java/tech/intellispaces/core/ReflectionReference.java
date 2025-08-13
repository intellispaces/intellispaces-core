package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

/**
 * The reflection reference.
 */
public interface ReflectionReference {

  /**
   * The reflection identifier.
   * <p>
   * If the reflection is not registered, then <code>null</code> should be returned.
   */
  @Nullable Rid rid();

  /**
   * The reflection alias in the context of a space.
   */
  @Nullable String alias();
}
