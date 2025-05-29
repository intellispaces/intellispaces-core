package tech.intellispaces.core;

class ReflectionImpl implements Reflection {
  private final Rid rid;
  private final Domain domain;

  ReflectionImpl(Rid rid, Domain domain) {
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
