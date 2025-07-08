package tech.intellispaces.core;

import java.util.Collection;
import java.util.List;

import org.jetbrains.annotations.Nullable;

/**
 * The ontology repository.
 */
public interface OntologyRepository {

  /**
   * Returns spaces supported by the repository.
   */
  Collection<String> spaces();

  /**
   * Adds reflection to repository.
   *
   * @param reflection the reflection.
   * @return <code>true</code> if reflection added to repository or <code>false</code> otherwise.
   */
  boolean add(Reflection reflection);

  /**
   * Searches for a reflection by name in the system.
   *
   * @param reflectionName the qualified reflection name.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable Reflection findReflection(String reflectionName);

  /**
   * Searches for a reflection by reflection identifier and domain name in the system.
   *
   * @param pid the reflection identifier.
   * @param domainName the reflection domain name.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable ReflectionPoint findReflection(Rid pid, String domainName);

  /**
   * Searches for a space by qualified name.
   *
   * @param spaceName the space qualified name.
   * @return the space or <code>null</code> if space is not found.
   */
  @Nullable ReflectionSpace findSpace(String spaceName);

  /**
   * Searches for a domain by qualified name.
   *
   * @param domainName the domain qualified name.
   * @return the domain or <code>null</code> if domain is not found.
   */
  @Nullable ReflectionDomain findDomain(String domainName);

  /**
   * Searches for subdomains of a domain.
   *
   * @param did the domain identifier.
   * @return the list of subdomains.
   */
  @Nullable
  List<ReflectionDomain> findSubdomains(Rid did);

  /**
   * Searches for subdomains of a domain.
   *
   * @param domainName the domain name.
   * @return the list of subdomains.
   */
  @Nullable
  List<ReflectionDomain> findSubdomains(String domainName);

  @Nullable ReflectionDomain findBorrowedDomain(String domainName);

  /**
   * Searches for a channel by qualified name.
   *
   * @param channelName the channel qualified name.
   * @return the channel or <code>null</code> if channel is not found.
   */
  @Nullable ReflectionChannel findChannel(String channelName);

  /**
   * Searches for a channel between the specified source and target domains.
   *
   * @param sourceDomain the source domain.
   * @param targetDomain the target domain/
   * @return the channel or <code>null</code> if channel is not found.
   */
  @Nullable ReflectionChannel findChannel(ReflectionDomain sourceDomain, ReflectionDomain targetDomain);

  /**
   * Searches for domain projection channels.
   *
   * @param domainName the qualified domain name.
   * @return the list of domain projection channels.
   */
  List<ReflectionChannel> findDomainChannels(String domainName);

  /**
   * Searches for context related reflections.
   *
   * @param reflectionName the reflection qualified name.
   * @return the list of related reflections.
   */
  List<Reflection> findRelatedReflections(String reflectionName);
}
