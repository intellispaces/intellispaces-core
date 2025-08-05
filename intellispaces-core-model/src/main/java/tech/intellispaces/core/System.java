package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

/**
 * The intellispaces system.
 */
public interface System {

  /**
   * Searches for a reflection registered in the system by its alias.
   *
   * @param alias the qualified reflection alias.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable TraversableReflection findReflection(String alias);

  /**
   * Searches for a reflection registered in the system by its identifier and domain alias.
   *
   * @param pid the reflection identifier.
   * @param domainAlias the qualified alias of the reflection domain.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable TraversableReflectionPoint findReflection(Rid pid, String domainAlias);

  /**
   * Returns the system's representation of the reflection.
   *
   * @param reflection the origin reflection.
   * @return the system's representation of the reflection.
   */
  TraversableReflection getReflection(Reflection reflection);

  /**
   * Creates and registers in the system reflection by contract.
   *
   * @param contract the contract to create reflection.
   * @return created reflection.
   */
  TraversableReflectionPoint createReflection(ReflectionContract contract);

  /**
   * Maps reflection to specified domain.
   *
   * @param source the source reflection.
   * @param domain the target domain.
   * @return the target reflection.
   * @param <S> the source reflection type.
   * @param <T> the target reflection type.
   */
  <S, T> T mapTo(S source, ReflectionDomain domain);

  /**
   * Maps reflection to specified domain.
   *
   * @param source the source reflection.
   * @param targetDomain the target domain.
   * @return the target reflection.
   */
  TraversableReflectionPoint mapTo(Reflection source, ReflectionDomain targetDomain);

  /**
   * Maps reflection to specified domain and casts to required class.
   *
   * @param source the source reflection.
   * @param targetDomain the target domain.
   * @param targetClass the target reflection class.
   * @return the target reflection.
   * @param <R> the target reflection type.
   */
  <R extends Reflection> R mapAndCastTo(Reflection source, ReflectionDomain targetDomain, Class<R> targetClass);

  /**
   * Maps reflection to specified domain and casts to required class.
   *
   * @param source the source reflection.
   * @param targetDomain the target domain.
   * @param qualifier the qualifier.
   * @param targetClass the target reflection class.
   * @return the target reflection.
   * @param <Q> the qualifier type.
   * @param <R> the target reflection type.
   */
  <Q, R extends Reflection> R mapAndCastTo(Reflection source, ReflectionDomain targetDomain, Q qualifier, Class<R> targetClass);

  /**
   * Moves reflection through specified channel.
   *
   * @param reflection the source reflection.
   * @param channelId the channel identifier.
   * @param qualifier the qualifier.
   *
   * @param <S> the source reflection type.
   * @param <Q> the qualifier domain.
   */
  <S, Q> void moveThruChannel1(S reflection, Rid channelId, Q qualifier);
}
