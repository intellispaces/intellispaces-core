package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

/**
 * The ontology repository.
 */
public interface OntologyRepository {

  /**
   * Searches for a reflection by qualified name.
   *
   * @param reflectionName the reflection qualified name.
   * @return the reflection or <code>null</code> if domain is not found.
   */
  @Nullable Reflection findReflection(String reflectionName);

  /**
   * Searches for a space by qualified name.
   *
   * @param spaceName the space qualified name.
   * @return the space or <code>null</code> if space is not found.
   */
  @Nullable Space findSpace(String spaceName);

  /**
   * Searches for a domain by qualified name.
   *
   * @param domainName the domain qualified name.
   * @return the domain or <code>null</code> if domain is not found.
   */
  @Nullable Domain findDomain(String domainName);

  /**
   * Searches for a channel by qualified name.
   *
   * @param channelName the channel qualified name.
   * @return the channel or <code>null</code> if channel is not found.
   */
  @Nullable Channel findChannel(String channelName);

  /**
   * Searches for a channel between the specified source and target domains.
   *
   * @param sourceDomain the source domain.
   * @param targetDomain the target domain/
   * @return the channel or <code>null</code> if channel is not found.
   */
  @Nullable Channel findChannel(Domain sourceDomain, Domain targetDomain);

  /**
   * Searches for domain projection channels.
   *
   * @param domainName the qualified domain name.
   * @return the list of domain projection channels.
   */
  List<Channel> projectionChannels(String domainName);

  /**
   * Searches for context related reflections.
   *
   * @param reflectionName the reflection qualified name.
   * @return the list of related reflections.
   */
  List<Reflection> findRelatedReflections(String reflectionName);
}
