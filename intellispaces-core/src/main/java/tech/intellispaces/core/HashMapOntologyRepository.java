package tech.intellispaces.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.NotImplementedExceptions;
import tech.intellispaces.commons.exception.UnexpectedExceptions;

public class HashMapOntologyRepository implements ModifiableOntologyRepository {
  private final Map<String, Reflection> nameToReflectionIndex = new HashMap<>();
  private final Map<Rid, ReflectionPoint> pidToReflectionIndex = new HashMap<>();

  @Override
  public void add(Reflection reflection) {
    if (reflection.reflectionName() != null) {
      nameToReflectionIndex.put(reflection.reflectionName(), reflection);
    }
    if (reflection.rid() != null && reflection.canBeRepresentedAsPoint()) {
      pidToReflectionIndex.put(reflection.rid(), reflection.asPoint());
    }
  }

  @Override
  public @Nullable Reflection findReflection(String reflectionName) {
    return nameToReflectionIndex.get(reflectionName);
  }

  @Override
  public @Nullable ReflectionPoint findReflection(Rid pid, String domainName) {
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
  public List<ReflectionDomain> findSubdomains(Rid did) {
    throw NotImplementedExceptions.withCode("g6I9jQ");
  }

  @Override
  public List<ReflectionDomain> findSubdomains(String domainName) {
    throw NotImplementedExceptions.withCode("QSZRkg");
  }

  @Override
  public @Nullable ReflectionDomain findBorrowedDomain(String domainName) {
    throw NotImplementedExceptions.withCode("yKMZxw");
  }

  @Override
  public @Nullable ReflectionChannel findChannel(String channelName) {
    Reflection reflection = findReflection(channelName);
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
  public List<ReflectionChannel> findDomainChannels(String domainName) {
    return List.of();
  }

  @Override
  public List<Reflection> findRelatedReflections(String reflectionName) {
    return List.of();
  }
}
