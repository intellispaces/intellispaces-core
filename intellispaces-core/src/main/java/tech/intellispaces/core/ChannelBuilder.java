package tech.intellispaces.core;

public class ChannelBuilder {
  private Rid cid;
  private String name;
  private String alias;
  private ReflectionDomain sourceDomain;
  private ReflectionDomain targetDomain;
  private ReflectionDomain domain;

  public ChannelBuilder cid(Rid cid) {
    this.cid = cid;
    return this;
  }

  public ChannelBuilder name(String name) {
    this.name = name;
    return this;
  }

  public ChannelBuilder alias(String alias) {
    this.alias = alias;
    return this;
  }

  public ChannelBuilder sourceDomain(ReflectionDomain sourceDomain) {
    this.sourceDomain = sourceDomain;
    return this;
  }

  public ChannelBuilder targetDomain(ReflectionDomain targetDomain) {
    this.targetDomain = targetDomain;
    return this;
  }

  public ChannelBuilder domain(ReflectionDomain domain) {
    this.domain = domain;
    return this;
  }

  public ReflectionChannel get() {
    return new ReflectionChannelImpl(
        cid,
        name,
        alias,
        sourceDomain,
        targetDomain,
        domain
    );
  }
}
