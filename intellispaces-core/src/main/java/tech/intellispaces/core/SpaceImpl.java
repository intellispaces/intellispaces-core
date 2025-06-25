package tech.intellispaces.core;

class SpaceImpl extends AbstractReflection implements Space {
  private final Rid sid;
  private final String name;
  private final Domain domain;

  SpaceImpl(Rid sid, String name, Domain domain) {
    this.sid = sid;
    this.name = name;
    this.domain = domain;
  }

  @Override
  public Rid rid() {
    return sid;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Domain domain() {
    return domain;
  }
}
