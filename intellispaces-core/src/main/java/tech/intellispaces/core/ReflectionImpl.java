package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

class ReflectionImpl extends AbstractReflection implements Reflection {
  private final ReflectionType type;
  private final Rid rid;
  private final String name;
  private final Domain domain;

  ReflectionImpl(ReflectionType type, Rid rid, String name, Domain domain) {
    this.type = type;
    this.rid = rid;
    this.name = name;
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
    return name;
  }

  @Override
  public Domain domain() {
    return domain;
  }
}
