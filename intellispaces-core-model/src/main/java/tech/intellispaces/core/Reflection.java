package tech.intellispaces.core;

import java.util.List;

/**
 * The abstract reflection.
 */
public interface Reflection extends ReflectionReference {

  /**
   * Returns projection of this reflection through identified channel.
   *
   * @param cid the channel identifier.
   * @return the projection.
   */
  Projection projectionThru(Rid cid);

  /**
   * Returns projection of this reflection through channel.
   *
   * @param channelAlias the channel alias.
   * @return the projection.
   */
  Projection projectionThru(String channelAlias);

  /**
   * Returns projection of this reflection to domain.
   *
   * @param domainAlias the target domain alias.
   * @return the projection.
   */
  Projection projectionTo(String domainAlias);

  /**
   * Returns projection of this reflection to target domain.
   *
   * @param domain the target domain.
   * @return the projection.
   */
  Projection projectionTo(ReflectionDomain domain);

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
