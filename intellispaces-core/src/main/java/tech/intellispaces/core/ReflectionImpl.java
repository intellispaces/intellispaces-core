package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

class ReflectionImpl extends AbstractReflection implements Reflection {
  private final ReflectionType type;
  private final Rid rid;
  private final String reflectionName;
  private final Domain domain;

  ReflectionImpl(ReflectionType type, Rid rid, String reflectionName, Domain domain) {
    this.type = type;
    this.rid = rid;
    this.reflectionName = reflectionName;
    this.domain = domain;
  }

  @Override
  public ReflectionType reflectionType() {
    return type;
  }

  @Override
  public @Nullable Rid rid() {
    return rid;
  }

  @Override
  public @Nullable String reflectionName() {
    return reflectionName;
  }

  @Override
  public Domain domain() {
    return domain;
  }
}
