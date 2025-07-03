package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

/**
 * The abstract reflection.
 * <p>
 * This interface of the reflection provides the information stored in the reflection itself.
 */
public interface Reflection {

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

  /**
   * Checks whether this reflection can be considered as a point of domain.
   *
   * @return <code>true</code> if this reflection can be considered as point of domain or <code>false</code> otherwise.
   */
  boolean canBeRepresentedAsPoint();

  /**
   * Checks whether this reflection can be considered as a space domain.
   *
   * @return <code>true</code> if this reflection can be considered as domain or <code>false</code> otherwise.
   */
  boolean canBeRepresentedAsDomain();

  /**
   * Checks whether this reflection can be considered as a space channel.
   *
   * @return <code>true</code> if this reflection can be considered as channel or <code>false</code> otherwise.
   */
  boolean canBeRepresentedAsChannel();

  /**
   * Checks whether this reflection can be considered as a semantic space.
   *
   * @return <code>true</code> if this reflection can be considered as space or <code>false</code> otherwise.
   */
  boolean canBeRepresentedAsSpace();

  /**
   * Represents this reflection as semantic space point.
   */
  ReflectionPoint asPoint();

  /**
   * Represents this reflection as semantic space domain.
   */
  ReflectionDomain asDomain();

  /**
   * Represents this reflection as semantic space channel.
   */
  ReflectionChannel asChannel();

  /**
   * Represents this reflection as semantic space.
   */
  ReflectionSpace asSpace();
}
