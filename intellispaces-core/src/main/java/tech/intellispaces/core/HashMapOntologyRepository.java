package tech.intellispaces.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.NotImplementedExceptions;
import tech.intellispaces.commons.exception.UnexpectedExceptions;

public class HashMapOntologyRepository implements OntologyRepository {
  private final String spaceAlias;
  private final Map<Rid, ReflectionPoint> pidToReflectionIndex = new HashMap<>();
  private final Map<String, Reflection> aliasToReflectionIndex = new HashMap<>();

  public HashMapOntologyRepository(String spaceAlias) {
    this.spaceAlias = spaceAlias;
  }

  @Override
  public List<String> spaces() {
    return List.of(spaceAlias);
  }

  @Override
  public boolean add(Reflection reflection) {
    boolean added = false;
    if (reflection.reflectionName() != null) {
      aliasToReflectionIndex.put(reflection.reflectionName(), reflection);
      added = true;
    }
    if (reflection.rid() != null && reflection.canBeRepresentedAsPoint()) {
      pidToReflectionIndex.put(reflection.rid(), reflection.asPoint());
      added = true;
    }
    return added;
  }

  @Override
  public @Nullable Reflection findReflection(String alias) {
    return aliasToReflectionIndex.get(alias);
  }

  @Override
  public @Nullable ReflectionPoint findReflection(Rid pid, String domainAlias) {
    return pidToReflectionIndex.get(pid);
  }

  @Override
  public @Nullable ReflectionPoint findReflection(Rid pid, Rid did) {
    return pidToReflectionIndex.get(pid);
  }

  @Override
  public @Nullable ReflectionSpace findSpace(String spaceName) {
    Reflection reflection = findReflection(spaceName);
    if (reflection == null) {
      return null;
    }
    if (reflection instanceof ReflectionSpace space) {
      return space;
    }
    throw UnexpectedExceptions.withMessage("The reflection type does not match the requested type");
  }

  @Override
  public @Nullable ReflectionDomain findDomain(String domainName) {
    Reflection reflection = findReflection(domainName);
    if (reflection == null) {
      return null;
    }
    if (reflection instanceof ReflectionDomain domain) {
      return domain;
    }
    throw UnexpectedExceptions.withMessage("The reflection type does not match the requested type");
  }

  @Override
  public Projection findProjection(Rid rid, Rid did, Rid cid) {
    return Projections.unknown();
  }

  @Override
  public List<ReflectionDomain> findSubdomains(Rid did) {
    throw NotImplementedExceptions.withCode("g6I9jQ");
  }

  @Override
  public List<ReflectionDomain> findSubdomains(String domainName) {
    return List.of();
  }

  @Override
  public List<ReflectionDomain> findForeignDomains(Rid domainId) {
    return List.of();
  }

  @Override
  public @Nullable ReflectionChannel findChannel(String channelAlias) {
    Reflection reflection = findReflection(channelAlias);
    if (reflection == null) {
      return null;
    }
    if (reflection instanceof ReflectionChannel channel) {
      return channel;
    }
    throw UnexpectedExceptions.withMessage("The reflection type does not match the requested type");
  }

  @Override
  public @Nullable ReflectionChannel findChannel(ReflectionDomain sourceDomain, ReflectionDomain targetDomain) {
    return null;
  }

  @Override
  public List<ReflectionChannel> findDomainContextChannels(String domainAlias) {
    return List.of();
  }

  @Override
  public List<Reflection> findRelatedReflections(String reflectionAlias) {
    return List.of();
  }

  @Override
  public List<Reflection> findRelatedReflections(Rid pid, Rid did) {
    return List.of();
  }
}
