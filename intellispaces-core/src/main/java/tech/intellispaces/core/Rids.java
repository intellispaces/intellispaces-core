package tech.intellispaces.core;

import java.util.UUID;

import tech.intellispaces.commons.data.UuidFunctions;

public class Rids {

  public static Rid of(byte[] bytes, String sting) {
    return new RidImpl(bytes, sting);
  }

  public static Rid of(byte[] bytes) {
    return new RidImpl(bytes);
  }

  public static Rid of(UUID uuid) {
    return new RidImpl(UuidFunctions.uuidToBytes(uuid), uuid.toString());
  }

  public static Rid undefined() {
    return UNDEFINED_RID;
  }

  private static final Rid UNDEFINED_RID = of(new byte[0]);

  private Rids() {}
}
