package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.type.Type;

/**
 * The reflection considered as a domain of points in semantic space.
 */
public interface ReflectionDomain extends Reflection {

  /**
   * The domain identifier.
   */
  default Rid did() {
    return rid();
  }

  /**
   * The domain class related to this reflection.
   */
  @Nullable Class<?> domainClass();

  /**
   * The domain type related to this reflection.
   */
  @Nullable Type<?> domainType();

  /**
   * The borrowed domain.
   */
  @Nullable ReflectionDomain borrowedDomain();

  /**
   * Domain outgoing channels.
   */
  List<ReflectionChannel> domainChannels();

  /**
   * Parent domains.
   */
  List<ReflectionDomain> parentDomains();
}
