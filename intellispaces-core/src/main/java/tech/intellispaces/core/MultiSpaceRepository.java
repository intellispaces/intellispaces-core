package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

/**
 * The multi space ontology repository.
 */
public class MultiSpaceRepository implements OntologyRepository {
  private final Map<String, List<OntologyRepository>> repositories = new HashMap<>();

  public void addRepository(OntologyRepository repository) {
    for (String spaceName : repository.spaces()) {
      repositories.computeIfAbsent(spaceName, k -> new ArrayList<>()).add(repository);
    }
  }

  @Override
  public Collection<String> spaces() {
    return repositories.keySet();
  }

  @Override
  public boolean add(Reflection reflection) {
    for (OntologyRepository repository : selectRepositories(reflection.reflectionName())) {
      if (repository.add(reflection)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public @Nullable Reflection findReflection(String reflectionName) {
    for (OntologyRepository repository : selectRepositories(reflectionName)) {
      Reflection reflection = repository.findReflection(reflectionName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionPoint findReflection(Rid pid, String domainName) {
    for (OntologyRepository repository : selectRepositories(domainName)) {
      ReflectionPoint reflection = repository.findReflection(pid, domainName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionSpace findSpace(String spaceName) {
    for (OntologyRepository repository : selectRepositories(spaceName)) {
      ReflectionSpace reflection = repository.findSpace(spaceName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionDomain findDomain(String domainName) {
    for (OntologyRepository repository : selectRepositories(domainName)) {
      ReflectionDomain reflection = repository.findDomain(domainName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public List<ReflectionDomain> findSubdomains(Rid did) {
    for (List<OntologyRepository> repositories : repositories.values()) {
      for (OntologyRepository repository : repositories) {
        List<ReflectionDomain> subdomains = repository.findSubdomains(did);
        if (subdomains != null) {
          return subdomains;
        }
      }
    }
    return null;
  }

  @Override
  public List<ReflectionDomain> findSubdomains(String domainName) {
    for (OntologyRepository repository : selectRepositories(domainName)) {
      List<ReflectionDomain> subdomains = repository.findSubdomains(domainName);
      if (subdomains != null) {
        return subdomains;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionDomain findBorrowedDomain(String domainName) {
    for (OntologyRepository repository : selectRepositories(domainName)) {
      ReflectionDomain reflection = repository.findBorrowedDomain(domainName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionChannel findChannel(String channelName) {
    for (OntologyRepository repository : selectRepositories(channelName)) {
      ReflectionChannel reflection = repository.findChannel(channelName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionChannel findChannel(ReflectionDomain sourceDomain, ReflectionDomain targetDomain) {
    for (List<OntologyRepository> repositories : repositories.values()) {
      for (OntologyRepository repository : repositories) {
        ReflectionChannel channel = repository.findChannel(sourceDomain, targetDomain);
        if (channel != null) {
          return channel;
        }
      }
    }
    return null;
  }

  @Override
  public List<ReflectionChannel> findDomainChannels(String domainName) {
    for (OntologyRepository repository : selectRepositories(domainName)) {
      List<ReflectionChannel> channels = repository.findDomainChannels(domainName);
      if (channels != null) {
        return channels;
      }
    }
    return null;
  }

  @Override
  public List<Reflection> findRelatedReflections(String reflectionName) {
    for (OntologyRepository repository : selectRepositories(reflectionName)) {
      List<Reflection> relatedReflections = repository.findRelatedReflections(reflectionName);
      if (relatedReflections != null) {
        return relatedReflections;
      }
    }
    return null;
  }

  private List<OntologyRepository> selectRepositories(String reflectionName) {
    if (reflectionName == null) {
      return repositories.values().stream()
          .flatMap(Collection::stream)
          .toList();
    }
    String space = SpaceFunctions.getSpaceName(reflectionName);
    return repositories.getOrDefault(space, List.of());
  }
}
