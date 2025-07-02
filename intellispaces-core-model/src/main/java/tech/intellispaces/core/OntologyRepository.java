package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

/**
 * The ontology repository.
 */
public interface OntologyRepository {

  /**
   * Searches for a reflection by identifier.
   *
   * @param rid the reflection identifier.
   * @return the reflection or <code>null</code> if reflection is not found.
   */
  @Nullable Reflection findReflection(Rid rid);

  /**
   * Searches for a reflection by qualified name.
   *
   * @param reflectionName the reflection qualified name.
   * @return the reflection or <code>null</code> if reflection is not found.
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
   * Searches for subdomains of a domain.
   *
   * @param did the domain identifier.
   * @return the list of subdomains.
   */
  @Nullable
  List<Domain> findSubdomains(Rid did);

  /**
   * Searches for subdomains of a domain.
   *
   * @param domainName the domain name.
   * @return the list of subdomains.
   */
  @Nullable
  List<Domain> findSubdomains(String domainName);

  @Nullable Domain findBorrowedDomain(String domainName);

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
   * Searches for a point by qualified name.
   *
   * @param pointName the point qualified name.
   * @return the point or <code>null</code> if point is not found.
   */
  @Nullable Point findPoint(String pointName);

  /**
   * Searches for domain projection channels.
   *
   * @param domainName the qualified domain name.
   * @return the list of domain projection channels.
   */
  List<Channel> findDomainChannels(String domainName);

  /**
   * Searches for context related reflections.
   *
   * @param reflectionName the reflection qualified name.
   * @return the list of related reflections.
   */
  List<Reflection> findRelatedReflections(String reflectionName);
}
