package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

/**
 * The object reflection.
 */
public interface Reflection {

  /**
   * The reflection type.
   */
  ReflectionType rtype();

  /**
   * The reflection identifier in the current system.
   * <p>
   * If the reflection is not registered in the current system, then undefined identifier is returned.
   */
  @Nullable
  Rid rid();

  /**
   * The reflection qualified name.
   */
  @Nullable
  String rname();

  /**
   * Returns reflection domain.
   */
  Domain domain();

  /**
   * Returns projection of this reflection through identified channel.
   *
   * @param cid the channel identifier.
   * @return the projection.
   */
  Projection projectThru(Rid cid);

  /**
   * Returns projection of this reflection through named channel.
   *
   * @param channelName the channel qualified name.
   * @return the projection.
   */
  Projection projectThru(String channelName);
}
