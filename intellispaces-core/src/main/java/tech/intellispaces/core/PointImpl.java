package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

class PointImpl extends AbstractReflection implements Point {
  private final Rid rid;
  private final String name;
  private final Domain domain;

  PointImpl(Rid rid, String name, Domain domain) {
    this.rid = rid;
    this.name = name;
    this.domain = domain;
  }

  @Override
  public ReflectionType reflectionType() {
    return ReflectionTypes.Point;
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
