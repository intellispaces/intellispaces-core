package tech.intellispaces.core;

import java.util.UUID;

public class Rids {

  public static Rid of(byte[] bytes, String sting) {
    return new RidImpl(bytes, sting);
  }

  public static Rid of(byte[] bytes) {
    return new RidImpl(bytes);
  }

  public static Rid of(UUID uuid) {
    return new UuidRid(uuid);
  }

  public static Rid undefined() {
    return UNDEFINED_RID;
  }

  private static final Rid UNDEFINED_RID = of(new byte[0]);

  private Rids() {}
}
