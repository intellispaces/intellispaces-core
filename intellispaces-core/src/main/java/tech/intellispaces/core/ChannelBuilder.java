package tech.intellispaces.core;

public class ChannelBuilder {
  private Rid cid;
  private String name;
  private String alias;
  private Domain sourceDomain;
  private Domain targetDomain;

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

  public ChannelBuilder sourceDomain(Domain sourceDomain) {
    this.sourceDomain = sourceDomain;
    return this;
  }

  public ChannelBuilder targetDomain(Domain targetDomain) {
    this.targetDomain = targetDomain;
    return this;
  }

  public Channel get() {
    return new ChannelImpl(
        cid,
        name,
        alias,
        sourceDomain,
        targetDomain
    );
  }
}
