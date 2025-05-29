package tech.intellispaces.core;

class ChannelImpl implements Channel {
  private final Rid rid;
  private final String name;
  private final String alias;
  private final Domain sourceDomain;
  private final Domain targetDomain;

  ChannelImpl(
      Rid rid,
      String name,
      String alias,
      Domain sourceDomain,
      Domain targetDomain
  ) {
    this.rid = rid;
    this.name = name;
    this.alias = alias;
    this.sourceDomain = sourceDomain;
    this.targetDomain = targetDomain;
  }

  @Override
  public Rid rid() {
    return rid;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String alias() {
    return alias;
  }

  @Override
  public Domain sourceDomain() {
    return sourceDomain;
  }

  @Override
  public Domain targetDomain() {
    return targetDomain;
  }

  @Override
  public Domain domain() {
    return Domains.undefine();
  }
}
