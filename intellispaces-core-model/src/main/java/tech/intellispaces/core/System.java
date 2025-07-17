package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

/**
 * The intellispaces system.
 */
public interface System {

  /**
   * Searches for a reflection by name in the system.
   *
   * @param reflectionName the qualified reflection name.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable TraversableReflection getReflection(String reflectionName);

  /**
   * Searches for a reflection by reflection identifier and domain name in the system.
   *
   * @param pid the reflection identifier.
   * @param domainName the reflection domain name.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable TraversableReflectionPoint getReflection(Rid pid, String domainName);

  /**
   * Creates reflection by contract and registered it in the system.
   *
   * @param contract the contract.
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
