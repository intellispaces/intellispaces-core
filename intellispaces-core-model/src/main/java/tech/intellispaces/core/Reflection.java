package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

/**
 * The object reflection.
 * <p>
 * This interface of the reflection provides the information stored in the reflection itself.
 */
public interface Reflection {

  /**
   * The reflection type.
   */
  ReflectionType reflectionType();

  /**
   * The reflection identifier.
   * <p>
   * If the reflection is not registered, then <code>null</code> should be returned.
   */
  @Nullable
  Rid rid();

  /**
   * The reflection qualified name.
   * <p>
   * If the reflection is not named, then <code>null</code> should be returned.
   */
  @Nullable
  String reflectionName();

  /**
   * The reflection domain.
   */
  Domain domain();

  /**
   * Returns projection of this reflection through identified channel.
   *
   * @param cid the channel identifier.
   * @return the projection.
   */
  Projection projectionThru(Rid cid);

  /**
   * Returns projection of this reflection through named channel.
   *
   * @param channelName the channel qualified name.
   * @return the projection.
   */
  Projection projectionThru(String channelName);

  /**
   * Returns projection of this reflection to named domain.
   *
   * @param domainName the target domain qualified name.
   * @return the projection.
   */
  Projection projectionTo(String domainName);

  /**
   * Returns the list of related reflections.
   */
  List<Reflection> relatedReflections();
}
