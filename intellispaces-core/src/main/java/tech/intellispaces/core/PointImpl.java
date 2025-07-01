package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

class PointImpl extends AbstractReflection implements Point {
  private final Rid rid;
  private final String name;
  private final Domain domain;
  private final List<Point> underlyingPoints;

  PointImpl(Rid rid, String name, Domain domain, List<Point> underlyingPoints) {
    this.rid = rid;
    this.name = name;
    this.domain = domain;
    this.underlyingPoints = underlyingPoints;
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

  @Override
  public List<Point> underlyingPoints() {
    return underlyingPoints;
  }
}
