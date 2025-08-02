package tech.intellispaces.core;

public class SpaceBuilder {
  private Rid sid;
  private String alias;

  public SpaceBuilder sid(Rid sid) {
    this.sid = sid;
    return this;
  }

  public SpaceBuilder alias(String alias) {
    this.alias = alias;
    return this;
  }

  public ReflectionSpace get() {
    return new ReflectionSpaceImpl(sid, alias);
  }
}
