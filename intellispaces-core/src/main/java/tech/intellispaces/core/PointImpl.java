package tech.intellispaces.core;

class PointImpl extends AbstractReflection implements Point {
  private final Rid rid;
  private final Domain domain;

  PointImpl(Rid rid, Domain domain) {
    this.rid = rid;
    this.domain = domain;
  }

  @Override
  public Rid rid() {
    return rid;
  }

  @Override
  public Domain domain() {
    return domain;
  }
}
