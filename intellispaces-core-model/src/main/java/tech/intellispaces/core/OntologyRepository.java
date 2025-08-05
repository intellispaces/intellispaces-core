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
   * Searches for a reflection by alias.
   *
   * @param alias the qualified alias of the reflection.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable Reflection findReflection(String alias);

  /**
   * Searches for a reflection by reflection identifier and domain alias.
   *
   * @param pid the reflection identifier.
   * @param domainAlias the qualified alias of the reflection domain.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable ReflectionPoint findReflection(Rid pid, String domainAlias);

  /**
   * Searches for a reflection by reflection and domain identifiers.
   *
   * @param pid the reflection identifier.
   * @param did the reflection domain identifier.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable ReflectionPoint findReflection(Rid pid, Rid did);

  /**
   * Searches for a space by alias.
   *
   * @param alias the space alias.
   * @return the space or <code>null</code> if space is not found.
   */
  @Nullable ReflectionSpace findSpace(String alias);

  /**
   * Searches for a domain by alias.
   *
   * @param alias the qualified alias of the domain.
   * @return the domain or <code>null</code> if domain is not found.
   */
  @Nullable ReflectionDomain findDomain(String alias);

  Projection findProjection(Rid rid, Rid did, Rid cid);

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
   * @param domainAlias the qualified alias of the reflection domain.
   * @return the list of subdomains.
   */
  @Nullable
  List<ReflectionDomain> findSubdomains(String domainAlias);

  @Nullable ReflectionDomain findBorrowedDomain(String domainAlias);

  /**
   * Searches for a channel by alias.
   *
   * @param channelAlias the qualified alias of the channel.
   * @return the channel or <code>null</code> if channel is not found.
   */
  @Nullable ReflectionChannel findChannel(String channelAlias);

  /**
   * Searches for a channel between the specified source and target domains.
   *
   * @param sourceDomain the source domain.
   * @param targetDomain the target domain.
   * @return the channel or <code>null</code> if channel is not found.
   */
  @Nullable ReflectionChannel findChannel(ReflectionDomain sourceDomain, ReflectionDomain targetDomain);

  /**
   * Searches for domain context channels.
   *
   * @param domainAlias the qualified alias of the reflection domain.
   * @return the list of domain context channels.
   */
  List<ReflectionChannel> findDomainContextChannels(String domainAlias);

  /**
   * Searches for context related reflections.
   *
   * @param reflectionAlias the qualified alias of the reflection.
   * @return the list of related reflections.
   */
  List<Reflection> findRelatedReflections(String reflectionAlias);

  /**
   * Searches for context related reflections.
   *
   * @param pid the reflection identifier.
   * @param did the domain identified.
   * @return the list of related reflections.
   */
  List<Reflection> findRelatedReflections(Rid pid, Rid did);
}
