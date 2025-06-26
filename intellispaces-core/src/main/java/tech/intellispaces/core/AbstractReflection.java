package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractReflection implements Reflection {
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> channelNameToProjection = new HashMap<>();

  @Override
  public Projection projectThru(Rid cid) {
    return cidToProjection.get(cid);
  }

  @Override
  public Projection projectThru(String channelName) {
    return channelNameToProjection.get(channelName);
  }

  protected void setProjection(Rid cid, Projection projection) {
    cidToProjection.put(cid, projection);
  }

  protected void setProjection(String channelName, Projection projection) {
    channelNameToProjection.put(channelName, projection);
  }
}
