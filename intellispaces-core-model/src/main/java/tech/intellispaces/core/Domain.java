package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.type.Type;

/**
 * The semantic space domain.
 */
public interface Domain extends Reflection {

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
   * The foreign domain qualified name.
   */
  @Nullable String foreignDomainName();
}
