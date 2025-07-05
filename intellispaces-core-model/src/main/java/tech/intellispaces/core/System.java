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
   * Maps source to specified domain.
   *
   * @param source the source reflection.
   * @param domain the target domain.
   * @return the target reflection.
   * @param <S> the source reflection type.
   * @param <T> the target reflection type.
   */
  <S, T> T mapSourceTo(S source, ReflectionDomain domain);

  /**
   * Maps source through specified channel.
   *
   * @param source the source reflection.
   * @param domain the target domain.
   * @return the target reflection.
   */
  TraversableReflectionPoint mapSourceTo(Reflection source, ReflectionDomain domain);

  /**
   * Maps source through specified channel.
   *
   * @param source the source reflection.
   * @param targetDomain the target domain.
   * @param targetClass the target reflection class.
   * @return the target reflection.
   * @param <R> the target reflection type.
   */
  <R extends Reflection> R mapSourceTo(Reflection source, ReflectionDomain targetDomain, Class<R> targetClass);
}
